import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTextFieldExample {
    public static void main(String[] args) {
        // Create a new JFrame instance.
        JFrame frame = new JFrame("JTextField Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a new JPanel instance with a FlowLayout.
        JPanel panel = new JPanel(new FlowLayout());

        // Create a new JTextField instance with 20 columns.
        JTextField textField = new JTextField(20);

        // Add an ActionListener to the JTextField.
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This method is called when the Enter key is pressed.
                String text = textField.getText();
                System.out.println("Input received: " + text);
            }
        });

        // Add the JTextField to the JPanel.
        panel.add(textField);

        // Add the JPanel to the JFrame.
        frame.add(panel);

        // Set the size of the JFrame.
        frame.setSize(300, 100);

        // Center and show the JFrame.
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
