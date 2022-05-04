package w2.FishController;
import java.awt.*;
import java.util.concurrent.CyclicBarrier;

public class AquaFish extends AquaAnimal {


    //Fish eat count
    private int eatCount;

    /**
     * Fish constructor
     * @param h horizontal speed
     * @param v vertical speed
     * @param size pixel size
     * @param c @{@link Color} object
     */
    public AquaFish(int h, int v, int size, Color c) {
        super(h, v, size, c, FishUtils.getRandomImage(FishUtils.fishLibrary,c));
        eatCount = 0;
    }


    @Override
    public String getAnimalName() {
        return "Fish";
    }

    /**
     * Draw fish on @{@link Graphics} object
     * @param g @{@link Graphics} object
     */
    @Override
    public void drawAnimal(Graphics g) {
        if (isOnXBorder(g)) {                       //if fish is on the border
            setHorSpeed(-getHorSpeed());            //change X direction
            flipImage();                            //flip image
        }
        if (isOnYBorder(g)) setVerSpeed(-getVerSpeed()); //change Y direction
        g.drawImage(this.image, xFront, yFront, pixelSize, pixelSize, null); //draw fish
    }

    /**
     * Stop fish
     */
    @Override
    public void setSuspend()  {
        isSuspended = true;
    }

    /**
     * Resume fish
     */
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
