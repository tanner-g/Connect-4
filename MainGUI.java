/**
 * @authors Tanner Glantz and Brett Phillips
 * @version 02/27/2016  
 * Description: The MainGUI class creates the Connect 4 game board
 * Course: ISTE-121
 */
 
 //imports the necesary classes for GUI program.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
public class MainGUI{

   private JFrame frame;
   private JMenuBar menuBar;
   private JMenu fileMenu;
   private JMenu helpMenu;
   private JMenuItem aboutMenu;
   private JMenuItem newGame;
   private JMenuItem exitMenu;
   private JMenuItem instructions;
   
   public MainGUI(){
      frame = new JFrame();
      frame.setSize(800,800);
      frame.setTitle("Connect 4");
      frame.setLayout(new BorderLayout());
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocationRelativeTo( null );
      
      EventListener al = new EventListener();
      
      menuBar = new JMenuBar();
      
      fileMenu = new JMenu("File");
      newGame = new JMenuItem("New Game");
      newGame.addActionListener(al);
      aboutMenu = new JMenuItem("About");
      
      exitMenu = new JMenuItem("Exit");
      exitMenu.addActionListener(al);
      fileMenu.add(newGame);
      fileMenu.add(aboutMenu);
      fileMenu.add(exitMenu);
      
      helpMenu = new JMenu("Help");
      instructions = new JMenuItem("Instructions");
      instructions.addActionListener(al);
      helpMenu.add(instructions);
      
           
      menuBar.add(fileMenu);
      menuBar.add(helpMenu); 
      
      frame.add(menuBar, BorderLayout.NORTH);
      
      frame.setVisible(true);
   }
   public void exitProgram(){
      System.exit(0);
   }
   
   class EventListener extends JPanel implements ActionListener{
      public EventListener(){
      
      }
      
      public void actionPerformed(ActionEvent e){
         String actionString = e.getActionCommand();
            if(actionString.equals("New Game")){
            }
            else if(actionString.equals("Exit")){
               exitProgram();
            }
            else if(actionString.equals("Instructions")){
            
            }
            else if(actionString.equals("About")){
            JOptionPane.showMessageDialog(frame, "put text here.");
            }
           
      }

   
   }
   
   class Board extends JPanel{
   
   }
   
   public static void main(String [] args){
      MainGUI game = new MainGUI();
   }


}