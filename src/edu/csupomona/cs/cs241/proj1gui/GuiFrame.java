/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MovieQueueUI.java
 *
 * Created on Oct 8, 2011, 11:19:08 PM
 */

package edu.csupomona.cs.cs241.proj1gui;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import edu.csupomona.cs.cs241.proj1.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JList;
/**
 *
 * @author Satshabad
 */
public class GuiFrame extends javax.swing.JFrame {

    
    private DefaultListModel libraryListModel;
    private DefaultListModel waitingQueueListModel;
    private DefaultListModel searchListModel;
    private MovieSystemManager backEndManager;
    private DefaultListModel atHomeListModel;


   /** Creates new form MovieQueueUI */
    public GuiFrame() throws IOException, ClassNotFoundException {
       backEndManager = new MovieSystemManager();
       initComponents();
       priorityMediumRadioButton.doClick();
       sortByTitleRadioButton.doClick();
       normalOrderRadioButton.setSelected(true);
       updateQueueViews();
       this.addWindowListener(new WindowAdapter() {

          public void windowClosing(WindowEvent evt) {
             backEndManager.exit(0);


            }



       });
    }
   

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      librarySortRadioGroup = new javax.swing.ButtonGroup();
      waitingQueueDisplayRadioGroup = new javax.swing.ButtonGroup();
      priorityButtonGroup = new javax.swing.ButtonGroup();
      jPanel1 = new javax.swing.JPanel();
      jPanel3 = new javax.swing.JPanel();
      jLabel1 = new javax.swing.JLabel();
      jPanel4 = new javax.swing.JPanel();
      sortByGenreRadioButton = new javax.swing.JRadioButton();
      sortByDirectorRadioButton = new javax.swing.JRadioButton();
      sortByActorRadioButton = new javax.swing.JRadioButton();
      sortByTitleRadioButton = new javax.swing.JRadioButton();
      priorityLowRadioButton = new javax.swing.JRadioButton();
      priorityMediumRadioButton = new javax.swing.JRadioButton();
      priorityHighRadioButton = new javax.swing.JRadioButton();
      jScrollPane1 = new javax.swing.JScrollPane();
      libraryList = new javax.swing.JList();
      jLabel5 = new javax.swing.JLabel();
      jPanel5 = new javax.swing.JPanel();
      jLabel2 = new javax.swing.JLabel();
      searchByBox = new javax.swing.JComboBox();
      searchTextField = new javax.swing.JTextField();
      searchButton = new javax.swing.JButton();
      jScrollPane2 = new javax.swing.JScrollPane();
      searchList = new javax.swing.JList();
      jSeparator1 = new javax.swing.JSeparator();
      jPanel2 = new javax.swing.JPanel();
      jPanel6 = new javax.swing.JPanel();
      jLabel3 = new javax.swing.JLabel();
      deliverButton = new javax.swing.JButton();
      deliverByPriorityButton = new javax.swing.JButton();
      jScrollPane3 = new javax.swing.JScrollPane();
      waitingQueueList = new javax.swing.JList();
      normalOrderRadioButton = new javax.swing.JRadioButton();
      priorityOrderRadioButton = new javax.swing.JRadioButton();
      jPanel7 = new javax.swing.JPanel();
      jLabel4 = new javax.swing.JLabel();
      sendBackButton = new javax.swing.JButton();
      jScrollPane4 = new javax.swing.JScrollPane();
      atHomeList = new javax.swing.JList();

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      addWindowListener(new java.awt.event.WindowAdapter() {
         public void windowClosed(java.awt.event.WindowEvent evt) {
            formWindowClosed(evt);
         }
      });

      jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
      jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      jLabel1.setText("MovieLibrary");

      librarySortRadioGroup.add(sortByGenreRadioButton);
      sortByGenreRadioButton.setText("Sort by Genre");
      sortByGenreRadioButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
      sortByGenreRadioButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            sortByGenreRadioButtonActionPerformed(evt);
         }
      });

      librarySortRadioGroup.add(sortByDirectorRadioButton);
      sortByDirectorRadioButton.setText("Sort by Director");
      sortByDirectorRadioButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
      sortByDirectorRadioButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            sortByDirectorRadioButtonActionPerformed(evt);
         }
      });

      librarySortRadioGroup.add(sortByActorRadioButton);
      sortByActorRadioButton.setText("Sort by Main Actor");
      sortByActorRadioButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
      sortByActorRadioButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            sortByActorRadioButtonActionPerformed(evt);
         }
      });

      librarySortRadioGroup.add(sortByTitleRadioButton);
      sortByTitleRadioButton.setText("Sort by Title");
      sortByTitleRadioButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
      sortByTitleRadioButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            sortByTitleRadioButtonActionPerformed(evt);
         }
      });

      priorityButtonGroup.add(priorityLowRadioButton);
      priorityLowRadioButton.setText("LOW");
      priorityLowRadioButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            priorityLowRadioButtonActionPerformed(evt);
         }
      });

      priorityButtonGroup.add(priorityMediumRadioButton);
      priorityMediumRadioButton.setText("MEDIUM");
      priorityMediumRadioButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            priorityMediumRadioButtonActionPerformed(evt);
         }
      });

      priorityButtonGroup.add(priorityHighRadioButton);
      priorityHighRadioButton.setText("HIGH");

      javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
      jPanel4.setLayout(jPanel4Layout);
      jPanel4Layout.setHorizontalGroup(
         jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel4Layout.createSequentialGroup()
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(sortByActorRadioButton)
               .addComponent(sortByTitleRadioButton))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel4Layout.createSequentialGroup()
                  .addComponent(sortByDirectorRadioButton)
                  .addGap(18, 18, 18)
                  .addComponent(priorityLowRadioButton)
                  .addGap(18, 18, 18)
                  .addComponent(priorityMediumRadioButton)
                  .addGap(18, 18, 18)
                  .addComponent(priorityHighRadioButton))
               .addComponent(sortByGenreRadioButton))
            .addContainerGap(9, Short.MAX_VALUE))
      );
      jPanel4Layout.setVerticalGroup(
         jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel4Layout.createSequentialGroup()
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(sortByTitleRadioButton)
               .addComponent(sortByDirectorRadioButton)
               .addComponent(priorityLowRadioButton)
               .addComponent(priorityMediumRadioButton)
               .addComponent(priorityHighRadioButton))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(sortByActorRadioButton)
               .addComponent(sortByGenreRadioButton)))
      );

      libraryList.setCellRenderer(new CustomListRenderer());
      libraryListModel = new DefaultListModel();
      libraryList.setModel(libraryListModel);
      libraryList.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            libraryListMouseClicked(evt);
         }
      });
      jScrollPane1.setViewportView(libraryList);

      jLabel5.setText("Add by Priority:");

      javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
      jPanel3.setLayout(jPanel3Layout);
      jPanel3Layout.setHorizontalGroup(
         jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel3Layout.createSequentialGroup()
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel5)
            .addGap(66, 66, 66))
         .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
      );
      jPanel3Layout.setVerticalGroup(
         jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel3Layout.createSequentialGroup()
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jLabel1)
               .addGroup(jPanel3Layout.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(jLabel5)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE))
      );

      jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
      jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      jLabel2.setText("Search Library");

      searchByBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Title", "Actor", "Director", "Genre" }));
      searchByBox.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            searchByBoxActionPerformed(evt);
         }
      });

      searchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
         public void keyPressed(java.awt.event.KeyEvent evt) {
            searchTextFieldKeyPressed(evt);
         }
      });

      searchButton.setText("Search");
      searchButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            searchButtonActionPerformed(evt);
         }
      });
      searchButton.addKeyListener(new java.awt.event.KeyAdapter() {
         public void keyPressed(java.awt.event.KeyEvent evt) {
            searchButtonKeyPressed(evt);
         }
      });

      searchList.setCellRenderer(new CustomListRenderer());
      searchListModel = new DefaultListModel();
      searchList.setModel(searchListModel);
      searchList.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            searchListMouseClicked(evt);
         }
      });
      jScrollPane2.setViewportView(searchList);

      javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
      jPanel5.setLayout(jPanel5Layout);
      jPanel5Layout.setHorizontalGroup(
         jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
         .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
         .addGroup(jPanel5Layout.createSequentialGroup()
            .addComponent(searchByBox, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(searchTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
         .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
      );
      jPanel5Layout.setVerticalGroup(
         jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel5Layout.createSequentialGroup()
            .addComponent(jLabel2)
            .addGap(27, 27, 27)
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(searchByBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(searchButton))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE))
      );

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );

      jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
      jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      jLabel3.setText("Your Queue");

      deliverButton.setText("Deliver");
      deliverButton.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            deliverButtonMouseClicked(evt);
         }
      });
      deliverButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            deliverButtonActionPerformed(evt);
         }
      });

      deliverByPriorityButton.setText("Deliver by Priority");
      deliverByPriorityButton.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            deliverByPriorityButtonMouseClicked(evt);
         }
      });

      waitingQueueList.setCellRenderer(new CustomListRenderer());
      waitingQueueListModel = new DefaultListModel();
      waitingQueueList.setModel(waitingQueueListModel);
      jScrollPane3.setViewportView(waitingQueueList);

      waitingQueueDisplayRadioGroup.add(normalOrderRadioButton);
      normalOrderRadioButton.setText("Show in Normal Order");
      normalOrderRadioButton.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            normalOrderRadioButtonMouseClicked(evt);
         }
      });

      waitingQueueDisplayRadioGroup.add(priorityOrderRadioButton);
      priorityOrderRadioButton.setText("Show by Priority");
      priorityOrderRadioButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            priorityOrderRadioButtonActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
      jPanel6.setLayout(jPanel6Layout);
      jPanel6Layout.setHorizontalGroup(
         jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(deliverButton, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
               .addComponent(normalOrderRadioButton))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(priorityOrderRadioButton)
               .addComponent(deliverByPriorityButton, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
         .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
      );
      jPanel6Layout.setVerticalGroup(
         jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel6Layout.createSequentialGroup()
            .addComponent(jLabel3)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(deliverButton)
               .addComponent(deliverByPriorityButton))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(normalOrderRadioButton)
               .addComponent(priorityOrderRadioButton))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE))
      );

      jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
      jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      jLabel4.setText("Movies at Home");

      sendBackButton.setText("Send Back");
      sendBackButton.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            sendBackButtonMouseClicked(evt);
         }
      });
      sendBackButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            sendBackButtonActionPerformed(evt);
         }
      });

      atHomeList.setCellRenderer(new CustomListRenderer());
      atHomeListModel = new DefaultListModel();
      atHomeList.setModel(atHomeListModel);
      jScrollPane4.setViewportView(atHomeList);

      javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
      jPanel7.setLayout(jPanel7Layout);
      jPanel7Layout.setHorizontalGroup(
         jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
         .addComponent(sendBackButton, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
         .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
      );
      jPanel7Layout.setVerticalGroup(
         jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel7Layout.createSequentialGroup()
            .addComponent(jLabel4)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(sendBackButton)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE))
      );

      javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
      jPanel2.setLayout(jPanel2Layout);
      jPanel2Layout.setHorizontalGroup(
         jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      jPanel2Layout.setVerticalGroup(
         jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

    private void sendBackButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_sendBackButtonActionPerformed
    {//GEN-HEADEREND:event_sendBackButtonActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_sendBackButtonActionPerformed

    private void sortByTitleRadioButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_sortByTitleRadioButtonActionPerformed
    {//GEN-HEADEREND:event_sortByTitleRadioButtonActionPerformed
         libraryListModel.clear();
         Movie[] movieList = backEndManager.getMoviesListedByTitle();
         for (int i = 0; i < movieList.length; i++)
       {
            libraryListModel.add(i, movieList[i]);
       }
    }//GEN-LAST:event_sortByTitleRadioButtonActionPerformed

    private void sortByDirectorRadioButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_sortByDirectorRadioButtonActionPerformed
    {//GEN-HEADEREND:event_sortByDirectorRadioButtonActionPerformed
         libraryListModel.clear();
         Movie[] movieList = backEndManager.getMoviesListedByDirector();
         for (int i = 0; i < movieList.length; i++)
       {
            libraryListModel.add(i, movieList[i]);
       }
    }//GEN-LAST:event_sortByDirectorRadioButtonActionPerformed

    private void sortByActorRadioButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_sortByActorRadioButtonActionPerformed
    {//GEN-HEADEREND:event_sortByActorRadioButtonActionPerformed
         libraryListModel.clear();
         Movie[] movieList = backEndManager.getMoviesListedByMainActor();
         for (int i = 0; i < movieList.length; i++)
       {
            libraryListModel.add(i, movieList[i]);
       }
    }//GEN-LAST:event_sortByActorRadioButtonActionPerformed

    private void sortByGenreRadioButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_sortByGenreRadioButtonActionPerformed
    {//GEN-HEADEREND:event_sortByGenreRadioButtonActionPerformed
         libraryListModel.clear();
         Movie[] movieList = backEndManager.getMoviesListedByGenre();
         for (int i = 0; i < movieList.length; i++)
       {
            libraryListModel.add(i, movieList[i]);
       }
    }//GEN-LAST:event_sortByGenreRadioButtonActionPerformed

    private void updateLibraryListView(){
        if (normalOrderRadioButton.isSelected()){
                  //This displays the data change
                  waitingQueueListModel.clear();
                  Movie[] waitingQueueArray = backEndManager.getWaitingQueue();

                  for(int i = 0; i < waitingQueueArray.length; i++)
                  {
                     waitingQueueListModel.add(i, waitingQueueArray[i]);
                  }
               }
               else if (priorityOrderRadioButton.isSelected()){
                  //This displays the data change
                  waitingQueueListModel.clear();
                  Movie[] waitingQueueArray = backEndManager.getWaitingQueueByPriority();

                  for(int i = 0; i < waitingQueueArray.length; i++)
                  {
                     waitingQueueListModel.add(i, waitingQueueArray[i]);
                  }
               }
    }


    private void libraryListMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_libraryListMouseClicked
    {//GEN-HEADEREND:event_libraryListMouseClicked
       JList list = (JList)evt.getSource();
        if (evt.getClickCount() == 2){
            int index = list.locationToIndex(evt.getPoint());
            Movie movieToBeAdded;

            int pri=0;
            if(priorityLowRadioButton.isSelected()){pri = 3;}
            else if(priorityMediumRadioButton.isSelected()){pri= 2;}
            else if(priorityHighRadioButton.isSelected()){pri = 1;}




         if (sortByTitleRadioButton.isSelected() ){
            Movie[] moviesByTitle = backEndManager.getMoviesListedByTitle();
            movieToBeAdded = moviesByTitle[index];
            backEndManager.addToMovieQueue(movieToBeAdded, pri);
            updateLibraryListView();
            }
            else if(sortByActorRadioButton.isSelected())
            {
               Movie[] moviesByActor = backEndManager.getMoviesListedByMainActor();
               movieToBeAdded = moviesByActor[index];
               backEndManager.addToMovieQueue(movieToBeAdded, pri);
               updateLibraryListView();
            }
            else if(sortByDirectorRadioButton.isSelected())
            {
               Movie[] moviesByDirector = backEndManager.getMoviesListedByDirector();
               movieToBeAdded = moviesByDirector[index];
               backEndManager.addToMovieQueue(movieToBeAdded, pri);
               updateLibraryListView();
            }
            else if(sortByGenreRadioButton.isSelected())
            {
               Movie[] moviesByGenre = backEndManager.getMoviesListedByGenre();
               movieToBeAdded = moviesByGenre[index];
               backEndManager.addToMovieQueue(movieToBeAdded, pri);
               updateLibraryListView();
            
            }


        }
        

    }//GEN-LAST:event_libraryListMouseClicked

    private void priorityLowRadioButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_priorityLowRadioButtonActionPerformed
    {//GEN-HEADEREND:event_priorityLowRadioButtonActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_priorityLowRadioButtonActionPerformed

    private void priorityMediumRadioButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_priorityMediumRadioButtonActionPerformed
    {//GEN-HEADEREND:event_priorityMediumRadioButtonActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_priorityMediumRadioButtonActionPerformed

    private void searchByBoxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_searchByBoxActionPerformed
    {//GEN-HEADEREND:event_searchByBoxActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_searchByBoxActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_searchButtonActionPerformed
    {//GEN-HEADEREND:event_searchButtonActionPerformed
       String target = searchTextField.getText();
       if (target.equalsIgnoreCase("")){return;}
       
       Movie[] searchResults;
       if (searchByBox.getSelectedItem().toString().equals("Title")){
          searchResults = backEndManager.searchByTitle(target);
       }
       else if (searchByBox.getSelectedItem().toString().equals("Actor"))
       {
          searchResults = backEndManager.searchByActor(target);
       }
       else if (searchByBox.getSelectedItem().toString().equals("Director"))
       {
         searchResults = backEndManager.searchByDirector(target);
       }
       else if (searchByBox.getSelectedItem().toString().equals("Genre"))
       {
         searchResults = backEndManager.searchByGenre(target);
       }else{
          searchResults = null;
       }

       searchListModel.clear();

       for (int i = 0; i < searchResults.length; i++)
       {
          searchListModel.add(i, searchResults[i]);
       }

    }//GEN-LAST:event_searchButtonActionPerformed

    private void searchListMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_searchListMouseClicked
    {//GEN-HEADEREND:event_searchListMouseClicked
         JList list = (JList)evt.getSource();
        if (evt.getClickCount() == 2){
            int index = list.locationToIndex(evt.getPoint());
            int pri;
            if (priorityLowRadioButton.isSelected()){pri = 1;}
            else if (priorityMediumRadioButton.isSelected()){pri = 2;}
            else{pri = 3;}
            if (!searchListModel.isEmpty()){
               backEndManager.addToMovieQueue((Movie)searchListModel.get(index), pri);
               if(normalOrderRadioButton.isSelected()){
                  waitingQueueListModel.clear();

                  Movie[] waitingList = backEndManager.getWaitingQueue();

                  for (int i = 0; i < waitingList.length; i++)
                  {
                     waitingQueueListModel.add(i, waitingList[i]);
                  }
               }
               else if(priorityOrderRadioButton.isSelected()){
                  waitingQueueListModel.clear();

                  Movie[] waitingList = backEndManager.getWaitingQueueByPriority();

                  for (int i = 0; i < waitingList.length; i++)
                  {
                     waitingQueueListModel.add(i, waitingList[i]);
                  }
               }
            }
        }
        
       
    }//GEN-LAST:event_searchListMouseClicked

    private void searchButtonKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_searchButtonKeyPressed
    {//GEN-HEADEREND:event_searchButtonKeyPressed

    }//GEN-LAST:event_searchButtonKeyPressed

    private void searchTextFieldKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_searchTextFieldKeyPressed
    {//GEN-HEADEREND:event_searchTextFieldKeyPressed
       if(evt.getKeyChar() == '\n')
       {
          searchButtonActionPerformed(null);
       }
    }//GEN-LAST:event_searchTextFieldKeyPressed


    private void priorityOrderRadioButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_priorityOrderRadioButtonActionPerformed
    {//GEN-HEADEREND:event_priorityOrderRadioButtonActionPerformed
       priorityOrderRadioButton.setSelected(true);
       normalOrderRadioButton.setSelected(false);
       updateQueueViews();
    }//GEN-LAST:event_priorityOrderRadioButtonActionPerformed

    private void deliverButtonMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_deliverButtonMouseClicked
    {//GEN-HEADEREND:event_deliverButtonMouseClicked
       if (waitingQueueListModel.isEmpty()){return;}

       backEndManager.deliverMovie();
       updateQueueViews();
    }//GEN-LAST:event_deliverButtonMouseClicked

    private void deliverButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_deliverButtonActionPerformed
    {//GEN-HEADEREND:event_deliverButtonActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_deliverButtonActionPerformed

    private void updateQueueViews(){

       atHomeListModel.clear();
       waitingQueueListModel.clear();
       Movie[] waitList;
       if(normalOrderRadioButton.isSelected()){waitList = backEndManager.getWaitingQueue();}
       else{waitList = backEndManager.getWaitingQueueByPriority();}
       Movie[] homeList = backEndManager.getatHomeQueue();
       for (int i = 0; i < waitList.length; i++)
       {
            waitingQueueListModel.add(i, waitList[i]);
       }
       for (int i = 0; i < homeList.length; i++)
       {
            atHomeListModel.add(i, homeList[i]);
       }
    }

    private void deliverByPriorityButtonMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_deliverByPriorityButtonMouseClicked
    {//GEN-HEADEREND:event_deliverByPriorityButtonMouseClicked
       if (waitingQueueListModel.isEmpty()){return;}

       backEndManager.deliverMovieByPrioirity();
       updateQueueViews();
       

      
    }//GEN-LAST:event_deliverByPriorityButtonMouseClicked

    private void sendBackButtonMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_sendBackButtonMouseClicked
    {//GEN-HEADEREND:event_sendBackButtonMouseClicked
          if (atHomeListModel.isEmpty()){return;}

       backEndManager.sendMovieBack();
       updateQueueViews();
    }//GEN-LAST:event_sendBackButtonMouseClicked

    private void normalOrderRadioButtonMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_normalOrderRadioButtonMouseClicked
    {//GEN-HEADEREND:event_normalOrderRadioButtonMouseClicked
       normalOrderRadioButton.setSelected(true);
       priorityOrderRadioButton.setSelected(false);
       updateQueueViews();
    }//GEN-LAST:event_normalOrderRadioButtonMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosed
    {//GEN-HEADEREND:event_formWindowClosed
       System.out.println("here");
    }//GEN-LAST:event_formWindowClosed





    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            try
            {
               new GuiFrame().setVisible(true);
            }
            catch (IOException ex)
            {
               Logger.getLogger(GuiFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (ClassNotFoundException ex)
            {
               Logger.getLogger(GuiFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        });
    }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JList atHomeList;
   private javax.swing.JButton deliverButton;
   private javax.swing.JButton deliverByPriorityButton;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JLabel jLabel5;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JPanel jPanel2;
   private javax.swing.JPanel jPanel3;
   private javax.swing.JPanel jPanel4;
   private javax.swing.JPanel jPanel5;
   private javax.swing.JPanel jPanel6;
   private javax.swing.JPanel jPanel7;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JScrollPane jScrollPane2;
   private javax.swing.JScrollPane jScrollPane3;
   private javax.swing.JScrollPane jScrollPane4;
   private javax.swing.JSeparator jSeparator1;
   private javax.swing.JList libraryList;
   private javax.swing.ButtonGroup librarySortRadioGroup;
   private javax.swing.JRadioButton normalOrderRadioButton;
   private javax.swing.ButtonGroup priorityButtonGroup;
   private javax.swing.JRadioButton priorityHighRadioButton;
   private javax.swing.JRadioButton priorityLowRadioButton;
   private javax.swing.JRadioButton priorityMediumRadioButton;
   private javax.swing.JRadioButton priorityOrderRadioButton;
   private javax.swing.JButton searchButton;
   private javax.swing.JComboBox searchByBox;
   private javax.swing.JList searchList;
   private javax.swing.JTextField searchTextField;
   private javax.swing.JButton sendBackButton;
   private javax.swing.JRadioButton sortByActorRadioButton;
   private javax.swing.JRadioButton sortByDirectorRadioButton;
   private javax.swing.JRadioButton sortByGenreRadioButton;
   private javax.swing.JRadioButton sortByTitleRadioButton;
   private javax.swing.ButtonGroup waitingQueueDisplayRadioGroup;
   private javax.swing.JList waitingQueueList;
   // End of variables declaration//GEN-END:variables

}
