package w2.FishController;

import w2.GUI.AquaBackground;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.CyclicBarrier;

public class AquaFish extends AquaAnimal {


    private int eatCount;

    public AquaFish(int h, int v, int size, Color c, Image aquaImage) {
        super(h, v, size, c, aquaImage);
        eatCount = 0;
    }

    public AquaFish(int h, int v, int size, Color c) {
        super(h, v, size, c, FishUtils.getRandomImage(FishUtils.fishLibrary,c));
        eatCount = 0;
    }

    @Override
    public String getAnimalName() {
        return "Fish";
    }

    @Override
    void draw(Graphics g) {
        g.drawImage(this.image, xFront, yFront, pixelSize, pixelSize, null);
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
        pixelSize += 10;
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
