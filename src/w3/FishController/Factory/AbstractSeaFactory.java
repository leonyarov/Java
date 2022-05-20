package w3.FishController.Factory;

import w3.FishController.SeaCreature;

public abstract class AbstractSeaFactory {
    public abstract SeaCreature produceSeaCreature(String type);
}
