import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import javax.imageio.*;

public class StartUp extends JFrame
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

      try
      {
         image = ImageIO.read(new File("startup.jpg"));
      }
      catch(IOException ioe)
      {
      }
      
      labelOne = new JLabel(new ImageIcon(image));
      frame.add(labelOne);      
      
      /*panel = new JPanel(new FlowLayout());
      start = new JButton("Start");
      panel.add(start);
      about = new JButton("About");
      panel.add(about);
      frame.add(panel);*/
      
      frame.setVisible(true);  
   }
}  
