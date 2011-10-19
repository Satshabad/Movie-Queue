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
 * @author Satshabad Khalsa
 * 
 */
public class Movie implements Serializable {
    /**
     * The serial for serialization.
     */
    private static final long serialVersionUID = 6214120954635819543L;

    /**
     * The title of the movie.
     */
    private String title;

    /**
     * The genre of the movie.
     */
    private String genre;

    /**
     * The first actor in the movie.
     */
    private String actorOne;

    /**
     * The second actor in the movie.
     */
    private String actorTwo;

    /**
     * The third actor in the movie.
     */
    private String actorThree;

    /**
     * The director of the movie.
     */
    private String director;

    /**
     * Constructs a movie consisting of the passes attributes.
     * 
     * @param name
     *            the name of the film
     * @param genre
     *            the genre of the film
     * @param actorOne
     *            the main actor of the film
     * @param actorTwo
     *            another actor in the film
     * @param actorThree
     *            yet another actor in the film
     * @param director
     *            the director of the film
     */
    Movie(String name, String genre, String actorOne, String actorTwo,
            String actorThree, String director) {
        this.title = name;
        this.genre = genre;
        this.actorOne = actorOne;
        this.actorTwo = actorTwo;
        this.actorThree = actorThree;
        this.director = director;
    }

    /**
     * Gets the name of the movie.
     * 
     * @return name of the movie
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the genre of the movie.
     * 
     * @return genre of the movie
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Gets the name the first actor in the movie.
     * 
     * @return name of the actor
     */
    public String getActorOne() {
        return actorOne;
    }

    /**
     * Gets the name the second actor in the movie.
     * 
     * @return name of the actor
     */
    public String getActorTwo() {
        return actorTwo;
    }

    /**
     * Gets the name the third actor in the movie.
     * 
     * @return name of the actor
     */
    public String getActorThree() {
        return actorThree;
    }

    /**
     * Gets the name of the director of this movie.
     * 
     * @return director name
     */
    public String getDirector() {
        return director;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "" + title + ", \n" + "Director: " + director + ", \n"
                + "Actors: " + actorOne + ", " + actorTwo + ", " + actorThree
                + ", \n" + "Genre: " + genre + "\n";

    }

}
