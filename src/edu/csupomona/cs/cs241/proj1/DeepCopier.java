package edu.csupomona.cs.cs241.proj1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * This utility class makes deep copies of any {@link Serializable} object.
 * 
 * @author Satshabad
 * 
 */
public class DeepCopier {

    /**
     * This utility class may not be instantiated.
     */
    protected DeepCopier() {
    }

    /**
     * This method makes a deep copy of any {@link Serializable} object.
     * 
     * @pre the item to be copied must not be {@code null}
     * @post a new object with exactly the same fields will be created and will
     *       share no reference with the passed object
     * @param tobeCopied
     *            the {@link Serializable} object to be copied
     * @return a copy of the passed object with no reference to the passed
     *         object
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
