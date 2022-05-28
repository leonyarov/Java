package w3.FishController.Factory;

import w3.FishController.SeaCreature;
import w3.GUI.AddAnimalDialog;

import javax.swing.*;

public abstract class AbstractSeaFactory {
    public abstract SeaCreature produceSeaCreature(String type);


}
