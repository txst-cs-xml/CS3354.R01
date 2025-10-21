import javax.swing.JDialog;

public class SimpleJDialog {
    public static void main(String[] args) {
        JDialog dialog = new JDialog(); // Create a dialog
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // Set default close operation
        dialog.setSize(300, 200); // Set the size of the dialog
        dialog.setVisible(true); // Make the dialog visible
    }
}


