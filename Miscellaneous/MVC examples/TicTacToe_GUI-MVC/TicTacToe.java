import board.Board;
import player.Player;

/**
 * The main class for the Tic Tac Toe game. This class initializes and starts the game.
 */
public class TicTacToe {

    /**
     * The main method to execute the Tic Tac Toe game with a GUI.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Board board = new Board(); //model
        TicTacToeView view = new TicTacToeView(); //view
        Player player1 = new Player('X'); //model
        Player player2 = new Player('O'); //model
        TicTacToeController controller = new TicTacToeController(board, view, player1, player2); //controller

        view.display();
    }
}