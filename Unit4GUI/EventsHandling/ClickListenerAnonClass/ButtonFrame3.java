import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonFrame3 extends JFrame
{
   private JButton button;
   private JLabel label;

   private static final int FRAME_WIDTH = 300;
   private static final int FRAME_HEIGHT = 100;

   public ButtonFrame3()
   {
      createComponents();
      setSize(FRAME_WIDTH, FRAME_HEIGHT);
   }


   private void createComponents()
   {
      button = new JButton("Click me!");
      button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event)
        {
           label.setText("I was clicked.");
        }    
      });

      label = new JLabel("Hello, World!");

      JPanel panel = new JPanel();
      panel.add(button);
      panel.add(label);
      add(panel);
   }
}