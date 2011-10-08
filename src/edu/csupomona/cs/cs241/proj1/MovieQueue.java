/**
 * CS 241: Data Structures and Algorithms II
 * Professor: Edwin Rodr&iacute;guez
 *
 * Programming Assignment 1
 *
 * This assignment is to create a netflix like movie queue and give it added functionality
 *
 * Satshabad Khalsa  
 */
package edu.csupomona.cs.cs241.proj1;

import java.io.IOException;

/**
 * This class holds two queues that hold {@link Movies} for the user.
 * it represents the actual data and procedures that the user will directly interact with when building his/her queue
 * 
 * @author Satshabad
 *
 */
public class MovieQueue
{
   private PriorityQueue<Movie> waitingQueue;
   private MyQueue<Movie> atHomeQueue;
   
      /**
       * This construct is called to create a new MovieQueue or to create one from a a saved file.
       * 
       * @param numberOfMovies the MAX number of movies that the queue will hold
       * @param numberOfPriortities the MAX number of different priorities that might be assigned 
       * @throws ClassNotFoundException 
       * @throws IOException 
       */
      MovieQueue(int numberOfMovies, int numberOfPriortities) throws IOException, ClassNotFoundException{
         FileManager fm = new FileManager();
         MyQueue<Movie> q = fm.getSavedHomeQueue();
         PriorityQueue<Movie> p = fm.getSavedWaitingQueue();
          if (p == null && q == null){
             waitingQueue = new PriorityQueue<Movie>(numberOfMovies, numberOfPriortities);
             atHomeQueue = new MyQueue<Movie>(numberOfMovies);
          }
          else {
             waitingQueue = p;
             atHomeQueue = q;
          }
         
      }
      
      /**
       * Adds a movie to the waiting queue
       * 
       * @pre movie must not be {@code null}
       * @post the movie will be added in the correct spot
       * 
       * @param m the movie to be added
       * @param priority the priority to add the movie at
       */
      public void addMovietoWaiting(Movie m, int priority){
         if ( m == null) {return;} 
         
         waitingQueue.enqueue(m, priority);
      }
      
      
      /**
       * This method takes a movie from the top of the queue by FIFO style and send it to the home queue
       * 
       * @pre the waiting queue must not be empty
       * @post the correct movie will be dequeued from the waiting queue and enqueued in the home queue
       * @return whether the dequeue was successful
       */
      public void sendMovieHome(){
        Movie m = waitingQueue.dequeue();
        if (m == null){ return;}
        atHomeQueue.enqueue(m);
      }
      
      /**
       * This method takes a movie from the top of the queue by the priority it was added and send it to the home queue
       * 
       * @pre the waiting queue must not be empty
       * @post the correct movie will be dequeued from the waiting queue and enqueued in the home queue
       * @return whether the dequeue was successful
       */
      public void sendMovieHomeByPriority(){
         Movie m = waitingQueue.dequeueByPriority();
         if (m == null){ return;}
         atHomeQueue.enqueue(m);
       }

      
      
      /**
       * This allows the UI direct access to the waiting queue to display it
       * 
       * @return the waitingQueue
       */
      public PriorityQueue<Movie> getWaitingQueue()
      {
         return waitingQueue;
      }
      

      /**
       * This allows the UI direct access to the home queue to display it
       * 
       * @return the homeQueue
       */
      public MyQueue<Movie> getAtHomeQueue()
      {
         return atHomeQueue;
      }
      
      
}
