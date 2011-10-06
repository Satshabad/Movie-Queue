/**
 * CS 241: Data Structures and Algorithms II
 * Professor: Edwin Rodr&iacute;guez
 *
 * Programming Assignment 1
 *
 * <description-of-assignment>
 *
 * Satshabad Khalsa  
 */

package edu.csupomona.cs.cs241.proj1;

/**
 * @author Satshabad Khalsa
 *
 * @param <E> The type of {@link java.lang.Object} to be used in this queue
 */
public class MyQueue<E> implements Queue<E>
{
   /**
    * The array to hold the queue elements
    */
   private Object array[];
   
   /**
    * The size of the the array
    */
   private int size;
   
   /**
    * Points to the last element of the queue 
    */
   private int tail = 0;
   
   /**
    * Points to the first element of the queue
    */
   private int head = 0;
   
   
   /**
    * Constructs the Queue with a specific size
    * 
    * @param size the size of the queue to be made
    */
   @SuppressWarnings("unchecked")
   public MyQueue(int size){
      size = size + 1;
      array = (E[]) new Object[size];
      this.size = size;
   }
   
   /**
    * Adds the given item to the end of the queue. 
    * 
    * @pre The queue is not full and the item to be added is not null
    * @post The item is added at the end of the queue
    * @param item The item to be added to the queue
    * @return whether the item has  been added to the queue or not
    */
   public boolean enqueue(E item){
      if (isFull()){
         return false;
      }   
      tail = (tail + 1) % size;
      array[tail] = item;
      
      return true;
   }
   
   
   /**
    * Removes and returns the item from the beginning of the queue.
    * 
    * @pre The queue is not full
    * @post The item is removed queue
    * @return the item removed from the queue or null if the queue is empty
    */
   public E dequeue(){
      if (isEmpty()){
         return null;
      }
      head = (head +1) % size;
      @SuppressWarnings("unchecked")
      E temp = (E) array[head];
      return temp;
   }
   
   
   /**
    * Finds out if the queue is empty
    * 
    * @return whether the queue is empty or not
    */
   public boolean isEmpty(){
      return head == tail;
   }

   /**
    * Finds out if the queue is full
    * 
    * @return whether the queue is full or not
    */
   public boolean isFull()
   {
      return (tail +1) % size == head;
   }
   
   
   
}
