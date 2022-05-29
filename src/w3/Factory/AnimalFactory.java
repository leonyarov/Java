package w3.Factory;

import w3.Creatures.Fish;
import w3.Creatures.JellyFish;
import w3.Creatures.SeaCreature;
import w3.GUI.AddAnimalDialog;

public class AnimalFactory extends AbstractSeaFactory {

    public AddAnimalDialog gui;
    public AnimalFactory(AddAnimalDialog gui) {        this.gui = gui;    }

    @Override
    public SeaCreature produceSeaCreature(String type) {
        if (type.equals("Fish"))
            return new Fish(-gui.hspeed.getValue(), gui.vspeed.getValue(), gui.size.getValue(), gui.color);
        else if (type.equals("JellyFish"))
            return new JellyFish(-gui.hspeed.getValue(), gui.vspeed.getValue(), gui.size.getValue(), gui.color);
        return null;
    }
}
