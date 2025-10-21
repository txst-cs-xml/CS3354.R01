import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MiniTextEditor {

    private JFrame frame;
    private JTextArea textArea;
    private JFileChooser fileChooser;
    private JComboBox<String> fontSizeComboBox;
    private JSlider slider;
    private JList<String> fontList;
    private JTextField textField;
    private JColorChooser colorChooser;
    private ButtonGroup textStyleGroup;
    private JCheckBox underlineCheckBox;
    private JCheckBox strikeThroughCheckBox;

    public MiniTextEditor() {
        frame = new JFrame("Mini Text Editor");

        // Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);


        fileChooser = new JFileChooser();
        JButton openButton = new JButton("Open File");
        JButton saveButton = new JButton("Save File");
        JButton colorButton = new JButton("Choose Text Color");

        String[] fontSizes = {"12", "14", "16", "18", "20"};
        fontSizeComboBox = new JComboBox<>(fontSizes);

        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        fontList = new JList<>(fonts);
        fontList.setVisibleRowCount(5);
        fontList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        slider = new JSlider(10, 50, 20);
        textField = new JTextField(15);

        colorChooser = new JColorChooser();

        // Radio Buttons for Text Style
        JRadioButton plainRadioButton = new JRadioButton("Plain", true);
        JRadioButton boldRadioButton = new JRadioButton("Bold");
        JRadioButton italicRadioButton = new JRadioButton("Italic");
        textStyleGroup = new ButtonGroup();
        textStyleGroup.add(plainRadioButton);
        textStyleGroup.add(boldRadioButton);
        textStyleGroup.add(italicRadioButton);

        // Checkboxes for Underline and StrikeThrough
        underlineCheckBox = new JCheckBox("Underline");
        strikeThroughCheckBox = new JCheckBox("StrikeThrough");

        // Adding listeners
        openButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int returnVal = fileChooser.showOpenDialog(frame);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try {
                        textArea.read(new FileReader(file.getAbsolutePath()), null);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int returnVal = fileChooser.showSaveDialog(frame);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try {
                        FileWriter writer = new FileWriter(file);
                        textArea.write(writer);
                        writer.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        colorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Color newColor = colorChooser.showDialog(frame, "Choose Text Color", textArea.getForeground());
                if (newColor != null) {
                    textArea.setForeground(newColor);
                }
            }
        });


        // Layout and adding components to the frame
        frame.setLayout(new FlowLayout());
        frame.add(new JScrollPane(textArea));
        frame.add(openButton);
        frame.add(saveButton);
        frame.add(colorButton);
        frame.add(new JLabel("Font Size: "));
        frame.add(fontSizeComboBox);
        frame.add(new JLabel("Select Font: "));
        frame.add(new JScrollPane(fontList));
        frame.add(new JLabel("Zoom: "));
        frame.add(slider);
        frame.add(new JLabel("Enter Text: "));
        frame.add(textField);
        frame.add(plainRadioButton);
        frame.add(boldRadioButton);
        frame.add(italicRadioButton);
        frame.add(underlineCheckBox);
        frame.add(strikeThroughCheckBox);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MiniTextEditor();
            }
        });
    }
}
