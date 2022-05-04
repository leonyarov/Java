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
//                    if (isSuspended)
//                        synchronized (this) {
//                            wait();
//                        }
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
        start();
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

                try { barrier.await();}
                catch (Exception e){ return; }

                if (getCenterPointX() > f.xFront && horizontalSpeed > 0){
                    flipImage();
                    horizontalSpeed = -horizontalSpeed;
                }
                if (getCenterPointX() < f.xFront && horizontalSpeed < 0){
                    flipImage();
                    horizontalSpeed = -horizontalSpeed;
                }

                if (getCenterPointY() > f.yFront && verticalSpeed > 0) verticalSpeed = -verticalSpeed;
                if (getCenterPointY() < f.yFront && verticalSpeed < 0) verticalSpeed = -verticalSpeed;

//                if (Math.abs(getCenterPointX() - f.xFront) < 5) xSpeed = 0;
//                if (Math.abs(getCenterPointY() - f.yFront) < 5) ySpeed = 0;

                if (f.isNear(this)) {
                    eatInc();
                    FishTank.getInstance().food.isEaten = true;
                }
            }
            xFront += horizontalSpeed;
            yFront += verticalSpeed;
            //clear system console
            System.out.print("\033[H\033[2J");
            //print speed
            System.out.println("H: " + horizontalSpeed + " V: " + verticalSpeed);


    }
    public int getXFront() { return xFront; }
    public int getYFront() { return yFront; }



    public boolean isOnXBorder(Graphics g) {
        return xFront + pixelSize >= g.getClipBounds().width || xFront <= 0;
    }

    public boolean isOnYBorder(Graphics g) {
        return yFront + pixelSize >= g.getClipBounds().height || yFront <= 0;
    }

    public int getCenterPointX(){
        return xFront + pixelSize/2;
    }
    public int getCenterPointY(){
        return yFront + pixelSize/2;
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
