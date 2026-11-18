import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Logger;
import logging.GameLogging;

public class TicTacToeView {
    private static final Logger LOGGER = Logger.getLogger("tictactoe.View");
    private JFrame frame;
    private JButton[][] buttons;

    public TicTacToeView() {
        frame = new JFrame("Tic Tac Toe");
        frame.setSize(300, 300);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                LOGGER.info("Game window closed by user.");
                GameLogging.close();
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 3));

        buttons = new JButton[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 50));
                frame.add(buttons[i][j]);
            }
        }
    }

    public void display() {
        LOGGER.fine("Displaying the game window.");
        frame.setVisible(true);
    }

    public JButton getButton(int row, int col) {
        return buttons[row][col];
    }

    public void setButtonText(int row, int col, String text) {
        LOGGER.finer("Updating button (" + row + ", " + col + ") to " + text);
        buttons[row][col].setText(text);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }

    public void close() {
        LOGGER.info("Game finished; closing the window.");
        frame.dispose();
        GameLogging.close();
    }
}
