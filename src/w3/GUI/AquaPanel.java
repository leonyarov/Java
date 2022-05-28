package w3.GUI;

import w3.FishController.FishTank;
import w3.FishController.Immobile;
import w3.FishController.Swimmable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Observable;
import w3.GUI.Observer;


/**
 * Button Storage
 */
public class AquaPanel extends JPanel implements ActionListener, Observer {

    public static int totalEatCounter = 0;
    FishTable table;
    DuplicateAnimal duplicateAnimal;
    /*FishTable dupTable;*/
    private JButton info;
    private JButton dupAnimal;
    private int infoClicks = 0;
   /* private int dupClicks = 0;*/
    public static HashMap<Swimmable,Integer> swimmable = new HashMap<>();
    public static HashSet<Immobile> immobile = new HashSet<>();
    public static int ID = 0;
    public AquaPanel() {

        //Add Buttons to panel
        JButton addAnimal = new JButton("Add Animal");
        JButton wakeUp = new JButton("Wake Up");
        JButton food = new JButton("Food");
        JButton sleep = new JButton("Sleep");
        info = new JButton("Info");
        dupAnimal = new JButton(("Duplicate Animal"));
        JButton exit = new JButton("Exit");
        JButton reset = new JButton("Reset");

        // action listener
        addAnimal.addActionListener(e -> addAnimal());
        exit.addActionListener(e -> System.exit(0));
        food.addActionListener(e -> FishTank.getInstance().feed());
        reset.addActionListener(e -> FishTank.getInstance().reset());
        sleep.addActionListener(e -> FishTank.getInstance().sleepAll());
        wakeUp.addActionListener(e -> FishTank.getInstance().wakeAll());
        /*dupAnimal.addActionListener(this);*/
        info.addActionListener(this);
        // button placement order
        add(addAnimal);
        add(sleep);
        add(wakeUp);
        add(reset);
        add(food);
        add(info);
        add(dupAnimal);
        add(exit);

        setLayout(new GridLayout(1, 0));
    }

    /**
     * Information table for FishTank
     * @param e Event performed on Info Button
     */
    public void actionPerformed(ActionEvent e) {
        /*if (e.getSource() == dupAnimal) {
            dupClicks++;
            if (dupClicks % 2 == 0) {
                duplicateAnimal.setVisibility(2);
                duplicateAnimal = null;
                return;
            } else {
                duplicateAnimal = new DuplicateAnimal();
                duplicateAnimal.setVisibility(1);
            }
        }*/
        if (e.getSource() == info) {
            infoClicks++;
            if (infoClicks % 2 == 0) {
                table.setVisible(false);
                table = null;
                return;
            } else {
                table = new FishTable();
                table.setVisible(true);
            }
        }
    }

    /**
     * AquaticAnimal EatCounter Update after worm consumption
     */
    public static void eatInc() {
        totalEatCounter++;
    }

    /**
     * AquaticAnimal addition to FishTank visual
     */
    private void addAnimal() {
        if (FishTank.fishes.size() < 5) {
            AddAnimalDialog dialog = new AddAnimalDialog();
            dialog.setVisible(true);
        }
    }
    @Override
    public void update() {
        JOptionPane.showMessageDialog(null, "Feed us ohh great one!",
                "Sustenance now!", JOptionPane.PLAIN_MESSAGE);
    }
}

