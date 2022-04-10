package w2.FishController;

import w2.GUI.AnimalPanel;

import java.awt.*;
import java.util.HashSet;

/**
 * This class represents a fish tank.
 * It contains a set of swimmable objects.
 */
public class FishTank {
    HashSet<AquaAnimal> fishes;
    public enum AnimalType {
        FISH, JELLYFISH
    }

    public FishTank() {
        fishes = new HashSet<AquaAnimal>();
    }


    public void newFish(int h, int v, int s, Color c, AnimalPanel p, AnimalType t){
        switch (t) {
            case FISH:
                fishes.add(new AquaJellyFish(h,v,s,c,p));
                break;
            case JELLYFISH:
                fishes.add(new AquaFish(h,v,s,c,p));
        }
    }




}
