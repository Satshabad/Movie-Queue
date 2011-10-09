package edu.csupomona.cs.cs241.proj1;

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
   private StringPointerPair[] DirectorList;
   
       
   /**
    * This constructor creates the MovieLibrary object and populates it with the list of movies.
    */
   MovieLibrary(){
      FileManager fm = new FileManager();
      movieList = fm.getMoviesFromFile();
      
      int size = movieList.length;
      
      titleList = new StringPointerPair[size];
      genreList = new StringPointerPair[size];
      actorList = new StringPointerPair[size*3];
      DirectorList = new StringPointerPair[size];
      populateReferenceList();
      
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
         DirectorList[i] = new StringPointerPair(m.getDirector(), m);
      }
      
       
    }
      
   
   /**
    * This method implements binary search for a full matching string in the given array. It will find all instances of that string
    * 
    * @param array
    * @param target
    * @return
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
}
