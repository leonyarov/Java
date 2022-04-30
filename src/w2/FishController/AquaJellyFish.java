package w2.FishController;

import w2.GUI.AquaBackground;

import java.awt.*;
import java.util.concurrent.CyclicBarrier;

public class AquaJellyFish extends AquaAnimal {


    public AquaJellyFish(int h, int v, int size, Color color, Image image) {
        super(h, v, size, color, image);
        eatCount = 0;
    }

    public AquaJellyFish(int h, int v, int size, Color color) {
        super(h, v, size, color, FishUtils.getRandomImage(FishUtils.jellyfishLibrary,color));
        eatCount = 0;
    }

    @Override
    public void drawAnimal(Graphics g) {
        if (isOnXBorder(g)) {
            setHorSpeed(-getHorSpeed());
            flipImage();
        }
        if (isOnYBorder(g)) setVerSpeed(-getVerSpeed());
        moveAnimal();
        g.drawImage(this.image, xFront, yFront, pixelSize, pixelSize, null);

    }

    private int eatCount;
    @Override
    public String getAnimalName() {
        return "JellyFish";
    }



    @Override
    public void setSuspend() {
        isSuspended = true;
    }

    @Override
    public void setResume() {
        synchronized (this){
            isSuspended = false;
            notify();
        }
    }

    @Override
    public void setBarrier(CyclicBarrier b) {
        barrier = b;
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
    public Color getColor() {
        return color;
    }
}
