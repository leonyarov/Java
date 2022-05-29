package w3.GUI;

import w3.Factory.PlantFactory;
import w3.Creatures.FishTank;

import javax.swing.*;
import java.awt.*;

public class AddPlantDialog extends JDialog {
    public JSlider xPos;
    public JSlider size;
    String type;


    public AddPlantDialog() {
        setTitle("Add Animal");
        JPanel propertiesPanel = new JPanel();
        JLabel plantTypeLabel = new JLabel("Plant Type:");
        JPanel plantTypePanel = new JPanel();

        ButtonGroup plantTypeGroup = new ButtonGroup(); //group of radio buttons
        JRadioButton zostera = new JRadioButton("Zostera", true);
        JRadioButton laminaria = new JRadioButton("Laminaria");
        plantTypeGroup.add(zostera);
        plantTypeGroup.add(laminaria);

        JLabel sizeLabel = new JLabel("Size:");
        size = new JSlider(20, 320, 50);
        size.setMajorTickSpacing(1);

        JLabel xPosLabel = new JLabel("X-Position: ");
        xPos = new JSlider(1, 800, 2);


        JPanel buttonPanel = new JPanel();
        JButton createNew = new JButton("Create New");
        JButton cancel = new JButton("Cancel");


        plantTypePanel.add(zostera);
        plantTypePanel.add(laminaria);

        //Add to properties panel
        propertiesPanel.add(plantTypeLabel);
        propertiesPanel.add(plantTypePanel);
        propertiesPanel.add(sizeLabel);
        propertiesPanel.add(size);
        propertiesPanel.add(xPosLabel);
        propertiesPanel.add(xPos);

        //set grid layout
        propertiesPanel.setLayout(new GridLayout(0, 2, 10 ,10));
        propertiesPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        buttonPanel.add(createNew);
        buttonPanel.add(cancel);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,20));


        createNew.addActionListener(e -> {
            type = zostera.isSelected() ? "Zostera" : "Laminaria";
            var factory = new PlantFactory(this);
            var product = factory.produceSeaCreature(type);
            FishTank.getInstance().addCreature(product);
        });

        cancel.addActionListener(e -> this.dispose());
        //Add to form
        add(propertiesPanel);
        add(buttonPanel);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        pack();
    }


}
