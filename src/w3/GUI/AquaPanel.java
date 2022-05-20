package w3.GUI;

import w3.FishController.FishTank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Button Storage
 */
public class AquaPanel extends JPanel implements ActionListener {

    public static int totalEatCounter = 0;
    FishTable table;
    private JButton info;
    private int infoClicks = 0;

    public AquaPanel() {

        //Add Buttons to panel
        JButton addAnimal = new JButton("Add Animal");
        JButton wakeUp = new JButton("Wake Up");
        JButton food = new JButton("Food");
        JButton sleep = new JButton("Sleep");
        info = new JButton("Info");
        JButton exit = new JButton("Exit");
        JButton reset = new JButton("Reset");

        // action listener
        addAnimal.addActionListener(e -> addAnimal());
        exit.addActionListener(e -> System.exit(0));
        food.addActionListener(e -> FishTank.getInstance().feed());
        reset.addActionListener(e -> FishTank.getInstance().reset());
        sleep.addActionListener(e -> FishTank.getInstance().sleepAll());
        wakeUp.addActionListener(e -> FishTank.getInstance().wakeAll());
        info.addActionListener(this);
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

    /**
     * Information table for FishTank
     * @param e Event performed on Info Button
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == info) {
            infoClicks++;
        } else {
            infoClicks--;
        }
        if (infoClicks % 2 == 0) {
            table.setVisible(false);
            table = null;
            return;
        } else {
            table = new FishTable();
            table.setVisible(true);
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
}

