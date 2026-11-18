import board.Board;
import player.Player;
import logging.GameLogging;
import java.io.IOException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/** Starts the MVC game with an optional logging threshold. */
public class TicTacToe {
    private static final Logger LOGGER = Logger.getLogger("tictactoe.Main");

    public static void main(String[] args) {
        Level level = Level.INFO;
        try {
            if (args.length > 1) {
                throw new IllegalArgumentException("Expected at most one level.");
            }
            if (args.length == 1) {
                level = Level.parse(args[0].toUpperCase(Locale.ROOT));
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Usage: java TicTacToe [LEVEL]");
            System.err.println("Levels: OFF, SEVERE, WARNING, INFO, CONFIG, FINE, FINER, FINEST, ALL");
            System.exit(1);
            return;
        }

        try {
            GameLogging.setup(level);
        } catch (IOException | SecurityException e) {
            System.err.println("Cannot create tictactoe_log.html: " + e.getMessage());
            System.exit(1);
            return;
        }
        Runtime.getRuntime().addShutdownHook(new Thread(GameLogging::close));
        System.out.println("Log level: " + level + "; HTML file: "
                + new java.io.File("tictactoe_log.html").getAbsolutePath());
        LOGGER.info("Application started.");
        LOGGER.config("Selected logging threshold: " + level);

        // Swing components must be created on the event dispatch thread.
        SwingUtilities.invokeLater(() -> {
            try {
                Board board = new Board();
                TicTacToeView view = new TicTacToeView();
                Player player1 = new Player('X');
                Player player2 = new Player('O');
                new TicTacToeController(board, view, player1, player2);
                view.display();
            } catch (RuntimeException e) {
                LOGGER.log(Level.SEVERE, "Unable to start the game.", e);
                GameLogging.close();
                System.exit(1);
            }
        });
    }
}
