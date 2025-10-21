import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtonExample {

    public static void main(String[] args) {
        // Create a new JFrame instance
        JFrame frame = new JFrame("JButton Example");

        // Set the default operation when the frame is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a new JButton instance
        JButton button = new JButton("Click Me!");

        // Add an action listener to the button for handling clicks
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This line of code will be executed when the button is clicked
                JOptionPane.showMessageDialog(frame, "Button was clicked!");
            }
        });

        // Add the button to the JFrame
        frame.add(button);

        // Set the size of the frame
        frame.setSize(300, 200);

        // Optionally, you can set the frame to start in the middle of the screen
        frame.setLocationRelativeTo(null);

        // Important to make the frame visible
        frame.setVisible(true);
    }
}
