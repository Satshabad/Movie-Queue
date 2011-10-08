package edu.csupomona.cs.cs241.proj1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

/**
 * This class manages all of the file reading and writing operations. 
 * It's a little quick and dirty (unmodular) but it does a great job of
 * abstracting the processes from the callers
 * 
 * @author Satshabad
 *
 */
public class FileManager
{
   /**
    * This method reads from the standard list of movies (res\movies.txt) inflated the {@link Movie} Objects.
    * 
    * @pre There is at least one movie in the file movies.txt
    * @post The movies will be returned in there object form.
    * @return an array of {@link Movie} objects from the file res\movies.txt
    */
   public Movie[] getMoviesFromFile(){
      Movie movies[];
      File movieFileList = new File("res" + File.separator + "movies.txt");  
      Scanner scan = null;
      try
      {
          scan = new Scanner(movieFileList);
      } catch (FileNotFoundException e)
      {
         // the file will always exists so this will never happen. even if it didn't exist it was created by our File object
         System.err.println("Error movies file missing. Find movies.txt and place in the res folder!");
         e.printStackTrace();
      }
      
      /* I know this is a very inefficient and backwards way of doing things 
      * but you said we couldn't use java's implementation of a queue, and my
      * implementation is bounded. You did say however that I could use a Java 
      * Stack for some things, and so THAT is why I am doing this. If I could 
      * I would use an unbounded list. The main problem is that I don't know 
      * how many movie I will read before I read them in. */
      
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
   
   /**
    * This method lets the caller add a {@link Movie} object to the standard list of movies for use from now on.
    * The {@link Movie} is broken into components and written to the file res\movies.txt
    * 
    * @pre The movies file res\movies.txt exists and is in proper format
    * @post the new movie will be appended to the end of the movies.txt file in the form of it's components
    * @param m the movie to be added
    * @throws IOException
    */
   public void addMovietoFile(Movie m) throws IOException{
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
      
   }
   
   /**
    * This method saves the state of the {@link PriorityQueue} object passed and all of it's contained objects
    * 
    * @pre the passed objects all implement the Java.io.Serializable interface and this class has the ability to write to disk
    * @post the file "waitingQueue.txt" has been created in sav folder and hold the passed object
    * @param p the PriorityQueue in the state to be saved
    * @throws IOException
    */
   public void saveWaitingQueue(PriorityQueue<Movie> p) throws IOException{
      File newFile = new File("sav" + File.separator + "waitingQueue.txt");
      FileOutputStream theFileOutPutStream = new FileOutputStream(newFile, false);
      ObjectOutputStream theObjectOutputStream = new ObjectOutputStream(theFileOutPutStream);
      theObjectOutputStream.writeObject(p);
      theObjectOutputStream.close();
      theFileOutPutStream.close();
   }

   /**
    * This returns the last saved state of the {@link PriorityQueue} passed.
    * If there is no last saved state {@code null}is returned
    * 
    * @pre this class has the ability to read the file and file saved has not been tampered with.
    * @post the file will be unedited and the object extracted will be returned
    * @return the last saved queue or null if there is no last saved queue
    * @throws IOException
    * @throws ClassNotFoundException
    */
   public PriorityQueue<Movie> getSavedWaitingQueue() throws IOException, ClassNotFoundException{
      File newFile = new File("sav" + File.separator + "waitingQueue.txt");
      FileInputStream theFileInputStream;
      try
      {
         theFileInputStream = new FileInputStream(newFile);
      } catch (FileNotFoundException e)
      {
         return null;  
      }
      ObjectInputStream theObjectInputStream = new ObjectInputStream(theFileInputStream);
      @SuppressWarnings("unchecked")
      PriorityQueue<Movie> p = (PriorityQueue<Movie>) theObjectInputStream.readObject();
      return p;
   }
   
   /**
    * This method saves the state of the {@link MyQueue} object passed and all of it's contained objects
    * 
    * @pre the passed objects all implement the Java.io.Serializable interface and this class has the ability to write to disk
    * @post the file "homeQueue.txt" has been created in sav folder and hold the passed object
    * @param p the MyQueue in the state to be saved
    * @throws IOException
    */
   public void saveHomeQueue(MyQueue<Movie> p) throws IOException{
      File newFile = new File("sav" + File.separator + "homeQueue.txt");
      FileOutputStream theFileOutPutStream = new FileOutputStream(newFile, false);
      ObjectOutputStream theObjectOutputStream = new ObjectOutputStream(theFileOutPutStream);
      theObjectOutputStream.writeObject(p);
      theObjectOutputStream.close();
      theFileOutPutStream.close();
   }
   
   /**
    * This returns the last saved state of the {@link MyQueue} passed.
    * If there is no last saved state {@code null}is returned
    * 
    * @pre this class has the ability to read the file and file saved has not been tampered with.
    * @post the file will be unedited and the object extracted will be returned
    * @return the last saved queue or null if there is no last saved queue
    * @throws IOException
    * @throws ClassNotFoundException
    */
   public MyQueue<Movie> getSavedHomeQueue() throws IOException, ClassNotFoundException{
      File newFile = new File("sav" + File.separator + "waitingQueue.txt");
      FileInputStream theFileInputStream;
      try
      {
         theFileInputStream = new FileInputStream(newFile);
      } catch (FileNotFoundException e)
      {
         return null;  
      }
      ObjectInputStream theObjectInputStream = new ObjectInputStream(theFileInputStream);
      @SuppressWarnings("unchecked")
      MyQueue<Movie> p = (MyQueue<Movie>) theObjectInputStream.readObject();
      return p;
   }
}

