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

import java.util.Stack;

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
   private MyQueue<QueueItemShell<E>> array[]; 
   
   /**
    * This hold the queue elements in normal queue order
    */
   private MyQueue<QueueItemShell<E>> normalQueue;
   
   /**
    * This keeps track of the order in which the elements are added.
    * it also acts as a unique id passed to the wrapper class 
    */
   private int orderCounter;

   /**
    * This constructor creates a priority queue. 
    * 
    * @pre priorities and size must be greater than {@code 0}
    * @post a priority queue is created
    * @param size The max number of elements that there can be of each priority
    * @param priorities The number of priorities to use in your queue
    */
   @SuppressWarnings("unchecked")
   PriorityQueue(int size, int priorities)
   {
      
      array = (MyQueue<QueueItemShell<E>>[]) new MyQueue[priorities];
      normalQueue =  (MyQueue<QueueItemShell<E>>) new MyQueue<E>(size);
      // Makes an array of queues
      for (int i=0; i < array.length; i++){
         array[i] = (MyQueue<QueueItemShell<E>>) new MyQueue<QueueItemShell<E>>(size);
      }
      orderCounter = 0;
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
      if (normalQueue.isFull()){
         return false;
      }
      if (array[priority - 1].isFull()){
         return false;
      }
      QueueItemShell<E> wrapper = new QueueItemShell<E>(item, priority, orderCounter++);
      if (!array[priority - 1].enqueue(wrapper)) {return false;}
      if (!normalQueue.enqueue(wrapper)) {return false;}
      return true;
   }

   /**
    * This adds the item passed to the method to the end of the queue.
    * Internally it is automatically given the lowest priority. 
    * 
    * @pre the item is not null and the queue is not full
    * @post the item is added to the end of queue
    * @param item the item to be added
    * @return where the item has been added or not.
    */
   public boolean enqueue(E item)
   {
      if (item == null) {return false;}
      if (normalQueue.isFull()){
         return false;
      }
      if (array[array.length].isFull()){
         return false;
      }
      QueueItemShell<E> wrapper = new QueueItemShell<E>(item, array.length, orderCounter++);
      if (!array[array.length].enqueue(wrapper)) {return false;}
      if (!normalQueue.enqueue(wrapper)) {return false;}
      return true;
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
   public E dequeueByPriority()
   {
      if (isEmpty()){return null;}
      QueueItemShell<E>  temp = null;
      // Runs through the queues starting with the highest priority and tries 
      // to dequeue any element. When it does it returns
      for(int i=0; i < array.length; i++){
        if ((temp = array[i].dequeue()) != null)
           break;
        }
      Stack<QueueItemShell<E>> tempStack = new Stack<QueueItemShell<E>>();
      QueueItemShell<E> compareTemp;
      while(!normalQueue.isEmpty()){
         compareTemp = normalQueue.dequeue();
         if (compareTemp.getPriority() == temp.getPriority()){
            while (!tempStack.isEmpty())
            {
               normalQueue.enqueue(tempStack.pop());
            }
            return compareTemp.getItem();
         }
         tempStack.push(compareTemp);
      }
      
      // Just in case the caller doesn't fulfill the contract this gives it 
      // lee way by returning null of the queue is empty.
      return null;
   }
   
   /**
    * This removes and returns an item in FIFO order, regardless of priority.
    * 
    * @pre the queue is not empty
    * @post the item is removed and returned to the caller
    * @return the item at the front of the queue
    */
   public E dequeue(){
      if (isEmpty()){return null;}
      QueueItemShell<E> temp = normalQueue.dequeue();
      Stack<QueueItemShell<E>> tempStack = new Stack<QueueItemShell<E>>();
      QueueItemShell<E> compareTemp;
      int pri = temp.getPriority();
      int place = temp.getPlaceInQueue();
      while(!array[pri-1].isEmpty()){
         compareTemp = array[pri-1].dequeue();
         if (compareTemp.getPlaceInQueue() == place){
            while (!tempStack.isEmpty())
            {
               normalQueue.enqueue(tempStack.pop());
            }
            return compareTemp.getItem();
         }
         tempStack.push(compareTemp);
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
