/**
 * 
 */
package edu.csupomona.cs.cs241.proj1;

/**
 * This class's single function is to sort the passed array with a heapsort algorithm.
 * 
 * @author Satshabad
 *
 */
public class HeapSorter<E extends Comparable<E>>
{

   
   /**
    * Creates a heapSorter object solely to sort the given array.
    * 
    * @pre the array type must implement {@link Comparable} and must be full with no {@code null} objects
    * @post the array is sorted from lowest to highest
    * @param array of objects to be sorted
    */
   public void sort(E[] array){      
      
       heapify(array);
       for (int lastLeaf = array.length-1; lastLeaf >= 1; lastLeaf--){
          swap(array, 0, lastLeaf);
          
          siftDown(0, lastLeaf-1, array);
          
       }
   }
   
   /**
    * This internal method turns any given array into a heap, even if the array has repeat elements
    * 
    * @pre The array must be full of non {@code null} objects and the objects must implement {@link Comparable}
    * @post The given array is in heap form, holding the heap property throughout
    * @param array the array to be turned into a heap.
    */
   private void heapify(E[] array){
         
      for (int firstLeafAndForward = ((array.length+1)/2); firstLeafAndForward < array.length; firstLeafAndForward++){
         siftUp(firstLeafAndForward, array);
      }
      
      
   }
   
   /**
    * This method takes the index of any node in a heap and moves the node toward the leaves until it is greater than both it's child nodes. 
    * The heap is in array form.
    * 
    * @pre The node and end indices must be within the range of the non {@code null} array. The objects in the array must implement {@link Comparable}
    * @post The node at the given index is sifted to a place in the array where it is greater than the objects at 2k+1 and 2k+2 where k is the new index of the node
    * @param node the index of the node to be sifted down
    * @param end the last leaf in the heap to be looked at
    * @param array the array which contains the heap
    */
   private void siftDown(int node, int end ,E[] array)
   {
      int childOne;
      int childTwo;
      int maxChild;
      boolean done = false;
      while (node < end && !done)
      {
         childOne = node*2+1;
         childTwo = node*2+2;
         if (childOne > end || childTwo > end){
            break;
         }
         if (array[childOne].compareTo(array[childTwo]) >= 0){
            maxChild = childOne;
         }else{
            maxChild = childTwo;
         }
         System.out.println( node + " : " +maxChild);
         if (array[node].compareTo(array[maxChild]) < 0){
            System.out.println("here");
            swap(array, maxChild, node);
            node = maxChild;
         }else{done = true;}
      }

   }
   
   /**
    * This method takes the index of any node in a heap and moves the node toward the root until it is less than both it's parent node. 
    * The heap is in array form.
    * 
    * @pre The node index must be within the range of the non {@code null} array. The objects in the array must implement {@link Comparable}
    * @post The node at the given index is sifted up to a place in the array where it is less than the object at (k-1)/2 where k is the new index of the node
    * @param node the index of the node to be sifted up
    * @param array the array which contains the heap
    */
   private void siftUp(int node, E[] array){      
      int parent;
      int sibiling;
      boolean done = false;
      while (node > 0 && !done){
         
         parent = (node-1)/2;
         
         sibiling = node;
         if (node + 1 != array.length){
            if (parent*2 + 1 == node){
               sibiling = node+1;
            }
            else if(parent*2 +2 == node){
               sibiling = node-1;
            }
            if (array[sibiling].compareTo(array[node]) > 0){
               node = sibiling;
            }   
         }
         System.out.println(parent + ":" + node);
         if (array[parent].compareTo(array[node]) < 0){
            
            System.out.println("here");
            swap(array, parent, node);
            node = parent;
         }
         else{done = true;}
      }
         
   }

   /**
    * This internal method swaps two elements in the given array.
    * 
    * @pre the array must not be {@code null} and the two indices of the elements must be within the range of the array.
    * @post the object at index j is at index i and vice versa
    * @param array the array containing the objects at the indices to be switched
    * @param j the index of the first object
    * @param i the index of the second object
    */
   private void swap(E[] array, int j, int i)
   {
      E temp = array[j];
      array[j] = array[i];
      array[i] = temp;
   }
   
}
