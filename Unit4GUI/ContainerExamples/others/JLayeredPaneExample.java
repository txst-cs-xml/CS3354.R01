import javax.swing.*;
import java.awt.*;

// A JLayeredPane manages the z-order of its child components, allowing them to overlap.
public class JLayeredPaneExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JLayeredPane Example");

        JLayeredPane layeredPane = new JLayeredPane();

        // Create several buttons to layer.
        JButton top = new JButton("Top");
        top.setBackground(Color.WHITE);
        top.setBounds(20, 20, 100, 100);

        JButton middle = new JButton("Middle");
        middle.setBackground(Color.GRAY);
        middle.setBounds(80, 80, 100, 100);

        JButton bottom = new JButton("Bottom");
        bottom.setBackground(Color.BLACK);
        bottom.setForeground(Color.WHITE);
        bottom.setBounds(150, 150, 100, 100);

        //Add buttons to the JLayeredPane
        layeredPane.add(bottom, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(middle, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(top, JLayeredPane.MODAL_LAYER);

        frame.add(layeredPane);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

// In this JLayeredPane example, three buttons are created and added to different layers, making them overlap each other.