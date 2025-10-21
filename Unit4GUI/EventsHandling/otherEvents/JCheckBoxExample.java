import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class JCheckBoxExample {
    public static void main(String[] args) {
        // Creating the frame
        JFrame frame = new JFrame("JCheckBox Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Creating the checkbox
        JCheckBox checkBox = new JCheckBox("Check me");

        // Creating a label to display the result
        JLabel label = new JLabel("Unchecked");

        // Adding an item listener to the checkbox
        checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // Check if the checkbox is checked or unchecked
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // The checkbox is selected
                    label.setText("Checked");
                } else {
                    // The checkbox is deselected
                    label.setText("Unchecked");
                }
            }
        });

        // Adding the checkbox and label to the frame
        frame.add(checkBox);
        frame.add(label);

        // Setting the frame size
        frame.setSize(300, 100);

        // Centering the frame on the screen
        frame.setLocationRelativeTo(null);

        // Showing the frame
        frame.setVisible(true);
    }
}
