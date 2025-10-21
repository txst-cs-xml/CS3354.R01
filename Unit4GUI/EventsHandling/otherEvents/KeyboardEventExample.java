import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardEventExample {
    // Setting the initial coordinates of the character
    private static int circleX = 50;
    private static int circleY = 50;
    private static final int CIRCLE_DIAMETER = 50;
    private static final int MOVE_SPEED = 10;

    public static void main(String[] args) {
        // Creating the frame
        JFrame frame = new JFrame("Keyboard Event Example");

        // Creating a custom panel that can draw our character and listen to keyboard events
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Drawing the character as a simple circle
                g.fillOval(circleX, circleY, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
            }
        };

        // Creating a key listener to move the character
        KeyListener keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Not needed for this example
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // Moving the character based on the arrow key pressed
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        circleY -= MOVE_SPEED; // Move up
                        break;
                    case KeyEvent.VK_DOWN:
                        circleY += MOVE_SPEED; // Move down
                        break;
                    case KeyEvent.VK_LEFT:
                        circleX -= MOVE_SPEED; // Move left
                        break;
                    case KeyEvent.VK_RIGHT:
                        circleX += MOVE_SPEED; // Move right
                        break;
                }
                panel.repaint();  // Repaint the panel to show the new position
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Not needed for this example
            }
        };

        // Setting up the frame
        frame.addKeyListener(keyListener); // Adding the key listener to the frame
        frame.setFocusable(true); // Allowing the frame to gain focus for keyboard events
        frame.setSize(400, 400); // Setting the size of the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Setting the default close operation

        // Setting up the panel
        panel.setPreferredSize(new Dimension(400, 400)); // Setting the size of the panel

        // Adding the panel to the frame
        frame.add(panel);

        // Finalizing the frame setup
        frame.pack(); // Adjusting the size of the frame to fit its content
        frame.setVisible(true); // Making the frame visible
    }
}
