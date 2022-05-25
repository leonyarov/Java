package w3.FishController.Factory;

import w3.FishController.Fish;
import w3.FishController.JellyFish;
import w3.FishController.SeaCreature;

import java.awt.*;

public class AnimalFactory extends AbstractSeaFactory {

    @Override
    public SeaCreature produceSeaCreature(String type) {
        if (type.equals("Fish"))
            return new Fish();
        else if (type.equals("JellyFish"))
            return new JellyFish();
        return null;
    }
}
