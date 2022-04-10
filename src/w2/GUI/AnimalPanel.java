package w2.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class AnimalPanel extends JPanel {

    String pathToImage;
    public AnimalPanel(String pathToImage) {
        this.pathToImage = pathToImage;

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon(pathToImage).getImage(), 0, 0, getWidth(),getHeight(),this);
    }

    public int getParentBoundaryWidth(){
        return getParent().getWidth();
    }
    public int getParentBoundaryHeight(){
        return getParent().getHeight();
    }

}
