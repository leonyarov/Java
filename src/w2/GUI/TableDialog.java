package w2.GUI;

import w2.FishController.FishTank;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TableDialog extends JDialog {
    public TableDialog() {
        setTitle("FishTank Information");
        pack();
    }

//    public static void CreateJTable(){
//        DefaultTableModel tableModel = new DefaultTableModel();
//        tableModel.addColumn("Animal");
//        tableModel.addColumn("Color");
//        tableModel.addColumn("Hor.Speed");
//        tableModel.addColumn("Ver.Speed");
//        tableModel.addColumn("Eat counter");
//        for (var fish: FishTank.fishes){
//            tableModel.addRow(new Object[] {fish.getName(), fish.getColor(), fish.getSize(), fish.getHorSpeed(), fish.getVerSpeed(), fish.getEatCount()});
//        }
//        JTable table = new JTable(tableModel);
//        JFrame f = new JFrame();
//        f.setSize(550, 350);
//        f.add(new JScrollPane(table));
//        f.setVisible(true);
//    }


}
