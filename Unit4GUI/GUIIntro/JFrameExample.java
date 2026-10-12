import javax.swing.JFrame;
import javax.swing.JLabel;

public class JFrameExample {

    public static void main(String[] args) {
        // Create a new JFrame instance
        JFrame frame = new JFrame("JFrame Example");
        JLabel label = new JLabel("This is a label");
        frame.add(label);

        // Set the default operation when the frame is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the size of the frame
        frame.setSize(500, 500);

        // set frame size unchanged
        frame.setResizable(true);

        // Optionally, you can set the frame to start in the middle of the screen
        frame.setLocationRelativeTo(null);

        // Important to make the frame visible
        frame.setVisible(true);
    }
}
