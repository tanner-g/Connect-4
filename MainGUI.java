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

public class MainGUI {

    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenu helpMenu;
    private JMenuItem aboutMenu;
    private JMenuItem newGame;
    private JMenuItem exitMenu;
    private JMenuItem instructions;

    public MainGUI() {
        frame = new JFrame();
        frame.setSize(800, 800);
        frame.setTitle("Connect 4");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        EventListener al = new EventListener();

        menuBar = new JMenuBar();

        fileMenu = new JMenu("File");
        newGame = new JMenuItem("New Game");
        newGame.addActionListener(al);
        aboutMenu = new JMenuItem("About");
        aboutMenu.addActionListener(al);
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

    public static void main(String[] args) {
        MainGUI game = new MainGUI();
    }

    public void exitProgram() {
        System.exit(0);
    }

    class EventListener extends JPanel implements ActionListener {
        private String instructionsDialog = "Game Description:\n\tConnect 4 is a two player game in which players attempt to align their colored chips four in a row.\nPlayers place their chips into the top of the board, which then fall to the lowest available spot in that column.\nPlayers place one chip per turn. The goal of the game is to align four of your chips in either horizontal, diagonal, or vertical alignment.\nThe first person to align their chips in the ways described above, is the winner.\n\nThe design of this game is close to that of the traditional version of this game.\n\n\tGame URL: https://en.wikipedia.org/wiki/Connect_Four";
        public EventListener() {

        }

        public void actionPerformed(ActionEvent e) {
            String actionString = e.getActionCommand();
            if (actionString.equals("New Game")) {
            } else if (actionString.equals("Exit")) {
                exitProgram();
            } else if (actionString.equals("Instructions")) {
                JOptionPane.showMessageDialog(frame, instructionsDialog);
            } else if (actionString.equals("About")) {
                JOptionPane.showMessageDialog(frame, "put text here.");
            }

        }


    }

    class Board extends JPanel {

    }


}