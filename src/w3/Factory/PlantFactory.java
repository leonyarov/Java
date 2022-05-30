package w3.Factory;

import w3.Creatures.*;
import w3.GUI.AddPlantDialog;
import w3.GUI.AquaBackground;
import w3.GUI.AquaFrame;

import java.awt.*;

public class PlantFactory extends AbstractSeaFactory{

    AddPlantDialog gui;
    public PlantFactory(AddPlantDialog gui) {        this.gui = gui;    }

    @Override
    public SeaCreature produceSeaCreature(String type) {
        if (type.equals("Zostera"))
            return new Zostera(gui.xPos.getValue(), 520 - gui.size.getValue()*2 ,gui.size.getValue(), Color.GREEN);
        else if (type.equals("Laminaria"))
            return new Laminaria(gui.xPos.getValue(), 520 - gui.size.getValue()*2, gui.size.getValue(), Color.GREEN);
        return null;
    }
}
