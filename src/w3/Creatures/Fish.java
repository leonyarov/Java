package w3.Creatures;
import w3.Decorator.MarineAnimal;
import w3.Decorator.MarineAnimalDecorator;
import w3.ListenerObserver.HungerObserver;
import w3.Utils.FishUtils;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

public class Fish extends Swimmable implements MarineAnimal, Cloneable {

    List<HungerObserver> observers;
    //Fish eat count
    private int eatCount;

    /**
     * Fish constructor
     * @param h horizontal speed
     * @param v vertical speed
     * @param size pixel size
     * @param c @{@link Color} object
     */
    public Fish(int h, int v, int size, Color c, int hungerTime) {
        super(h, v, size, c, FishUtils.getRandomImage(FishUtils.fishLibrary), hungerTime);
        observers = new ArrayList<HungerObserver>();
        eatCount = 0;
    }

    @Override
    public String getAnimalName() {
        return "Fish";
    }

    @Override
    public void drawCreature(Graphics g) {
        if (isOnXBorder(g)) {                       //if fish is on the border
            setHorSpeed(-getHorSpeed());            //change X direction
            flipImage();                            //flip image
        }
        if (isOnYBorder(g)) setVerSpeed(-getVerSpeed()); //change Y direction
        g.drawImage(PaintAnimal(image,color), xFront, yFront, pixelSize, pixelSize, null); //draw fish
    }

    @Override
    public void setSuspend()  {
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
            hunger.isNotified = true;
            notifyAllObservers();
        }
        return status;

    }

    @Override
    public boolean isHungry() {
        return hunger.isHungry();
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
        System.out.println("Fish is hungry");
        observers.forEach(o -> o.update(this));
    }

    public Object clone() {
        Object clone = null;

        try{
            clone = super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return clone;
    }
}
