package edu.csupomona.cs.cs241.proj1;

public class QueueItemShell<E>
{
   private int priority;
   private int placeInQueue;
   private E item;
   
   QueueItemShell(E item, int priority, int placeInQueue){
      this.item = item;
      this.placeInQueue = placeInQueue;
      this.priority = priority;
   }

   public int getPriority()
   {
      return priority;
   }

   public int getPlaceInQueue()
   {
      return placeInQueue;
   }

   public E getItem()
   {
      return item;
   }
   
}
