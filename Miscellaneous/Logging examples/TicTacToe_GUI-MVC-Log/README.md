# Tic Tac Toe: MVC logging example

Requires a JDK (Java 8 or newer) and a graphical desktop. No external libraries are needed: this example uses `java.util.logging`.

From this folder, compile and run:

```sh
javac TicTacToe.java TicTacToeController.java TicTacToeView.java board/Board.java player/Player.java logging/*.java
java TicTacToe
java TicTacToe FINE
java TicTacToe ALL
java TicTacToe WARNING
java TicTacToe OFF
```

Run one command at a time. The default is INFO; level names are case-insensitive. In an IDE, put the level (for example `FINE`) in the program arguments for `TicTacToe`.

The output is `tictactoe_log.html` in the working directory (the absolute path is printed at startup). Each run replaces the previous log. Close the game and open this file in a browser; closing the handler completes the HTML document. OFF records no messages, so the file may be empty. Avoid simultaneous runs when comparing files; Java's FileHandler may add a suffix when a file is already locked.

## Levels to demonstrate

A threshold includes that level and all more severe levels. FINE therefore includes FINE, CONFIG, INFO, WARNING, and SEVERE, but excludes FINER and FINEST.

| Level | Example in this game |
| --- | --- |
| SEVERE | Startup failure, including an exception stack trace |
| WARNING | Clicking an already occupied cell |
| INFO | Startup, moves, winner/draw, window closing |
| CONFIG | Selected threshold, board creation, button listener setup |
| FINE | Window display and player turn changes |
| FINER | Controller button clicks and view button updates |
| FINEST | Move validation and full board contents |
| ALL | Includes every level |
| OFF | Disables logging |

Try a game at INFO, click an occupied cell, then finish a winning game. Open the HTML file. Repeat at FINEST to see the extra details, then WARNING to see only rejected moves (unless a real severe failure occurs). Board coordinates in logs are zero-based. SEVERE is reserved for actual failures; a normal game does not manufacture errors.

## How it fits MVC

- `board/Board.java` logs model state and moves.
- `TicTacToeView.java` logs display updates and window lifecycle.
- `TicTacToeController.java` logs input handling, rejected moves, turn changes, and results.
- `TicTacToe.java` reads the command-line level and configures logging before creating MVC objects.
- `logging/GameLogging.java` configures the shared `tictactoe` parent logger and FileHandler. Child loggers inherit the selected level. The handler accepts ALL so it does not silently discard fine-level records.
- `logging/HTMLFormatter.java` renders records as table rows with time, severity, component, message, and exception. It escapes HTML characters and preserves complete stack traces.

The formatter controls presentation; the logger controls severity filtering; the handler sends accepted records to the file. A Supplier in the board's FINEST logging defers building the board string until that level is enabled. No logging configuration is needed in the Player value object.
