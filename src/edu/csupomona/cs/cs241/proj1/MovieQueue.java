/**
 * 
 */
package edu.csupomona.cs.cs241.proj1;

/**
 * This holds the users movies that are added to it.
 * 
 * @author Satshabad
 *
 */
public class MovieQueue
{
   /**
    * Holds the movies in a normal queue order
    */
   private MyQueue<Movie> normalQueue;
   
   /**
    * Holds the movies in the priorities they were given.
    * if no priority was given, lowest priority is assumed.
    */
   private PriorityQueue<Movie> priQueue;
   
   private boolean normalQueueState;
   
   private int priorities;
   
   public MovieQueue(int size, int priorities)
   {
      this.priorities = priorities;
      normalQueue = new MyQueue<Movie>(size);
      priQueue = new PriorityQueue<Movie>(size, priorities);
      normalQueueState = true;
   }
   
   public boolean enqueue(Movie m){
      if (normalQueue.enqueue(m) == false) {return false;}
      if (priQueue.enqueue(m, priorities) == false) {return false;}
      return true;
   }
   
   public boolean enqueue(Movie m, int priority){
      if (normalQueue.enqueue(m) == false) {return false;}
      if (priQueue.enqueue(m, priority) == false) {return false;}
      return true;
   }
   
   public Movie dequeue()
   {
      if(normalQueueState){
         normalQueue.dequeue();
      }
      else{

      }
      return null;
   }
}
