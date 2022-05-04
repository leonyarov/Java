package w2.GUI;

import w2.FishController.FishTank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
        info.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                infoTable(e);
            }});

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



    public void infoTable(MouseEvent e){
        if (e.getClickCount() == 2){
            table.setVisible(false);
            table = null;
            return;
        }
        table = new FishTable();
        table.setVisible(true);
    }
}
