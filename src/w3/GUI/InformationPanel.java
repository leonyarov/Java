package w3.GUI;

import w3.FishController.Immobile;
import w3.FishController.Swimmable;
import w3.GUI.AquaPanel;
import w3.GUI.Observer;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.HashMap;
import java.util.HashSet;


public class InformationPanel implements ListSelectionListener {
    public static DefaultTableModel tableModel = new DefaultTableModel();
    public static JTable table = new JTable(tableModel);

    static JFrame info_frame = new JFrame("My Aquarium");

    public static boolean close;
    static int total = 0;
    static JScrollPane sp;

    public static int Copy_ID = 0;
    public InformationPanel() {
        tableModel.addColumn("Animal");
        tableModel.addColumn("Color");
        tableModel.addColumn("Size");
        tableModel.addColumn("Hor.speed");
        tableModel.addColumn("Ver.speed");
        tableModel.addColumn("ID");
        tableModel.addColumn("Eat count");
        tableModel.insertRow(0, new Object[]{"Total", "", "", "", "", "", "0"});
        sp = new JScrollPane(table);
        ListSelectionModel listModel = table.getSelectionModel();
        listModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listModel.addListSelectionListener(this);

    }
    public  static void open_table(){
        if (!close) {
            table.setBounds(30, 40, 200, 300);
            info_frame.add(sp);
            info_frame.setSize(500, 200);
            info_frame.setVisible(true);
            close = true;
        } else {
            info_frame.setVisible(false);
            close = false;
        }
    }

    synchronized public static void refresh_table() {
        total = 0;
        int temp = 1;
        tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);

        for (Swimmable animal : AquaPanel.swimmable.keySet()) {
            total = total + animal.getEatCount();
        }
        tableModel.insertRow(0, new Object[]{"Total", "", "", "", "", "", total});

        for (Swimmable animal : AquaPanel.swimmable.keySet()) {
            tableModel.insertRow(0, new Object[]{animal.getAnimalName(), animal.getColor(), animal.getSize(), animal.getHorSpeed(), animal.getVerSpeed(), temp++, animal.getEatCount()});
        }
    }

    synchronized public static void Reset_table() {
        for (Swimmable animal : AquaPanel.swimmable.keySet()) {
            animal.stop();
        }
        AquaPanel.immobile = new HashSet<Immobile>();
        AquaPanel.swimmable = new HashMap<>();
        AquaPanel.ID = 0;
        tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        tableModel.insertRow(0, new Object[]{"Total", "", "", "", "", "", "0"});
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int[] sel;
        Object value;
        if (!e.getValueIsAdjusting()) {
            sel = table.getSelectedRows();
            if (sel.length > 0) {

                // get data from JTable
                TableModel tm = table.getModel();
                value = tm.getValueAt(sel[0], 5);
                Copy_ID = (int)value;
            }
        }
    }
}

