import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// JToolBar is used to create a toolbar, 
// often seen at the top of applications, providing quick access to various actions. 
public class ToolBarExample {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("JToolBar Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());  // Set layout manager for the frame

        // Create a toolbar
        JToolBar toolBar = new JToolBar("Application Toolbar");

        // Create buttons for the toolbar
        JButton newButton = new JButton("New");
        JButton openButton = new JButton("Open");
        JButton saveButton = new JButton("Save");

        // make button font size bigger
        newButton.setFont(new Font("Arial", Font.PLAIN, 30));
        openButton.setFont(new Font("Arial", Font.PLAIN, 30));
        saveButton.setFont(new Font("Arial", Font.PLAIN, 30));

        // Add buttons to the toolbar
        toolBar.add(newButton);
        toolBar.add(openButton);
        toolBar.add(saveButton);

        // Create an action listener for the buttons
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                System.out.println(source.getText() + " button clicked!");
            }
        };

        // Add the action listener to buttons
        newButton.addActionListener(actionListener);
        openButton.addActionListener(actionListener);
        saveButton.addActionListener(actionListener);

        // Add the toolbar to the frame at the page start position
        frame.add(toolBar, BorderLayout.PAGE_START); // Adding to the top

        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
