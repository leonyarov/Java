package w3.GUI;

import w3.Creatures.FishTank;
import javax.swing.*;
import java.awt.*;

/**
 * Main frame of the Aqua theme.
 */

public class AquaFrame extends JFrame {

    public AquaFrame() {

        //Aqua Frame
        setTitle("Leon's and Alon's Aquarium Pro v13"); // set the title of the frame
        setResizable(false); // not resizable
        setSize(800,600); //Set the size of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On close exit the program
        setIconImage(new ImageIcon("src/w3/Assets/icon.ico").getImage()); //set the icon of the frame
        setVisible(true); //Make the frame visible

        //Initialize aquarium to draw on
        AquaBackground background = new AquaBackground(); //create a new AquaBackground
        add(background,BorderLayout.CENTER); //add the background to the frame

        //Init aquarium thread
        Thread backgroundThread = new Thread(background); //create a new Thread for the background
        backgroundThread.start(); //start the background thread

        //Init Top tool bar
        AquaMenu menu = new AquaMenu(background);
        setJMenuBar(menu);

        //Add bottom buttons panel
        AquaPanel panel = new AquaPanel();
        add(panel, BorderLayout.PAGE_END);
    }

}
