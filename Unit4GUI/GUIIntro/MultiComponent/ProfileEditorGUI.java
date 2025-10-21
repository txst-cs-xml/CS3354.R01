import javax.swing.*;
import java.awt.*;

public class ProfileEditorGUI {

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Profile Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the size of the frame
        frame.setSize(500, 500);
        
        // Set a layout for the frame
        frame.setLayout(new BorderLayout());

        // Create a main panel with a BoxLayout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Add a profile picture
        ImageIcon profileIcon = new ImageIcon("codingIcon.png"); // make sure to have an image file at this location
        JLabel profileLabel = new JLabel();
        profileLabel.setIcon(profileIcon);
        profileLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centering the image

        // Add a name label
        JLabel nameLabel = new JLabel("John Doe");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Changing the font
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centering the text
        
        // Add a description area
        JTextArea descriptionArea = new JTextArea("Bio: A short description about John.");
        descriptionArea.setFont(new Font("Serif", Font.ITALIC, 16)); // Changing the font
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setEditable(false); // User cannot edit this area

        // Change background colors
        mainPanel.setBackground(Color.LIGHT_GRAY); // Changing the background color of the main panel
        descriptionArea.setBackground(Color.WHITE); // Changing the background color of the text area

        // Create an edit button
        JButton editButton = new JButton("Edit Profile");
        editButton.setFont(new Font("SansSerif", Font.BOLD, 16)); // Changing the font
        editButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Centering the button

        // Add components to the main panel
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add some top spacing
        mainPanel.add(profileLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add some spacing
        mainPanel.add(nameLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add some spacing
        mainPanel.add(descriptionArea);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add some spacing
        mainPanel.add(editButton);

        // Add padding around the main panel
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add the main panel to the frame's content pane
        frame.add(mainPanel, BorderLayout.CENTER);

        // Pack the frame's contents and set the frame to the center of the screen
        frame.pack();
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
    }
}
