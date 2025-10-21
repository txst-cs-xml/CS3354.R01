import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LightSwitchSimulator extends JFrame {
    private boolean isLightOn; // Flag to check if the light is on
    private JLabel lightStatusLabel; // Label to display the light's status

    public LightSwitchSimulator() {
        // Set up the frame
        setTitle("Light Switch Simulator");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Initialize the light status (off)
        isLightOn = false;

        // Create a label with the light's initial status
        lightStatusLabel = new JLabel("Light is OFF");
        this.add(lightStatusLabel);

        // Create the "Switch" button and add action listener
        JButton switchButton = new JButton("Toggle Light");
        switchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Toggle the light status and update the label's text accordingly
                isLightOn = !isLightOn;
                if (isLightOn) {
                    lightStatusLabel.setText("Light is ON");
                } else {
                    lightStatusLabel.setText("Light is OFF");
                }
            }
        });
        this.add(switchButton);

        // Make the frame visible
        this.setVisible(true);
    }

    public static void main(String[] args) {
        // Start the application on the event-dispatching thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LightSwitchSimulator();
            }
        });
    }
}
