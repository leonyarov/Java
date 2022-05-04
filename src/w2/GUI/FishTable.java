package w2.GUI;

import w2.FishController.FishTank;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class FishTable extends JDialog {
    JTable table = new JTable();
    DefaultTableModel tableModel = new DefaultTableModel();

    public FishTable() {
        tableModel.addColumn("Animal");
        tableModel.addColumn("Color");
        tableModel.addColumn("Hor.Speed");
        tableModel.addColumn("Ver.Speed");
        tableModel.addColumn("Eat counter");
        setSize(550, 350);
//        add(new JScrollPane(this));
        table.setModel(tableModel);
        add(table);
        addFish();
    }

    public void addFish(){
        for (var fish : FishTank.fishes) {
            tableModel.addRow(new Object[]{
                    fish.getAnimalName(),
                    fish.getColor(),
                    fish.getHorSpeed(),
                    fish.getVerSpeed(),
                    fish.getEatCount()});
        }
    }


}

