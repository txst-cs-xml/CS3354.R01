import javax.swing.JFrame;

/**
   This program shows the growth of an investment.
*/
public class InvestmentViewer
{  
   public static void main(String[] args)
   {  
      JFrame frame = new InvestmentFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}