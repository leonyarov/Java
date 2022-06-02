package w3.Factory;

import w3.Creatures.SeaCreature;

/**
 * Abstract Factory DP for simulating Elements within Aquarium.
 */
public abstract class AbstractSeaFactory {
    public abstract SeaCreature produceSeaCreature(String type);


}
