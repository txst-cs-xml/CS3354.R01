import javax.swing.JFrame;
import java.awt.Color;

/**
   This program displays an empty frame.
*/
public class MyFirstFrame
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      final int FRAME_WIDTH = 500;
      final int FRAME_HEIGHT = 500;
      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      //frame.setResizable(false); //prevent frame from being resized
      //frame.setTitle("My First Frame");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //frame.getContentPane().setBackground(new Color(0xFFFFFF)); //change color of background
      frame.setVisible(true);
   }
}