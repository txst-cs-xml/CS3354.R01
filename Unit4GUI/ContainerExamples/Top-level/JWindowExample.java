import javax.swing.*;
import java.awt.*;

public class JWindowExample {

    public static void main(String[] args) {
        // Create a new JWindow instance
        JWindow window = new JWindow();

        // Create a label to add to the window
        JLabel label = new JLabel("Hello, JWindow!", SwingConstants.CENTER);
        // set label font size bigger
        label.setFont(new Font("Serif", Font.PLAIN, 30));

        // Set the window's size
        //window.setSize(200, 100);
        // make window size bigger 
        window.setSize(400, 200);

        // Add the label to the window's content pane
        window.getContentPane().add(label);

        // Optionally, you can set the window to start in the middle of the screen
        window.setLocationRelativeTo(null);

        // Set a background color for the window (optional)
        window.getContentPane().setBackground(Color.LIGHT_GRAY);

        // Important to make the window visible
        window.setVisible(true);

        // Simulate a splash screen: Display it for a few seconds and then close
        try {
            Thread.sleep(10000); // Wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        window.setVisible(false);
        window.dispose(); // Release all of the native screen resources
    }
}
