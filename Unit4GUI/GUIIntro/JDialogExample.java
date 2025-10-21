import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JDialogExample {

    public static void main(String[] args) {
        // Create a new JFrame instance as the parent frame
        JFrame frame = new JFrame("JDialog Example");

        // Set the default operation when the frame is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a button for opening a dialog
        JButton button = new JButton("Show Dialog");

        // Add an action listener to the button
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
                JLabel label = new JLabel("Hello from the Dialog!", SwingConstants.CENTER);
                dialog.add(label);

                // Display the dialog
                dialog.setVisible(true);
            }
        });

        // Add the button to the JFrame
        frame.add(button);

        // Set the frame layout
        frame.setLayout(new FlowLayout());

        // Set the size of the frame
        frame.setSize(300, 200);

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);

        // Important to make the frame visible
        frame.setVisible(true);
    }
}
