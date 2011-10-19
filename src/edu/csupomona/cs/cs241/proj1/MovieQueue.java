/**
 * CS 241: Data Structures and Algorithms II
 * Professor: Edwin Rodr&iacute;guez
 *
 * Programming Assignment 1
 *
 * This assignment is to create a netflix like movie
 * 
 * queue by which the user can sort search a
 * library of movies as well as add movies to
 * their queue by priority rather than just
 * FIFO order. They may freely switch
 * between FIFO and priority order. The
 * Queues are persistent and the library is extensible.
 * 
 * Satshabad Khalsa  
 */

package edu.csupomona.cs.cs241.proj1;

import java.io.IOException;

/**
 * This class holds two queues that hold {@link Movies} for the user. it
 * represents the actual data and procedures that the user will directly
 * interact with when building his/her queue
 * 
 * @author Satshabad
 * 
 */
public class MovieQueue {

    /**
     * This queue holds the movies that the user has added.
     */
    private PriorityQueue<Movie> waitingQueue;

    /**
     * This queue holds movies that are at the users home waiting to be
     * returned.
     */
    private MyQueue<Movie> atHomeQueue;

    /**
     * This construct is called to create a new MovieQueue or to create one from
     * a a saved file.
     * 
     * @param numberOfMovies
     *            the MAX number of movies that the queue will hold
     * @param numberOfPriortities
     *            the MAX number of different priorities that might be assigned
     * @throws ClassNotFoundException
     * @throws IOException
     */
    MovieQueue(int numberOfMovies, int numberOfPriortities) throws IOException,
            ClassNotFoundException {
        FileManager fm = new FileManager();
        MyQueue<Movie> q = fm.getSavedHomeQueue();
        PriorityQueue<Movie> p = fm.getSavedWaitingQueue();
        if (p == null || q == null) {
            waitingQueue = new PriorityQueue<Movie>(numberOfMovies,
                    numberOfPriortities);
            atHomeQueue = new MyQueue<Movie>(numberOfMovies);
        } else {
            waitingQueue = p;
            atHomeQueue = q;
        }

    }

    /**
     * Adds a movie to the waiting queue.
     * 
     * @pre movie must not be {@code null}
     * @post the movie will be added in the correct spot
     * 
     * @param m
     *            the movie to be added
     * @param priority
     *            the priority to add the movie at
     */
    public void addMovietoWaiting(Movie m, int priority) {
        if (m == null) {
            return;
        }

        waitingQueue.enqueue(m, priority);
    }

    /**
     * This method takes a movie from the top of the queue by FIFO style and
     * send it to the home queue.
     * 
     * @pre the waiting queue must not be empty
     * @post the correct movie will be dequeued from the waiting queue and
     *       enqueued in the home queue
     */
    public void sendMovieHome() {
        Movie m = waitingQueue.dequeue();
        if (m == null) {
            return;
        }
        atHomeQueue.enqueue(m);
    }

    /**
     * This method takes a movie from the top of the queue by the priority it
     * was added and send it to the home queue.
     * 
     * @pre the waiting queue must not be empty
     * @post the correct movie will be dequeued from the waiting queue and
     *       enqueued in the home queue
     */
    public void sendMovieHomeByPriority() {
        Movie m = waitingQueue.dequeueByPriority();
        if (m == null) {
            return;
        }
        atHomeQueue.enqueue(m);
    }

    /**
     * This method is used for the UI to display the list of movies in normal
     * FIFO order.
     * 
     * @pre
     * @post the movies will be in the order the user queued them
     * @return an array of {@link Movie} objects that are in FIFO order
     */
    public Movie[] displayWaitingMovies() {

        @SuppressWarnings("unchecked")
        PriorityQueue<Movie> cloneOfP = (PriorityQueue<Movie>) DeepCopier
                .copy(waitingQueue);
        Movie[] movieList = new Movie[cloneOfP.getSize()];

        int i = 0;
        while (!cloneOfP.isEmpty()) {
            movieList[i] = cloneOfP.dequeue();
            i++;
        }
        return movieList;
    }

    /**
     * This method is used for the UI to display the list of movies in priority
     * order.
     * 
     * @pre
     * @post the movies will be in the order of the priority the user queued
     *       them in, if two movies have the same priority then they appear in
     *       FIFO order
     * @return an array of {@link Movie} objects that are in priority order
     */
    public Movie[] displayWaitingMoviesByPriority() {
        @SuppressWarnings("unchecked")
        PriorityQueue<Movie> cloneOfP = (PriorityQueue<Movie>) DeepCopier
                .copy(waitingQueue);
        Movie[] movieList = new Movie[cloneOfP.getSize()];
        int i = 0;
        while (!cloneOfP.isEmpty()) {
            movieList[i] = cloneOfP.dequeueByPriority();
            i++;
        }
        return movieList;
    }

    /**
     * Dequeues from the atHome queue in FIFO order and returns the movie.
     * 
     * @return the movie dequeued
     */
    public Movie returnMovie() {
        return atHomeQueue.dequeue();

    }

    /**
     * Returns an array of movies in the same order they they are in the queue
     * but shares no data with the actual queue.
     * 
     * @pre
     * @post the array of movies will be returned in the order fo the queue
     * @return the array of movies
     */
    public Movie[] displayMoviesAtHome() {
        @SuppressWarnings("deprecation")
        MyQueue<Movie> cloneOfP = new MyQueue<Movie>(atHomeQueue);
        Movie[] movieList = new Movie[cloneOfP.getSize()];
        int i = 0;
        while (!cloneOfP.isEmpty()) {
            movieList[i] = cloneOfP.dequeue();
            i++;
        }
        return movieList;
    }

    /**
     * This internal method attempts to write the {@link #waitingQueue} and
     * {@link #atHomeQueue} to files.
     * 
     * @pre there is enough memory to write to the system
     * @post the objects are saved
     * @throws IOException
     *             if the files can not be written out
     */
    public void save() throws IOException {

        FileManager fm = new FileManager();
        fm.saveHomeQueue(atHomeQueue);
        fm.saveWaitingQueue(waitingQueue);

    }

}
