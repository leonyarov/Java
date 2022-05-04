package w2.GUI;

import w2.FishController.FishTank;
import javax.swing.*;
import java.awt.*;
import w2.GUI.FishTable;
/**
 * Button Storage
 */
public class AquaPanel extends JPanel {


    public static int totalEatCounter = 0;
    FishTable table;
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
        reset.addActionListener(e -> FishTank.getInstance().reset());
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



    public static boolean closed;
    public void infoTable(){
        FishTable table = new FishTable();
        table.setVisible(true);
    }
}
