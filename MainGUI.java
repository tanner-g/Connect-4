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
   private JMenu aboutMenu;
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
      exitMenu = new JMenuItem("Exit");
      exitMenu.addActionListener(al);
      fileMenu.add(newGame);
      fileMenu.add(exitMenu);
      
      helpMenu = new JMenu("Help");
      instructions = new JMenuItem("Instructions");
      instructions.addActionListener(al);
      helpMenu.add(instructions);
      aboutMenu = new JMenu("About");
      aboutMenu.addActionListener(al);     
      
      menuBar.add(fileMenu);
      menuBar.add(helpMenu);
      menuBar.add(aboutMenu);
      
      frame.add(menuBar, BorderLayout.NORTH);
      
      frame.setVisible(true);
   }
   
   class EventListener extends JPanel implements ActionListener{
      public EventListener(){
      
      }
      
      public void actionPerformed(ActionEvent e){
         String actionString = e.getActionCommand();
            if(actionString.equals("xxx")){
            }
            else if(actionString.equals("")){
            
            }
      }

   
   }
   
   class Board extends JPanel{
   
   }
   
   public static void main(String [] args){
      MainGUI game = new MainGUI();
   }


}