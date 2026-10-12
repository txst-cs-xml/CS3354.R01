import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CardLayoutExample implements ActionListener {
    // Define the container and cards for the CardLayout
    private JFrame frame = new JFrame("CardLayout Example");
    private JPanel cardPanel = new JPanel();
    private CardLayout cardLayout = new CardLayout();
    private JButton nextButton = new JButton("Next");
    private JButton prevButton = new JButton("Previous");

    public CardLayoutExample() {
        // Set CardLayout as the layout manager for cardPanel
        cardPanel.setLayout(cardLayout);

        // Create a few cards (panels) and add them to cardPanel
        for (int i = 1; i <= 5; i++) {
            JButton button = new JButton("Card " + i);
            JPanel card = new JPanel();
            card.add(button);
            cardPanel.add(card, "Card" + i);
        }

        // Create a panel for the buttons and add listeners
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        nextButton.addActionListener(this);
        prevButton.addActionListener(this);

        // Add cardPanel and buttonPanel to the frame
        frame.add(cardPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton) {
            cardLayout.next(cardPanel);  // Show next card
        } else if (e.getSource() == prevButton) {
            cardLayout.previous(cardPanel);  // Show previous card
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CardLayoutExample();
            }
        });
    }
}
