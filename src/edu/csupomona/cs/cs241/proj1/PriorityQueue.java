/**
 * CS 241: Data Structures and Algorithms II
 * Professor: Edwin Rodr&iacute;guez
 *
 * Programming Assignment 1
 *
 * <description-of-assignment>
 *
 * Satshbaad Khalsa
 */

package edu.csupomona.cs.cs241.proj1;

/**
 * This is a queue with priority dequeuing. The lower the priority the higher the number.
 * 
 * @author Satshabad Khalsa
 *
 */
public class PriorityQueue<E>
{
   /**
    * The array that holds the queues of different priorities
    */
   private MyQueue<E> array[]; 
   
   /**
    * This constructor creates a priority queue. 
    * 
    * @pre priorities and size must be greater than {@code 0}
    * @post a priority queue is created
    * @param priorities The number of priorities to use in your queue
    * @param size The max number of elements that the queue will hold
    */
   @SuppressWarnings("unchecked")
   public PriorityQueue(int priorities, int size)
   {
      array = (MyQueue<E>[]) new MyQueue[priorities];
      for (int i=0; i < array.length; i++){
         array[i] = (MyQueue<E>) new MyQueue(size/priorities);
      }
   }    
   

   /**
    * This adds the item passed to the queue with a specific priority. Low is high
    * 
    * @pre the {@code item} is not null and the queue is not full
    * @post {@code item} is enqueued
    * @param item The item to be added
    * @param priority The priority to add the element at 
    * @return whether the element was added or not
    */
   public boolean enqueue(E item, int priority)
   {
      if (priority  < array.length ) priority = array.length;
      if (priority > 0) priority = 0;
      
      if (array[priority - 1].isFull()){
         return false;
      }
      return array[priority - 1].enqueue(item);
   }

   /**
    * This removes and returns the item in order of priority. Low is high
    * 
    * @pre the queue must not be empty
    * @post the item is removed and returned to caller
    * @return the item removed
    */
   public E dequeue()
   {
      E  temp;
      for(int i=0; i < array.length; i++){
        if ((temp = array[i].dequeue()) != null)
           return temp;
      }
      return null;
   }
   
   public boolean isEmpty(){
      for(int i=0; i < array.length; i++){
         if (!array[i].isEmpty()){
            return false;
         }
      }
      return true;
   } 
}
