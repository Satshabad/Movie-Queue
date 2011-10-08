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
//      FileManager fm = new FileManager();
//      MyQueue<Movie> p = fm.getSavedHomeQueue();
//      if ( p == null){
//         p = new MyQueue<Movie>(5);
//         p.enqueue(new Movie("the1movie", "war", "blah", "blahtwo", "blahthree", "whateve"));
//         p.enqueue(new Movie("the2movie", "war", "blah", "blahtwo", "blahthree", "whateve"));
//         p.enqueue(new Movie("the3movie", "war", "blah", "blahtwo", "blahthree", "whateve"));
//         p.enqueue(new Movie("the4movie", "war", "blah", "blahtwo", "blahthree", "whateve"));
//         fm.saveHomeQueue(p);
//      }else{
//         System.err.println(p.enqueue(new Movie("the5movie", "war", "blah", "blahtwo", "blahthree", "whateve")));
//      }
//      while (!p.isEmpty()){
//         System.out.println(p.dequeue());
//      }
      MyQueue<String> q = new MyQueue<String>(4);
      q.enqueue("hi");
      q.enqueue("threr");
      q.enqueue("hg");
      q.enqueue("hif");
      q.enqueue("hdi");
      q.enqueue("hsi");
      q.enqueue("hai");
      q.enqueue("hai");
      q.enqueue("hai");
 
      q.dequeue();
      q.dequeue();
      q.dequeue();
      q.dequeue();
      q.dequeue();
      q.dequeue();
      q.enqueue("hif");
      q.enqueue("hdi");
      q.enqueue("hsi");
      q.enqueue("hai");
      q.enqueue("hai");
      q.enqueue("hai");
      
      while (!q.isEmpty())
      {
         System.out.println(q.dequeue());
      }
      
   }

void TestFrame(){
  
   
//   JLabel jlb = new JLabel(q.dequeue() + q.dequeue() + q.dequeue());
//   add(jlb);
//   this.setSize(1000, 1000);
//   setVisible(true);
}
}