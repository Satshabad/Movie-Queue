package edu.csupomona.cs.cs241.proj1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestDriver extends JFrame
{

   /**
    * @param args
    * @throws FileNotFoundException 
    */
   public static void main(String[] args) throws FileNotFoundException
   {
    File movieFileList = new File("res" +File.separator +"movies.txt");  
     Scanner scan = new Scanner(movieFileList);
     TestDriver td = new TestDriver();
     td.TestFrame();
     
     
           

   }



void TestFrame(){
   PriorityQueue<String> q = new PriorityQueue<String>(5, 3);
   System.err.println(q.enqueue("two", 1));
   System.err.println(q.enqueue("three", 1));
   System.err.println(q.enqueue("four", 2));
   System.err.println(q.enqueue("five", 2));
   System.err.println(q.enqueue("six", 2));
   JLabel jlb = new JLabel(q.dequeue() + q.dequeue() + q.dequeue());
   add(jlb);
   this.setSize(1000, 1000);
   setVisible(true);
}
}