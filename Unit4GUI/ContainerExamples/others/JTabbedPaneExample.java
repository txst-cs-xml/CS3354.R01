import javax.swing.*;

// A JTabbedPane allows the user to switch between a group of components by clicking on a tab.
public class JTabbedPaneExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JTabbedPane Example");
        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Tab 1", new JLabel("Content for Tab 1"));
        tabbedPane.addTab("Tab 2", new JLabel("Content for Tab 2"));

        frame.add(tabbedPane);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

// In this script, a JTabbedPane is used to switch between two tabs, each containing a simple label.