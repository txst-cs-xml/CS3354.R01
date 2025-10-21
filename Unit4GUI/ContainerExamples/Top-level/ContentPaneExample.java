import javax.swing.*;
import java.awt.*;

public class ContentPaneExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Content Pane Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Accessing and adding a component to the content pane
        Container contentPane = frame.getContentPane();
        contentPane.add(new JButton("Click Me!"), BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
