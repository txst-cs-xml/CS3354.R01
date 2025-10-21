import javax.swing.JFrame;


public class CounterViewer
{  
   public static void main(String[] args)
   {
      JFrame frame = new CounterApplication();
      frame.setTitle("Counter Application");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}