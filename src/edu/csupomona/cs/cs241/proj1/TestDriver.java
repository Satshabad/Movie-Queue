package edu.csupomona.cs.cs241.proj1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestDriver
{

   /**
    * @param args
    * @throws FileNotFoundException 
    */
   public static void main(String[] args) throws FileNotFoundException
   {
    File movieFileList = new File("res" +File.separator +"movies.txt");  
     Scanner scan = new Scanner(movieFileList);
     
     PriorityQueue<String> q = new PriorityQueue<String>(5, 3);
     System.err.println(q.enqueue("one", 3));
     System.err.println(q.enqueue("two", 1));
     System.err.println(q.enqueue("three", 1));
     System.err.println(q.enqueue("four", 2));
     System.err.println(q.enqueue("five", 2));
     System.err.println(q.enqueue("six", 2));
     System.err.println(q.dequeue());
     System.err.println(q.dequeue());
     System.err.println(q.dequeue());
     System.err.println(q.enqueue("seven", 1));
     System.err.println(q.enqueue("eight", 2));
     System.err.println(q.enqueue("nine", 2));
     System.err.println(q.enqueue("ten", 2));
     System.err.println(q.enqueue("eleven", 2));
     System.err.println(q.dequeue());
     
           

   }

}
