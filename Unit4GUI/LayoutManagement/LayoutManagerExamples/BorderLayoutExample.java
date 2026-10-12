import javax.swing.*;
import java.awt.*;

public class BorderLayoutExample {
    public static void main(String[] args) {
        // Creating instance of JFrame
        JFrame frame = new JFrame("BorderLayout Example");

        // Setting the layout manager to BorderLayout
        frame.setLayout(new BorderLayout());

        // Creating buttons
        JButton northButton = new JButton("North");
        JButton southButton = new JButton("South");
        JButton eastButton = new JButton("East");
        JButton westButton = new JButton("West");
        JButton centerButton = new JButton("Center");

        // Adding buttons to the frame container with BorderLayout constraints
        frame.add(northButton, BorderLayout.NORTH);
        frame.add(southButton, BorderLayout.SOUTH);
        frame.add(eastButton, BorderLayout.EAST);
        frame.add(westButton, BorderLayout.WEST);
        frame.add(centerButton, BorderLayout.CENTER);
        

        // Packing the frame to prefered sizes of components
        frame.pack();

        // Setting default close operation and making the frame visible
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
