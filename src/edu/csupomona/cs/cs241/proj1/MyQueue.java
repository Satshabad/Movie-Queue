/**
 * CS 241: Data Structures and Algorithms II
 * Professor: Edwin Rodr&iacute;guez
 *
 * Programming Assignment 1
 *
 * This assignmemnt is to create a netflix like movie queue and give it added functionality
 *
 * Satshabad Khalsa  
 */

package edu.csupomona.cs.cs241.proj1;

import java.io.Serializable;

/**
 * This is a unbounded queue implemented with a circular array.
 * 
 * @author Satshabad Khalsa
 *
 * @param <E> The type of {@link java.lang.Object} to be used in this queue
 */
public class MyQueue<E> implements Queue<E>, Serializable
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
      // Due to indexing problem the first spot in the queue is never filled, 
      // so we just increase the users size by one so the user never notices
      size = size + 1;
      array = (E[]) new Object[size];
      this.size = size;
   }
   
   /**
    * Adds the given item to the end of the queue. 
    * 
    * @pre the item to be added is not null
    * @post The item is added at the end of the queue
    * @param item The item to be added to the queue
    */
   public void enqueue(E item){
      if (isFull()){
         increaseQueueSize();
      }   
      tail = (tail + 1) % size;
      array[tail] = item;
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
   
   private void increaseQueueSize()
   {
      @SuppressWarnings("unchecked")
      Object theNewArray[] = (E[]) new Object[(int) (size*2)];
      size = size*2;
      head = 0;
      int i;
      for (i = 0; i < array.length; i++)
         {
            theNewArray[i] = array[i];
         }
      tail = i - 1;
      array = theNewArray;
   }
   
}
