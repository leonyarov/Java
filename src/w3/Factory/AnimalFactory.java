package w3.Factory;

import w3.Creatures.Fish;
import w3.Creatures.JellyFish;
import w3.Creatures.SeaCreature;
import w3.GUI.AddAnimalDialog;
import w3.Prototype.DuplicateAnimal;

/**
 Animal objects simulated using Inheritance from AbstractFactory DP
 */
public class AnimalFactory extends AbstractSeaFactory {

    public AddAnimalDialog gui;
    public AnimalFactory(AddAnimalDialog gui) {        this.gui = gui;    }
    @Override
    public SeaCreature produceSeaCreature(String type) {
        if (type.equals("Fish"))
            return new Fish(-gui.hspeed.getValue(), gui.vspeed.getValue(), gui.size.getValue(), gui.color, gui.hunger.getValue());
        else if (type.equals("JellyFish"))
            return new JellyFish(-gui.hspeed.getValue(), gui.vspeed.getValue(), gui.size.getValue(), gui.color, gui.hunger.getValue());
        return null;

    }
}
