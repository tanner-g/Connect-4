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

public class PlayerChoice extends JFrame implements ActionListener
{
   private JLabel playerOneLabel = null;
   private JLabel playerTwoLabel = null;
   private JTextField playerOneText = null;
   private JTextField playerTwoText = null;
   private JButton ok = null;
   private JPanel panel = null;
   private JPanel panelTwo = null;
   private String playerOneEntered;
   private String playerTwoEntered;
   public static void main(String [] args)
   {
      PlayerChoice pC = new PlayerChoice();
   } 
   
   public PlayerChoice()
   {
      JFrame frame = new JFrame();
      frame.setTitle("Connect Four");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(600, 200);
      
      panel = new JPanel();
      panel.setLayout(new GridLayout(4,1));
      
      playerOneLabel = new JLabel("Player One:");
      panel.add(playerOneLabel);
      playerOneText = new JTextField();
      panel.add(playerOneText);
      playerTwoLabel = new JLabel("Player Two:");
      panel.add(playerTwoLabel);      
      playerTwoText = new JTextField();
      panel.add(playerTwoText); 
      
      panelTwo = new JPanel();
      panel.setLayout(new GridLayout(4, 1));
      
      ok = new JButton("OK");
      panelTwo.add(ok);
      ok.addActionListener(this);
      
      frame.add(panelTwo, BorderLayout.SOUTH);
      frame.add(panel, BorderLayout.CENTER);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   } 
   
   public void actionPerformed(ActionEvent ae)
   {
      if(ae.getActionCommand().equals("OK"));
      {
         playerOneEntered = playerOneText.getText();
         playerTwoEntered = playerTwoText.getText();         
         new MainGUI(playerOneEntered, playerTwoEntered);
      }
   }   
    
}