package w2.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.nio.file.Paths;

/**
 * Top menu toolbar
 */
public class AquaMenu extends JMenuBar {
    JFrame f;
    AquaBackground aquaBackground;
    public AquaMenu(AquaBackground aquaBackground) {
        this.aquaBackground = aquaBackground;
        JMenu file = new JMenu("File");
        JMenu background = new JMenu("Background");
        JMenu help = new JMenu("Help");

        JMenuItem exit =                new JMenuItem("Exit");

        //background menu items - Select from file, select from gallery, select color, select none
        JMenuItem selectFromFile =      new JMenuItem("Image");
        JMenuItem selectBlue =          new JMenuItem("Blue");
        JMenuItem selectNone =          new JMenuItem("None");

        //Help Dialog
        JMenuItem helpItem =            new JMenuItem("Help");

        //Set menu button action
        exit.addActionListener(e -> closeWindow());
        selectFromFile.addActionListener(e -> selectFromFile());
        selectNone.addActionListener(e -> removeBackround());
        selectBlue.addActionListener(e -> setBackgroundColor(Color.BLUE));
//        selectDefault.addActionListener(e -> setBackgroundImage());
        //TODO: Add action for help
        helpItem.addActionListener(e -> helpBox());



        //add menu items to file menu
        file.add(exit);

        //add menu items to background menu
        background.add(selectFromFile);
        background.add(selectBlue); //wtf man we can do better lmao
        background.add(selectNone);


        //add menu items to help menu
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
        JFileChooser fileChooser = new JFileChooser(Paths.get("").toAbsolutePath().toString());
        var result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            //get file path
            var file = fileChooser.getSelectedFile();
            setBackgroundImage(file);
        }
    }

//    /**
//     * Select color from color picker
//     */
//    public void selectColor() {
//        //Open color picker
//        Color color = JColorChooser.showDialog(null, "Choose Background Color", Color.BLACK);
//        //set color to main panel
//        setBackgroundColor(color);
//    }

    private void setBackgroundColor(Color color) {
        aquaBackground.setColor(color);
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


    public void helpBox(){
        JOptionPane.showMessageDialog(f, "Home Work 3\nGUI @ Threads");
    }

}
