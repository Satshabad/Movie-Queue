/**
 * CS 241: Data Structures and Algorithms II
 * Professor: Edwin Rodr&iacute;guez
 *
 * Programming Assignment 1
 *
 * This assignment is to create a netflix like movie queue and give it added functionality
 *
 * Satshabad Khalsa  
 */
package edu.csupomona.cs.cs241.proj1;

import java.io.Serializable;
import java.util.Stack;

/**
 * This is a bounded queue with priority dequeuing. The lower the priority the higher the number.
 * 
 * @author Satshabad Khalsa
 *
 */
public class PriorityQueue<E extends Serializable> implements Serializable
{
   /**
    * 
    */
   private static final long serialVersionUID = 3773878027018179872L;

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
   
   private int size;

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
      
      // Makes a normal queue to hold elements in original order, regardless of priority
      normalQueue =  (MyQueue<QueueItemShell<E>>) new MyQueue<E>(size);
      
      // Makes an array of queues
      for (int i=0; i < array.length; i++){
         array[i] = (MyQueue<QueueItemShell<E>>) new MyQueue<QueueItemShell<E>>(size);
      }
      orderCounter = 0;
      size = 0;
   }    
   
   /**
    * This is a cloning constructor which takes a param of the {@link PriorityQueue} to be cloned from.
    * 
    * @pre p must not be null
    * @post the fields of p are now the fields of {@code this}
    * @param p the {@link PriorityQueue} to be cloned from
    */
   public PriorityQueue(PriorityQueue<E> p)
   {
      this.array = p.array;
      this.normalQueue = p.normalQueue;
      this.orderCounter = p.orderCounter;
      this.size = p.size;
   }

   /**
    * This adds the item passed to the queue with a specific priority. Low is high.
    * if the priority passed is less than 1 or greater than the greatest priorities, 
    * it is truncated to 1 and the highest priority respectively. 
    * 
    * @pre the {@code item} is not null
    * @post {@code item} is enqueued
    * @param item The item to be added
    * @param priority The priority to add the element at 
    */
   public void enqueue(E item, int priority)
   {
      if (item == null){return;}
      // Makes sure that the priority given is in bounds of set priority, if not changes it
      if (priority  > array.length ) {priority = array.length;}
      if (priority < 1) { priority = 1;}

      // Wraps the item to be added in a wrapper class and 
      // stores data about the items position in the wrapper class
      QueueItemShell<E> wrapper = new QueueItemShell<E>(item, priority, orderCounter++);
      array[priority - 1].enqueue(wrapper);
      normalQueue.enqueue(wrapper);
      size++;

   }

   /**
    * This adds the item passed to the method to the end of the queue.
    * Internally it is automatically given the lowest priority. 
    * 
    * @pre the item is not null
    * @post the item is added to the end of queue
    * @param item the item to be added
    */
   public void enqueue(E item)
   {
      // Makes sure that the priority given is in bounds of set priority, if not changes it
      if (item == null) {return;}
      
      // Wraps the item to be added in a wrapper class and 
      // stores data about the items position in the wrapper class
      QueueItemShell<E> wrapper = new QueueItemShell<E>(item, array.length, orderCounter++);
      array[array.length-1].enqueue(wrapper);
      normalQueue.enqueue(wrapper);
      size++;
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
      // to dequeue any element. When it breaks
      for(int i=0; i < array.length; i++){
        if ((temp = array[i].dequeue()) != null)
           break;
        }
      
      // Here it takes the item to be dequeued and returned and dumps out element into a 
      // temporary stack until it finds a match then also dequeues the match from 
      // the sister data set and returns the item to the caller
      Stack<QueueItemShell<E>> tempStack = new Stack<QueueItemShell<E>>();
      QueueItemShell<E> compareTemp;
      while(!normalQueue.isEmpty()){
         compareTemp = normalQueue.dequeue();
         if (compareTemp.getPriority() == temp.getPriority()){
            while (!tempStack.isEmpty())
            {
               normalQueue.enqueue(tempStack.pop());
            }
            size--;
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
      
      // Here it takes the item to be dequeued and returned and dumps out element into a 
      // temporary stack until it finds a match then also dequeues the match from 
      // the sister data set and returns the item to the caller
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
            size--;
            return compareTemp.getItem();
         }
         tempStack.push(compareTemp);
      }
      
      return null;
      
   }
   
   /**
    * Checks whether the queue is empty or not
    * 
    * @post a {@code boolean} will be returns to the user
    * @return where the queue is empty or not
    */
   public boolean isEmpty(){
      for(int i=0; i < array.length; i++){
         if (!array[i].isEmpty()){
            return false;
         }
      }
      return true;
   }

   public int getSize()
   {
      return size;
   } 
}
