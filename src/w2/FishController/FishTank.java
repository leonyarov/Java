package w2.FishController;

import w2.GUI.AquaBackground;

import java.awt.*;
import java.util.HashSet;

/**
 * This class represents a fish tank.
 * It contains a set of swimmable objects.
 */
public class FishTank {
    public static HashSet<AquaAnimal> fishes;
    public static HashSet<AquaFood> food;
    private static FishTank instance;
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
        food = new HashSet<AquaFood>();
        instance = this;
        g = aquaBackground.getGraphics();

    }

    public void Update(Graphics g){
//        for (AquaAnimal fish : fishes) {
//            fish.draw(g);
//            if (fish.isOnXBorder(g)) {
//                fish.setHorSpeed(-fish.getHorSpeed());
//                fish.flipImage();
//            }
//            if (fish.isOnYBorder(g)) fish.setVerSpeed(-fish.getVerSpeed());
//            fish.moveAnimal();
//        }

        for (AquaFood food : FishTank.food) {
            if (food.isOnYBorder(g) || food.isEaten()){
                FishTank.food.remove(food);
                break;
            }
//            food.draw(g);
            food.move();
        }
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

    public void feed(){
        //select random point in aquabackground
        var rand = new java.util.Random();
        int x = rand.nextInt(background.getWidth() - AquaFood.FOOD_WIDTH);
        int y = rand.nextInt(background.getHeight() - AquaFood.FOOD_WIDTH);
        food.add(new AquaFood(x,y));
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
//        fish.start();
        fishes.add(fish);
    }







}
