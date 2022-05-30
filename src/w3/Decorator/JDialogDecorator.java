package w3.Decorator;

import w3.Creatures.Immobile;
import w3.Creatures.SeaCreature;
import w3.Creatures.Swimmable;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;

public class JDialogDecorator extends JDialog {
    JColorChooser color;

    public JDialogDecorator(HashSet<SeaCreature> seaCreatures) {
        var creaturePanel = new JPanel();
        var creatureList = new  JList(seaCreatures.toArray());
        color = new JColorChooser();
        creaturePanel.add(creatureList);
        creaturePanel.add(color);

        var changeColorBtn = new JButton("Change");
        changeColorBtn.addActionListener(e -> applyColor((SeaCreature) creatureList.getSelectedValue(),color.getColor()));
        creaturePanel.setLayout(new GridLayout(0,1, 10 ,10));
        add(creaturePanel);
        add(changeColorBtn, BorderLayout.SOUTH);
        setVisible(true);
        pack();
    }

    private void applyColor (SeaCreature creature, Color c){
        if (creature instanceof Immobile) return;
        ((Swimmable)creature).setColor(c);
    }
}
