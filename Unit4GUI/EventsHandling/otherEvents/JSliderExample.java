import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JSliderExample {

    public static void main(String[] args) {
        // Create a new JFrame container.
        JFrame frame = new JFrame("JSlider Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Create a slider with a range from 0 to 100 and an initial value of 50.
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        slider.setMajorTickSpacing(20); // create a tick every 20 units
        slider.setPaintTicks(true); // paint the ticks on the slider
        slider.setPaintLabels(true); // display the numerical labels for the major ticks

        // Create a label that displays the slider's value.
        JLabel label = new JLabel("Value: 50");

        // Register a change listener for the slider.
        slider.addChangeListener(e -> {
            // Get the value of the slider.
            int value = slider.getValue();
            // Update the label with the value of the slider.
            label.setText("Value: " + value);
        });

        // Add the slider and label to the frame.
        frame.add(slider);
        frame.add(label);

        // Set the frame's size and make it visible.
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null); // center the frame
        frame.setVisible(true);
    }
}
