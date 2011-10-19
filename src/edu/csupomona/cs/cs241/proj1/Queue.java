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

/**
 * This is a Queue interface.
 * 
 * @author Satshabad
 * 
 */
public interface Queue<E> {

    /**
     * Adds the given item to the end of the queue.
     * 
     * @pre The queue is not full and the item to be added is not null
     * @post The item is added at the end of the queue
     * @param item
     *            The item to be added to the queue
     */
    void enqueue(E item);

    /**
     * Removes and returns the item from the beginning of the queue.
     * 
     * @pre The queue is not full
     * @post The item is removed queue
     * @return the item removed from the queue or null if the queue is empty
     */
    E dequeue();

}
