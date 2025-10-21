import javax.swing.*;
import java.awt.*;

public class MultiComponentExample {

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("User Registration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a main panel to host all other components and set a layout for it
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Create a panel for the name with a label and a text field
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        namePanel.add(new JLabel("Name:"));
        namePanel.add(new JTextField(20));

        // Create a panel for the password with a label and a password field
        JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        passwordPanel.add(new JLabel("Password:"));
        passwordPanel.add(new JPasswordField(20));

        // Create a panel for the email with a label and a text field
        JPanel emailPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        emailPanel.add(new JLabel("Email:"));
        emailPanel.add(new JTextField(20));

        // Create a panel for the profession with a label and a combo box
        JPanel professionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        professionPanel.add(new JLabel("Profession:"));
        String[] professions = {"Engineer", "Doctor", "Artist", "Other"};
        professionPanel.add(new JComboBox<>(professions));

        // Create a panel for the bio with a label and a text area within a scroll pane
        JPanel bioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bioPanel.add(new JLabel("Bio:"));
        JTextArea bioTextArea = new JTextArea(5, 20);
        bioTextArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(bioTextArea);
        bioPanel.add(scrollPane);

        // Create a panel for the submit button
        JPanel submitPanel = new JPanel();
        submitPanel.add(new JButton("Submit"));

        // Add all panels to the main panel
        mainPanel.add(namePanel);
        mainPanel.add(passwordPanel);
        mainPanel.add(emailPanel);
        mainPanel.add(professionPanel);
        mainPanel.add(bioPanel);
        mainPanel.add(submitPanel);

        // Add some outer padding to the main panel
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add the main panel to the frame
        frame.add(mainPanel);

        // Pack the contents of the window and display it
        frame.pack();
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
    }
}
