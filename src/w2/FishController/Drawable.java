package w2.FishController;

import java.awt.*;

public abstract class Drawable extends Thread {
    protected Image image;
    protected int xFront;
    protected int yFront;
    protected int pixelSize;
    protected Color color;

    public Drawable() {
        super();
        start(); //start the thread
    }


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
}

