package w3.GUI;

import w3.FishController.Immobile;
import w3.FishController.SeaCreature;
import w3.FishController.Swimmable;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;

public class JDialogDecorator extends JDialog {
    JColorChooser color;

    public JDialogDecorator(HashSet<SeaCreature> seaCreatures) {
        var creaturePanel = new JPanel();
        var creatureList = new JList(seaCreatures.toArray());
        creatureList.setMinimumSize(new Dimension(100,200));
        color = new JColorChooser();
        creaturePanel.add(creatureList);
        creaturePanel.add(color);

        var changeColorBtn = new JButton("Change");
        changeColorBtn.addActionListener(e -> applyColor((SeaCreature) creatureList.getSelectedValue(),color.getColor()));
        creaturePanel.setLayout(new GridLayout(0,1));
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
