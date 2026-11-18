package player;

/**
 * Represents a player in the Tic Tac Toe game.
 */
public class Player {
    private char symbol;

    /**
     * Initializes a player with the specified symbol.
     *
     * @param symbol The symbol representing the player ('X' or 'O').
     */
    public Player(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Returns the symbol representing the player.
     *
     * @return The player's symbol.
     */
    public char getSymbol() {
        return symbol;
    }
}