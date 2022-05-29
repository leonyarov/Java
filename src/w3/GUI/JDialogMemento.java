package w3.GUI;

import w3.FishController.SeaCreature;

import javax.swing.*;
import java.util.HashSet;

public class JDialogMemento  extends JDialog {

    HashSet<SeaCreature> seaCreatures;

    public JDialogMemento(HashSet<SeaCreature> seaCreatures) {
        this.seaCreatures = seaCreatures;
        var panel = new JPanel();
        var buttons = new JPanel();

        var saveStateBtn = new JButton("Save State");
        var restoreState = new JButton("Restore State");

        var creatureList = new JList(seaCreatures.toArray());
        var stateLabel = new JLabel("Last Saved");
        panel.add(creatureList);
    }
}
