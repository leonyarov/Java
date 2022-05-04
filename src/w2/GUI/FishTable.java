package w2.GUI;

import w2.FishController.FishTank;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


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
//        add(new JScrollPane(this));
        table.setModel(tableModel);
        scrollPane.setViewportView(table);
        add(scrollPane);
        addFish();
        pack();
        table.setVisible(true);

    }

    public void addFish(){
        for (var fish : FishTank.fishes) {
            var a = new Object[] {
                    fish.getAnimalName(),
                    fish.getSize(),
                    fish.getColor(),
                    Math.abs(fish.getHorSpeed()),
                    Math.abs(fish.getVerSpeed()),
                    fish.getEatCount() };

            tableModel.addRow(a);

        }
    }


}

