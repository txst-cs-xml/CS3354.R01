import javax.swing.*;
import java.awt.*;

public class PizzaOrderGUI {
    
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Pizza Order");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        // Radio button panel
        JPanel radioButtonPanel = new JPanel();
        radioButtonPanel.setLayout(new GridLayout(3, 1));
        radioButtonPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Size"));
        
        JRadioButton smallButton = new JRadioButton("Small");
        JRadioButton mediumButton = new JRadioButton("Medium");
        JRadioButton largeButton = new JRadioButton("Large");
        
        radioButtonPanel.add(smallButton);
        radioButtonPanel.add(mediumButton);
        radioButtonPanel.add(largeButton);
    
        ButtonGroup sizeGroup = new ButtonGroup();
        sizeGroup.add(smallButton);
        sizeGroup.add(mediumButton);
        sizeGroup.add(largeButton);
        
        // Check box panel
        JPanel checkBoxPanel = new JPanel();
        checkBoxPanel.setLayout(new GridLayout(2, 1));
        
        JCheckBox pepperoniButton = new JCheckBox("Pepperoni");
        JCheckBox anchoviesButton = new JCheckBox("Anchovies");
        
        checkBoxPanel.add(pepperoniButton);
        checkBoxPanel.add(anchoviesButton);
        
        // Price panel
        JPanel pricePanel = new JPanel();
        
        JLabel priceLabel = new JLabel("Your Price: ");
        JTextField priceTextField = new JTextField(10);
        
        pricePanel.add(priceLabel);
        pricePanel.add(priceTextField);
        
        // Center panel
        JPanel centerPanel = new JPanel();
        
        centerPanel.add(radioButtonPanel);
        centerPanel.add(checkBoxPanel);
        
        // Add panels to the main frame
        frame.setLayout(new BorderLayout());
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(pricePanel, BorderLayout.SOUTH);
        
        // Display the frame
        frame.pack();
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
    }
}
