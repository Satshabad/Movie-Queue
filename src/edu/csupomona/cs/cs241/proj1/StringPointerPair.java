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
 * This class is used to hold {@link Movie} attributes and links to their
 * respective {@link Movie}.
 * 
 * @author Satshabad
 * 
 */
public class StringPointerPair implements Comparable<StringPointerPair> {
    /**
     * The movie's attribute
     */
    private String theField;

    /**
     * The attribute's Movie
     */
    private Movie theMovie;

    /**
     * This creates an instance of this class with the passed fields
     * 
     * @param s
     *            the {@link Movie}'s attribute (e.g. title)
     * @param m
     *            a reference to the attribute's correct movie
     */
    public StringPointerPair(String s, Movie m) {
        theField = s;
        theMovie = m;
    }

    /**
     * Gets the Movie's attribute
     * 
     * @pre
     * @post
     * @return the attribute
     */
    public String getTheField() {
        return theField;
    }

    /**
     * Gets a reference to the Movie
     * 
     * @pre
     * @post
     * @return the theMovie
     */
    public Movie getTheMovie() {
        return theMovie;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(StringPointerPair o) {
        if (theField.equalsIgnoreCase(o.getTheField())) {
            return 0;
        }
        if (theField.compareToIgnoreCase(getTheField()) > 0) {
            return 1;
        }
        if (theField.compareToIgnoreCase(o.getTheField()) < 0) {
            return -1;
        }
        return 0;
    }
}
