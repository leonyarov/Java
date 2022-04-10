package w2.GUI;

import javax.swing.*;
import java.awt.*;



public class AquaBackground extends JComponent {
    private Image image;

    /**
     * Controls the background image (tank image background)
     * @param image - the image to be displayed
     */
    public AquaBackground(Image image) {
        this.image = image;
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
        if (image == null)  return;
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        JFrame root = (JFrame) SwingUtilities.getWindowAncestor(this);
        int rootWidth = root.getWidth();
        int rootHeight = root.getHeight();

        g2d.drawImage(image, 0, 0, rootWidth ,rootHeight, this);
        g2d.dispose();

    }

}
