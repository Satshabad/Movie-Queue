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

   }

}
