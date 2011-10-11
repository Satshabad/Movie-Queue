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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;




public class TestDriver 
{

   /**
    * @param args
    * @throws IOException 
    * @throws ClassNotFoundException 
    */
   public static void main(String[] args) throws IOException, ClassNotFoundException
   {
//      MovieSystemManager msm = new MovieSystemManager();
//      msm.addToMovieQueue(new Movie("test7", "test", "test", "test", "test", "test"), 2);
//      msm.addToMovieQueue(new Movie("test8", "test", "test", "test", "test", "test"), 2);
//      msm.addToMovieQueue(new Movie("test9", "test", "test", "test", "test", "test"), 2);
//      Movie[] home = msm.getatHomeQueue();
//      Movie[] wait = msm.getWaitingQueue();
//      
//      for (Movie movie : wait)
//      {
//         System.out.println(movie);
//      }
//      
//      for (Movie movie : home)
//      {
//         System.err.println(movie);
//      }
//      System.out.println(msm.exit(0));
      
      File newFile = new File("test.txt");
      FileOutputStream theFileOutPutStream = new FileOutputStream(newFile, false);
      ObjectOutputStream theObjectOutputStream = new ObjectOutputStream(theFileOutPutStream);
      theObjectOutputStream.writeObject(new Movie("test7", "test", "test", "test", "test", "test"));
      theObjectOutputStream.close();
      theFileOutPutStream.close();
      
      File thenewfile2 = new File("test.txt");
      FileInputStream theFileInputStream =null;
      try
      {
         theFileInputStream = new FileInputStream(thenewfile2);
      } catch (FileNotFoundException e)
      {
            System.err.println("help!");
      }
      ObjectInputStream theObjectInputStream = new ObjectInputStream(theFileInputStream);
      @SuppressWarnings("unchecked")
      Movie p = (Movie) theObjectInputStream.readObject();
      System.err.println(p);
      
   }
}