package w2.GUI;

import javax.swing.*;
import javax.swing.plaf.synth.Region;
import java.awt.*;

/**
 * Main frame of the Aqua theme.
 */

public class AquaFrame extends JFrame {

    public AquaFrame() {
        //region AquaFrame
        setTitle("Leon's and Alon's Aquarium Pro v13"); // set the title of the frame
        setResizable(false); // not resizable
        setSize(800, 600); //Set the size of the frame
        setVisible(true); //Make the frame visi ble
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On close exit the program
        setIconImage(new ImageIcon("src/w2/Assets/icon.ico").getImage()); //set the icon of the frame
        //endregion

        AquaBackground background = new AquaBackground(null); //create a new AquaBackground
        add(background); //add the background to the frame
        background.setLayout(new BorderLayout());

        //region MenuBar
        AquaMenu menu = new AquaMenu(background);
        menu.setVisible(true);
        setJMenuBar(menu);
    }
}
