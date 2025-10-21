import javax.swing.JFrame;

/**
   This program shows a frame that is filled with two components.
*/
public class FilledFrameViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new FilledFrame(); 
      frame.setTitle("A frame with two components");
      frame.setSize(500, 500);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}