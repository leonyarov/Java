package w3.GUI;

import w3.Creatures.FishTank;
import w3.Creatures.Food;

import javax.swing.*;
import java.awt.*;


public class AquaBackground extends JPanel implements Runnable {
    private static boolean shouldNotifyHunger = false;
    private Image image;
    private FishTank fishTank;
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
        fishTank = new FishTank();
        setDoubleBuffered(true);
    }

    public static boolean isShouldNotifyHunger() {
        return shouldNotifyHunger;
    }

    public static void setShouldNotifyHunger(boolean shouldNotifyHunger) {
        AquaBackground.shouldNotifyHunger = shouldNotifyHunger;
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

        //Draw aquarium background
        if (image != null) g.drawImage(image, 0, 0, getWidth(), getHeight(), this);

        //Draw alert if fish is hungry
        if (isShouldNotifyHunger()) {
            g.setFont(g.getFont().deriveFont(Font.BOLD, 20));
            g.setColor(Color.RED);
            g.drawString("A Fish Is Hungry!", getWidth() / 2 - 100, getHeight() / 2);
        }

        //Draw sea cratures
        for (var fish : FishTank.getInstance().seaCreatures)
            fish.drawCreature(g);
        if (!Food.getInstance().isEaten)
            Food.getInstance().draw(g);

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
