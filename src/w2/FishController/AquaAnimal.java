package w2.FishController;

import w2.GUI.AquaLabel;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public abstract class AquaAnimal extends Thread {


    protected int horizontalSpeed;
    protected int verticalSpeed;
    protected int pixelSize;
    protected Color color;
    protected AquaLabel aquaImage;

    public AquaAnimal() {
        horizontalSpeed = 0;
        verticalSpeed = 0;
    }
    public AquaAnimal(int hor, int ver) {
        horizontalSpeed = hor;
        verticalSpeed = ver;
        color = Color.WHITE;
        pixelSize = new Random().nextInt(300) + 20;
    }

    public AquaAnimal(int h, int v, int size, Color c, AquaLabel aquaImage) {
        horizontalSpeed = h;
        verticalSpeed = v;
        pixelSize = size;
        color = c;
        this.aquaImage = aquaImage;

    }


    public void setPixelSize(int size) {
        int min = 20, max = 320;
        pixelSize = Math.min(max, Math.max(min, size));
    }

    public void setColor(Color c) {
        color = c;
    }

    public void setAnimalImage(AquaLabel image) {
        aquaImage = image;
    }

    public void Update(){
        aquaImage.moveLabel(horizontalSpeed, verticalSpeed);
        if (aquaImage.isOnXBorder()) {
            horizontalSpeed = -horizontalSpeed;
            aquaImage.flipImage();
        }

        if (aquaImage.isOnYBorder()) verticalSpeed = -verticalSpeed;
        aquaImage.repaint();
    }
    public int getHorSpeed() { return horizontalSpeed; }
    public int getVerSpeed() { return verticalSpeed; }
    public void setHorSpeed(int hor) { horizontalSpeed = hor; }
    public void setVerSpeed(int ver) { verticalSpeed = ver; }
    public AquaLabel getAnimalImage() { return aquaImage; }
    abstract public String getAnimalName();
    abstract public void setSuspend();
    abstract public void setResume();
    abstract public void setBarrier(CyclicBarrier b);
    abstract public int getSize();
    abstract public void eatInc();
    abstract public int getEatCount();
    abstract public String getColor();
}
