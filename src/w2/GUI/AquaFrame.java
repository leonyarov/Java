package w2.GUI;

import w2.FishController.FishTank;
import javax.swing.*;
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
        setVisible(true); //Make the frame visible
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On close exit the program
        setIconImage(new ImageIcon("src/w2/Assets/icon.ico").getImage()); //set the icon of the frame
        //endregion

        FishTank tank = new FishTank(); //create a new FishTank
        AquaBackground background = new AquaBackground(); //create a new AquaBackground

        add(background,BorderLayout.CENTER); //add the background to the frame

        Thread backgroundThread = new Thread(background); //create a new Thread for the background
        backgroundThread.start(); //start the background thread

        AquaMenu menu = new AquaMenu(background);
        menu.setVisible(true);
        setJMenuBar(menu);


        //Add bottom panel buttons
        AquaPanel panel = new AquaPanel();
        add(panel, BorderLayout.SOUTH);
    }

}
