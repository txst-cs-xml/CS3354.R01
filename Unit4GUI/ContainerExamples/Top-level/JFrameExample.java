import javax.swing.*;

public class JFrameExample {

    public static void main(String[] args) {
        // Create a new JFrame instance
        // JFrame frame = new JFrame("JFrame Example");
        JFrame frame = new JFrame();

        // Set the default operation when the frame is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // change frame background color to dar blue
        frame.getContentPane().setBackground(new java.awt.Color(0, 0, 153));


        // Set the size of the frame
        frame.setSize(500, 500);

        // set frame size unchanged
        frame.setResizable(false);

        // Optionally, you can set the frame to start in the middle of the screen
        frame.setLocationRelativeTo(null);

        // Important to make the frame visible
        frame.setVisible(true);
    }
}
