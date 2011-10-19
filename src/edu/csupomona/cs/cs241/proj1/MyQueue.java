/**
 * CS 241: Data Structures and Algorithms II
 * Professor: Edwin Rodr&iacute;guez
 *
 * Programming Assignment 1
 *
 * This assignment is to create a netflix like movie
 * 
 * queue by which the user can sort search a
 * library of movies as well as add movies to
 * their queue by priority rather than just
 * FIFO order. They may freely switch
 * between FIFO and priority order. The
 * Queues are persistent and the library is extensible.
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
     * The serial for serialization.
     */
    private static final long serialVersionUID = 8083605114660050629L;

    /**
     * The array to hold the queue elements.
     */
    private E array[];

    /**
     * The capacity of the the array.
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
     * @param capacity
     *            the size of the queue to be made
     */
    @SuppressWarnings("unchecked")
    public MyQueue(int capacity) {
        // Due to indexing problem the first spot in the queue is never filled,
        // so we just increase the users size by one so the user never notices
        capacity = capacity + 1;
        array = (E[]) new Serializable[capacity];
        this.capacity = capacity;
        tail = 0;
        head = 0;
        size = 0;

    }

    /**
     * Creates a new queue from the passes one.
     * 
     * @pre passed queue must not be null
     * @post the field are be copied into this object
     * @param q
     *            the queue to be copies from
     * @deprecated deepcopier should work instead of this
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
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * Finds out if the queue is empty
     * 
     * @return whether the queue is empty or not
     */
    public boolean isEmpty() {
        return head == tail;
    }

    /**
     * Finds out if the queue is full
     * 
     * @return whether the queue is full or not
     */
    public boolean isFull() {
        return (tail + 1) % capacity == head;
    }

    /**
     * This internal method increases the queue size by double the current size.
     * 
     * @pre
     * @post the new queue (array) will be double the size of the old one and
     *       every element will be in the correct place
     */
    private void increaseQueueSize() {
        @SuppressWarnings("unchecked")
        E theNewArray[] = (E[]) new Serializable[(int) (capacity * 2)];
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
