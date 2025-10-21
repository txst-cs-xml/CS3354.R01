import javax.swing.*;
import java.awt.*;

public class GlassPaneExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Glass Pane Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Accessing the glass pane
        JPanel glassPane = (JPanel) frame.getGlassPane();
        glassPane.setVisible(true); // Make it visible to intercept mouse events
        glassPane.add(new JLabel("Clicks are blocked!"), BorderLayout.CENTER);

        frame.setVisible(true);
    }
}