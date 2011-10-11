/**
 * 
 */
package edu.csupomona.cs.cs241.proj1;

import java.io.IOException;

/**
 * @author Satshabad
 *
 */
public class MovieSystemManager
{
   private MovieQueue theMovieQueue;
   private MovieLibrary theMovieLibrary;
   private final int NUM_OF_PRIORITIES = 3;
   private boolean priorityMode; 
   
   public MovieSystemManager() throws IOException, ClassNotFoundException
   {
      this.theMovieLibrary = new MovieLibrary();
      this.theMovieQueue = new MovieQueue(theMovieLibrary.getNumberOfMovies(), NUM_OF_PRIORITIES);
      priorityMode = false;
   }
   
   public void addToMovieQueue(Movie m, int priority)
   {
      if (priorityMode) {theMovieQueue.addMovietoWaiting(m, priority);}
      else theMovieQueue.addMovietoWaiting(m, 2);
   }
   
   public void deliverMovie(){
      if (priorityMode){theMovieQueue.sendMovieHomeByPriority();}
      else {theMovieQueue.sendMovieHome();}
   }
   
   public Movie returnMovie(){
      return theMovieQueue.returnMovie();
   }
   
   /**
    * @param c
    * @return the list of movies in correct order or null if input was not {@code w} {@code h} {@code t} {@code d} {@code g} or {@code m}
    */
   private Movie[] getMoviesForDisplay(char c)
   {
      switch (c)
         {
            case 'w':
               if (priorityMode){return theMovieQueue.displayWaitingMoviesByPriority();}
               return theMovieQueue.displayWaitingMovies();
            case 'h':
               return theMovieQueue.displayMoviesAtHome();
            case 't':
               return theMovieLibrary.movieListBy(c);
            case 'd':
               return theMovieLibrary.movieListBy(c);
            case 'g':
               return theMovieLibrary.movieListBy(c);
            case 'm':
               return theMovieLibrary.movieListBy(c);
            default:
               return null;
         }
   }
   
   public Movie[] getWaitingQueue(){
      return getMoviesForDisplay('w');
   }
   
   public Movie[] getatHomeQueue(){
      return getMoviesForDisplay('h');
   }
   
   public Movie[] moviesListedByTitle(){
      return getMoviesForDisplay('t');
   }
   
   public Movie[] moviesListedByDirector(){
      return getMoviesForDisplay('d');
   }
   
   public Movie[] moviesListedByGenre(){
      return getMoviesForDisplay('g');
   }
   
   public Movie[] moviesListedByMainActor(){
      return getMoviesForDisplay('m');
   }
   
   /**
    * Set the state of the queue management, FIFO or priority mode
    * 
    * @param priorityMode {@code true} for priority mode and {@code false} for FIFO mode
    */
   public void setPriorityMode(boolean priorityMode)
   {
      this.priorityMode = priorityMode;
   }    
   
   public boolean exit(int n)  
   {
      try
      {
        theMovieQueue.save();
      } catch (IOException e)
      {
         if (n == 0){return false;}
         else System.exit(-1);
      }
      System.exit(0);
      return true;
   }
   
   
}
