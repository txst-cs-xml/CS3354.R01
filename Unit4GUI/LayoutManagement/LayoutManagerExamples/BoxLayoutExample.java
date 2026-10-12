import javax.swing.*;
import java.awt.*;

public class BoxLayoutExample {
    public static void main(String[] args) {
        // Creating instance of JFrame
        JFrame frame = new JFrame("BoxLayout Example");

        // Setting BoxLayout manager for the frame, aligned along the Y-axis
        BoxLayout boxlayout = new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS);
        frame.setLayout(boxlayout);

        // Creating buttons
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("******Button 3*******");
        JButton button4 = new JButton("Button 4");
        JButton button5 = new JButton("Button 5");

        // Adding buttons to the frame container
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.add(button5);

        // Adding a vertical strut for a bit of space between the buttons
        frame.add(Box.createVerticalStrut(5));

        // Packing the frame to the preferred sizes of components
        frame.pack();

        // Setting default close operation and making the frame visible
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
