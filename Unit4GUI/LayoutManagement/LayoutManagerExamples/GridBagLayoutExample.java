import javax.swing.*;
import java.awt.*;

public class GridBagLayoutExample {
    public static void main(String[] args) {
        // Creating instance of JFrame
        JFrame frame = new JFrame("GridBagLayout Example");

        // Setting the layout manager to GridBagLayout
        frame.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        // Creating buttons
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("Button 3");

        // Adding the first button with certain constraints
        constraints.gridx = 0;  // column 0
        constraints.gridy = 0;  // row 0
        constraints.weightx = 0.5;
        constraints.fill = GridBagConstraints.HORIZONTAL;  // Makes component wide enough to fill its display area horizontally, but does not change height.
        frame.add(button1, constraints);

        // Adding the second button with different constraints
        constraints.gridx = 1;  // column 1
        constraints.gridy = 0;  // row 0
        frame.add(button2, constraints);

        // Adding the third button with different constraints
        constraints.gridx = 0;  // column 0
        constraints.gridy = 1;  // row 1
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridwidth = 2;  // The component's display area will span two columns.
        constraints.weightx = 0.0;
        frame.add(button3, constraints);

        // Adjusting the size of the frame to the preferred size of its components and setting other properties
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
