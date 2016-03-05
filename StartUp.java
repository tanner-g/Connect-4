import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;

public class StartUp extends JFrame implements ActionListener
{
   private Image image = null;
   private JLabel labelOne = null;
   private JButton start = null;
   private JButton about = null;
   private JPanel panel = null;
      
   public static void main(String [] args)
   {
      StartUp startUp = new StartUp();
   }
   
   public StartUp()
   {
      JFrame frame = new JFrame();
      frame.setSize(800, 800);
      frame.setTitle("Connect 4");
      frame.setLocationRelativeTo(null);
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      Icon aPic = new ImageIcon("startup.jpg");
      
      labelOne = new JLabel(aPic);
      labelOne.setLayout(new BorderLayout());
      
      panel = new JPanel(new FlowLayout());
            
      start = new JButton("Start");
      start.addActionListener(this);
      panel.add(start);
      
      labelOne.add(panel, BorderLayout.SOUTH);
      
      frame.add(labelOne);
      
      frame.setVisible(true);  
   }
   
   public void actionPerformed(ActionEvent ae)
   {
      if(ae.getActionCommand().equals("Start"));
      {
         new MainGUI();
      }
   }   
}  
