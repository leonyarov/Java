package w3.FishController;

import w3.Utils.FishUtils;

import java.awt.*;
import java.util.concurrent.CyclicBarrier;

public class JellyFish extends Swimmable {

    //JellyFish eat count
    private int eatCount;

    /**
     * JellyFish constructor
     * @param h horizontal speed
     * @param v vertical speed
     * @param size pixel size
     * @param color @{@link Color} object
     */
    public JellyFish(int h, int v, int size, Color color) {
        super(h, v, size, color, FishUtils.getRandomImage(FishUtils.jellyfishLibrary,color));
        eatCount = 0;
    }

    public JellyFish(){
        super(1, 1, 30, Color.WHITE, FishUtils.getRandomImage(FishUtils.jellyfishLibrary,Color.WHITE));
        eatCount = 0;
    }


    @Override
    public void drawCreature(Graphics g) {
        if (isOnXBorder(g)) {
            setHorSpeed(-getHorSpeed());
            flipImage();
        }
        if (isOnYBorder(g)) setVerSpeed(-getVerSpeed());

        g.drawImage(this.image, xFront, yFront, pixelSize, pixelSize, null);

    }

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
        pixelSize += 10;
    }

    @Override
    public int getEatCount() {
        return eatCount;
    }

    @Override
    public String getColor() {
        return "Blue: " +  color.getBlue() + " Red: " + color.getRed() + " Green: " + color.getGreen();

    }
}
