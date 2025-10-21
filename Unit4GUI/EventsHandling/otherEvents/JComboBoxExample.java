import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JComboBoxExample {
    public static void main(String[] args) {
        // Create and set up a frame window
        JFrame frame = new JFrame("JComboBox Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Define some choices for the JComboBox
        String[] choices = {"Choice 1", "Choice 2", "Choice 3", "Choice 4"};

        // Create a combo box with the given array
        JComboBox<String> comboBox = new JComboBox<>(choices);

        // Create a label to display the selected item
        JLabel label = new JLabel();
        label.setPreferredSize(new Dimension(200, 50)); // setting preferred size for demonstration purposes

        // Add an action listener to handle the selection changes
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String) comboBox.getSelectedItem();
                label.setText("Selected: " + selectedItem);
            }
        });

        // Add components to the frame window
        frame.add(comboBox);
        frame.add(label);

        // Set the window's size and make it visible
        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
    }
}
