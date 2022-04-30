package w2.GUI;

import w2.FishController.AquaAnimal;
import w2.FishController.AquaFish;
import w2.FishController.FishTank;
import w2.GUI.InfoBox;
import w2.GUI.TableDialog;
import java.awt.event.WindowEvent;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.Frame;
import javax.swing.JFrame;


import java.util.*;


/**
 * Button Storage
 */
public class AquaPanel extends JPanel {


    public static int totalEatCounter = 0;
    public AquaPanel() {

        //Add Buttons to panel
        JButton addAnimal = new JButton("Add Animal");
        JButton wakeUp = new JButton("Wake Up");
        JButton food = new JButton("Food");
        JButton sleep = new JButton("Sleep");
        JButton info = new JButton("Info");
        JButton exit = new JButton("Exit");
        JButton reset = new JButton("Reset");

        // action listener
        addAnimal.addActionListener(e -> addAnimal());
        exit.addActionListener(e -> System.exit(0));
        food.addActionListener(e -> FishTank.getInstance().feed());
        reset.addActionListener(e -> FishTank.fishes.clear());
        sleep.addActionListener(e -> FishTank.getInstance().sleepAll());
        wakeUp.addActionListener(e -> FishTank.getInstance().wakeAll());
        info.addActionListener(e -> infoTable());

        // button placement order
        add(addAnimal);
        add(sleep);
        add(wakeUp);
        add(reset);
        add(food);
        add(info);
        add(exit);

        setLayout(new GridLayout(1, 0));
    }

    public static void eatInc(){
        totalEatCounter++;
    }
    private void addAnimal(){

        AddAnimalDialog dialog = new AddAnimalDialog();
        dialog.setVisible(true);
    }



    // needs work not finished
    JFrame infoFrame = new JFrame("FishTank Information");
    WindowListener listener = new WindowAdapter() {
        public void windowClosing(WindowEvent evt) {
            closed = false;
        }
    };

    boolean closed;
    public void infoTable(){
        if (!closed) {
            DefaultTableModel tableModel = new DefaultTableModel();
            JTable table = new JTable(tableModel);
            tableModel.addColumn("Animal");
            tableModel.addColumn("Color");
            tableModel.addColumn("Hor.Speed");
            tableModel.addColumn("Ver.Speed");
            tableModel.addColumn("Eat counter");
            infoFrame.setSize(550, 350);
            infoFrame.add(new JScrollPane(table));
            infoFrame.setVisible(true);
            closed = true;
        }
        else {
            infoFrame.setVisible(false);
            closed = false;
        }

    }
}
