package board;

import player.Player;

/**
 * Represents the Tic Tac Toe board. This class manages the board state and game rules.
 */
public class Board {
    private char[][] grid;
    private final int SIZE = 3;

    /**
     * Initializes an empty Tic Tac Toe board.
     */
    public Board() {
        grid = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = '-';
            }
        }
    }

    /**
     * Displays the current state of the board to the console.
     */
    public void display() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Checks if the specified move is valid.
     *
     * @param row The row of the move.
     * @param col The column of the move.
     * @return true if the move is valid, false otherwise.
     */
    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && grid[row][col] == '-';
    }

    /**
     * Makes a move on the board for the specified player.
     *
     * @param row The row of the move.
     * @param col The column of the move.
     * @param player The player making the move.
     */
    public void makeMove(int row, int col, Player player) {
        grid[row][col] = player.getSymbol();
    }

/**
     * Checks if the game is over either due to a win or a draw.
     *
     * @return true if the game is over, false otherwise.
     */
    public boolean isGameOver() {
        return hasWinner() || isDraw();
    }

    /**
     * Determines if there is a winning line on the board (row, column, or diagonal).
     *
     * @return true if there is a winner, false otherwise.
     */
    public boolean hasWinner() {
        for (int i = 0; i < SIZE; i++) {
            if (grid[i][0] != '-' && grid[i][0] == grid[i][1] && grid[i][0] == grid[i][2]) {
                return true;
            }
            if (grid[0][i] != '-' && grid[0][i] == grid[1][i] && grid[0][i] == grid[2][i]) {
                return true;
            }
        }
        if (grid[0][0] != '-' && grid[0][0] == grid[1][1] && grid[0][0] == grid[2][2]) {
            return true;
        }
        if (grid[0][2] != '-' && grid[0][2] == grid[1][1] && grid[0][2] == grid[2][0]) {
            return true;
        }
        return false;
    }

    /**
     * Determines if the board is fully occupied without any winning line, resulting in a draw.
     *
     * @return true if the game is a draw, false otherwise.
     */
    public boolean isDraw() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}