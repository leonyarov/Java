package w2.FishController;

import w2.GUI.AnimalPanel;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public abstract class AquaAnimal extends Thread {
    protected int horizontalSpeed;
    protected int verticalSpeed;
    protected int pixelSize;
    protected Color color;
    protected AnimalPanel animalPanel;

    public AquaAnimal() {
        horizontalSpeed = 0;
        verticalSpeed = 0;
    }
    public AquaAnimal(int hor, int ver) {
        horizontalSpeed = hor;
        verticalSpeed = ver;
        color = Color.WHITE;
        Object RandomGenerator;
        pixelSize = new Random().nextInt(300) + 20;
    }

    public AquaAnimal(int h, int v, int size, Color c, AnimalPanel panel) {
        horizontalSpeed = h;
        verticalSpeed = v;
        pixelSize = size;
        color = c;
        animalPanel = panel;
    }


    public void setPixelSize(int size) {
        int min = 20, max = 320;
        pixelSize = Math.min(max, Math.max(min, size));
    }

    public void setColor(Color c) {
        color = c;
    }

    public void moveAnimal(){
        int x = animalPanel.getX();
        int y = animalPanel.getY();
        int pw = animalPanel.getParentBoundaryWidth();
        int ph = animalPanel.getParentBoundaryHeight();
        int w = animalPanel.getWidth();
        int h = animalPanel.getHeight();
        if (x + w > pw || x <= 0) horizontalSpeed = -horizontalSpeed;
        if (y + h > ph || y <= 0) verticalSpeed = -verticalSpeed;
        animalPanel.setLocation(animalPanel.getX() + horizontalSpeed, animalPanel.getY() + verticalSpeed);
    }
    public void setAnimalPanel(AnimalPanel panel) {
        animalPanel = panel;
    }
    public void Update(){
        moveAnimal();
        animalPanel.repaint();
    }
    public int getHorSpeed() { return horizontalSpeed; }
    public int getVerSpeed() { return verticalSpeed; }
    public void setHorSpeed(int hor) { horizontalSpeed = hor; }
    public void setVerSpeed(int ver) { verticalSpeed = ver; }
    abstract public String getAnimalName();
    abstract public void setSuspend();
    abstract public void setResume();
    abstract public void setBarrier(CyclicBarrier b);
    abstract public int getSize();
    abstract public void eatInc();
    abstract public int getEatCount();
    abstract public String getColor();
}
