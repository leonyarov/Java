package w3.Prototype;

import w3.Creatures.*;

import java.awt.*;
import java.util.HashSet;
import java.util.stream.Collectors;
import javax.swing.*;
import w3.Creatures.FishTank;

/**
 * Duplicate Animal instance implemented using JDialog interface.
 */
public class DuplicateAnimal extends JDialog {
    JColorChooser color;
    JSlider CreatureSize;
    JSlider CreatureHorSpeed;
    JSlider CreatureVerSpeed;
    JList CreatureList;
    JButton SubmitBtn;
    JButton changeColorBtn;
    Swimmable duplicatedCreature = null;

    public DuplicateAnimal( ) {

        var dlm = new DefaultListModel<>();
        dlm.addAll(FishTank.getInstance().seaCreatures);

        var CreaturePanel = new JPanel();
        CreatureList = new JList(dlm);
        CreaturePanel.add(CreatureList);
        var DupAnimalBtn = new JButton("Clone");
        CreaturePanel.setLayout(new GridLayout(0, 1, 10, 10));
        CreaturePanel.add(DupAnimalBtn, BorderLayout.SOUTH);
        DupAnimalBtn.addActionListener(e -> duplicateCreature());


        var clonePropsPanel = new JPanel();
        JLabel sizeLabel = new JLabel("Size:");
        CreatureSize = new JSlider(20, 320);
        CreatureSize.setMajorTickSpacing(320/10);
        CreatureSize.setPaintTicks(true);
        CreatureSize.setPaintLabels(true);
        CreatureSize.setEnabled(false);
        JLabel ver_speedLabel = new JLabel("Vertical speed:");
        CreatureVerSpeed = new JSlider(1, 10, 2);
        CreatureVerSpeed.setMajorTickSpacing(1);
        CreatureVerSpeed.setPaintTicks(true);
        CreatureVerSpeed.setPaintLabels(true);
        CreatureVerSpeed.setEnabled(false);
        JLabel hor_speedLabel = new JLabel("Horizontal speed:");
        CreatureHorSpeed = new JSlider(1, 10, 2);
        CreatureHorSpeed.setMajorTickSpacing(1);
        CreatureHorSpeed.setPaintTicks(true);
        CreatureHorSpeed.setPaintLabels(true);

        CreatureHorSpeed.setEnabled(false);
        JLabel colorLabel = new JLabel("Color:");
        changeColorBtn = new JButton("Choose Color");
        changeColorBtn.addActionListener(e-> chooseColor());
        changeColorBtn.setEnabled(false);
        SubmitBtn = new JButton("Submit");
        SubmitBtn.setEnabled(false);
        SubmitBtn.addActionListener(e -> applyChanges());
        clonePropsPanel.add(sizeLabel);
        clonePropsPanel.add(CreatureSize);
        clonePropsPanel.add(ver_speedLabel);
        clonePropsPanel.add(CreatureVerSpeed);
        clonePropsPanel.add(hor_speedLabel);
        clonePropsPanel.add(CreatureHorSpeed);
        clonePropsPanel.add(colorLabel);
        clonePropsPanel.add(changeColorBtn);
        clonePropsPanel.add(SubmitBtn);
        clonePropsPanel.setLayout(new GridLayout(0, 2, 10, 10));

        setLayout(new GridLayout(0, 2, 10, 10));
        add(CreaturePanel);
        add(clonePropsPanel);
        setVisible(true);
        pack();
    }

    private void chooseColor() {
        changeColorBtn.setBackground(JColorChooser.showDialog(this, "Choose Color", duplicatedCreature.getColor()));
    }

    private void applyChanges() {
        if (duplicatedCreature == null)
            return;

        duplicatedCreature.dupChangeValues(CreatureSize.getValue(), CreatureHorSpeed.getValue(), CreatureVerSpeed.getValue(), changeColorBtn.getBackground());

    }

    private void duplicateCreature() {
        var selectedCreature = (SeaCreature) CreatureList.getSelectedValue();
        if (selectedCreature instanceof Immobile) {
            JOptionPane.showMessageDialog(this, "This creature is immobile and cannot be cloned.");
            return;
        }

        if (FishTank.getInstance().isSwimmableFull()) {
            JOptionPane.showMessageDialog(this, "The fish tank is full.");
            return;
        }

        var newCreature = ((Swimmable) selectedCreature).clone();
        FishTank.getInstance().addCreature(newCreature);
//        this.seaCreatures.add(newCreature);
        var dlm = new DefaultListModel<>();
        dlm.addAll(FishTank.getInstance().seaCreatures);
        CreatureList.setModel(dlm);
        duplicatedCreature = newCreature;
        ActivateEdit();
    }

    public void ActivateEdit() {
        CreatureSize.setEnabled(true);
        CreatureVerSpeed.setEnabled(true);
        CreatureHorSpeed.setEnabled(true);
        SubmitBtn.setEnabled(true);
        changeColorBtn.setEnabled(true);

        CreatureSize.setValue(duplicatedCreature.getSize());
        CreatureVerSpeed.setValue(duplicatedCreature.getVerSpeed());
        CreatureHorSpeed.setValue(duplicatedCreature.getHorSpeed());
        changeColorBtn.setBackground(duplicatedCreature.getColor());

    }
}
