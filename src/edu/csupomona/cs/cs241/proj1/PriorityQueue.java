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
 * @author Satshabad Khalsa
 *
 */
public class PriorityQueue<E>
{
   private MyQueue<E> array[];
   private int priorities;
   
   @SuppressWarnings("unchecked")
   public PriorityQueue(int priorities, int size)
   {
      array = (MyQueue<E>[]) new MyQueue[priorities];
      for (int i=0; i < array.length; i++){
         array[i] = (MyQueue<E>) new MyQueue(size);
         this.priorities = priorities;
      }
   }    
   

   public boolean enqueue(E item, int priority)
   {
      if (array[priority - 1].isFull()){
         return false;
      }
      return array[priority - 1].enqueue(item);
   }

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
