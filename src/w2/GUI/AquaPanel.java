package w2.GUI;

import w2.FishController.FishTank;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Button Storage
 */
public class AquaPanel extends JPanel {


    public AquaPanel() {

        //Add Buttons to panel
        JButton addAnimal = new JButton("Add Animal");
        JButton wakeUp = new JButton("Wake Up");
        JButton feed = new JButton("Feed");
        JButton sleep = new JButton("Sleep");
        JButton info = new JButton("Info");
        JButton exit = new JButton("Exit");

        addAnimal.addActionListener(e -> addAnimal());
        exit.addActionListener(e -> System.exit(0));

        add(addAnimal);
        add(wakeUp);
        add(feed);
        add(sleep);
        add(info);
        add(exit);

        setLayout(new GridLayout(1, 0));
    }


    private void addAnimal(){

        AddAnimalDialog dialog = new AddAnimalDialog();
        dialog.setVisible(true);


    }



}
