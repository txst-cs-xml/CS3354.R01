import board.Board;
import player.Player;
import java.util.Scanner;
/**
 * Represents the Tic Tac Toe game. It controls the game flow and manages turns.
 */
public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Scanner scanner;

    /**
     * Initializes a new Tic Tac Toe game.
     */
    public Game() {
        board = new Board();
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        scanner = new Scanner(System.in);
    }

    /**
     * Starts the Tic Tac Toe game.
     */
    public void start() {
        while (!board.isGameOver()) {
            board.display();
            System.out.println("Player " + currentPlayer.getSymbol() + ", enter your move (row[0-2] and column[0-2]): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            if (board.isValidMove(row, col)) {
                board.makeMove(row, col, currentPlayer);
                if (!board.isGameOver()) {
                    switchPlayer();
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
        board.display();
        if (board.hasWinner()) {
            System.out.println("Player " + currentPlayer.getSymbol() + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    /**
     * Switches the current player.
     */
    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
}