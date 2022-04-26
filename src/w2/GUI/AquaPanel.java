package w2.GUI;

import w2.FishController.AquaAnimal;
import w2.FishController.AquaFish;
import w2.FishController.FishTank;
import w2.GUI.InfoBox;
import w2.GUI.TableDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.*;

/**
 * Button Storage
 */
public class AquaPanel extends JPanel {


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
//        info.addActionListener(e -> TableDialog;

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


    private void addAnimal(){

        AddAnimalDialog dialog = new AddAnimalDialog();
        dialog.setVisible(true);
    }
}
