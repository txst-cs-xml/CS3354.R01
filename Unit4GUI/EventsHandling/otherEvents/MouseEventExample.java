import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEventExample {

    // Main function to execute the application
    public static void main(String[] args) {
        // Creating instance of JFrame
        JFrame frame = new JFrame("Mouse Event Example");

        // Creating a panel with a certain background color
        JPanel panel = new JPanel();
        panel.setBackground(Color.RED);

        // Adding a mouse listener to the panel to handle mouse events
        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // This method is called when the panel is clicked
                // Changing the color of the panel when it's clicked
                if (panel.getBackground() == Color.RED) {
                    panel.setBackground(Color.BLUE);
                } else {
                    panel.setBackground(Color.RED);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // This method is called when a mouse button is pressed on the panel
                // It can be used to perform an action when the mouse is pressed
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // This method is called when a mouse button is released on the panel
                // It can be used to perform an action when the mouse button is released
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // This method is called when the mouse enters the panel
                // It can be used to perform an action, such as changing the cursor or displaying a message
                // draw a smile face
                Graphics g = panel.getGraphics();
                g.setColor(Color.YELLOW);
                g.fillOval(100, 100, 200, 200);
                g.setColor(Color.BLACK);
                g.fillOval(150, 150, 20, 20);
                g.fillOval(230, 150, 20, 20);
                g.drawArc(150, 200, 100, 50, 180, 180);
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // This method is called when the mouse exits the panel
                // It can be used to perform cleanup actions, such as changing the cursor back to the default
            }
        });

        // Setting the frame to close on exit
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Adding the panel to the frame
        frame.add(panel);

        // Setting the size of the frame
        frame.setSize(400, 400);

        // Making the frame visible
        frame.setVisible(true);
    }
}
