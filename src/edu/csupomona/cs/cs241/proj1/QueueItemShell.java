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
 * This class wraps an object and holds information about it's priority and
 * place in a queue.
 * 
 * @author Satshabad
 * @param <E>
 *            the type of object to be wrapped
 */
public class QueueItemShell<E extends Serializable> implements Serializable {
    /**
     * the serial for serialization.
     */
    private static final long serialVersionUID = -1334304355784814880L;

    /**
     * The items priority in the queue.
     */
    private int priority;

    /**
     * The items place in the queue.
     */
    private int placeInQueue;

    /**
     * The actual item being held.
     */
    private E item;

    /**
     * This creates a wrapper class around the passed item with information
     * about its place and priority in a queue.
     * 
     * @param item
     *            the item to be wrapped
     * @param priority
     *            the items priority in a queue
     * @param placeInQueue
     *            the items place in a queue
     */
    QueueItemShell(E item, int priority, int placeInQueue) {
        this.item = item;
        this.placeInQueue = placeInQueue;
        this.priority = priority;
    }

    /**
     * Gets the priority.
     * 
     * @post the priority will be returned
     * @return the priority of the item on the queue
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Gets the place in the queue line.
     * 
     * @post the place will be returned
     * @return the place in line of the item on the queue
     */
    public int getPlaceInQueue() {
        return placeInQueue;
    }

    /**
     * Gets the item.
     * 
     * @post the item will be returned
     * @return the item being held
     */
    public E getItem() {
        return item;
    }

}
