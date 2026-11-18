import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;
import board.Board;
import player.Player;

public class TicTacToeController {
    private static final Logger LOGGER = Logger.getLogger("tictactoe.Controller");
    private Board board;
    private TicTacToeView view;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public TicTacToeController(Board board, TicTacToeView view, Player player1, Player player2) {
        this.board = board;
        this.view = view;
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;

        initialize();
        LOGGER.info("New game: player X moves first.");
    }

    private void initialize() {
        LOGGER.config("Connecting the nine view buttons to the controller.");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int finalI = i;
                int finalJ = j;
                JButton button = view.getButton(i, j);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        handleButtonClick(finalI, finalJ, button);
                    }
                });
            }
        }
    }

    private void handleButtonClick(int row, int col, JButton button) {
        LOGGER.finer("Button clicked at row " + row + ", column " + col);
        if (board.isValidMove(row, col)) {
            board.makeMove(row, col, currentPlayer);
            view.setButtonText(row, col, String.valueOf(currentPlayer.getSymbol()));
            if (board.isGameOver()) {
                gameOver();
            } else {
                switchPlayer();
            }
        } else {
            LOGGER.warning("Rejected move: cell (" + row + ", " + col + ") is occupied.");
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
        LOGGER.fine("Next turn: player " + currentPlayer.getSymbol());
    }

    private void gameOver() {
        String message = "Game Over. ";
        if (board.hasWinner()) {
            message += "Player " + currentPlayer.getSymbol() + " wins!";
        } else {
            message += "It's a draw!";
        }
        LOGGER.info(message);
        view.showMessage(message);
        view.close(); // You might want to restart instead.
    }
}
