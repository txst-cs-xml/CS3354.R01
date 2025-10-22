import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SimpleGameBoard {

    private static final int ROWS = 8;
    private static final int COLS = 8;
    private final JPanel[][] gameBoardSquares = new JPanel[ROWS][COLS];
    private JPanel selectedPiece = null;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SimpleGameBoard().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Simple Game Board with Multiple Pieces");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(ROWS, COLS));
        frame.setSize(500, 500);

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                JPanel panel = new JPanel();
                panel.setBackground((i + j) % 2 == 0 ? Color.LIGHT_GRAY : Color.WHITE);
                panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        handleMouseClick(panel);
                    }
                });
                gameBoardSquares[i][j] = panel;
                frame.add(panel);
            }
        }

        setupGamePieces();

        frame.pack();
        frame.setVisible(true);
    }

    private void setupGamePieces() {
        gameBoardSquares[0][0].setBackground(Color.GREEN);
        gameBoardSquares[0][1].setBackground(Color.BLUE);
        gameBoardSquares[0][2].setBackground(Color.RED);
    }

    private void handleMouseClick(JPanel clickedPanel) {
        Color background = clickedPanel.getBackground();
        if (selectedPiece == null) {
            if (background == Color.GREEN || background == Color.BLUE || background == Color.RED) {
                selectedPiece = clickedPanel;
                clickedPanel.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
            }
        } else {
            if (background == Color.LIGHT_GRAY || background == Color.WHITE) {
                clickedPanel.setBackground(selectedPiece.getBackground());
                int[] oldPosition = findPanelPosition(selectedPiece);
                selectedPiece.setBackground((oldPosition[0] + oldPosition[1]) % 2 == 0 ? Color.LIGHT_GRAY : Color.WHITE);
                selectedPiece.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                selectedPiece = null;
            }
        }
    }

    private int[] findPanelPosition(JPanel panel) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (gameBoardSquares[i][j] == panel) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1}; // Not found
    }
}
