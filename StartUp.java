import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class StartUp extends JFrame implements ActionListener
{
   private JButton start = null;
   private JPanel panel = null;
   private JPanel panelTwo = null;
   private Icon aPic = new ImageIcon("startup.jpg");
      
   public static void main(String [] args)
   {
      StartUp startUp = new StartUp();
   }
   
   public StartUp()
   {
      JFrame frame = new JFrame();
      frame.setSize(700, 600);
      frame.setTitle("Connect 4");
      frame.setLocationRelativeTo(null);
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
      panel = new JPanel(new BorderLayout());
      panel.add(new StartUpInner());
      frame.add(panel);
            
      panelTwo = new JPanel(new FlowLayout());
      start = new JButton("Start");
      start.addActionListener(this);
      panelTwo.add(start);
      frame.add(panelTwo, BorderLayout.SOUTH);
                  
      frame.setVisible(true);  
   }
   
   class StartUpInner extends JPanel
   {
      public StartUpInner()
      {
      }
      
      protected void paintComponent(Graphics g)
      {
         super.paintComponent(g);
         aPic.paintIcon(this, g, 0, 0); 
      }
   }
   
   public void actionPerformed(ActionEvent ae)
   {
      if(ae.getActionCommand().equals("Start"));
      {
         new MainGUI();
      }
   }   
}  
