import javax.swing.*;
import java.awt.*;

public class FeedbackFormExample {

    public static void main(String[] args) {
        // Create the main frame for the feedback form
        JFrame frame = new JFrame("Session Feedback");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main panel with BoxLayout for stacking components vertically
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Panel for session rating with a label and radio buttons
        JPanel ratingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ratingPanel.add(new JLabel("Rate the session:"));
        ButtonGroup group = new ButtonGroup();
        JRadioButton rb1 = new JRadioButton("Poor");
        JRadioButton rb2 = new JRadioButton("Fair");
        JRadioButton rb3 = new JRadioButton("Good");
        JRadioButton rb4 = new JRadioButton("Excellent");
        group.add(rb1);
        group.add(rb2);
        group.add(rb3);
        group.add(rb4);
        ratingPanel.add(rb1);
        ratingPanel.add(rb2);
        ratingPanel.add(rb3);
        ratingPanel.add(rb4);

        // Panel for feedback comments with a label and text area
        JPanel commentsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        commentsPanel.add(new JLabel("Comments:"));
        JTextArea commentsTextArea = new JTextArea(5, 20);
        commentsTextArea.setLineWrap(true);
        commentsTextArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(commentsTextArea);
        commentsPanel.add(scrollPane);

        // Panel for the submit button
        JPanel submitPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton submitButton = new JButton("Submit Feedback");
        submitPanel.add(submitButton);

        // Add all panels to the main panel
        mainPanel.add(ratingPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 5))); // Add some space between panels
        mainPanel.add(commentsPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 15))); // Add some space before the button
        mainPanel.add(submitPanel);

        // Add padding around the main panel
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Add the main panel to the frame
        frame.add(mainPanel);

        // Pack the frame's contents and set the frame to the center
        frame.pack();
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
    }
}
