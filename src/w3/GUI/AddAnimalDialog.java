package w3.GUI;

import w3.Factory.AnimalFactory;
import w3.Creatures.FishTank;

import javax.swing.*;
import java.awt.*;

/**
 * Adding an AquaticAnimal instance to the FishTank through a Dialog Box
 */

public class AddAnimalDialog extends JDialog {

    //params taken from buttons and sliders
    String type;
    Icon image = null;

    public Color color = Color.WHITE;
    public JSlider vspeed;
    public JSlider hspeed;
    public JSlider size;

    public AddAnimalDialog(){
        setTitle("Add Animal");


        //Radio buttons choose animal type - fish, jellyfish, accompanied by label
        JPanel propertiesPanel = new JPanel();

        JLabel animalTypeLabel = new JLabel("Animal Type:");
        JPanel animalTypePanel = new JPanel();
        ButtonGroup animalTypeGroup = new ButtonGroup(); //group of radio buttons
        JRadioButton fish = new JRadioButton("Fish", true);
        JRadioButton jellyfish = new JRadioButton("Jellyfish");

        //Add buttons to group
        animalTypeGroup.add(fish);
        animalTypeGroup.add(jellyfish);

        //slider choose size of animal clamp - 20, 320
        JLabel sizeLabel = new JLabel("Size:");
        size = new JSlider(20, 320, 50);
        size.setMajorTickSpacing(1);

        //slider choose vertical speed of animal clamp - 1, 10

        JLabel speedLabel = new JLabel("Vertical speed:");
        vspeed = new JSlider(1, 10, 2);

        //slider choose horizontal speed of animal clamp - 1, 10
        JLabel hspeedLabel = new JLabel("Horizontal speed:");
        hspeed = new JSlider(1, 10, 2);

        //Color picker
        JLabel colorLabel = new JLabel("Color:");
        JButton color = new JButton("Choose Color");

        //Choose fish image
        JLabel imageLabel = new JLabel("Image:");
        JButton image = new JButton("Choose Image");


        JPanel buttonPanel = new JPanel();
        JButton createNew = new JButton("Create New");
        JButton cancel = new JButton("Cancel");

        color.addActionListener(e -> {
            Color col = JColorChooser.showDialog(this, "Choose Color", Color.BLACK);
            color.setBackground(col);
            this.color = col;
        });

        createNew.addActionListener(e -> {
                type = fish.isSelected() ? "Fish" : "JellyFish";
                var factory = new AnimalFactory(this);
                var creature = factory.produceSeaCreature(type);
                FishTank.getInstance().addCreature(creature);
        });


        cancel.addActionListener(e -> { this.dispose(); });

        //add objects to dialog
        animalTypePanel.add(fish);
        animalTypePanel.add(jellyfish);

        //Add to properties panel
        propertiesPanel.add(animalTypeLabel);
        propertiesPanel.add(animalTypePanel);
        propertiesPanel.add(sizeLabel);
        propertiesPanel.add(size);
        propertiesPanel.add(speedLabel);
        propertiesPanel.add(vspeed);
        propertiesPanel.add(hspeedLabel);
        propertiesPanel.add(hspeed);
        propertiesPanel.add(colorLabel);
        propertiesPanel.add(color);

        //set grid layout
        propertiesPanel.setLayout(new GridLayout(0, 2));
        propertiesPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        buttonPanel.add(createNew);
        buttonPanel.add(cancel);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,20));

        add(propertiesPanel);
        add(buttonPanel);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));


        pack();
    }


}
