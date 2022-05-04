package w2.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import w2.FishController.FishTank;


public class InfoBox extends JPanel {


    /**
     * Show message box with given strings
     * @param infoMessage It's not about the money, it's about sending a message
     * @param titleBar The title of the message box
     */
    public static void show(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }




}

