package w2.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import w2.FishController.FishTank;


public class InfoBox extends JPanel {

    String[] columnName = { "Animal",
            "Color",
            "Size",
            "Hor.Speed",
            "Ver.Speed",
            "Eat counter"};

    private static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }




}

