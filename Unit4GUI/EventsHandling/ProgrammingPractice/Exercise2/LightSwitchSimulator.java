import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LightSwitchSimulator extends JFrame
{
   private JButton button;
   private JLabel label;
   private Boolean lightOn = false;

   private static final int FRAME_WIDTH = 300;
   private static final int FRAME_HEIGHT = 100;

   public LightSwitchSimulator()
   {
      createComponents();
      setSize(FRAME_WIDTH, FRAME_HEIGHT);
   }

   private void createComponents()
   {
      button = new JButton("Light Switch");
      button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event)
        {  if (lightOn) {
              label.setText("Light is OFF");
              lightOn = false;
           } else {
              label.setText("Light is ON");
              lightOn = true;
           }
        }    
      });

      label = new JLabel("Light is OFF");

      JPanel panel = new JPanel();
      panel.add(button);
      panel.add(label);
      add(panel);
   }
}

