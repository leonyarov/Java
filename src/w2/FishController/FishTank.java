package w2.FishController;

import w2.GUI.AquaBackground;
import w2.GUI.AquaPanel;
import w2.GUI.FishTable;

import java.awt.*;
import java.util.HashSet;
import java.util.concurrent.CyclicBarrier;

/**
 * This class represents a fish tank.
 * It contains a set of swimmable objects.
 */
public class FishTank {
    public static HashSet<AquaAnimal> fishes;
    public AquaFood food = new AquaFood();
    private static FishTank instance;
    public CyclicBarrier foodBarrier ;

    public static FishTank getInstance() {
        if (instance == null) {
            throw new IllegalStateException("FishTank is not initialized");
        }
        return instance;
    }

    public enum AnimalType {
        FISH, JELLYFISH
    }


    public FishTank() {
        fishes = new HashSet<>();
        instance = this;
    }


    //sleep all fishes
    public  void sleepAll() {
        for (AquaAnimal fish : fishes) fish.setSuspend();
    }

    //wake up all fish
    public void wakeAll() {
        for (AquaAnimal fish : fishes) fish.setResume();
    }

    public void reset(){
        foodBarrier.reset();    //reset barrier
        fishes.clear();         //clear fishes
    }

    public void feed(){

        if(fishes.size() == 0) return;        //If no fishes present dont place food
        food.placeFood(400,300);         //Place in the center of the aquarium
        foodBarrier = new CyclicBarrier(fishes.size()); //init new barrier
        for(var fish : fishes) fish.setBarrier(foodBarrier); //set the barrier to the fishes
    }


    /**
     * Create new animal in the tank
     * @param h horizontal speed
     * @param v vertical speed
     * @param s size
     * @param c color
     * @param i {@link Image}
     * @param t type enum
     */
    public void newFish(int h, int v, int s, Color c, Image i, AnimalType t){
        AquaAnimal fish;
        switch (t) {
            case FISH:
                fish = new AquaFish(h,v,s,c);
                break;
            case JELLYFISH:
                fish = new AquaJellyFish(h,v,s,c);
                break;
            default:
                fish = new AquaFish(h,v,s,c);
        }
        fishes.add(fish);
    }







}
