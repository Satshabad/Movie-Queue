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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestDriver extends JFrame
{

   /**
    * @param args
    * @throws IOException 
    * @throws ClassNotFoundException 
    */
   public static void main(String[] args) throws IOException, ClassNotFoundException
   {
     FileManager fm = new FileManager();
     fm.addMovietoFile(new Movie("hi", "this", "is", "a", "great", "Movie!"));
     Movie[] m = fm.getMoviesFromFile();
     
     for (Movie movie : m)
   {
      System.err.println(movie);
   }
     
      
      
   }

void TestFrame(){
  
   
//   JLabel jlb = new JLabel(q.dequeue() + q.dequeue() + q.dequeue());
//   add(jlb);
//   this.setSize(1000, 1000);
//   setVisible(true);
}
}