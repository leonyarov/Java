package w3.GUI;

import w3.Creatures.FishTank;
import w3.Creatures.Swimmable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * AquaticAnimal Information Table
 */
public class FishTable extends JDialog {
    JScrollPane scrollPane = new JScrollPane();
    JTable table = new JTable();
    DefaultTableModel tableModel = new DefaultTableModel();



    public FishTable() {
        tableModel.addColumn("Animal");
        tableModel.addColumn("Color");
        tableModel.addColumn("Size");
        tableModel.addColumn("Hor.Speed");
        tableModel.addColumn("Ver.Speed");
        tableModel.addColumn("Eat counter");
        setSize(550, 350);
        table.setModel(tableModel);
        scrollPane.setViewportView(table);
        add(scrollPane);
        addFish();
        tableModel.addRow(new Object[] {"Total","","","","",AquaPanel.totalEatCounter});
        pack();
    }
    /*public FishTable(String str) {
        if (str == "Duplicate") {
            tableModel.addColumn("Animal");
            tableModel.addColumn("ID");
            setSize(550, 350);
            table.setModel(tableModel);
            scrollPane.setViewportView(table);
            add(scrollPane);
            AddDupFish();
            pack();
        }
    }*/

    /**
     * Input values of all instances of AquaticAnimals in FishTank
     */
    public void addFish(){
        for (var creature : FishTank.getInstance().seaCreatures) {
            var fish = ((Swimmable)creature);
            var a = new Object[] {
                    fish.getAnimalName(),
                    fish.getColor(),
                    fish.getSize(),
                    Math.abs(fish.getHorSpeed()),
                    Math.abs(fish.getVerSpeed()),
                    fish.getEatCount() };
            tableModel.addRow(a);
        }
    }

    /*public void AddDupFish(){
        int i = 0;
        for (var creature : FishTank.getInstance().seaCreatures) {
            var fish = ((Swimmable)creature);

            i++;
            var a = new Object[] {
                    fish.getAnimalName(),
                    i };
            tableModel.addRow(a);
        }
    }*/
}

