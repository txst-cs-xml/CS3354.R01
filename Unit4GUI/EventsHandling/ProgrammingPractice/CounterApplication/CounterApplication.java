import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CounterApplication extends JFrame {
    private int count = 0; // Counter value
    private JLabel labelCount; // Label to display the counter

    public CounterApplication() {
        // Set up the frame
        setTitle("Counter Application");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create a label and set its initial value
        labelCount = new JLabel("0");
        this.add(labelCount);

        // Create the "Increase" button and add action listener
        JButton increaseButton = new JButton("Increase");
        increaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                labelCount.setText(String.valueOf(count));
            }
        });
        this.add(increaseButton);

        // Create the "Decrease" button and add action listener
        JButton decreaseButton = new JButton("Decrease");
        decreaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count--;
                labelCount.setText(String.valueOf(count));
            }
        });
        this.add(decreaseButton);

        // Make the frame visible
        this.setVisible(true);
    }

    public static void main(String[] args) {
        // Start the application on the event-dispatching thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CounterApplication();
            }
        });
    }
}
