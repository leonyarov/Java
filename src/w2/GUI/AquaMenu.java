package w2.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Top menu toolbar
 */
public class AquaMenu extends JMenuBar {

    AquaBackground aquaBackground;
    public AquaMenu(AquaBackground aquaBackground) {
        this.aquaBackground = aquaBackground;
        JMenu file = new JMenu("File");
        JMenu background = new JMenu("Background");
        JMenu help = new JMenu("Help");

        JMenuItem exit =                new JMenuItem("Exit");

        //background menu items - Select from file, select from gallery, select color, select none
        JMenuItem selectFromFile =      new JMenuItem("Select from file");
        JMenuItem selectColor =         new JMenuItem("Single Color");
        JMenuItem selectNone =          new JMenuItem("None");

        //Help menu items - About, Help
        JMenuItem about =               new JMenuItem("About");
        JMenuItem helpItem =            new JMenuItem("Help");

        //Set menu button action
        exit.addActionListener(e -> closeWindow());
        selectFromFile.addActionListener(e -> selectFromFile());
        selectColor.addActionListener(e -> selectColor());
        selectNone.addActionListener(e -> removeBackround());
        //TODO: Add action for about and help
        about.addActionListener(e -> System.out.println("About"));
        helpItem.addActionListener(e -> System.out.println("Help"));



        //add menu items to file menu
        file.add(exit);

        //add menu items to background menu
        background.add(selectFromFile);
        background.add(selectColor);
        background.add(selectNone);

        //add menu items to help menu
        help.add(about);
        help.add(helpItem);

        //add menus to menu bar
        this.add(file);
        this.add(background);
        this.add(help);

    }

    /**
     * Exits the program
     */
    public void closeWindow() {
        System.exit(0);
    }

    /**
     * Select image on pc
     */
    public void selectFromFile() {
        //Open dialog to select image from file
        JFileChooser fileChooser = new JFileChooser();
        var result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            //get file path
            var file = fileChooser.getSelectedFile();
            setBackgroundImage(file);
        }
    }

    /**
     * Select color from color picker
     */
    public void selectColor() {
        //Open color picker
        Color color = JColorChooser.showDialog(null, "Choose Background Color", Color.BLACK);
        //set color to main panel
        setBackgroundColor(color);
    }

    private void setBackgroundColor(Color color) {
        aquaBackground.setImage(null);
        this.getRootPane().getContentPane().setBackground(color);
    }

    private void setBackgroundImage(File file) {
        //create image from path
        try {
            var img = ImageIO.read(file);
            aquaBackground.setImage(img);
            aquaBackground.repaint();

        }
        catch (Exception e) {
            System.out.println("Error loading image");
        }
    }

    private void removeBackround() {
     setBackgroundColor(Color.WHITE);
    }


}
