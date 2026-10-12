import javax.swing.*;
import java.awt.*;

public class SpringLayoutExample {
    public static void main(String[] args) {
        // Creating instance of JFrame
        JFrame frame = new JFrame("SpringLayout Example");

        // Setting up the SpringLayout
        SpringLayout layout = new SpringLayout();
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(layout);

        // Creating and adding components to the frame's content pane
        JButton button1 = new JButton("Button 1");
        contentPane.add(button1);
        JButton button2 = new JButton("Button 2");
        contentPane.add(button2);

        // Adjust constraints for the first button (Button 1)
        SpringLayout.Constraints button1Cons = layout.getConstraints(button1);
        button1Cons.setX(Spring.constant(100));  // Fixed x distance from left
        button1Cons.setY(Spring.constant(80));   // Fixed y distance from top

        // Adjust constraints for the second button (Button 2) - position it relative to Button 1
        SpringLayout.Constraints button2Cons = layout.getConstraints(button2);
        button2Cons.setX(Spring.sum(Spring.constant(20), button1Cons.getConstraint(SpringLayout.EAST)));  // Positioned 20px to the right of Button 1
        button2Cons.setY(Spring.sum(Spring.constant(20), button1Cons.getConstraint(SpringLayout.SOUTH))); // Positioned 20px below Button 1

        // Setting up the frame size, close operation, and making it visible
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
