package w3.Creatures;

import w3.Decorator.MarineAnimal;
import w3.Decorator.MarineAnimalDecorator;
import w3.ListenerObserver.HungerObserver;
import w3.Utils.FishUtils;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

public class JellyFish extends Swimmable implements MarineAnimal {

    List<HungerObserver> observers;

    //JellyFish eat count
    private int eatCount;

    /**
     * JellyFish constructor
     * @param h horizontal speed
     * @param v vertical speed
     * @param size pixel size
     * @param color @{@link Color} object
     */
    public JellyFish(int h, int v, int size, Color color, int hungerTime) {
        super(h, v, size, color, FishUtils.getRandomImage(FishUtils.jellyfishLibrary), hungerTime);
        observers = new ArrayList<HungerObserver>();
        eatCount = 0;
    }

    @Override
    public void drawCreature(Graphics g) {
        if (isOnXBorder(g)) {
            setHorSpeed(-getHorSpeed());
            flipImage();
        }
        if (isOnYBorder(g)) setVerSpeed(-getVerSpeed());

        g.drawImage(PaintAnimal(image,color), xFront, yFront, pixelSize, pixelSize, null);

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

    @Override
    public Image PaintAnimal(Image image, Color color) {
        return new MarineAnimalDecorator().PaintAnimal(image, color);
    }

    @Override
    public boolean getHungerStatus() {
        var status = hunger.isHungry();
        if (status && !hunger.isNotified) {
            notifyAllObservers();
            hunger.isNotified = true;
        }
        return status;

    }

    @Override
    public void setFed() {
        hunger.feed();
        notifyAllObservers();
    }

    @Override
    public void attach(HungerObserver observer) {
        if (!observers.contains(observer)) observers.add(observer);
    }

    @Override
    public void notifyAllObservers() {
        observers.forEach(o -> o.update(this));
    }
    @Override
    public boolean isHungry() {
        return hunger.isHungry();
    }
}
