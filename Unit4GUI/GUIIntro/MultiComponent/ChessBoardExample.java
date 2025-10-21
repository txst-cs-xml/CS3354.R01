import javax.swing.*;
import java.awt.*;

public class ChessBoardExample {
    public static void main(String[] args) {
        // Create the main frame for the chess board
        JFrame frame = new JFrame("Chess Board");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create a JPanel that will hold the board
        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(8, 8));  // Chess board is 8x8 grid

        // Set a larger size to better see the squares
        boardPanel.setPreferredSize(new Dimension(400, 400));

        // Create the chess board squares
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                JPanel square = new JPanel();
                // Check the row and column numbers to decide the color
                if ((row + col) % 2 == 0) {
                    square.setBackground(Color.WHITE);
                } else {
                    square.setBackground(Color.BLACK);
                }
                boardPanel.add(square);  // Add the square to the board panel
            }
        }

        // Add board panel to the frame
        frame.add(boardPanel);
        frame.pack();  // Pack the frame to fit the board
        frame.setLocationRelativeTo(null);  // Center the frame
        frame.setVisible(true);
    }
}
