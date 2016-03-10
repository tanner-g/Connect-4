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
import java.io.*;
import java.util.*;

public class MainGUI
{
   private JFrame frame;
   private JMenuBar menuBar;
   private JMenu fileMenu;
   private JMenu helpMenu;
   private JMenuItem newGame;
   private JMenuItem exitMenu;
   private JMenuItem instructions;
   private JPanel mainPanel;
   private JPanel panel;
   private JPanel panelTwo;
   private JPanel buttonPanel;
   private JButton colButton1;
   private JButton colButton2;
   private JButton colButton3;
   private JButton colButton4;
   private JButton colButton5;
   private JButton colButton6;
   private JButton colButton7;
   private JLabel playerOne;
   private JLabel playerTwo;
   private static String finalPlayerOne = null;
   private static String finalPlayerTwo = null;
   private int howManyWins = 0;
   private boolean keepGoing = true;
   private int chipMovement = 0;
   private int redCounter = 0;
   private int yellowCounter = 0;
   private boolean isYellowChip = false; //player two should be yellow
   private boolean isRedChip = true;  //player one should be red
   private static final int CHIP_MAX = 600;
   private static final int PANNEL_WIDTH = 700;
   private static final int PANNEL_HEIGHT = 690;
    
   private Thread thread;
 
   private Icon theBoard = new ImageIcon("grid.png");
   private Icon yellowChip = new ImageIcon("yellowpiece.png");
   private Icon redChip = new ImageIcon("redpiece.png");
   
   private String[][] gamePlay = new String[][]
      {{"e","e","e","e","e","e","e"},
       {"e","e","e","e","e","e","e"},
       {"e","e","e","e","e","e","e"},
       {"e","e","e","e","e","e","e"},
       {"e","e","e","e","e","e","e"},
       {"e","e","e","e","e","e","e"}};
   
   public MainGUI(String _playerOne, String _playerTwo)
   {
      finalPlayerOne = _playerOne;
      finalPlayerTwo = _playerTwo;
      frame = new JFrame();
      frame.setSize(PANNEL_WIDTH, PANNEL_HEIGHT);
      frame.setTitle("Connect 4");
      frame.setLayout(new BorderLayout());
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocationRelativeTo(null);

      Board al = new Board();

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
      menuBar.add(fileMenu);
      menuBar.add(helpMenu);
        
      buttonPanel = new JPanel(new GridLayout(0,7));
      colButton1 = new JButton("1");
      colButton2 = new JButton("2");
      colButton3 = new JButton("3");
      colButton4 = new JButton("4");
      colButton5 = new JButton("5");
      colButton6 = new JButton("6");
      colButton7 = new JButton("7");
      colButton1.addActionListener(al);
      colButton2.addActionListener(al);
      colButton3.addActionListener(al);
      colButton4.addActionListener(al);
      colButton5.addActionListener(al);
      colButton6.addActionListener(al);
      colButton7.addActionListener(al);
      buttonPanel.add(colButton1);
      buttonPanel.add(colButton2);
      buttonPanel.add(colButton3);
      buttonPanel.add(colButton4);
      buttonPanel.add(colButton5);
      buttonPanel.add(colButton6);
      buttonPanel.add(colButton7);
      panel = new JPanel(new BorderLayout());
      //thread = new Thread(new Board());
        
      panel.add(new Board(), BorderLayout.CENTER);
      
      panelTwo = new JPanel(new GridLayout(1, 2));
     
      playerOne = new JLabel(finalPlayerOne + ":     " + howManyWins);
      panelTwo.add(playerOne);
      playerTwo = new JLabel(finalPlayerTwo + ":     " + howManyWins);
      panelTwo.add(playerTwo);
        
      mainPanel = new JPanel(new BorderLayout());
      mainPanel.add(buttonPanel, BorderLayout.NORTH);
      mainPanel.add(panel,BorderLayout.CENTER);
      mainPanel.add(panelTwo,BorderLayout.SOUTH);
      frame.add(menuBar, BorderLayout.NORTH);
      frame.add(mainPanel, BorderLayout.CENTER);       
        
      frame.setVisible(true);       
   }

   public static void main(String[] args)
   {
      MainGUI game = new MainGUI(finalPlayerOne, finalPlayerTwo);
   }

   public void exitProgram()
   {
      System.exit(0);
   }

   class Board extends JPanel implements ActionListener, Runnable
   {
      private int counter = 0;
      private String instructionsDialog = "Game Description:\n\tConnect 4 is a two player game in which players attempt to align their colored chips four in a row.\nPlayers place their chips into the top of the board, which then fall to the lowest available spot in that column.\nPlayers place one chip per turn. The goal of the game is to align four of your chips in either horizontal, diagonal, or vertical alignment.\nThe first person to align their chips in the ways described above, is the winner.\n\nThe design of this game is close to that of the traditional version of this game.\n\n\tGame URL: https://en.wikipedia.org/wiki/Connect_Four";
      private int colNumber;                 
    
      public Board()
      {  
      }
      
      public void actionPerformed(ActionEvent e)
      {
         String actionString = e.getActionCommand();
         
         if (actionString.equals("New Game"))
         {
         }
         else if (actionString.equals("Exit"))
         {
            exitProgram();
         }
         else if (actionString.equals("Instructions"))
         {
            JOptionPane.showMessageDialog(frame, instructionsDialog);
         }
         else if(actionString.equals("1"))
         {

            gamePlay[0][1] = "r";
            //counter++;           
                        
            revalidate();
         }
         else if(actionString.equals("2"))
         {       
         }
         else if(actionString.equals("3"))
         {
         }
         else if(actionString.equals("4"))
         {
         }
         else if(actionString.equals("5"))
         {
         }
         else if(actionString.equals("6"))
         {
         }
      }

      protected void paintComponent(Graphics g) 
      {
         super.paintComponent(g);
         
         for(int i = 100; i<=600; i+=100)
         {
            g.drawLine(i,0, i, PANNEL_HEIGHT);
         }
         
         for(int i = 0; i<=500; i+=100)
         {
            g.drawLine(0,i,PANNEL_WIDTH,i);
         }
            
         theBoard.paintIcon(this, g, 0, 0);
         
        /* for(int i = 0; i < gamePlay.length; i++)
         {
            for(int j = 0; j < gamePlay.length; j++)
            {
               gamePlay[0][1].paintIcon(this, g , 0, 1);
            }
         }*/
        
            if(gamePlay[0][1] == "r"){
               redChip.paintIcon(this, g, 1, 1); 
                         
            }         
         /*
         
         if(isYellowChip == true)
         {
            yellowChip.paintIcon(this,g, counter, addYellowChip());
            counter++;
         }
         else if(isRedChip == true)
         {
            redChip.paintIcon(this,g, counter, addRedChip());
            counter++;
         }    
         else
         {
            System.err.println("Error: no chip placed");
         }
         */ 
             
      }
      
      public int addYellowChip()
      {
         isYellowChip = true;
         isRedChip = false;
         
         if(isYellowChip == true)
         {
            counter += 100;
            return CHIP_MAX - counter;
         }
         else
         {
            return -1;
         }
      } 
      
      public int addRedChip()
      {
         isYellowChip = false;
         isRedChip = true;
         
         if(isRedChip == true)
         {
            counter += 100;
            return CHIP_MAX - counter;
         }
         else
         {
            return -1;
         }
      }       

      public void run()
      {                 
         while(true)
         {
            
            try
            {  
               chipMovement += 100;
               Thread.currentThread().sleep(1000);
               //repaint();                 
            }
            catch(InterruptedException ie)
            {
            }
            
            /*if(chipMovement == 500)
            {
               keepGoing = false;
            }*/
         }
      }        
   }
}