package w2.GUI;

import w2.FishController.FishTank;
import w2.FishController.FishUtils;

import javax.swing.*;
import java.awt.*;


public class AquaBackground extends JPanel {
    private Image image;
    Thread t;

    /**
     * Controls the background image (tank image background)
     * @param image - the image to be displayed
     */
    public AquaBackground(Image image) {
        this.image = image;
    }

    public AquaBackground() {
        image = null;
        setLayout(null); //make fish move freely
//        setDoubleBuffered(true); //double buffering to make the fish move smoothly

         t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        repaint();
                        Thread.sleep(16);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();
    }

    /**
     * Set new background image
     * @param image - image to set
     */
    public void setImage(Image image) {
        if (this.image != null) this.image.flush();
        this.image = image;
    }

    public void setColor(Color color) {
        setImage(null);
        setBackground(color);
    }

    /**
     * Called by .repaint()
     * @param g - graphics object
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        FishTank.getInstance().Update(g);

    }

}
