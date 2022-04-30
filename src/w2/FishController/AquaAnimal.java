package w2.FishController;


import java.awt.*;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public abstract class AquaAnimal extends Drawable {
    protected int horizontalSpeed;
    protected int verticalSpeed;
    CyclicBarrier barrier;
    public boolean isSuspended = false;
    public AquaAnimal() {
        horizontalSpeed = 0;
        verticalSpeed = 0;
    }

    @Override
     public void run() {
        super.run();
            while (true) {
                moveAnimal();
                try {
                    if (isSuspended){
                        synchronized (this) {
                            wait();
                        }
                    }
                    Thread.sleep(16);
                } catch (InterruptedException e) {
                    //interrupted
                }
            }
    }

    public AquaAnimal(int hor, int ver) {
        horizontalSpeed = hor;
        verticalSpeed = ver;
        color = Color.WHITE;
        pixelSize = new Random().nextInt(300) + 20;
    }

    public AquaAnimal(int h, int v, int size, Color c, Image animalImage) {
        super();
        horizontalSpeed = h;
        verticalSpeed = v;
        pixelSize = size;
        color = c;
        this.image = animalImage;
        xFront = 100;
        yFront = 100;
        moveAnimal();
    }

    public void setPixelSize(int size) {
        int min = 20, max = 320;
        pixelSize = Math.min(max, Math.max(min, size));
    }



    public int getHorSpeed() { return horizontalSpeed; }
    public int getVerSpeed() { return verticalSpeed; }
    public void setHorSpeed(int hor) { horizontalSpeed = hor; }
    public void setVerSpeed(int ver) { verticalSpeed = ver; }
    public Image getAnimalImage() { return image; }
    protected synchronized void moveAnimal(){
        var f = FishTank.food;
            if (f != null){

                try { barrier.await();}
                catch (Exception e){ return; }

                if (xFront > f.xFront) xFront -= Math.abs(horizontalSpeed);
                else xFront += Math.abs(horizontalSpeed);

                if (yFront > f.yFront) yFront -= Math.abs(verticalSpeed);
                else yFront += Math.abs(verticalSpeed);

                if (f.isNear(this)) {
                    eatInc();
                    FishTank.food = null;
                }
            }
            xFront += horizontalSpeed;
            yFront += verticalSpeed;
    }
    public int getXFront() { return xFront; }
    public int getYFront() { return yFront; }


    abstract public String getAnimalName();
    abstract public void setSuspend();
    abstract public void setResume();
    abstract public void setBarrier(CyclicBarrier b);
    abstract public int getSize();
    abstract public void eatInc();
    abstract public int getEatCount();
    abstract public Color getColor();

}
