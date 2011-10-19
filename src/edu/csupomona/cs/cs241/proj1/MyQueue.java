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

/**
 * This is a unbounded queue implemented with a circular array.
 * 
 * @author Satshabad Khalsa
 * 
 * @param <E>
 *            The type of {@link java.lang.Object} to be used in this queue
 */
public class MyQueue<E extends Serializable> implements Serializable, Queue<E> {

    /**
     * For serialization.
     */
    private static final long serialVersionUID = -8439111171987671336L;

    /**
     * The array to hold the queue elements.
     */
    private E[] array;

    /**
     * The capacity of the array.
     */
    private int capacity;

    /**
     * Points to the last element of the queue.
     */
    private int tail;

    /**
     * Points to the first element of the queue.
     */
    private int head;

    /**
     * The number of elements in the array.
     */
    private int size;

    /**
     * Constructs the Queue with a specific size.
     * 
     * @pre
     * @post an instance of this class is created.
     * @param capacity
     *            the size of the queue to be made
     */
    @SuppressWarnings("unchecked")
    public MyQueue(int capacity) {
        // Due to indexing problem the first spot in the queue is never filled,
        // so we just increase the users size by one so the user never notices
        this.capacity = capacity + 1;
        array = (E[]) new Serializable[capacity];
        this.capacity = capacity;
        tail = 0;
        head = 0;
        size = 0;

    }

    /**
     * This used to be a method to copy an object but has since been deprecated.
     * 
     * @param q
     * @deprecated
     */
    public MyQueue(MyQueue<E> q) {
        this.array = q.array;
        this.capacity = q.capacity;
        this.head = q.head;
        this.tail = q.tail;
        this.size = q.size;
    }

    /**
     * Adds the given item to the end of the queue.
     * 
     * @pre the item to be added is not null
     * @post The item is added at the end of the queue
     * @param item
     *            The item to be added to the queue
     */
    public void enqueue(E item) {
        if (isFull()) {
            increaseQueueSize();
        }
        tail = (tail + 1) % capacity;
        array[tail] = item;
        size++;
    }

    /**
     * Removes and returns the item from the beginning of the queue.
     * 
     * @pre The queue is not full
     * @post The item is removed queue
     * @return the item removed from the queue or null if the queue is empty
     */
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        head = (head + 1) % capacity;
        @SuppressWarnings("unchecked")
        E temp = (E) array[head];
        size--;
        return temp;
    }

    /**
     * Finds out the number of elements in the queue.
     * 
     * @pre
     * @post the size is returned
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * Finds out if the queue is empty.
     * 
     * @pre
     * @post the correct boolean will be returned
     * @return true if the queue is empty, false if it is not
     */
    public boolean isEmpty() {
        return head == tail;
    }

    /**
     * Finds out if the queue is full.
     * 
     * @pre
     * @post the correct boolean will be returned
     * @return true if the queue is full, false if it is not
     */
    public boolean isFull() {
        return (tail + 1) % capacity == head;
    }

    /**
     * This internal method doubles the size of the array.
     * 
     * @pre
     * @post the array will be double it's original size and contain all the
     *       elements in their original order
     */
    private void increaseQueueSize() {
        @SuppressWarnings("unchecked")
        E[] theNewArray = (E[]) new Serializable[(int) (capacity * 2)];
        capacity = capacity * 2;
        head = 0;
        int i;
        for (i = 0; i < array.length; i++) {
            theNewArray[i] = array[i];
        }
        tail = i - 1;
        array = theNewArray;
    }

}
