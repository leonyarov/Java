package w3.Prototype;

import w3.Creatures.FishTank;
import w3.Creatures.Immobile;
import w3.Creatures.SeaCreature;
import w3.Creatures.Swimmable;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.*;

/**
 * Duplicate Animal instance implemented using JDialog interface.
 */
public class DuplicateAnimal extends JDialog {
    JColorChooser color;
    JSlider CreatureSize;
    JSlider CreatureHorSpeed;
    JSlider CreatureVerSpeed;

    public DuplicateAnimal(HashSet<SeaCreature> seaCreature) {
        var CreaturePanel = new JPanel();
        var CreatureList = new JList(seaCreature.toArray());
        CreaturePanel.add(CreatureList);
        var DupAnimalBtn = new JButton("Clone");
        JLabel sizeLabel = new JLabel("Size:");
        CreatureSize = new JSlider(20, 320);
        CreatureSize.setMajorTickSpacing(1);
        JLabel ver_speedLabel = new JLabel("Vertical speed:");
        CreatureVerSpeed = new JSlider(1, 10, 2);
        CreatureVerSpeed.setMajorTickSpacing(1);
        JLabel hor_speedLabel = new JLabel("Horizontal speed:");
        CreatureHorSpeed = new JSlider(1, 10, 2);
        CreatureHorSpeed.setMajorTickSpacing(1);
        JLabel colorLabel = new JLabel("Color:");
        JButton changeColorBtn = new JButton("Choose Color");
        CreaturePanel.add(sizeLabel);
        CreaturePanel.add(CreatureSize);
        CreaturePanel.add(ver_speedLabel);
        CreaturePanel.add(CreatureVerSpeed);
        CreaturePanel.add(hor_speedLabel);
        CreaturePanel.add(CreatureHorSpeed);


        CreaturePanel.setLayout(new GridLayout(0, 1, 10, 10));
        add(CreaturePanel);
        add(changeColorBtn, BorderLayout.EAST);
        add(DupAnimalBtn, BorderLayout.SOUTH);
        setVisible(true);
        pack();

    }
}
