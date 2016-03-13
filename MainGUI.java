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
   private JLabel numMovesTaken;
   private static String finalPlayerOne = null;
   private static String finalPlayerTwo = null;
   private int moveCount = 0; //red is first player or player one

   private int chipMovement = 0;
   private int redCounter = 0;
   private int yellowCounter = 0;
   private boolean isYellowChip = false; 
   private boolean isRedChip = false;  
   private static final int CHIP_MAX = 601;
   private static final int PANNEL_WIDTH = 700;
   private static final int PANNEL_HEIGHT = 690;
   private boolean foundWinner = false;  //true when winner is found
   
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
   
        
      panel.add(new Board(), BorderLayout.CENTER);
      
      panelTwo = new JPanel(new GridLayout(1, 3));
     
      playerOne = new JLabel(finalPlayerOne + ":\t" );//put chip color here and a counter for each piece set
      panelTwo.add(playerOne);
      playerTwo = new JLabel(finalPlayerTwo + ":\t" );
      panelTwo.add(playerTwo);
      numMovesTaken = new JLabel("Number of Moves: "+moveCount);
      panelTwo.add(numMovesTaken);
      mainPanel = new JPanel(new BorderLayout());
      mainPanel.add(buttonPanel, BorderLayout.NORTH);
      mainPanel.add(panel,BorderLayout.CENTER);
      mainPanel.add(panelTwo,BorderLayout.SOUTH);
      frame.add(menuBar, BorderLayout.NORTH);
      frame.add(mainPanel, BorderLayout.CENTER);       
        
      frame.setVisible(true);
            
   }
   public void setColorChip()
   {
      if(isRedChip == true && isYellowChip == false)
      {
         isRedChip = false;
         isYellowChip = true;
      
      }
      else if( isYellowChip == true && isRedChip == false)
      {
         isRedChip = true;
         isYellowChip = false;
      }
      else if(isYellowChip == true && isRedChip == true)
      {
         System.err.println("Both chips are active.");
      }
      else if(isYellowChip == false && isRedChip == false)
      {
         isRedChip = true;
         isYellowChip = false;
      }
   }

   public static void main(String[] args)
   {
      MainGUI game = new MainGUI(finalPlayerOne, finalPlayerTwo);
   }

   public void exitProgram()
   {
      System.exit(0);
   }
 

   class Board extends JPanel implements ActionListener
   {
      private boolean keepGoing = true;
      private String INVALID_MOVE_MESSAGE = "You made an invalid move.";
      private int indexCounterCol1 = 5;
      private int indexCounterCol2 = 5;
      private int indexCounterCol3 = 5;
      private int indexCounterCol4 = 5;
      private int indexCounterCol5 = 5;
      private int indexCounterCol6 = 5;
      private int indexCounterCol7 = 5;
      private int pixelCounter = 501;
      private String instructionsDialog = "Game Description:\nConnect 4 is a two player game in which players attempt to align their colored chips four in a row.\nPlayers place their chips into the top of the board, which then fall to the lowest available spot in that column.\nPlayers place one chip per turn. The goal of the game is to align four of your chips in either horizontal, diagonal, or vertical alignment.\nThe first person to align their chips in the ways described above, is the winner.\n\nThe design of this game is close to that of the traditional version of this game.\n\n\tGame URL: https://en.wikipedia.org/wiki/Connect_Four";
      private int colNumber;                 
      private int currentRow = 0;
      private int currentColumn = 0;
   
      public Board()
      {  
      }
      public void resetBoard(){
         for( int i = 0; i<=5; i++){
            for(int j = 0; j<=6; j++){
               gamePlay[i][j] = "e";
            }      
         }
         indexCounterCol1 = 5;
         indexCounterCol2 = 5;
         indexCounterCol3 = 5;
         indexCounterCol4 = 5;
         indexCounterCol5 = 5;
         indexCounterCol6 = 5;
         indexCounterCol7 = 5;      
      }
          
      public void actionPerformed(ActionEvent e)
      {
         
         String actionString = e.getActionCommand();
         
         int[] indexArray = {0,1,2,3,4,5,6,7};
         if (actionString.equals("New Game"))
         {
            resetBoard();
            
            updateUI();
         }
         
         else if (actionString.equals("Exit"))
         {
            exitProgram();
         }
         
         else if (actionString.equals("Instructions"))
         {
            JOptionPane.showMessageDialog(frame, instructionsDialog);
         }
         else{
         
            if(actionString.equals("1"))
            {
               switch(indexCounterCol1)
               {
                  case -1: 
                     JOptionPane.showMessageDialog(null, INVALID_MOVE_MESSAGE);
                     break;
               
                  case 5:
                  case 4:
                  case 3:
                  case 2:
                  case 1:
                  case 0:
                     setColorChip();
                     if(isYellowChip == true)
                     {
                        gamePlay[indexCounterCol1][0] = "y";
                        indexCounterCol1--;
                        revalidate();
                        repaint();
                     }
                     else if(isRedChip == true)
                     {
                        gamePlay[indexCounterCol1][0] = "r";
                        indexCounterCol1--;
                        revalidate();
                        repaint();
                     }
               }
               moveCount++;      
            }
         
            if(actionString.equals("2"))
            {
               switch(indexCounterCol2)
               {
                  case -1: 
                     JOptionPane.showMessageDialog(null, INVALID_MOVE_MESSAGE);
                     break;
               
                  case 5:
                  case 4:
                  case 3:
                  case 2:
                  case 1:
                  case 0:
                     setColorChip();
                     if(isYellowChip == true)
                     {
                        gamePlay[indexCounterCol2][1] = "y";
                        indexCounterCol2--;
                     }
                     else if(isRedChip == true)
                     {
                        gamePlay[indexCounterCol2][1] = "r";
                        indexCounterCol2--;
                     }
               }
               moveCount++; 
            }
         
            if(actionString.equals("3"))
            {
               switch(indexCounterCol3)
               {
                  case -1: 
                     JOptionPane.showMessageDialog(null, INVALID_MOVE_MESSAGE);
                     break;
               
                  case 5:
                  case 4:
                  case 3:
                  case 2:
                  case 1:
                  case 0:
                     setColorChip();
                     if(isYellowChip == true)
                     {
                        gamePlay[indexCounterCol3][2] = "y";
                        indexCounterCol3--;
                     }
                     else if(isRedChip == true)
                     {
                        gamePlay[indexCounterCol3][2] = "r";
                        indexCounterCol3--;
                     }
               } 
               moveCount++;
            }
         
            if(actionString.equals("4"))
            {
               switch(indexCounterCol4)
               {
                  case -1: 
                     JOptionPane.showMessageDialog(null, INVALID_MOVE_MESSAGE);
                     break;
               
                  case 5:
                  case 4:
                  case 3:
                  case 2:
                  case 1:
                  case 0:
                     setColorChip();
                     if(isYellowChip)
                     {
                        gamePlay[indexCounterCol4][3] = "y";
                        indexCounterCol4--;
                     }
                     else if(isRedChip)
                     {
                        gamePlay[indexCounterCol4][3] = "r";
                        indexCounterCol4--;
                     }
               } 
               moveCount++;
            }
         
            if(actionString.equals("5"))
            {
               switch(indexCounterCol5)
               {
                  case -1: 
                     JOptionPane.showMessageDialog(null, INVALID_MOVE_MESSAGE);
                     break;
               
                  case 5:
                  case 4:
                  case 3:
                  case 2:
                  case 1:
                  case 0:
                     setColorChip();
                     if(isYellowChip == true)
                     {
                        gamePlay[indexCounterCol5][4] = "y";
                        indexCounterCol5--;
                     }
                     else if(isRedChip == true)
                     {
                        gamePlay[indexCounterCol5][4] = "r";
                        indexCounterCol5--;
                     }
               } 
               moveCount++;
            }
         
            if(actionString.equals("6"))
            {
               switch(indexCounterCol6)
               {
                  case -1: 
                     JOptionPane.showMessageDialog(null, INVALID_MOVE_MESSAGE);
                     break;
               
                  case 5:
                  case 4:
                  case 3:
                  case 2:
                  case 1:
                  case 0:
                     setColorChip();
                     if(isYellowChip == true)
                     {
                        gamePlay[indexCounterCol6][5] = "y";
                        indexCounterCol6--;
                     }
                     else if(isRedChip == true)
                     {
                        gamePlay[indexCounterCol6][5] = "r";
                        indexCounterCol6--;
                     }
               } 
               moveCount++;
            }
         
            if(actionString.equals("7"))
            {
               switch(indexCounterCol7)
               {
                  case -1: 
                     JOptionPane.showMessageDialog(null, INVALID_MOVE_MESSAGE);
                     break;
               
                  case 5:
                  case 4:
                  case 3:
                  case 2:
                  case 1:
                  case 0:
                     setColorChip();
                     if(isYellowChip == true)
                     {
                     
                        gamePlay[indexCounterCol7][6] = "y";
                        indexCounterCol7--;
                     
                     
                     }
                     else if(isRedChip == true)
                     {
                        gamePlay[indexCounterCol7][6] = "r";
                        indexCounterCol7--;
                     }
               }
               moveCount++;
            }
         }
         
      }
      
    
      //checks all of the possible win cases on the piece that was placed
      // the x and y pos passed in are the current pieces position
      public boolean findWinner(int currentRow, int currentCol){
         String currentPiece = gamePlay[currentRow][currentCol];
        
         
         if(currentPiece.equals("e")){
            return false;
         }
         else{
            try{
               int matchFound = 1; // the first piece is included in the four count so this is how i account for it.
               //check the vertical positions above it
               for(int i = currentRow+1; i <= currentRow+3; i++){
                  if(currentPiece.equals(gamePlay[i][currentCol])){
                     matchFound++;
                     
                  }
               }
               if(matchFound == 4){
                  matchFound = 1;
                  foundWinner = true;
                  return true;
               }
               else{
                  matchFound = 1;              
               }
               for(int i = currentCol+1; i<=currentCol+3; i++){
                  if(currentPiece.equals(gamePlay[currentRow][i])){
                     matchFound++;
                  }
               }
               if(matchFound == 4){
                  matchFound = 1;
                  foundWinner = true;
                  return true;
               }
               else{
                  matchFound = 1;              
               }
               for(int i = currentCol-1; i<=currentCol-3; i--){
                  if(currentPiece.equals(gamePlay[currentRow][i])){
                     matchFound++;
                  }
               }
               if(matchFound == 4){
                  matchFound = 1;
                  return true;
               }
               else{
                  matchFound = 1;              
               }
                                                 
            }                       
            catch(ArrayIndexOutOfBoundsException e){}
            
                     
            return foundWinner;
         }
      }
      
      public void paintPieces(Graphics g){
       
         for(int rows = 0; rows < 6; rows++)
         {
            for(int columns = 0; columns < 7; columns++)
            {
                
               if(gamePlay[rows][columns].equals("r")){
                  redChip.paintIcon(this, g , columns*100, rows*100);
                                
               }
               else if(gamePlay[rows][columns].equals("y")){
                  yellowChip.paintIcon(this, g, columns*100, rows*100);
                 
               }
               if(findWinner(rows,columns)){
                  updateUI();
                  keepGoing = false;
                  colButton1.setEnabled(false);
                  colButton2.setEnabled(false);
                  colButton3.setEnabled(false);
                  colButton4.setEnabled(false);
                  colButton5.setEnabled(false);
                  colButton6.setEnabled(false);
                  colButton7.setEnabled(false);
                 
               }                           
            }     
         }         
      
       
      }
        
      
      protected void paintComponent(Graphics g) 
      {
         if(keepGoing){
            super.paintComponent(g);
            
            theBoard.paintIcon(this, g, 0, 0);
             
            paintPieces(g);
            
         }
         if(foundWinner){
            if(moveCount%2==0){
            JOptionPane.showMessageDialog(null, finalPlayerTwo+" you won!");
            }
            else{
               JOptionPane.showMessageDialog(null, finalPlayerOne+" you won!");
           }
            exitProgram();
         // resetBoard();
         
         }
         
         updateUI();
           
              
      }          
     
   }
}