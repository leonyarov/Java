package w2.FishController;


import java.awt.*;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public abstract class AquaAnimal extends Thread {

    protected int horizontalSpeed;
    protected int verticalSpeed;
    CyclicBarrier barrier;
    public boolean isSuspended = false;
    protected Image image;
    protected int xFront;
    protected int yFront;
    protected int pixelSize;
    protected Color color;

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
        var f = FishTank.getInstance().food;
            if (!f.isEaten){

//                try { barrier.await();}
//                catch (Exception e){ return; }

                if (xFront > f.xFront) xFront -= Math.abs(horizontalSpeed);
                else xFront += Math.abs(horizontalSpeed);

                if (yFront > f.yFront) yFront -= Math.abs(verticalSpeed);
                else yFront += Math.abs(verticalSpeed);

                if (f.isNear(this)) {
                    eatInc();
                    FishTank.getInstance().food.isEaten = true;
                }
                return;
            }
            xFront += horizontalSpeed;
            yFront += verticalSpeed;
    }
    public int getXFront() { return xFront; }
    public int getYFront() { return yFront; }



    public boolean isOnXBorder(Graphics g) {
        return xFront + pixelSize >= g.getClipBounds().width || xFront <= 0;
    }

    public boolean isOnYBorder(Graphics g) {
        return yFront + pixelSize >= g.getClipBounds().height || yFront <= 0;
    }


    public void flipImage() {
        var i = FishUtils.imageToBufferedImage(image);
        var b = FishUtils.flipVertical(i);
        setImage(b);
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setColor(Color c) {
        color = c;
    }

    abstract public void drawAnimal(Graphics g);

    abstract public String getAnimalName();
    abstract public void setSuspend();
    abstract public void setResume();
    abstract public void setBarrier(CyclicBarrier b);
    abstract public int getSize();
    abstract public void eatInc();
    abstract public int getEatCount();
    abstract public Color getColor();

}
