package w3.Creatures;

import w3.Decorator.MarineAnimal;
import w3.Decorator.MarineAnimalDecorator;
import w3.ListenerObserver.HungerObserver;
import w3.State.Hungry;
import w3.State.Satiated;
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

    public JellyFish(int x, int y, int h, int v, int size, Color c, int hungerTime, Image img) {
        this(h, v, size, c, hungerTime);
        this.xFront = x;
        this.yFront = y;
        this.setImage(img);
    }


    @Override
    public Swimmable clone() {
        return new JellyFish(xFront,yFront,horizontalSpeed, verticalSpeed, pixelSize, color, hunger.gethungerTime(),image);
    }

    @Override
    public void setColor(Color c) {
        paintedImage = PaintAnimal(image, c);
        this.color = c;
    }

    @Override
    public void drawCreature(Graphics g) {
        if (isOnXBorder(g)) {
            setHorSpeed(-getHorSpeed());
            flipImage();
        }
        if (isOnYBorder(g)) setVerSpeed(-getVerSpeed());

        g.drawImage(paintedImage, xFront, yFront, pixelSize, pixelSize, null);

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
    public String getColorString() {
        return "Blue: " +  color.getBlue() + " Red: " + color.getRed() + " Green: " + color.getGreen();

    }

    @Override
    public Image PaintAnimal(Image image, Color color) {
        return new MarineAnimalDecorator().PaintAnimal(image, color);
    }

    @Override
    public void checkHungerStatus() {
        if (hunger.isHungry()){
            var hungerState = new Hungry();
            hungerState.changeHungerState(hunger);
        }
        if (hunger.hungerState instanceof Hungry) {
            notifyAllObservers();
        }
    }

    @Override
    public void setFed() {
        var hungerState = new Satiated();
        hungerState.changeHungerState(hunger);
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
        return hunger.hungerState instanceof Hungry;
    }
}
