/*
 * @authors Tanner Glantz and Brett Phillips
 * @version 03/14/2016
 * Description: The StartUp class creates the start menu of the game.
 * Course: ISTE-121
 */

//imports the necesary classes for the GUI program
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

/*
 * A class that extends JFrame and implements ActionListener that will create a GUI menu for the user 
 * to press start when the would like to begin the game.
 * @param JButton start Creates a JButton object that the user will press to start the game.
 * @param JPanel panel Creates a JPanel obhect that will be in BorderLayout and contain the painted image.
 * @param JPanel panelTwo Creates a JPanel object that will be in FlowLayout and contain the JButton start.
 * @param Icon aPic Creates an Icon object that will take in the image to be shown.
 */
public class StartUp extends JFrame implements ActionListener
{
   //Private JButton attribute called start that is set to null to begin with 
   private JButton start = null;
   //Private JPanel attribute called panel that is set to null to begin with
   private JPanel panel = null;
   //Private JPanel attribute called panelTwo that is set to null to begin with
   private JPanel panelTwo = null;
   //Private Icon attribute called aPic that is set to null to begin with
   private Icon aPic = new ImageIcon("startup.jpg");
      
   //Main method
   public static void main(String [] args)
   {
      //Creates a new StartUp object
      StartUp startUp = new StartUp();
   }
   
   /*
    * A constructor that will create the GUI for the StartUp class. It will create a frame that will
    * have two panels added to it. These panels will contain an Icon object to display an image
    * and a JButton that will allow the user to start the game. 
    */
   public StartUp()
   {
      //Creates a JFrame object called frame
      JFrame frame = new JFrame();
      //Sets the size of the frame
      frame.setSize(700, 600);
      //Sets the title of the frame
      frame.setTitle("Connect 4");
      //Sets the location of the frame to be in the middle of the page
      frame.setLocationRelativeTo(null);
      //Sets the frame so it cannot be resized
      frame.setResizable(false);
      //Allows the user to close hte window and terminate the program by clicking the red X
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
      //Creates a JPanel object called panel that is in BorderLayout
      panel = new JPanel(new BorderLayout());
      //Adds the inner class to panel
      panel.add(new StartUpInner());
      //Adds panel to the frame
      frame.add(panel);
            
      //Creates a JPanel object called panel that is in FlowLayout
      panelTwo = new JPanel(new FlowLayout());
      //Creates a new JButton called start that takes in a String
      start = new JButton("Start");
      //Adds an action to the button
      start.addActionListener(this);
      //Adds the JButton to panelTwo
      panelTwo.add(start);
      //Adds panelTwo to the frame and sets it in BorderLayout and to the South of the frame
      frame.add(panelTwo, BorderLayout.SOUTH);
                  
      //Sets the frame to be visible by the user
      frame.setVisible(true);  
   }
   
   /*
    * An inner class that extends a JPanel. This class will create an image and paint it 
    * it to the panel, so that it can be added to the frame in the main class. 
    */
   class StartUpInner extends JPanel
   {
      //Empty default constructor
      public StartUpInner()
      {
      }
      
      /*
       * Void paintComponent method that will take in the Graphics g parameter in order to paint the 
       * image to the panel at a certian location.
       * @param Graphics g
       */
      protected void paintComponent(Graphics g)
      {
         //Calls the super class
         super.paintComponent(g);
         //Paints the image to the panel
         aPic.paintIcon(this, g, 0, 0); 
      }
   }
   
   /*
    * Void method that is to listen to the JButton, then in return, perform
    * a certain action.
    * @param ActionEvent ae Allows the action command to be performed 
    */    
   public void actionPerformed(ActionEvent ae)
   {
      //If the command equals Start, then it will perform the following action 
      if(ae.getActionCommand().equals("Start"));
      {
         //Creates a PlayerChoice object so that the next class can be started and the players playing can be picked
         new PlayerChoice();
      }
   }   
}  
