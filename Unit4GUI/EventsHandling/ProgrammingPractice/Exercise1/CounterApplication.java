import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CounterApplication extends JFrame
{
   private JButton incButton;
   private JButton decButton;
   private JLabel labelCount;
   private int count = 0;

   private static final int FRAME_WIDTH = 300;
   private static final int FRAME_HEIGHT = 100;

   public CounterApplication()
   {
      createComponents();
      setSize(FRAME_WIDTH, FRAME_HEIGHT);
   }

   private void createComponents()
   {
      // set incButton text as increase
      incButton = new JButton("Increase");
      decButton = new JButton("Decrease");
      labelCount = new JLabel("0");

      incButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event)
        {
           count++;
           labelCount.setText(Integer.toString(count));
        }    
      });

      decButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event)
        {
            count--;
            labelCount.setText(Integer.toString(count));
        }    
      });


      JPanel panel = new JPanel();
      panel.add(incButton);
      panel.add(decButton);
      panel.add(labelCount);
      add(panel);
   }
}