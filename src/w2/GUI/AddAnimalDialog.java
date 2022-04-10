package w2.GUI;

import w2.FishController.FishTank;

import javax.swing.*;
import javax.swing.colorchooser.ColorSelectionModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AddAnimalDialog extends JDialog {

    //params taken from buttons and sliders
    Color color = Color.BLACK;
    FishTank.AnimalType type;
    int size;
    int vspeed;
    int hspeed;



    public AddAnimalDialog(){
        setTitle("Add Animal");


        //Radio buttons choose animal type - fish, jellyfish, accompanied by label
        JLabel animalTypeLabel = new JLabel("Animal Type:");
        JPanel animalTypePanel = new JPanel();
        JRadioButton fish = new JRadioButton("Fish");
        JRadioButton jellyfish = new JRadioButton("Jellyfish");

        //slider choose size of animal clamp - 20, 320
        JLabel sizeLabel = new JLabel("Size:");
        JSlider size = new JSlider(20, 320, 20);
        size.setMajorTickSpacing(1);

        //slider choose vertical speed of animal clamp - 1, 10

        JLabel speedLabel = new JLabel("Vectical speed:");
        JSlider vspeed = new JSlider(1, 10, 1);

        //slider choose horizontal speed of animal clamp - 1, 10
        JLabel hspeedLabel = new JLabel("Horizontal speed:");
        JSlider hspeed = new JSlider(1, 10, 1);

        //Color picker
        JLabel colorLabel = new JLabel("Color:");
        JButton color = new JButton("Choose Color");

        color.addActionListener(e -> {
            Color col = JColorChooser.showDialog(this, "Choose Color", Color.BLACK);
            color.setBackground(col);
            this.color = col;
        });
        //add objects to dialog
        animalTypePanel.add(fish);
        animalTypePanel.add(jellyfish);

        add(animalTypeLabel);
        add(animalTypePanel);
        add(sizeLabel);
        add(size);
        add(speedLabel);
        add(vspeed);
        add(hspeedLabel);
        add(hspeed);

        add(colorLabel);
        add(color);

        //set grid layout
        setLayout(new GridLayout(0, 2));


        pack();
    }


}
