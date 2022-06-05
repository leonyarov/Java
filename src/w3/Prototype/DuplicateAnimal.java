package w3.Prototype;

import w3.Creatures.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.*;
import w3.Creatures.FishTank;
import w3.Factory.AnimalFactory;

/**
 * Duplicate Animal instance implemented using JDialog interface.
 */
public class DuplicateAnimal extends JDialog {
    JColorChooser color;
    JSlider CreatureSize;
    JSlider CreatureHorSpeed;
    JSlider CreatureVerSpeed;
    JList CreatureList;
    HashSet<SeaCreature> seaCreatures;
    public DuplicateAnimal(HashSet<SeaCreature> seaCreatures) {
        this.seaCreatures = seaCreatures;
        var CreaturePanel = new JPanel();
        CreatureList = new JList(seaCreatures.toArray());
        CreaturePanel.add(CreatureList);
        var DupAnimalBtn = new JButton("Clone");
        CreaturePanel.setLayout(new GridLayout(0, 1, 10, 10));
        add(CreaturePanel);
        add(DupAnimalBtn, BorderLayout.SOUTH);
        setVisible(true);
        pack();
        DupAnimalBtn.addActionListener(e -> {
            if(cloneObject() != null) {
                remove(CreaturePanel);
                remove(DupAnimalBtn);
                setVisible(false);
                cloneWindow(cloneObject());
            }
        });
    }

    public Swimmable cloneObject(){
        var selected = (Swimmable)CreatureList.getSelectedValue();
        Object MrClone = selected.clone();
        return (Swimmable)MrClone;
    }

    public void cloneWindow(Object cloneObj){
        var jPanel = new JPanel();
        JLabel sizeLabel = new JLabel("Size:");
        CreatureSize = new JSlider(20, 320);
        CreatureSize.setMajorTickSpacing(1);
        JLabel ver_speedLabel = new JLabel("Vertical speed:");
        CreatureVerSpeed = new JSlider(1, 10, 2);
        CreatureVerSpeed.setMajorTickSpacing(1);
        JLabel hor_speedLabel = new JLabel("Horizontal speed:");
        CreatureHorSpeed = new JSlider(1, 10, 2);
        CreatureHorSpeed.setMajorTickSpacing(1);
        /*JLabel colorLabel = new JLabel("Color:");
        JButton changeColorBtn = new JButton("Choose Color");*/
        JButton SubmitBtn = new JButton("Submit");
        jPanel.add(sizeLabel);
        jPanel.add(CreatureSize);
        jPanel.add(ver_speedLabel);
        jPanel.add(CreatureVerSpeed);
        jPanel.add(hor_speedLabel);
        jPanel.add(CreatureHorSpeed);
        add(SubmitBtn,BorderLayout.SOUTH);
        SubmitBtn.addActionListener(e->{
            if (cloneObj instanceof Fish) {
                var creature = new Fish(CreatureHorSpeed.getValue(),CreatureVerSpeed.getValue(),
                                        CreatureSize.getValue(), ((Fish) cloneObj).getmyColor(),
                                        ((Fish) cloneObj).hunger.gethungerTime());
                FishTank.getInstance().addCreature(creature);
            }
            if (cloneObj instanceof JellyFish){
                var creature = new JellyFish(CreatureHorSpeed.getValue(),CreatureVerSpeed.getValue(),
                                            CreatureSize.getValue(), ((Fish) cloneObj).getmyColor(),
                                            ((Fish) cloneObj).hunger.gethungerTime());
                FishTank.getInstance().addCreature(creature);
            }
            dispose();
        });
        jPanel.setLayout(new GridLayout(0, 1, 10, 10));
        add(jPanel);
        /*add(changeColorBtn, BorderLayout.EAST);*/
        setVisible(true);
        pack();

    }
}
