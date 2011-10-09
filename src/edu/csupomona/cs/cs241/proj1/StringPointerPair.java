/**
 * 
 */
package edu.csupomona.cs.cs241.proj1;

/**
 * @author Satshabad
 *
 */
public class StringPointerPair
{
   private String theField;
   private Movie theMovie;
   
   public StringPointerPair(String s, Movie m)
   {
      theField = s;
      theMovie = m;
   }

   /**
    * @return the theField
    */
   public String getTheField()
   {
      return theField;
   }

   /**
    * @return the theMovie
    */
   public Movie getTheMovie()
   {
      return theMovie;
   }
}
