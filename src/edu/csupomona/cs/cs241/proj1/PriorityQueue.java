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
 * This is a bounded queue with priority dequeuing. The lower the priority the higher the number.
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
    * @param size The max number of elements that there can be of each priority
    */
   @SuppressWarnings("unchecked")
   public PriorityQueue(int size, int priorities)
   {
      
      array = (MyQueue<E>[]) new MyQueue[priorities];
      
      // Makes an array of queues
      for (int i=0; i < array.length; i++){
         array[i] = (MyQueue<E>) new MyQueue(size);
      }
   }    
   

   /**
    * This adds the item passed to the queue with a specific priority. Low is high.
    * if the priority passed is less than 1 or greater than the greatest priorities, 
    * it is truncated to 1 and the highest priority respectively. 
    * 
    * @pre the {@code item} is not null and the queue is not full
    * @post {@code item} is enqueued
    * @param item The item to be added
    * @param priority The priority to add the element at 
    * @return whether the element was added or not
    */
   public boolean enqueue(E item, int priority)
   {
      if (priority  > array.length ) {priority = array.length;}
      if (priority < 1) { priority = 1;}
      
      if (array[priority - 1].isFull()){
         return false;
      }
      return array[priority - 1].enqueue(item);
   }

   /**
    * This removes and returns the item in order of priority. Low is high.
    * First it returns item by priority, if two elements are of the same priority 
    * the one that was added first is removed first (FIFO)
    * 
    * @pre the queue must not be empty
    * @post the item is removed and returned to caller
    * @return the item removed
    */
   public E dequeue()
   {
      E  temp;
      // Runs through the queues starting with the highest priority and tries 
      // to dequeue any element. When it does it returns
      for(int i=0; i < array.length; i++){
        if ((temp = array[i].dequeue()) != null)
           return temp;
      }
      
      // Just in case the caller doesn't fulfill the contract this gives it 
      // lee way by returning null of the queue is empty.
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
