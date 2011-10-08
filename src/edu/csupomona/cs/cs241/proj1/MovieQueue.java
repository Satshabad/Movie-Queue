/**
 * 
 */
package edu.csupomona.cs.cs241.proj1;

/**
 * @author Satshabad
 *
 */
public class MovieQueue
{
   private PriorityQueue<Movie> waitingQueue;
   private MyQueue<Movie> atHomeQueue;
   
      MovieQueue(int numberOfMovies, int numberOfPriortities){
         waitingQueue = new PriorityQueue<Movie>(numberOfMovies, numberOfPriortities);
         atHomeQueue = new MyQueue<Movie>(numberOfMovies);
      }
      
      MovieQueue(PriorityQueue<Movie> savedWaitingQueue, MyQueue<Movie> savedAtHomeQueue)
      {
            waitingQueue = savedWaitingQueue;
            atHomeQueue = savedAtHomeQueue;
      }

      public boolean addMovietoWaiting(Movie m, int priority){
         return waitingQueue.enqueue(m, priority);
      }
      
      public boolean sendMovieHome(){
        Movie m = waitingQueue.dequeue();
        if (m == null){ return false;}
        return atHomeQueue.enqueue(m);
      }
      
      public boolean sendMovieHomeByPriority(){
         Movie m = waitingQueue.dequeueByPriority();
         if (m == null){ return false;}
         return atHomeQueue.enqueue(m);
       }

      
      
      /**
       * @return the waitingQueue
       */
      public PriorityQueue<Movie> getWaitingQueue()
      {
         return waitingQueue;
      }
      

      /**
       * @return the atHomeQueue
       */
      public MyQueue<Movie> getAtHomeQueue()
      {
         return atHomeQueue;
      }
      
      
}
