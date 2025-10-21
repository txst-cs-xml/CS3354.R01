import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class JMenuItemExample {
    public static void main(String[] args) {
        // Create a JFrame instance
        JFrame frame = new JFrame("JMenuItem Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a menu bar to hold our menu
        JMenuBar menuBar = new JMenuBar();

        // Create a menu to add to our menu bar
        JMenu fileMenu = new JMenu("File");

        // Create a menu item to add to our menu
        JMenuItem openItem = new JMenuItem("Open");

        // Add an action listener to our menu item
        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a file chooser
                JFileChooser fileChooser = new JFileChooser();

                // Show the file chooser dialog and capture the user's selection
                int option = fileChooser.showOpenDialog(frame);

                // If the user clicks the "Open" button, get the selected file
                if(option == JFileChooser.APPROVE_OPTION){
                    File selectedFile = fileChooser.getSelectedFile();
                    // Print out the selected file path to the console (or do something else with it)
                    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                }
            }
        });

        // Add the menu item to the menu
        fileMenu.add(openItem);

        // Add the menu to the menu bar
        menuBar.add(fileMenu);

        // Set the menu bar for the frame
        frame.setJMenuBar(menuBar);

        // Set the size of the frame
        frame.setSize(400, 300);

        // Center and show the frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
