package w3.FishController.Factory;

import w3.FishController.*;

public class PlantFactory extends AbstractSeaFactory{
    @Override
    public SeaCreature produceSeaCreature(String type) {
        if (type.equals("Zostera"))
            return new Zostera();
        else if (type.equals("Laminaria"))
            return new Laminaria();
        return null;
    }
}
