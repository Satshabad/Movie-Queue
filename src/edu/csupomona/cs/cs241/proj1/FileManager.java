/**
 * CS 241: Data Structures and Algorithms II
 * Professor: Edwin Rodr&iacute;guez
 *
 * Programming Assignment 1
 *
 * This assignment is to create a netflix like movie
 * 
 * queue by which the user can sort search a
 * library of movies as well as add movies to
 * their queue by priority rather than just
 * FIFO order. They may freely switch
 * between FIFO and priority order. The
 * Queues are persistent and the library is extensible.
 * 
 * Satshabad Khalsa  
 */

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

/**
 * This class manages all of the file reading and writing operations. It's a
 * little quick and dirty (unmodular) but it does a great job of abstracting the
 * processes from the callers
 * 
 * @author Satshabad
 * 
 */
public class FileManager {
    /**
     * The number of line in the file movies.txt that make up a movie.
     */
    private final int NUM_OF_LINES_IN_MOVIE = 7;

    /**
     * This method reads from the standard list of movies (res\movies.txt)
     * inflated the {@link Movie} Objects.
     * 
     * @pre There is at least one movie in the file movies.txt
     * @post The movies will be returned in there object form.
     * @return an array of {@link Movie} objects from the file res\movies.txt
     */
    public Movie[] getMoviesFromFile() {
        Movie movies[];
        File movieFileList = new File("res" + File.separator + "movies.txt");
        Scanner scan = null;
        try {
            scan = new Scanner(movieFileList);
        } catch (FileNotFoundException e) {
            // the file will always exists so this will never happen. even if it
            // didn't exist it was created by our File object
            System.err
                    .println("Error movies file missing. Find movies.txt and "
                            + "place in the res folder!");
            e.printStackTrace();
        }
        // this finds out how many line are in the file
        int numOfLines = 0;
        while (scan.hasNext()) {
            scan.nextLine();
            numOfLines++;
        }
        // Increments this again for the last unread line in the file
        numOfLines++;
        // this closes the scanner so that it can opened again and read from the
        // top
        scan.close();

        // Reopens the scanner so it can read from the top
        try {
            scan = new Scanner(movieFileList);
        } catch (FileNotFoundException e) {
            // the file will always exists so this will never happen. even if it
            // didn't exist it was created by our File object
            System.err.println("Error movies file missing. Find movies.txt "
                    + "and place in the res folder!");
            e.printStackTrace();
        }

        // this create an array of the right size, the number of lines making up
        // a movie into the number of lines in the file
        movies = new Movie[(numOfLines) / NUM_OF_LINES_IN_MOVIE];
        for (int i = 0; i < movies.length; i++) {
            String title = scan.nextLine();
            String genre = scan.nextLine();
            String actorOne = scan.nextLine();
            String actorTwo = scan.nextLine();
            String actorThree = scan.nextLine();
            String director = scan.nextLine();
            if (scan.hasNext()) {
                scan.nextLine();
            }
            movies[i] = new Movie(title, genre, actorOne, actorTwo, actorThree,
                    director);
        }
        scan.close();
        return movies;
    }

    /**
     * This method lets the caller add a {@link Movie} object to the standard
     * list of movies for use from now on. The {@link Movie} is broken into
     * components and written to the file res\movies.txt
     * 
     * @pre The movies file res\movies.txt exists and is in proper format
     * @post the new movie will be appended to the end of the movies.txt file in
     *       the form of it's components
     * @param m
     *            the movie to be added
     * @throws IOException
     *             if the file movies.txt can not be found
     * @deprecated not needed for project req.
     */
    public void addMovietoFile(Movie m) throws IOException {
        File movieFileList = new File("res" + File.separator + "movies.txt");
        FileWriter movieFileWriter = null;
        try {
            movieFileWriter = new FileWriter(movieFileList, true);
        } catch (IOException e) {
            System.err.println("Error movies file missing. "
                    + "Find movies.txt and place in the res folder!");
            e.printStackTrace();
        }
        PrintWriter printToFile = new PrintWriter(movieFileWriter);
        printToFile.print("\n");
        printToFile.print(m.getTitle() + "\n");
        printToFile.print(m.getGenre() + "\n");
        printToFile.print(m.getActorOne() + "\n");
        printToFile.print(m.getActorTwo() + "\n");
        printToFile.print(m.getActorThree() + "\n");
        printToFile.print(m.getDirector() + "\n");
        printToFile.close();
        movieFileWriter.close();

    }

    /**
     * This method saves the state of the {@link PriorityQueue} object passed
     * and all of it's contained objects.
     * 
     * @pre the passed objects all implement the Java.io.Serializable interface
     *      and this class has the ability to write to disk
     * @post the file "waitingQueue.txt" has been created in sav folder and hold
     *       the passed object
     * @param p
     *            the PriorityQueue in the state to be saved
     * @throws IOException
     *             if the file cannot be made
     */
    public void saveWaitingQueue(PriorityQueue<Movie> p) throws IOException {
        fileWrite("sav" + File.separator + "waitingQueue.txt", p);

    }

    /**
     * This returns the last saved state of the {@link PriorityQueue} passed. If
     * there is no last saved state {@code null}is returned
     * 
     * @pre this class has the ability to read the file and file saved has not
     *      been tampered with.
     * @post the file will be unedited and the object extracted will be returned
     * @return the last saved queue or null if there is no last saved queue
     * @throws IOException
     *             if the file can not be made or found
     * @throws ClassNotFoundException
     *             if the file can not be found
     */
    public PriorityQueue<Movie> getSavedWaitingQueue() throws IOException,
            ClassNotFoundException {
        File newFile = new File("sav" + File.separator + "waitingQueue.txt");
        FileInputStream theFileInputStream;
        try {
            theFileInputStream = new FileInputStream(newFile);
        } catch (FileNotFoundException e) {
            return null;
        }
        ObjectInputStream theObjectInputStream = new ObjectInputStream(
                theFileInputStream);
        @SuppressWarnings("unchecked")
        PriorityQueue<Movie> p = (PriorityQueue<Movie>) theObjectInputStream
                .readObject();
        theObjectInputStream.close();
        theFileInputStream.close();
        return p;
    }

    /**
     * This method saves the state of the {@link MyQueue} object passed and all
     * of it's contained objects.
     * 
     * @pre the passed objects all implement the Java.io.Serializable interface
     *      and this class has the ability to write to disk
     * @post the file "homeQueue.txt" has been created in sav folder and hold
     *       the passed object
     * @param p
     *            the MyQueue in the state to be saved
     * @throws IOException
     *             when the file can not be made
     */
    public void saveHomeQueue(MyQueue<Movie> p) throws IOException {
        fileWrite("sav" + File.separator + "homeQueue.txt", p);

    }

    /**
     * This returns the last saved state of the {@link MyQueue} passed. If there
     * is no last saved state {@code null}is returned
     * 
     * @pre this class has the ability to read the file and file saved has not
     *      been tampered with.
     * @post the file will be unedited and the object extracted will be returned
     * @return the last saved queue or null if there is no last saved queue
     * @throws IOException
     *             when the file can not be found
     * @throws ClassNotFoundException
     *             when the file can not be made
     */
    public MyQueue<Movie> getSavedHomeQueue() throws IOException,
            ClassNotFoundException {
        File newFile = new File("sav" + File.separator + "homeQueue.txt");
        FileInputStream theFileInputStream;
        try {
            theFileInputStream = new FileInputStream(newFile);
        } catch (FileNotFoundException e) {
            return null;
        }
        ObjectInputStream theObjectInputStream = new ObjectInputStream(
                theFileInputStream);
        @SuppressWarnings("unchecked")
        MyQueue<Movie> p = (MyQueue<Movie>) theObjectInputStream.readObject();
        theObjectInputStream.close();
        theFileInputStream.close();
        return p;
    }

    /**
     * This internal method handles the writing to the passed file.
     * 
     * @pre the fileName and path must be valid and the object must be not be
     *      {@code null}
     * @post the specific file will be over written or created and it will
     *       contain the object passed
     * @param fileName
     *            the name and path of the file to be written to
     * @param p
     *            the object to be written out
     * @throws IOException
     *             when the file can not be made
     */
    private <E> void fileWrite(String fileName, E p) throws IOException {
        File newFile = new File(fileName);
        FileOutputStream theFileOutPutStream = new FileOutputStream(newFile,
                false);
        ObjectOutputStream theObjectOutputStream = new ObjectOutputStream(
                theFileOutPutStream);
        theObjectOutputStream.writeObject(p);
        theObjectOutputStream.close();
        theFileOutPutStream.close();
    }

}
