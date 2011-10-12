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
   
   public MovieSystemManager() throws IOException, ClassNotFoundException
   {
      this.theMovieLibrary = new MovieLibrary();
      this.theMovieQueue = new MovieQueue(theMovieLibrary.getNumberOfMovies(), NUM_OF_PRIORITIES);
   }
   
   public void addToMovieQueue(Movie m, int priority)
   {
            
      theMovieQueue.addMovietoWaiting(m, priority);

   }
   
   public void deliverMovieByPrioirity(){
         theMovieQueue.sendMovieHomeByPriority();

   }

   public void deliverMovie(){

      theMovieQueue.sendMovieHome();
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
            case 'p':
               return theMovieQueue.displayWaitingMoviesByPriority();
            case 'w':
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

   public Movie[] getWaitingQueueByPriority(){
      return getMoviesForDisplay('p');
   }
   
   public Movie[] getatHomeQueue(){
      return getMoviesForDisplay('h');
   }
   
   public Movie[] getMoviesListedByTitle(){
      return getMoviesForDisplay('t');
   }
   
   public Movie[] getMoviesListedByDirector(){
      return getMoviesForDisplay('d');
   }
   
   public Movie[] getMoviesListedByGenre(){
      return getMoviesForDisplay('g');
   }
   
   public Movie[] getMoviesListedByMainActor(){
      return getMoviesForDisplay('m');
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

   public Movie[] searchByTitle(String target)
   {
      return theMovieLibrary.searchBy('t', target);
   }

   public Movie[] searchByActor(String target)
   {
      return theMovieLibrary.searchBy('a', target);
   }

   public Movie[] searchByDirector(String target)
   {
      return theMovieLibrary.searchBy('d', target);
   }

   public Movie[] searchByGenre(String target)
   {
      return theMovieLibrary.searchBy('g', target);
   }

   public void sendMovieBack()
   {
      theMovieQueue.returnMovie();
   }

   
   
}
