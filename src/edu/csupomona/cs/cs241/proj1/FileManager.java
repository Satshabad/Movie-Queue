package edu.csupomona.cs.cs241.proj1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

public class FileManager
{
   public Movie[] getMoviesFromFile(){
      Movie movies[];
      File movieFileList = new File("res" + File.separator + "movies.txt");  
      Scanner scan = null;
      try
      {
          scan = new Scanner(movieFileList);
      } catch (FileNotFoundException e)
      {
         System.err.println("Error movies file missing. Find movies.txt and place in the res folder!");
         e.printStackTrace();
      }
      Stack<Movie> tempStack = new Stack<Movie>();
      
      while (scan.hasNext()){
         String title = scan.nextLine(); 
         String genre = scan.nextLine();
         String actorOne = scan.nextLine();
         String actorTwo = scan.nextLine();
         String actorThree = scan.nextLine();
         String director = scan.nextLine();
         if (scan.hasNext()) { scan.nextLine(); } 
         tempStack.push(new Movie(title, genre, actorOne, actorTwo, actorThree, director));
         
      }
      movies = new Movie[tempStack.size()];
      int i = 0;
      while (!tempStack.isEmpty())
      {
         movies[i] = tempStack.pop();
         i++;
      }
      scan.close();
      return movies;
   }
   
   public boolean addMovietoFile(Movie m) throws IOException{
      File movieFileList = new File("res" +File.separator +"movies.txt");
      FileWriter movieFileWriter = null;
      try
      {
          movieFileWriter = new FileWriter(movieFileList, true);
      } catch (IOException e)
      {
         System.err.println("Error movies file missing. Find movies.txt and place in the res folder!");
         e.printStackTrace();
      }
      PrintWriter printToFile = new PrintWriter(movieFileWriter);
      printToFile.print("\n");
      printToFile.print(m.getName()+ "\n");
      printToFile.print(m.getGenre()+ "\n");
      printToFile.print(m.getActorOne()+ "\n");
      printToFile.print(m.getActorTwo()+ "\n");
      printToFile.print(m.getActorThree()+ "\n");
      printToFile.print(m.getDirector()+ "\n");
      printToFile.close();
      movieFileWriter.close();
      return true;
      
   }
}
