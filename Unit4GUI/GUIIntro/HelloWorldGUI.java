import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloWorldGUI {
    public static void main(String[] args) {
        // Create a new JFrame instance
        JFrame frame = new JFrame("First GUI");

        JButton button = new JButton("Display message");
        frame.add(button);

        // Add an action listener to the button for handling clicks
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a dialog with the frame as the parent
                JDialog dialog = new JDialog(frame, "My Dialog", true); // 'true' for modal

                // Set the dialog size
                dialog.setSize(200, 150);

                // Optionally, you can set the dialog location relative to a component
                // Here it's centered relative to the frame
                dialog.setLocationRelativeTo(frame);

                // Add a label to the dialog
                JLabel label = new JLabel("Hello World!", SwingConstants.CENTER);

                dialog.add(label);

                // Display the dialog
                dialog.setVisible(true);

            }
        });

        // Set the default operation when the frame is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the size of the frame
        frame.setSize(300, 200);

        // set frame size unchanged
        frame.setResizable(false);

        // Optionally, you can set the frame to start in the middle of the screen
        frame.setLocationRelativeTo(null);

        // Important to make the frame visible
        frame.setVisible(true);
    }
}
