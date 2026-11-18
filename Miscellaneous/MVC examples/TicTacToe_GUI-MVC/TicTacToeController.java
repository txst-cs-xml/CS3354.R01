import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import board.Board;
import player.Player;

public class TicTacToeController {
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
    }

    private void initialize() {
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
        if (board.isValidMove(row, col)) {
            board.makeMove(row, col, currentPlayer);
            view.setButtonText(row, col, String.valueOf(currentPlayer.getSymbol()));
            if (board.isGameOver()) {
                gameOver();
            } else {
                switchPlayer();
            }
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    private void gameOver() {
        String message = "Game Over. ";
        if (board.hasWinner()) {
            message += "Player " + currentPlayer.getSymbol() + " wins!";
        } else {
            message += "It's a draw!";
        }
        view.showMessage(message);
        view.close(); // You might want to restart instead.
    }
}
