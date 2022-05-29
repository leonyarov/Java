package w3.Memento;

import w3.Creatures.SeaCreature;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.HashSet;

public class JDialogMemento  extends JDialog {

    HashSet<SeaCreature> seaCreatures;
    CareTaker careTaker;
    JLabel dateLabel;

    JList creatureList;
    public JDialogMemento(HashSet<SeaCreature> seaCreatures, CareTaker careTaker) {
        this.careTaker = careTaker;
        this.seaCreatures = seaCreatures;
        var panel = new JPanel();
        var buttons = new JPanel();
        var datePanel = new JPanel();

        var restoreState = new JButton("Restore State");
        var saveStateBtn = new JButton("Save State");

        creatureList = new JList(seaCreatures.toArray());
        var stateLabel = new JLabel("Last Saved:");
        dateLabel = new JLabel("");

        //Button actions
        saveStateBtn.addActionListener(e -> saveObjectState());
        restoreState.addActionListener(e -> restoreObjectState());
        creatureList.addListSelectionListener(e ->  getLastSavedDate());

        //Date panel
        datePanel.add(stateLabel);
        datePanel.add(dateLabel);
        datePanel.setLayout(new GridLayout(0,1, 5,5));
        //State panel
        panel.add(creatureList);
        panel.add(datePanel);
        panel.setLayout(new GridLayout(0,2,10,10));
        //Buttons Panel
        buttons.add(saveStateBtn);
        buttons.add(restoreState);
        buttons.setLayout(new GridLayout(1, 0,10,10));
        buttons.setBorder(new EmptyBorder(10,10,10,10));
        //Add to dialog
        add(panel);
        add(buttons, BorderLayout.SOUTH);

        pack();
    }

    private void getLastSavedDate() {
        var selected = creatureList.getSelectedIndex();
        if (selected == -1) return;

        if (selected >= careTaker.mementoList.size()){
            dateLabel.setText("No state saved!");
            return;
        }
        var text = careTaker.get(selected).time;
        dateLabel.setText(text.toString());
    }

    private void restoreObjectState() {
        var selected = (Originator)creatureList.getSelectedValue();
        if (selected == null) return;
        var index = creatureList.getSelectedIndex();
        if (index >= careTaker.mementoList.size()) return;
        var memento = careTaker.get(index);
        selected.loadState(memento);
    }

    private void saveObjectState() {
        var selected = (Originator)creatureList.getSelectedValue();
        if (selected == null) return;
        var memento = selected.saveState();
        careTaker.add(memento, creatureList.getSelectedIndex());
        getLastSavedDate();
    }
}
