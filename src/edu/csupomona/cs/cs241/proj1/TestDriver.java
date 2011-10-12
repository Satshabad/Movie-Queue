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
      MovieSystemManager msm = new MovieSystemManager();
      msm.addToMovieQueue(new Movie("test7", "test", "test", "test", "test", "test"), 2);
      msm.addToMovieQueue(new Movie("test8", "test", "test", "test", "test", "test"), 2);
      msm.addToMovieQueue(new Movie("test9", "test", "test", "test", "test", "test"), 2);
      Movie[] home = msm.getatHomeQueue();
      Movie[] wait = msm.getWaitingQueue();
      
      for (Movie movie : wait)
      {
         System.out.println(movie);
      }
      
//      for (Movie movie : home)
//      {
//         System.err.println(movie);
//      }
      System.out.println(msm.exit(0));
      
//      MyQueue<QueueItemShell<Movie>> myq  = new MyQueue<QueueItemShell<Movie>>(5);
//      myq.enqueue(new QueueItemShell<Movie>(new Movie("test1", "test", "test", "test", "test", "test"), 2, 0));
//      myq.enqueue(new QueueItemShell<Movie>(new Movie("test2", "test", "test", "test", "test", "test"), 2, 1));
//      myq.enqueue(new QueueItemShell<Movie>(new Movie("test3", "test", "test", "test", "test", "test"), 2, 2));
//      myq.enqueue(new QueueItemShell<Movie>(new Movie("test4", "test", "test", "test", "test", "test"), 2, 3));
//      myq.enqueue(new QueueItemShell<Movie>(new Movie("test5", "test", "test", "test", "test", "test"), 2, 4));
//      
//      File newFile = new File("test.txt");
//      FileOutputStream theFileOutPutStream = new FileOutputStream(newFile, false);
//      ObjectOutputStream theObjectOutputStream = new ObjectOutputStream(theFileOutPutStream);
//      theObjectOutputStream.writeObject(myq);
//      theObjectOutputStream.close();
//      theFileOutPutStream.close();
//      
//      File newFile1 = new File("test.txt");
//      FileInputStream theFileInputStream = null;
//      try
//      {
//         theFileInputStream = new FileInputStream(newFile1);
//      } catch (FileNotFoundException e)
//      {
//      }
//      ObjectInputStream theObjectInputStream = new ObjectInputStream(theFileInputStream);
//      @SuppressWarnings("unchecked")
//      MyQueue<QueueItemShell<Movie>> p = (MyQueue<QueueItemShell<Movie>>) theObjectInputStream.readObject();
//      
//      while (!p.isEmpty())
//      {
//         System.err.println(p.dequeue().getItem());
//      }
//     
   }
}