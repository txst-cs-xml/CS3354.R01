import javax.swing.*;
import java.awt.*;

public class MultiLayoutExample {
    public static void main(String[] args) {
        // Creating the main frame using BorderLayout
        JFrame mainFrame = new JFrame("Multi-Layout Example");
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel with a FlowLayout, adding buttons
        JPanel flowPanel = new JPanel(new FlowLayout());
        flowPanel.add(new JButton("Flow Button 1"));
        flowPanel.add(new JButton("Flow Button 2"));

        // Panel with a GridLayout, adding checkboxes
        JPanel gridPanel = new JPanel(new GridLayout(2, 2)); // 2 rows, 2 cols
        gridPanel.add(new JCheckBox("Grid Checkbox 1"));
        gridPanel.add(new JCheckBox("Grid Checkbox 2"));
        gridPanel.add(new JCheckBox("Grid Checkbox 3"));
        gridPanel.add(new JCheckBox("Grid Checkbox 4"));

        // Panel with a BoxLayout, adding labels
        JPanel boxPanel = new JPanel();
        boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS));
        boxPanel.add(new JLabel("Box Label 1"));
        boxPanel.add(new JLabel("Box Label 2"));
        boxPanel.add(new JLabel("Box Label 3"));


        // Adding panels to the frame's content pane
        mainFrame.add(flowPanel, BorderLayout.NORTH);
        mainFrame.add(gridPanel, BorderLayout.WEST);
        mainFrame.add(boxPanel, BorderLayout.CENTER);

        // Pack and show the frame
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null); // Center the frame
        mainFrame.setVisible(true);
    }
}
