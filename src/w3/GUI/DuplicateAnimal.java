package w3.GUI;

import w3.FishController.Fish;
import w3.FishController.Swimmable;
import w3.FishController.FishTank;
import w3.GUI.AquaPanel;

import javax.swing.*;
import java.util.ArrayList;
import java.awt.*;
import java.lang.reflect.Field;
import java.util.Random;


public class DuplicateAnimal extends JDialog {
    Color color;
    Random rand = new Random();
    Swimmable[] creatures ;
    int i;
    int id = InformationPanel.Copy_ID-1;
    String clr ;
    public DuplicateAnimal() {
        if(InformationPanel.Copy_ID < 1 || InformationPanel.Copy_ID > 5){
            JOptionPane.showMessageDialog(null, "Please pick an animal from the info table",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        creatures = AquaPanel.swimmable.keySet().toArray(new Swimmable[AquaPanel.swimmable.size()]);
        JSlider Size = new JSlider(20, 320, creatures[id].getSize());
        JSlider HorSpeed = new JSlider(1, 10,Math.abs(creatures[id].getHorSpeed()));
        JSlider VerSpeed = new JSlider(1, 10, Math.abs(creatures[id].getVerSpeed()));


        String[] Animal_color = {"","black", "red", "blue", "green", "cyan", "orange", "yellow", "magenta", "pink"};
        for (String A_crl:Animal_color) {
            if(creatures[id].getColor().equalsIgnoreCase(A_crl)){
                Animal_color[0] = A_crl;
            }
        }
        JComboBox animal_c = new JComboBox(Animal_color);
        JComponent[] inputs = new JComponent[]{
                new JLabel("Size: "),
                Size,
                new JLabel("Horizontal Speed: "),
                HorSpeed,
                new JLabel("Vertical Speed: "),
                VerSpeed,
                new JLabel("Color"),
                animal_c};
        int result = JOptionPane.showConfirmDialog(null, inputs,
                "Add animal", JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            int size_i = Size.getValue();
            int hor_i = VerSpeed.getValue();
            int var_i = HorSpeed.getValue();
            String color_i = animal_c.getSelectedItem().toString();

            try {
                Field field = Class.forName("java.awt.Color").getField(color_i);
                color = (Color) field.get(null);
            } catch (Exception e) {
                color = null; // Not defined
            }
            if (AquaPanel.swimmable.size() < 5) {

                Swimmable creature = (Swimmable) creatures[id].Clone();
                creature.setSize(size_i);
                creature.setHorSpeed(hor_i);
                creature.setVerSpeed(var_i);
                creature.setColor(color);
                AquaPanel.swimmable.put(creature,AquaPanel.ID++);
                InformationPanel.tableModel.insertRow(0, new Object[]{creature.getAnimalName(), color_i, size_i, hor_i, var_i,AquaPanel.ID++, creature.getEatCount()});
            } else JOptionPane.showMessageDialog(null, "No more then 5 Animals",
                    "Error", JOptionPane.ERROR_MESSAGE);


        }


    }


}