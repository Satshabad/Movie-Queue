/**
 * 
 */
package edu.csupomona.cs.cs241.proj1;

import java.io.IOException;

/**
 * This class is the top level of abstraction for the
 * edu.csupomona.cs.cs241.proj1 package. it contains all methods end users will
 * need.
 * 
 * @author Satshabad
 * 
 */
public class MovieSystemManager {

    /**
     * The object that manages the movie queues.
     */
    private MovieQueue theMovieQueue;

    /**
     * The object that manages the movie library.
     */
    private MovieLibrary theMovieLibrary;

    /**
     * The default number of priorities.
     */
    private final int NUM_OF_PRIORITIES = 3;

    /**
     * This creates an instance of this class which will manage all end user
     * functionality.
     * 
     * @pre
     * @post an instace of this object is created
     * @throws IOException
     *             if the saved files from a previous run are not available or
     *             corrupted
     * @throws ClassNotFoundException
     *             if the saved files from a previous run are not available or
     *             corrupted
     */
    public MovieSystemManager() throws IOException, ClassNotFoundException {
        this.theMovieLibrary = new MovieLibrary();
        this.theMovieQueue = new MovieQueue(
                theMovieLibrary.getNumberOfMovies(), NUM_OF_PRIORITIES);
    }

    /**
     * This adds a movie to the queue movies the user is waiting for.
     * 
     * @pre The movie must be non null
     * @post the movie is added in the correct place
     * @param m
     *            the {@link Movie} to be added
     * @param priority
     *            the priority to add the movie at in the queue
     */
    public void addToMovieQueue(Movie m, int priority) {

        theMovieQueue.addMovietoWaiting(m, priority);

    }

    /**
     * This dequeues by priority from the waiting queue and adds it to the home
     * queue.
     * 
     * @pre There must be at least one movie in the waiting queue
     * @post there is at least one movie in the home queue
     * 
     */
    public void deliverMovieByPrioirity() {
        theMovieQueue.sendMovieHomeByPriority();

    }

    /**
     * This dequeues from the waiting queue and adds it to the home queue.
     * 
     * @pre There must be at least one movie in the waiting queue
     * @post there is at least one movie in the home queue
     * 
     */
    public void deliverMovie() {

        theMovieQueue.sendMovieHome();
    }

    /**
     * This dequeues from the home queue queue returns it.
     * 
     * 
     * @pre There must be at least one movie in the home queue
     * @post there a movie returned
     * @return the movie dequeued
     */
    public Movie returnMovie() {
        return theMovieQueue.returnMovie();
    }

    /**
     * This method returns an array representation for the waiting queue which
     * shares no actual data with the queue elements.
     * 
     * @pre there is at least one movie in the queue
     * @post the data is returned in the correct order by FIFO
     * @return the waiting queue
     */
    public Movie[] getWaitingQueue() {
        return theMovieQueue.displayWaitingMovies();
    }

    /**
     * This method returns an array representation for the waiting queue which
     * shares no actual data with the queue elements.
     * 
     * @pre there is at least one movie in the queue
     * @post the data is returned in the correct order by priority
     * @return the waiting queue
     */
    public Movie[] getWaitingQueueByPriority() {
        return theMovieQueue.displayWaitingMoviesByPriority();
    }

    /**
     * This method returns an array representation for the home queue which
     * shares no actual data with the queue elements.
     * 
     * @pre there is at least one movie in the queue
     * @post the data is returned in the correct order
     * @return the home queue
     */
    public Movie[] getatHomeQueue() {
        return theMovieQueue.displayMoviesAtHome();
    }

    /**
     * This returns the actual movie objects in an array for display.
     * 
     * @pre there is at least one movie to be displayed
     * @post the movie array is returned in the correct order
     * 
     * @return an array of movies sorted by title
     */
    public Movie[] getMoviesListedByTitle() {
        return theMovieLibrary.movieListBy('t');
    }

    /**
     * This returns the actual movie objects in an array for display.
     * 
     * @pre there is at least one movie to be displayed
     * @post the movie array is returned in the correct order
     * 
     * @return an array of movies sorted by director
     */
    public Movie[] getMoviesListedByDirector() {
        return theMovieLibrary.movieListBy('d');
    }

    /**
     * This returns the actual movie objects in an array for display.
     * 
     * @pre there is at least one movie to be displayed
     * @post the movie array is returned in the correct order
     * 
     * @return an array of movies sorted by genre
     */
    public Movie[] getMoviesListedByGenre() {
        return theMovieLibrary.movieListBy('g');
    }

    /**
     * This returns the actual movie objects in an array for display.
     * 
     * @pre there is at least one movie to be displayed
     * @post the movie array is returned in the correct order
     * 
     * @return an array of movies sorted by main actor
     */
    public Movie[] getMoviesListedByMainActor() {
        return theMovieLibrary.movieListBy('m');
    }

    /**
     * This method is called on closing the program and attempts to save the
     * movie queue.
     * 
     * @pre true
     * @post false
     * @param n
     *            0 if user wants to exit or return a boolean if file save
     *            failed, 1 if the user wants to exit unconditionally
     * @return true if the files saved or false if they did not. will never
     *         return true.
     */
    public boolean exit(int n) {
        try {
            theMovieQueue.save();
        } catch (IOException e) {
            if (n == 0) {
                return false;
            } else
                System.exit(-1);
        }
        System.exit(0);
        return true;
    }

    /**
     * This method searches through the movie list by title attribute and
     * returns all matches to a given target {@link String}. Partial matches are
     * found.
     * 
     * @pre target is not null
     * @post the list has been searched
     * @param target
     *            the {@link String} being looked for
     * @return an array of the matched {@link Movie}s
     */
    public Movie[] searchByTitle(String target) {
        return theMovieLibrary.searchBy('t', target);
    }

    /**
     * This method searches through the movie list by Actor attribute and
     * returns all matches to a given target {@link String}. Partial matches are
     * found.
     * 
     * @pre target is not null
     * @post the list has been searched
     * @param target
     *            the {@link String} being looked for
     * @return an array of the matched {@link Movie}s
     */
    public Movie[] searchByActor(String target) {
        return theMovieLibrary.searchBy('a', target);
    }

    /**
     * This method searches through the movie list by Director attribute and
     * returns all matches to a given target {@link String}. Partial matches are
     * found.
     * 
     * @pre target is not null
     * @post the list has been searched
     * @param target
     *            the {@link String} being looked for
     * @return an array of the matched {@link Movie}s
     */
    public Movie[] searchByDirector(String target) {
        return theMovieLibrary.searchBy('d', target);
    }

    /**
     * This method searches through the movie list by genre attribute and
     * returns all matches to a given target {@link String}. Partial matches are
     * found.
     * 
     * @pre target is not null
     * @post the list has been searched
     * @param target
     *            the {@link String} being looked for
     * @return an array of the matched {@link Movie}s
     */
    public Movie[] searchByGenre(String target) {
        return theMovieLibrary.searchBy('g', target);
    }

    /**
     * This method dequeues a movie from the home queue.
     * 
     * @pre there must be at least one movie in the home queue
     * @post the top movie is dequeued and lost
     */
    public void sendMovieBack() {
        theMovieQueue.returnMovie();
    }

}
