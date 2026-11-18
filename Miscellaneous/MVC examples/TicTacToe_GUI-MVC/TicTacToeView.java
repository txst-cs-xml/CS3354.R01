import javax.swing.*;
import java.awt.*;

public class TicTacToeView {
    private JFrame frame;
    private JButton[][] buttons;

    public TicTacToeView() {
        frame = new JFrame("Tic Tac Toe");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 3));

        buttons = new JButton[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 50));
                frame.add(buttons[i][j]);
            }
        }
    }

    public void display() {
        frame.setVisible(true);
    }

    public JButton getButton(int row, int col) {
        return buttons[row][col];
    }

    public void setButtonText(int row, int col, String text) {
        buttons[row][col].setText(text);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }

    public void close() {
        frame.dispose();
    }
}
