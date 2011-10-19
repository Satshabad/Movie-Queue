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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * This utility class contains one method to make a deep copy of a
 * {@link Serializable} object
 * 
 * @author Satshabad
 * 
 */
public class DeepCopier {

    /**
     * This method takes an object and returns a copy of it with no references
     * connecting them.
     * 
     * @pre the passed object must not be null
     * @post the object returned has no connection with the passed object
     * @param tobeCopied
     *            the object to be copies.
     * @return an object that is a copy of the passed object but shares no
     *         reference with it.
     */
    public static Serializable copy(Serializable tobeCopied) {
        Serializable copy = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(bos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.writeObject(tobeCopied);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new ByteArrayInputStream(
                    bos.toByteArray()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            copy = (Serializable) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return copy;

    }

}
