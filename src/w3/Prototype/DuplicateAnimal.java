package w3.Prototype;

import w3.Creatures.SeaCreature;

import java.awt.*;
import java.util.HashSet;
import javax.swing.*;

public class DuplicateAnimal extends JDialog {

    public DuplicateAnimal(HashSet<SeaCreature> seaCreature){
        var CreaturePanel = new JPanel();
        var CreatureList = new JList(seaCreature.toArray());

        CreaturePanel.add(CreatureList);

        var DupAnimalBtn = new JButton("Clone");
        DupAnimalBtn.addActionListener(e -> dupAnimal((SeaCreature) CreatureList.getSelectedValue()));
        CreaturePanel.setLayout(new GridLayout(0,1, 10 ,10));
        add(CreaturePanel);
        add(DupAnimalBtn, BorderLayout.SOUTH);
        setVisible(true);
        pack();

    }

    private void dupAnimal(SeaCreature seaCreature){

    }
}
