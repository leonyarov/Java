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
//    public static FishTable ft = new FishTable();
    public AquaFood food = new AquaFood();
    private static FishTank instance;
    public CyclicBarrier foodBarrier ;
    private AquaBackground background;
    public Graphics g;
    public boolean isPaused = false;

    public static FishTank getInstance() {
        if (instance == null) {
            throw new IllegalStateException("FishTank is not initialized");
        }
        return instance;
    }

    public enum AnimalType {
        FISH, JELLYFISH
    }


    public FishTank(AquaBackground aquaBackground) {
        this.background = aquaBackground;
        fishes = new HashSet<AquaAnimal>();
        instance = this;
        g = aquaBackground.getGraphics();

    }


    //sleep all fishes
    public  void sleepAll(){
            for (AquaAnimal fish : fishes) {
                fish.setSuspend();
            }
    }

    //wake up all fish
    public void wakeAll(){
        for (AquaAnimal fish : fishes) {
            fish.setResume();
        }
    }

    public void reset(){
        foodBarrier.reset();
        fishes.clear();
    }

    public void feed(){

//        if(fishes.size() == 0) return;
        var rand = new java.util.Random();
        int x = rand.nextInt(background.getWidth() - AquaFood.FOOD_WIDTH);
        int y = rand.nextInt(background.getHeight() - AquaFood.FOOD_WIDTH);
        food.placeFood(x,y);
//        if (foodBarrier != null) foodBarrier.reset();
        foodBarrier = new CyclicBarrier(fishes.size());
        System.out.println(foodBarrier.getParties() + " fishes subscribed, with " + foodBarrier.getNumberWaiting() + " waiting");
    }


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
//        fish.setBarrier(foodBarrier);
        fishes.add(fish);
    }







}
