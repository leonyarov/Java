package w3.GUI;

import w3.Creatures.Swimmable;
import w3.Decorator.JDialogDecorator;
import w3.Creatures.FishTank;
import w3.Memento.JDialogMemento;
import w3.Prototype.DuplicateAnimal;

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
        JButton addPlant = new JButton("Add Plant");
        JButton decorator = new JButton("Decorator");
        JButton wakeUp = new JButton("Wake Up");
        JButton food = new JButton("Food");
        JButton sleep = new JButton("Sleep");
        JButton memento = new JButton("Memento");
        info = new JButton("Info");
        JButton dupAnimal = new JButton(("Duplicate"));
        JButton exit = new JButton("Exit");
        JButton reset = new JButton("Reset");

        // action listener
        addAnimal.addActionListener(e -> addAnimal());
        exit.addActionListener(e -> System.exit(0));
        food.addActionListener(e -> FishTank.getInstance().feed());
        reset.addActionListener(e -> FishTank.getInstance().reset());
        sleep.addActionListener(e -> FishTank.getInstance().sleepAll());
        wakeUp.addActionListener(e -> FishTank.getInstance().wakeAll());
        addPlant.addActionListener(e -> addPlant());
        decorator.addActionListener(e -> showDecorator());
        memento.addActionListener(e -> showMemento());
        dupAnimal.addActionListener(e -> showDuplicator());
        info.addActionListener(this);
        // button placement order

        add(addAnimal);
        add(addPlant);
        add(sleep);
        add(wakeUp);
        add(reset);
        add(memento);
        add(food);
        add(info);
        add(dupAnimal);
        add(decorator);
        add(exit);

        setLayout(new GridLayout(2, 0));
    }

    private void showDuplicator(){
        var duplicator = new DuplicateAnimal();
    }

    private void showMemento() {
        var dialog = new JDialogMemento(FishTank.getInstance().seaCreatures, FishTank.getInstance().careTaker);
        dialog.setVisible(true);
    }

    private void showDecorator() {
        var decorator = new JDialogDecorator(FishTank.getInstance().seaCreatures);
    }

    private void addPlant() {
            var dialog = new AddPlantDialog();
            dialog.setVisible(true);
    }

    /**
     * Information table for FishTank
     * @param e Event performed on Info Button
     */
    public void actionPerformed(ActionEvent e) {
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
        AddAnimalDialog dialog = new AddAnimalDialog();
        dialog.setVisible(true);
    }
}

