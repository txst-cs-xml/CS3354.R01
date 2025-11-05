import board.Board;
import player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * The {@code Game} class represents the graphical user interface for the Tic Tac Toe game.
 * It initializes the game window, handles user interactions, and updates the game state.
 */
public class Game {
    private final JFrame frame = new JFrame("Tic Tac Toe");
    private final Board board = new Board();
    private final Player player1 = new Player('X');
    private final Player player2 = new Player('O');
    private Player currentPlayer = player1;
    private final JButton[][] buttons = new JButton[3][3];

    /**
     * Constructs the GUI, sets up the game board, and initializes game components.
     */
    public Game() {
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton();
                button.setFont(new Font("Arial", Font.BOLD, 50));
                final int finalI = i;
                final int finalJ = j;
                button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        handleButtonClick(finalI, finalJ, button);
                    }
                });
                buttons[i][j] = button;
                frame.add(button);
            }
        }
    }

    /**
     * Starts the game by making the window visible.
     */
    public void start() {
        frame.setVisible(true);
    }

    /**
     * Handles button clicks on the game board, making a move if valid, and checks the game's end state.
     * 
     * @param row The row index of the button.
     * @param col The column index of the button.
     * @param button The button that was clicked.
     */
    private void handleButtonClick(int row, int col, JButton button) {
        if (board.isValidMove(row, col)) {
            board.makeMove(row, col, currentPlayer);
            button.setText(String.valueOf(currentPlayer.getSymbol()));
            if (board.isGameOver()) {
                gameOver();
            } else {
                switchPlayer();
            }
        }
    }

    /**
     * Switches the turn between two players.
     */
    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    /**
     * Displays a dialog with the game's outcome and then closes the application.
     */
    private void gameOver() {
        String message = "Game Over. ";
        if (board.hasWinner()) {
            message += "Player " + currentPlayer.getSymbol() + " wins!";
        } else {
            message += "It's a draw!";
        }
        JOptionPane.showMessageDialog(frame, message);
        frame.dispose(); // Close the application or you might want to offer a restart option here.
    }

}
