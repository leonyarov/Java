package w3.Factory;

import w3.Creatures.SeaCreature;

public abstract class AbstractSeaFactory {
    public abstract SeaCreature produceSeaCreature(String type);


}
