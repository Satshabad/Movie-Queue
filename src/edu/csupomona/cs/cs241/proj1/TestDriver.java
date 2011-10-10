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
//     System.err.println("pqr khalsa".compareTo("stuvs khalsa"));
//     StringPointerPair[] array = new StringPointerPair[10];
//     array[0] = new StringPointerPair("abc satshabad", new Movie("Test", "Test", "Test", "Test", "Test", "Test"));
//     array[1] = new StringPointerPair("abcd Satshabad Khalsa", new Movie("Test2", "Tes2t", "Te2st", "Tes2t", "Tes2t", "Tes2t"));
//     array[2] = new StringPointerPair("ghi Singh", new Movie("Te3st", "Te3st", "Te3st", "Te3st", "Tes3t", "Te3st"));
//     array[3] = new StringPointerPair("ghij Singh Khalsa", new Movie("Te3st", "Te3st", "Tes3t", "T3est", "T3est", "Te3st"));
//     array[4] = new StringPointerPair("pqr atma", new Movie("Te7st", "Te5st", "Test6", "T6est", "T7est", "Tes8t"));
//     array[5] = new StringPointerPair("pqr atma", new Movie("Te9st", "T09est", "Te88st", "Te77st", "Te66st", "Tes55t"));
//     array[6] = new StringPointerPair("pqr atma", new Movie("Tes4t", "Te4st", "Te4st", "Tes4t", "Te4st", "Tes4t"));
//     array[7] = new StringPointerPair("xyz khalsa", new Movie("T5est", "5Test", "Te5st", "Tes5t", "Te5st", "T5est"));
//     array[8] = new StringPointerPair("xyz khalsa", new Movie("Te6st", "Te6st", "Te6t", "Tes6t", "Tes6t", "Test6"));
//     array[9] = new StringPointerPair("xyz khalsa", new Movie("Te6st", "T6est", "Te6st", "Tes6t", "Tes6t", "Te6st"));
//     
//
//     MovieLibrary ml = new MovieLibrary();
//     array = ml.binarySearch(array, "xyz khalsa");
//     for (StringPointerPair stringPointerPair : array)
//   {
//      if ( stringPointerPair != null)
//      {
//         System.err.println(stringPointerPair.getTheMovie());
//      }
//   }
//      Integer[] arr = {3, 15, 35, 1, 67, 90, 25,3,3,3, 6, 0, 4, 105, 99, 37, 38, 39, 3};
//      HeapSorter<Integer> hp = new HeapSorter<Integer>();
//      hp.sort(arr);
//
//      
//      for (Integer integer : arr)
//      {
//         System.err.println(integer);
//      }
      StringPointerPair[] array = new StringPointerPair[10];
      array[5] = new StringPointerPair("literature", new Movie("Test", "Test", "Test", "Test", "Test", "Test"));
      array[3] = new StringPointerPair("phase", new Movie("Test2", "Tes2t", "Te2st", "Tes2t", "Tes2t", "Tes2t"));
      array[1] = new StringPointerPair("replacement", new Movie("Te3st", "Te3st", "Te3st", "Te3st", "Tes3t", "Te3st"));
      array[0] = new StringPointerPair("nut", new Movie("Te3st", "Te3st", "Tes3t", "T3est", "T3est", "Te3st"));
      array[7] = new StringPointerPair("respond", new Movie("Te7st", "Te5st", "Test6", "T6est", "T7est", "Tes8t"));
      array[4] = new StringPointerPair("frame", new Movie("Te9st", "T09est", "Te88st", "Te77st", "Te66st", "Tes55t"));
      array[2] = new StringPointerPair("bug", new Movie("Tes4t", "Te4st", "Te4st", "Tes4t", "Te4st", "Tes4t"));
      array[9] = new StringPointerPair("determination", new Movie("T5est", "5Test", "Te5st", "Tes5t", "Te5st", "T5est"));
      array[8] = new StringPointerPair("diameter", new Movie("Te6st", "Te6st", "Te6t", "Tes6t", "Tes6t", "Test6"));
      array[6] = new StringPointerPair("designing", new Movie("Te6st", "T6est", "Te6st", "Tes6t", "Tes6t", "Te6st"));
      HeapSorter<StringPointerPair> hp = new HeapSorter<StringPointerPair>();
      hp.sort(array);
      
      for (StringPointerPair stringPointerPair : array)
       {
             System.err.println(stringPointerPair.getTheField());
       }
      MovieLibrary ml = new MovieLibrary();
      array = ml.binarySearch(array, "nut");
      for (StringPointerPair stringPointerPair : array)
      {
         if ( stringPointerPair != null)
          {
             System.err.println(stringPointerPair.getTheMovie());
          }
      }
   }

}