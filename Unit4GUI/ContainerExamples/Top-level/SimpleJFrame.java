import javax.swing.JFrame;

public class SimpleJFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame(); // Create a frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation
        frame.setSize(300, 200); // Set the size of the frame
        frame.setVisible(true); // Make the frame visible
    }
}
