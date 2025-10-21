import javax.swing.JFrame;

public class JFrameExample {

    public static void main(String[] args) {
        // Create a new JFrame instance
        JFrame frame = new JFrame("JFrame Example");

        // Set the default operation when the frame is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the size of the frame
        frame.setSize(300, 200);

        // set frame size unchanged
        frame.setResizable(false);

        // Optionally, you can set the frame to start in the middle of the screen
        frame.setLocationRelativeTo(null);

        // Important to make the frame visible
        frame.setVisible(true);
    }
}
