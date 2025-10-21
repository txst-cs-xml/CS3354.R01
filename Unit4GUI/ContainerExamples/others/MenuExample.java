import javax.swing.*;

// JMenuBar, JMenu, and JMenuItem
// These components are used together to create a menu bar
public class MenuExample {
    public static void main(String[] args) {
        // Create a new frame
        JFrame frame = new JFrame("Menu Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a new menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create a menu
        JMenu fileMenu = new JMenu("File");
        //change fileMenu font size bigger
        fileMenu.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 30));

        // Create menu items
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem exitItem = new JMenuItem("Exit");

        //change menu item font size bigger
        newItem.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 30));
        openItem.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 30));
        exitItem.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 30));


        // Add menu items to menu
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.addSeparator(); // Separator
        fileMenu.add(exitItem);

        // Add menu to menu bar
        menuBar.add(fileMenu);

        // Set the menu bar for the frame
        frame.setJMenuBar(menuBar);

        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
