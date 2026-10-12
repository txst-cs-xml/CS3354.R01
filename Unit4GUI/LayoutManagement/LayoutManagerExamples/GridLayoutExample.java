import javax.swing.*;
import java.awt.*;

public class GridLayoutExample {
    public static void main(String[] args) {
        // Creating instance of JFrame
        JFrame frame = new JFrame("GridLayout Example");

        // Setting the layout manager to GridLayout, 3 rows, 2 columns, with horizontal and vertical gaps of 5
        frame.setLayout(new GridLayout(3, 2, 5, 5));  // (rows, columns, hgap, vgap)

        // Creating buttons to add to the frame
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("Button 3");
        JButton button4 = new JButton("Button 4");
        JButton button5 = new JButton("Button 5");
        JButton button6 = new JButton("Button 6");

        // Adding buttons to the frame
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.add(button5);
        frame.add(button6);

        // Packing the frame to the preferred sizes of components
        frame.pack();

        // Setting default close operation and making the frame visible
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
