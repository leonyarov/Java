package w3.Creatures;

import w3.ListenerObserver.Hunger;
import w3.ListenerObserver.HungrySubject;
import w3.Memento.Memento;
import w3.Memento.Originator;
import w3.GUI.AquaPanel;
import w3.Utils.FishUtils;

import java.awt.*;
import java.util.concurrent.CyclicBarrier;

public abstract class Swimmable extends Thread implements SeaCreature, Originator, HungrySubject {

    protected int horizontalSpeed;
    protected int verticalSpeed;
    CyclicBarrier barrier;
    public boolean isSuspended = false;
    protected Image image;
    protected int xFront;
    protected int yFront;
    protected int pixelSize;
    protected Color color;
    public Hunger hunger;

    @Override
     public void run() {
        super.run();
            while (true) {
                moveAnimal();
                getHungerStatus();
                try {
                    if (isSuspended)
                        synchronized (this) {
                            wait();
                        }
                    Thread.sleep(16);
                } catch (InterruptedException e) {
                    //interrupted
                }
            }
    }

    /**
     * Animal Super constructor
     * @param h horizontal speed
     * @param v vertical speed
     * @param size pixel size
     * @param c @{@link Color} object
     * @param animalImage @{@link Image} object
     * @param hungerTime
     */
    public Swimmable(int h, int v, int size, Color c, Image animalImage, int hungerTime) {
        super();
        hunger = new Hunger(hungerTime);
        horizontalSpeed = h;
        verticalSpeed = v;
        pixelSize = size;
        color = c;
        this.image = animalImage;
        xFront = 100;
        yFront = 100;
        start();
    }


    public int getHorSpeed() { return horizontalSpeed; }
    public int getVerSpeed() { return verticalSpeed; }
    public void setHorSpeed(int hor) { horizontalSpeed = hor; }
    public void setVerSpeed(int ver) { verticalSpeed = ver; }
    public Image getAnimalImage() { return image; }


    /**
     * Move animal position function
     */
    protected synchronized void moveAnimal() {

        //Copy food reference
        var f = FishTank.getInstance().food;

        //Temporary
        var xSpeed = horizontalSpeed;
        var ySpeed = verticalSpeed;

        //If food is not eaten chase it
        if (!f.isEaten) {


            //Cyclic barrier implementation
            try {
                barrier.await();
            } catch (Exception e) {
                return;
            }

            //Flip horizontally to chase food
            if (getCenterPointX() > f.xFront && horizontalSpeed > 0) {
                flipImage();
                horizontalSpeed = -horizontalSpeed;
            }
            if (getCenterPointX() < f.xFront && horizontalSpeed < 0) {
                flipImage();
                horizontalSpeed = -horizontalSpeed;
            }

            //Flip vertical axis to chase food
            if (getCenterPointY() > f.yFront && verticalSpeed > 0) verticalSpeed = -verticalSpeed;
            if (getCenterPointY() < f.yFront && verticalSpeed < 0) verticalSpeed = -verticalSpeed;

            //Copy speed reference for straight movement
            xSpeed = horizontalSpeed;
            ySpeed = verticalSpeed;

            //Move fish in straight line
            if (Math.abs(getCenterPointX() - f.xFront) < 5) horizontalSpeed = 0;
            if (Math.abs(getCenterPointY() - f.yFront) < 5) verticalSpeed = 0;

            //Check if animal is near food and eat it
            if (FishTank.getInstance().food.isNear(this) && !FishTank.getInstance().food.isEaten) {
                FishTank.getInstance().food.isEaten = true;
                eatInc();
                AquaPanel.eatInc(); //callback
                setFed();
            }
        }

        //Move fish with given speed
        xFront += horizontalSpeed;
        yFront += verticalSpeed;

        //Temporary revert
        horizontalSpeed = xSpeed;
        verticalSpeed = ySpeed;


    }

    //Get XFront pixel coordinate
    public int getXFront() { return xFront; }
    //Get YFront pixel coordinate
    public int getYFront() { return yFront; }


    /**
     * Check if fish is on the edge of the aquarium
     * @param g @{@link Graphics} object
     * @return True if fish is on the edge of the aquarium
     */
    public boolean isOnXBorder(Graphics g) {
        return xFront + pixelSize >= g.getClipBounds().width || xFront <= 0;
    }

    /**
     * Check if fish is on the edge of the aquarium
     * @param g @{@link Graphics} object
     * @return True if fish is on the edge of the aquarium
     */
    public boolean isOnYBorder(Graphics g) {
        return yFront + pixelSize >= g.getClipBounds().height || yFront <= 0;
    }

    /**
     * Get the middle X point of the fish
     * @return middle X point of the fish
     */
    public int getCenterPointX(){
        return xFront + pixelSize/2;
    }
    /**
     * Get the middle Y point of the fish
     * @return middle Y point of the fish
     */
    public int getCenterPointY(){
        return yFront + pixelSize/2;
    }


    /**
     * Flip fish image horizontally
     */
    public void flipImage() {
        var i = FishUtils.imageToBufferedImage(image);
        var b = FishUtils.flipHorizontal(i);
        setImage(b);
    }

    /**
     * Change all parameters of the swimming creature
     * @param h Horizontal Speed
     * @param v Vertical Speed
     * @param size Size in pixels
     * @param c Color
     */
    public void ChangeAll(int h, int v, int size, Color c){
        this.setHorSpeed(h);
        this.setVerSpeed(v);
        this.pixelSize = size;
        this.setColor(c);
    }

    /**
     * Set fish image to new image
     * @param image @{@link Image} object
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * Set fish color to new color
     * @param c @{@link Color} object
     */
    public void setColor(Color c) {
        color = c;
    }

    /**
     * Draw AquaticAnimal on @{@link Graphics} object
     * @param g @{@link Graphics} object
     */
    abstract public void drawCreature(Graphics g);

    /**
     * String representation of AquaticAnimal
     * @return name
     */
    abstract public String getAnimalName();

    /**
     * Stopping all instances of AquaticAnimal Movement
     */
    abstract public void setSuspend();

    /**
     * Resuming all instances of AquaticAnimal Movement
     */
    abstract public void setResume();

    /**
     * Set a CyclicBarrier for AquaticAnimal instances
     * @param b uses an all-or-none breakage model for failed synchronization attempts:
     */
    abstract public void setBarrier(CyclicBarrier b);

    /**
     * Size representation of AquaticAnimal
     * @return size
     */
    abstract public int getSize();

    /**
     * increment private field 'eatCounter' of AquaticAnimal(Fish/JellyFish)
     */
    abstract public void eatInc();

    /**
     * Receive eatCounter returned as integer
     * @return eatCount
     */
    abstract public int getEatCount();

    /**
     * Color representation by string for current instance of AquaticAnimal
     * @return color
     */
    abstract public String getColor();

    public Memento saveState() {
        return new Memento(xFront,yFront,pixelSize,color);
    }

    public void loadState(Memento state) {
        xFront = state.x;
        yFront = state.y;
        pixelSize = state.size;
        color = state.color;
    }

    @Override
    public String toString() {
        return "Swimmable Creature: " + getAnimalName() + " Color: " + getColor() + " Size: " + getSize();
    }
}
