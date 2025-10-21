import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonFrame2 extends JFrame
{
   private JButton button1;
   private JButton button2;
   private JLabel label;

   private static final int FRAME_WIDTH = 300;
   private static final int FRAME_HEIGHT = 100;

   public ButtonFrame2()
   {
      createComponents();
      setSize(FRAME_WIDTH, FRAME_HEIGHT);
   }
   
   /**
      An action listener that changes the label text.
   */
   class Button1ClickListener implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         label.setText("I was clicked.");
         // set label text font bigger
         label.setFont(label.getFont().deriveFont(30.0f));
         //System.out.println("I was clicked.");

         //click button 2 when button 1 is clicked
         //button2.doClick();

      }            
   }

   class Button2ClickListener2 implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         System.out.println("Button 2 was clicked.");
         // label.setText("Hello, World!");
         // label.setFont(label.getFont().deriveFont(30.0f));

      }            
   }

   private void createComponents()
   {
      button1 = new JButton("Button1");
      ActionListener button1listener = new Button1ClickListener();
      button1.addActionListener(button1listener);

      button2 = new JButton("Button2");
      ActionListener button2listener = new Button2ClickListener2();
      button2.addActionListener(button2listener);


      label = new JLabel("Hello, World!");
      //change label text font bigger
      label.setFont(label.getFont().deriveFont(30.0f));

      JPanel panel = new JPanel();
      panel.add(button1);
      panel.add(button2);
      panel.add(label);
      add(panel);
   }
}