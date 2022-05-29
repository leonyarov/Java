package w3.GUI;

import w3.Creatures.FishTank;
import javax.swing.*;
import java.awt.*;


public class AquaBackground extends JPanel implements Runnable {
    public static boolean shouldNotifyHunger = false;
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
    }

    /**
     * Set new background image
     * @param image - image to set
     */
    public void setImage(Image image) {
        if (this.image != null) this.image.flush();
        this.image = image;
    }

    /**
     * Set new image color
     * @param color - color to apply
     */
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
        if (shouldNotifyHunger) {
            g.setFont(g.getFont().deriveFont(Font.BOLD, 20));
            g.setColor(Color.RED);
            g.drawString("A Fish Is Hungry!", getWidth() / 2 - 100, getHeight() / 2);
        }

        for (var fish : FishTank.getInstance().seaCreatures)
            fish.drawCreature(g);
        if (!FishTank.getInstance().food.isEaten)
            FishTank.getInstance().food.draw(g);

    }

    @Override
    synchronized public void run() {
        while (true) {
            try {
                repaint();
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
