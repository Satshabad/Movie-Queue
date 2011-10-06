package edu.csupomona.cs.cs241.proj1;

public class TestDriver
{

   /**
    * @param args
    */
   public static void main(String[] args)
   {
      MyQueue<String> q = new MyQueue<String>(8);
      System.err.println(q.enqueue("two"));
      System.err.println(q.enqueue("two"));
      System.err.println(q.enqueue("two"));
      System.err.println(q.enqueue("two"));
      System.err.println(q.enqueue("two"));
      System.err.println(q.enqueue("two"));
      System.err.println(q.enqueue("two"));
      System.err.println(q.enqueue("two"));
      System.err.println(q.enqueue("two"));
      System.err.println(q.enqueue("two"));
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
