/**
 * CS 241: Data Structures and Algorithms II
 * Professor: Edwin Rodr&iacute;guez
 *
 * Programming Assignment 1
 *
 * <description-of-assignment>
 *
 * Satshabad Khalsa
 */

package edu.csupomona.cs.cs241.proj1;

/**
 * @author Satshabad Khalsa
 *
 */
public class Movie
{
   private String name;
   private String genre;
   private String actorOne;
   private String actorTwo;
   private String actorThree;
   private String director;
   
   /**
    * Constructs a movie consisting of the passes attributes
    * 
    * @param name the name of the film
    * @param genre the genre of the film
    * @param actorOne the main actor of the film
    * @param actorTwo another actor in the film
    * @param actorThree yet another actor in  the film
    * @param director the director of the film
    */
   Movie(String name, String genre, String actorOne,
         String actorTwo, String actorThree, String director){
      this.name = name;
      this.genre = genre;
      this.actorOne = actorOne;
      this.actorTwo = actorTwo;
      this.actorThree = actorThree;
      this.director = director;
   }
   
   /**
    * Gets the name of the movie
    * 
    * @return name of the movie
    */
   public String getName()
   {
      return name;
   }
 
   /**
    * Gets the genre of the movie
    * 
    * @return genre of the movie
    */
   public String getGenre()
   {
      return genre;
   }
   
   /**
    * Gets the name the first actor in the movie
    * 
    *  @return name of the actor
    */
   public String getActorOne()
   {
      return actorOne;
   }
   
   /**
    * Gets the name the second actor in the movie
    * 
    *  @return name of the actor
    */
   public String getActorTwo()
   {
      return actorTwo;
   }
   
   /**
    * Gets the name the third actor in the movie
    * 
    *  @return name of the actor
    */
   public String getActorThree()
   {
      return actorThree;
   }

   /**
    * Gets the name of the director of this movie
    * 
    * @return director name
    */
   public String getDirector(){
      return director;
   }
   
   
}
