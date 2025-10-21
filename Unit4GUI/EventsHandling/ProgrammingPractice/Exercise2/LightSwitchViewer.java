import javax.swing.JFrame;

/**
   This program demonstrates how to install an action listener.
*/
public class LightSwitchViewer
{  
   public static void main(String[] args)
   {
      JFrame frame = new LightSwitchSimulator();
      frame.setTitle("Light Switch Simulator");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}
