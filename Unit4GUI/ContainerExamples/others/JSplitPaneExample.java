import javax.swing.*;

// A JSplitPane contains two components, 
// either side by side or one on top of the other, with a draggable divider.
public class JSplitPaneExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JSplitPane Example");
        JTextArea textArea1 = new JTextArea(20, 20);
        JTextArea textArea2 = new JTextArea(20, 20);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, textArea1, textArea2);

        frame.add(splitPane);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
// Here, two JTextArea components are put into a JSplitPane, and they are divided horizontally.

