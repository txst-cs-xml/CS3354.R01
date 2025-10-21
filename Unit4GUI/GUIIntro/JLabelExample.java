import java.awt.*;

import javax.swing.*;

public class JLabelExample {

    public static void main(String[] args) {
        // Create a new JFrame instance
        JFrame frame = new JFrame("JFrame Example");

        // Set the default operation when the frame is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a new JLabel instance
        JLabel label = new JLabel("Hello, Swing!");

        //create a label with massage label2
        //JLabel label2 = new JLabel("Hello, Swing2!");

        // change label font size bigger
        label.setFont(new Font("Serif", Font.PLAIN, 40));
        // change label color as white
        label.setForeground(Color.WHITE);

        //change the frame background color to dark blue
        frame.getContentPane().setBackground(Color.BLUE);

        

        // Add the label to the JFrame
        frame.add(label);
        //frame.add(label2);

        // Set the size of the frame
        frame.setSize(300, 200);

        // Optionally, you can set the frame to start in the middle of the screen
        frame.setLocationRelativeTo(null);

        // Important to make the frame visible
        frame.setVisible(true);
    }
}
