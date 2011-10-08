/**
 * 
 */
package edu.csupomona.cs.cs241.proj1;

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
       * This construct is called the when a brand new queue must be made.
       * 
       * @param numberOfMovies the MAX number of movies that the queue will hold
       * @param numberOfPriortities the MAX number of different priorities that might be assigned 
       */
      MovieQueue(int numberOfMovies, int numberOfPriortities){
         waitingQueue = new PriorityQueue<Movie>(numberOfMovies, numberOfPriortities);
         atHomeQueue = new MyQueue<Movie>(numberOfMovies);
      }
      
      /**
       * This constructor creates a object with the passed queues instead of creating brand new queues.
       * 
       * @param savedWaitingQueue the waiting queue to be used for movies waiting to be delivered
       * @param savedAtHomeQueue the home queue to show which movies are at home.
       */
      MovieQueue(PriorityQueue<Movie> savedWaitingQueue, MyQueue<Movie> savedAtHomeQueue)
      {
            waitingQueue = savedWaitingQueue;
            atHomeQueue = savedAtHomeQueue;
      }

      /**
       * Adds a movie to the waiting queue
       * 
       * @pre The queue must not be full
       * @post the movie will be added in the correct spot
       * 
       * @param m the movie to be added
       * @param priority the priority to add the movie at
       * @return whether or not the movie has been added
       */
      public boolean addMovietoWaiting(Movie m, int priority){
         return waitingQueue.enqueue(m, priority);
      }
      
      
      /**
       * This method takes a movie from the top of the queue by FIFO style and send it to the home queue
       * 
       * @pre the waiting queue must not be empty
       * @post the correct movie will be dequeued from the waiting queue and enqueued in the home queue
       * @return whether the dequeue was successful
       */
      public boolean sendMovieHome(){
        Movie m = waitingQueue.dequeue();
        if (m == null){ return false;}
        return atHomeQueue.enqueue(m);
      }
      
      /**
       * This method takes a movie from the top of the queue by the priority it was added and send it to the home queue
       * 
       * @pre the waiting queue must not be empty
       * @post the correct movie will be dequeued from the waiting queue and enqueued in the home queue
       * @return whether the dequeue was successful
       */
      public boolean sendMovieHomeByPriority(){
         Movie m = waitingQueue.dequeueByPriority();
         if (m == null){ return false;}
         return atHomeQueue.enqueue(m);
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
