package edu.csupomona.cs.cs241.proj1;

public class MovieLibrary
{
   public Movie[] movieList;
   private StringPointerPair[] titleList;
   private StringPointerPair[] genreList;
   private StringPointerPair[] actorList;
   private StringPointerPair[] DirectorList;
   
       
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
   
    public StringPointerPair[] binarySearch(StringPointerPair[] array, String target){
        StringPointerPair[] instances = new StringPointerPair[array.length];
       int low = 0;
       int i = 0;
       int high = array.length;
       boolean allFound = false;
       while (!allFound){
         int mid = (high+low)/2;
         System.err.println(mid);
         if (array[mid].getTheField().equalsIgnoreCase(target)){
            instances[i++] = array[mid];
            
            for(int j = mid+1; j < high; j++){
               if (array[j].getTheField().equalsIgnoreCase(target)){
                  instances[i++] = array[j];
               }
            }  
            
            for(int k = mid-1; k > low; k--){
               if (array[k].getTheField().equalsIgnoreCase(target)){
                  instances[k++] = array[k];
               }
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
