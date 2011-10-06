package edu.csupomona.cs.cs241.proj1;

public class TestDriver
{

   /**
    * @param args
    */
   public static void main(String[] args)
   {
      PriorityQueue<String> q = new PriorityQueue<String>(3, 8);
      System.err.println(q.enqueue("one", 1));
      System.err.println(q.enqueue("two", 3));
      System.err.println(q.enqueue("three", 1));
      System.err.println(q.enqueue("four", 1));
      System.err.println(q.enqueue("five", 2));
      System.err.println(q.enqueue("six", 2));
      System.err.println(q.enqueue("seven", 3));
      System.err.println(q.enqueue("eight", 1));
      System.err.println(q.enqueue("nine", 3));
      System.err.println(q.enqueue("ten", 2));
      System.err.println(q.dequeue());
      System.err.println(q.dequeue());
      System.err.println(q.dequeue());
      System.err.println(q.dequeue());
      System.err.println(q.dequeue());
      System.err.println(q.dequeue());
      System.err.println(q.dequeue());
      System.err.println(q.dequeue());
      System.err.println(q.dequeue());
      System.err.println(q.dequeue());
      System.err.println(q.dequeue());
      System.err.println(q.dequeue());
      System.err.println(q.dequeue());
      
   }

}
