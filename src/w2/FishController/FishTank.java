package w2.FishController;

import w2.GUI.AquaBackground;
import w2.GUI.AquaLabel;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;

/**
 * This class represents a fish tank.
 * It contains a set of swimmable objects.
 */
public class FishTank {
    public static HashSet<AquaAnimal> fishes;
    private AquaBackground aquarium;
    private static FishTank instance;

    public static FishTank getInstance() {
        if (instance == null) {
            throw new IllegalStateException("FishTank is not initialized");
        }
        return instance;
    }

    public enum AnimalType {
        FISH, JELLYFISH
    }


    public FishTank(AquaBackground background) {
        if (background == null) throw new IllegalArgumentException("Background image cannot be null");
        fishes = new HashSet<AquaAnimal>();
        aquarium = background;
        instance = this;

        //make new thread with update func
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Update();
                    try {
                        Thread.sleep(16);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();


    }

    public void Update(){
        aquarium.repaint();
        for (AquaAnimal fish : fishes) {
            fish.Update();
        }
    }


    public void newFish(int h, int v, int s, Color c, AquaLabel i, AnimalType t){
        AquaAnimal fish;
        switch (t) {
            case FISH:
                fish = new AquaFish(h,v,s,c,i);
                break;
            case JELLYFISH:
                fish = new AquaJellyFish(h,v,s,c,i);
                break;
            default:
                fish = new AquaFish(h,v,s,c,i);
        }
        fishes.add(fish);
        aquarium.add(fish.getAnimalImage());
    }






}
