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
   
   @SuppressWarnings("unchecked")
   public PriorityQueue(int priorities, int size)
   {
      array = (MyQueue<E>[]) new Object[priorities];
      for (int i=0; i < array.length; i++){
         array[i] = (MyQueue<E>) new Object();
         array[i].setSize(size);
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
      // TODO Auto-generated method stub
      return null;
   }

}
