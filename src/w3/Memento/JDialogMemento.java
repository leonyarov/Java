package w3.Memento;

import w3.Creatures.Immobile;
import w3.Creatures.SeaCreature;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;

/**
 * Memento Dialog box for saved sessions,
   of SeaCreature instances within the aquarium.
 */

public class JDialogMemento  extends JDialog {

    HashSet<SeaCreature> seaCreatures;
    CareTaker careTaker;
    JLabel dateLabel;

    JList creatureList;

    public JDialogMemento(HashSet<SeaCreature> seaCreatures, CareTaker careTaker) {
        this.careTaker = careTaker;
        this.seaCreatures = seaCreatures;
        var panel = new JPanel();
        var buttonsSave = new JPanel();
        var datePanel = new JPanel();

        var restoreState = new JButton("Restore State");
        var saveStateBtn = new JButton("Save State");

        creatureList = new JList(seaCreatures.toArray());

        var stateLabel = new JLabel("Last Saved:");
        dateLabel = new JLabel("");
        datePanel.add(stateLabel);
        datePanel.add(dateLabel);
        datePanel.setLayout(new GridLayout(2,1,10,10));
        //Button actions
        saveStateBtn.addActionListener(e -> saveObjectState());
        restoreState.addActionListener(e -> restoreObjectState());
        creatureList.addListSelectionListener(e ->  getLastSavedDate());

        //State panel
        panel.add(creatureList);
        panel.add(datePanel);
        panel.setLayout(new GridLayout(0,2,10,10));
        //Buttons Panel
        buttonsSave.add(saveStateBtn);
        buttonsSave.add(restoreState);
        buttonsSave.setLayout(new GridLayout(1, 0,10,10));
        buttonsSave.setBorder(new EmptyBorder(10,10,10,10));

        //Add to dialog
        add(panel);
        add(buttonsSave, BorderLayout.SOUTH);

        pack();
    }

    private void getLastSavedDate() {
        var selected = (Originator)creatureList.getSelectedValue();
        if (selected == null) return;
        dateLabel.setText(careTaker.getLastTime(selected));
    }

    /**
     * Implement last Saved Instance
     */
    private void restoreObjectState() {
        var selected = (Originator)creatureList.getSelectedValue();
        if (selected == null) return;
        var memento = careTaker.get(selected);
        if (memento == null) return;
        selected.loadState(memento);
        getLastSavedDate();
    }

    /**
     * Preview of last saved instance`
     */
    private void saveObjectState() {
        var selected = (Originator)creatureList.getSelectedValue();
        if (selected == null) return;
        var memento = selected.saveState();
        careTaker.add(selected,memento);
        getLastSavedDate();
    }
}
