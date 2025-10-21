import javax.swing.*;

// A JScrollPane provides a scrollable view of a component.
public class JScrollPaneExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JScrollPane Example");
        JTextArea textArea = new JTextArea(20, 20);
        JScrollPane scrollPane = new JScrollPane(textArea);

        frame.add(scrollPane);
        frame.pack(); // all frame contents are at or above their preferred sizes.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
// In this example, a JTextArea is placed inside a JScrollPane, making the text area scrollable.