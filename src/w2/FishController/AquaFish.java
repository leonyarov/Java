package w2.FishController;

import w2.GUI.AquaBackground;
import w2.GUI.AquaLabel;

import java.awt.*;
import java.util.concurrent.CyclicBarrier;

public class AquaFish extends AquaAnimal {


    private int eatCount;

    public AquaFish(int h, int v, int size, Color c, AquaLabel aquaImage) {
        super(h, v, size, c, aquaImage);
        eatCount = 0;
    }

    @Override
    public String getAnimalName() {
        return "Fish";
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
