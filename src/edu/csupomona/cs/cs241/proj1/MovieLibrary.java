package edu.csupomona.cs.cs241.proj1;

import java.lang.reflect.Method;

public class MovieLibrary
{
   
   /**
    * This holds a list of available movies
    */
   public Movie[] movieList;
   
   /**
    * This holds a list of strings and pointers where the string is the name of the film 
    * and the pointer points to the movie in {@link #movieList}
    */
   private StringPointerPair[] titleList;
   
   /**
    * This holds a list of strings and pointers where the string is the genre of the film 
    * and the pointer points to the movie in {@link #movieList}
    */
   private StringPointerPair[] genreList;
   
   /**
    * This holds a list of strings and pointers where the string is the name of the actor in the film 
    * and the pointer points to the movie in {@link #movieList}
    */
   private StringPointerPair[] actorList;
   
   /**
    * This holds a list of strings and pointers where the string is the name of the director of the film 
    * and the pointer points to the movie in {@link #movieList}
    */
   private StringPointerPair[] directorList;
   
   /**
    * This holds a list of strings and pointers where the string is the name of the main actor in the film 
    * and the pointer points to the movie in {@link #movieList}
    */
   private StringPointerPair[] mainActorList;
   
   int numberOfMovies;
   /**
    * This constructor creates the MovieLibrary object and populates it with the list of movies.
    */
   MovieLibrary(){
      FileManager fm = new FileManager();
      movieList = fm.getMoviesFromFile();
      
      numberOfMovies = movieList.length;
      
      titleList = new StringPointerPair[numberOfMovies];
      genreList = new StringPointerPair[numberOfMovies];
      actorList = new StringPointerPair[numberOfMovies*3];
      directorList = new StringPointerPair[numberOfMovies];
      mainActorList = new StringPointerPair[numberOfMovies];
      populateReferenceList();
      
   }
    

   /**
    * Returns the number of movies in the file
    * 
    * @return the numberOfMovies
    */
   public int getNumberOfMovies()
   {
      return numberOfMovies;
   }


   /**
    * This method puts together a string (either title, actor, director, or genre) and 
    * a pointer to the movie associated with that string and puts it in the appropriate list.
    * 
    * @pre The movieList.length must be > 0
    * @post The lists will be populated
    */
   private void populateReferenceList(){
       
       
       for (int i = 0, j = 0; i < movieList.length; i++, j +=3)
      {
         Movie m = movieList[i];
         titleList[i] = new StringPointerPair(m.getName(), m);
         genreList[i] = new StringPointerPair(m.getGenre(), m);
         actorList[j] = new StringPointerPair(m.getActorOne(), m);
         actorList[j+1] = new StringPointerPair(m.getActorTwo(), m);
         actorList[j+2] = new StringPointerPair(m.getActorThree(), m);
         directorList[i] = new StringPointerPair(m.getDirector(), m);
         mainActorList[i] = new StringPointerPair(m.getActorOne(), m);
      }
      
       
    }
      
   
   /**
    * This method has been replaced by linear search to add partial search functionality. 
    * it used to be a beautiful binary search method
    * 
    * @param array
    * @param target
    * @return 
    * @deprecated
    */
   public StringPointerPair[] binarySearch(StringPointerPair[] array, String target){
        StringPointerPair[] instances = new StringPointerPair[array.length];
       int low = 0;
       int i = 0;
       int high = array.length;
       boolean allFound = false;
       while (!allFound){
         int mid = (high+low)/2;
         if (array[mid].getTheField().equalsIgnoreCase(target)){
            instances[i++] = array[mid];

            int tempForward = mid +1;
            while (tempForward < array.length && array[tempForward].getTheField().equalsIgnoreCase(target)){
               System.out.println("here");
               instances[i++] = array[tempForward];
               tempForward++;
            }
            
            int tempBackward = mid -1;
            while (tempBackward > 0 && array[tempBackward].getTheField().equalsIgnoreCase(target)){
               instances[i++] = array[tempBackward];
               tempBackward--;
            }
            
         return instances;
         }
         
         if (target.compareToIgnoreCase(array[mid].getTheField()) > 0)
            {low = mid + 1;
               System.err.println("here");} 
         
         else if (target.compareToIgnoreCase(array[mid].getTheField()) < 0)
            {high = mid -1;
            System.err.println("heres");
            }
         
         if(low == high || high == 0)
            {allFound = true;}
       }
       return instances;
    }

   /**
    * This {@link Method} searched linearly for partial matches to the {@link String} passes in the field of the the array of {@link StringPointerPair} objects
    * 
    * @pre the array of {@link StringPointerPair} objects must be non null 
    * @post an array of {@link Movie} objects which have the matched in there respected fields is returned
    * @param array the array of {@link StringPointerPair} objects to search
    * @param target the string being search for
    * @return an array of {@link Movie} objects which have a field that match the passed {@link String}
    */
   private Movie[] search(StringPointerPair[] array, String target){
      Movie[] instances = new Movie[array.length];
      int j = 0;
      for (int i = 0; i < array.length; i++)
      {
         if(contains(target, array[i].getTheField())){instances[j++] = array[i].getTheMovie();}
      }
      return instances;
   }
   
   /**
    * This method searches movies by a criteria: Title, Actor, Genre, Director. It returns the matching movies in an array.
    * 
    * @pre the {@link #titleList}, {@link #directorList}, {@link #genreList}, {@link #actorList} must all be non null
    * @post the array of {@link Movie} objects will be returned or null if the {@code char} passed is not {@code t} {@code d} {@code g} or {@code a}
    * @param c a char which is the first letter of the criteria to be searched for: {@code t} {@code d} {@code g} or {@code a} for Title, Director, Genre or Actor respectively
    * @param target the {@link String} that is being searched for
    * @return the array of {@link Movie} objects or null if {@code char} was not valid, if array is empty then no matches were found.
    */
   public Movie[] searchBy(char c, String target)
   {
      switch (c)
         {
            case 't':
               return search(titleList, target);
            case 'd':
               return search(directorList, target);
            case 'g':
               return search(genreList, target);
            case 'a':
               return search(actorList, target);               
            default:
               return null;
         }
   }
   
   /**
    * This internal method finds out if a {@link String} is a subset of another {@link String}
    * 
    * @pre 
    * @post the boolean will be returned indicating if the string is a subset or not
    * @param target the potential subset {@link String} 
    * @param containedIn the potential superset {@link String}
    * @return true if {@code target} is a subset of {@code containedIn}
    */
   private boolean contains(String target, String containedIn)
   {
      if (containedIn == null || target == null) {return false;}
      
      if (containedIn.indexOf(target) < 0){ return false;}
      
      return true;
   }

   /**
    * This method sorts movies by a criteria: Title, Main actor, Genre, Director. It returns the matching movies in an array.
    * 
    * @pre the {@link #titleList}, {@link #directorList}, {@link #genreList}, {@link #mainActorListList} must all be non null
    * @post the array of {@link Movie} objects will be returned or null if the {@code char} passed is not {@code t} {@code d} {@code g} or {@code m}
    * @param c a char which is the first letter of the criteria to be searched for: {@code t} {@code d} {@code g} or {@code m} for Title, Director, Genre or Main actor respectively
    * @return the array of {@link Movie} objects or null if {@code char} was not valid, if array is empty then no matches were found.
    */
   public Movie[] movieListBy(char c)
   {
      HeapSorter<StringPointerPair> heapSorter = new HeapSorter<StringPointerPair>();
      switch (c)
         {
            case 't':
               heapSorter.sort(titleList);
               return stringPointersToMovies(titleList);
            case 'd':
               heapSorter.sort(directorList);
               return stringPointersToMovies(directorList);
            case 'g':
               heapSorter.sort(genreList);
               return stringPointersToMovies(genreList);
            case 'm':
               heapSorter.sort(mainActorList);
               return stringPointersToMovies(mainActorList);
            default:
               return null;
         }
   }


   private Movie[] stringPointersToMovies(StringPointerPair[] array)
   {
      Movie[] movieArray = new Movie[array.length];
      for (int i = 0; i < array.length; i++)
      {
         movieArray[i] = array[i].getTheMovie();
      }
      return movieArray;
   }
}
