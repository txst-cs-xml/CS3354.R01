// The View: Handles the UI
import javax.swing.*;
import java.awt.*;

public class CalculatorView extends JFrame {
    private JTextField display;
    private JPanel buttonPanel;
    private JButton acButton;

    public CalculatorView() {
        setTitle("MVC Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        display = new JTextField("0");
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));
        add(buttonPanel, BorderLayout.CENTER);

        acButton = new JButton("AC");
        add(acButton, BorderLayout.SOUTH);

        setSize(400, 300);
    }

    public JTextField getDisplay() {
        return display;
    }

    public JPanel getButtonPanel() {
        return buttonPanel;
    }

    public JButton getAcButton() {
        return acButton;
    }
}
