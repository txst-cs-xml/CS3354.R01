import javax.swing.*;

public class JFrameExample {

    public static void main(String[] args) {
        // Create a new JFrame instance
        // JFrame frame = new JFrame("JFrame Example");
        JFrame frame = new JFrame();
        JButton button = new JButton("Submit");
        JLabel label1 = new JLabel("Hello World");
        JLabel label2 = new JLabel("Hello World");
        JLabel label3 = new JLabel("Hello World");
        JLabel label4 = new JLabel("Hello World");
        JLabel label5 = new JLabel("Hello World");
        JLabel label6 = new JLabel("Hello World");
        JLabel label7 = new JLabel("Hello World");
        JPanel panel = new JPanel();
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        panel.add(label6);
        panel.add(label7);
        frame.add(panel);

        // Set the default operation when the frame is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // change frame background color to dar blue
        //frame.getContentPane().setBackground(new java.awt.Color(0, 0, 153));


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
