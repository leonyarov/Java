package w2.GUI;

import w2.FishController.FishUtils;

import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class AquaBackground extends JPanel {
    private Image image;

    /**
     * Controls the background image (tank image background)
     * @param image - the image to be displayed
     */
    public AquaBackground(Image image) {
        this.image = image;
    }

    public AquaBackground() {
        image = null;
        setLayout(null);
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
     * Called by .repaint()
     * @param g - graphics object
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image == null)  return;
        Graphics2D g2d = (Graphics2D) g.create();

        g2d.drawImage(image, 0, 0, getWidth() ,getHeight(), this);
        g2d.dispose();

        getParent().repaint();
    }

}
