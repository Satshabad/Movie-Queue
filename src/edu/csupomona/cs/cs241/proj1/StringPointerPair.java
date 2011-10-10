/**
 * 
 */
package edu.csupomona.cs.cs241.proj1;

/**
 * @author Satshabad
 *
 */
public class StringPointerPair implements Comparable<StringPointerPair>
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

   @Override
   public int compareTo(StringPointerPair o)
   {
      if (theField.equalsIgnoreCase(o.getTheField())){return 0;}
      if (theField.compareToIgnoreCase(getTheField()) > 0){return 1;}
      if (theField.compareToIgnoreCase(o.getTheField()) < 0){return -1;}
      return 0;
   }
}
