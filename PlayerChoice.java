/*
 * @authors Tanner Glantz and Brett Phillips
 * @version 03/14/2016
 * Description: The PlayerChoice class creates a window for the user to choose what players are playing before strating the game.
 * Course: ISTE-121
 */

//imports the necesary classes for the GUI program
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

/*
 * A class that extends JFrame and implements ActionListener that will create a GUI for the user 
 * to input the names of the two players playing.
 */
public class PlayerChoice extends JFrame implements ActionListener
{
   //@param JLabel playerOneLabel Creates a JLabel object that that will let the user know who is player one.
   private JLabel playerOneLabel = null;
   //@param JLabel playerTwoLabel Creates a JLabel object that that will let the user know who is player two.
   private JLabel playerTwoLabel = null;
   //@param JTextField playerOneText Creates a JTextField object where the user will be able to enter his or her name as player one of the game.
   private JTextField playerOneText = null;
   //@param JTextField playerTwoText Creates a JTextField object where the user will be able to enter his or her name as player two of the game.
   private JTextField playerTwoText = null;
   //@param JButton ok Creates a JButton object that the user will press to add the players to the game and also start the game.
   private JButton ok = null;
   //@param JPanel panel Creates a JPanel object that will be in GridLayout and contain the JLabel and JTextFields for the player input.
   private JPanel panel = null;
   //@param JPanel panelTwo Creates a JPanel object that will be in FlowLayout and contain the JButton ok.
   private JPanel panelTwo = null;
   //@param String playerOneEntered Gets assigned the text that was put in the textField for player one.
   private String playerOneEntered;
   //@param String playerTwoEntered Gets assigned the text that was put in the textField for player two.
   private String playerTwoEntered;
   
   //Main method
   public static void main(String [] args)
   {
      //Creates a new PlayerChoice object
      PlayerChoice pC = new PlayerChoice();
   } 
   
   /*
    * The default constructor that will create the GUI for the PlayerChoice class. It will create a frame that will
    * have two panels added to it. These panels will contain JLabel and TextField objects that will allow
    * the user to input their name into either player one or two and a JButton that will allow the user 
    * accept the players, enter them, and start the game. 
    */   
   public PlayerChoice()
   {
      //Creates a JFrame object called frame
      JFrame frame = new JFrame();
      //Sets the title of the frame
      frame.setTitle("Connect Four");
      //Allows the user to close hte window and terminate the program by clicking the red X
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //Sets the size of the frame
      frame.setSize(600, 200);
      
      //Creates a new JPanel object called panel
      panel = new JPanel();
      //Sets the layout to GridLayout
      panel.setLayout(new GridLayout(4,1));
      
      //Creates a new JLabel object called playerOneLabel that takes in a String
      playerOneLabel = new JLabel("Player One:");
      //Adds playerOneLabel to panel
      panel.add(playerOneLabel);
      //Creates a new JTextField object called playerOneText where the user will be able to enter his or her own name
      playerOneText = new JTextField();
      //Adds playerOneText to panel
      panel.add(playerOneText);
      //Creates a new JLabel object called playerTwoLabel that takes in a String
      playerTwoLabel = new JLabel("Player Two:");
      //Adds playerTwoLabel to panel
      panel.add(playerTwoLabel);      
      //Creates a new JTextField object called playerTwoText where the user will be able to enter his or her own name
      playerTwoText = new JTextField();
      //Adds playerOneText to panel
      panel.add(playerTwoText); 
      
      //Creates a second JPanel called panelTwo which is defaultly FlowLayout
      panelTwo = new JPanel();
      
      //Creates a new JButton object called ok that takes in a String
      ok = new JButton("OK");
      //Adds the JButton ok to panelTwo
      panelTwo.add(ok);
      //Adds an action to the button
      ok.addActionListener(this);
      
      //Adds panelTwo to the frame and sets it to BorderLayout to the south of the frame
      frame.add(panelTwo, BorderLayout.SOUTH);
      //Adds panel to the frame and sets it to BorderLayout to the north of the frame
      frame.add(panel, BorderLayout.CENTER);
      //Sets the location of the frame to be in the middle of the page
      frame.setLocationRelativeTo(null);
      //Sets the frame to be visible by the user
      frame.setVisible(true);
   } 
   
   /*
    * Void method that is to listen to the JButton, then in return, perform
    * a certain action.
    * @param ActionEvent ae Allows the action command to be performed 
    */    
   public void actionPerformed(ActionEvent ae)
   {
      //If the command equals OK, then it will perform the following action 
      if(ae.getActionCommand().equals("OK"));
      {
         //Gets the text that was enterened in the TextField and assigns it to the String playerOneEntered
         playerOneEntered = playerOneText.getText();
         //Gets the text that was enterened in the TextField and assigns it to the String playerTwoEntered
         playerTwoEntered = playerTwoText.getText();
         JOptionPane.showMessageDialog(null, playerOneEntered+", you will go first");
         //Creates a new MainGUI object that takes in the two players and will start the official game         
         new MainGUI(playerOneEntered, playerTwoEntered, 0, 0);
      }
   }   
}