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


package edu.csupomona.cs.cs241.proj1gui;

import edu.csupomona.cs.cs241.proj1.Movie;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Satshabad
 */
public class CustomListRenderer implements ListCellRenderer {

   @Override
   public Component getListCellRendererComponent(JList list, Object value, int index,
        boolean isSelected, boolean cellHasFocus) {

        Movie theMovie = (Movie) value;
        JTextArea renderer = new JTextArea(7,10);
        renderer.setWrapStyleWord(true);
        renderer.setLineWrap(true);
        renderer.addMouseListener(null);
        renderer.append(theMovie.getTitle() +"\n");
        renderer.append("Director: " +theMovie.getDirector() +"\n");
        renderer.append("Actors: " + theMovie.getActorOne() +", "
                        + theMovie.getActorTwo() + ", "
                        + theMovie.getActorThree() + "\n");
        renderer.append("Genre: " + theMovie.getGenre()+ "\n");
        renderer.append("-----------------------------------------------------");
        renderer.setLineWrap(true);
        if (isSelected){renderer.setBackground(Color.LIGHT_GRAY);}

         

        return renderer;
   }
}
