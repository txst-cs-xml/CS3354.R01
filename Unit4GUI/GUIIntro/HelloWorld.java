import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HelloWorld {
    public static void main(String [] args) {
        JFrame frame = new JFrame("This is a frame");
        frame.getContentPane().setBackground(Color.BLUE);
        frame.setLayout(new FlowLayout());
        JButton button = new JButton("click me");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(frame, "Hello World");
                JDialog dialog = new JDialog(frame, "This is a dialog");
                JLabel label = new JLabel("Hello World!");
                label.setFont(new Font("Serif", Font.PLAIN, 40));
                dialog.add(label);
                dialog.setSize(200, 150);
                dialog.setLocationRelativeTo(frame);
                dialog.setVisible(true);
            }
        });
        frame.add(button);
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
