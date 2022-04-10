package w2.FishController;

import w2.GUI.AnimalPanel;

import java.awt.*;
import java.util.concurrent.CyclicBarrier;

public class AquaJellyFish extends AquaAnimal {


    public AquaJellyFish(int h, int v, int size, Color color, AnimalPanel panel) {
        super(h, v, size, color, panel);
        eatCount = 0;
    }

    private int eatCount;
    @Override
    public String getAnimalName() {
        return "JellyFish";
    }


    @Override
    public void setSuspend() {

    }

    @Override
    public void setResume() {

    }

    @Override
    public void setBarrier(CyclicBarrier b) {

    }

    @Override
    public int getSize() {
        return pixelSize;
    }

    @Override
    public void eatInc() {
        eatCount++;
    }

    @Override
    public int getEatCount() {
        return eatCount;
    }

    @Override
    public String getColor() {
        return color.toString();
    }
}
