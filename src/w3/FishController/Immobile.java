package w3.FishController;

import w3.Utils.FishUtils;

import java.awt.*;

public abstract class Immobile implements SeaCreature {
    int x,y, size;
    Image image;
    Color color;
    public Immobile(int x, int y, int size, String imageLocation, Color color){
        this.x = x;
        this.y = y;
        this.size = size;
        this.image = FishUtils.getRandomImage(imageLocation, color);
        this.color = color;
    }
    public void drawCreature(Graphics g){
        if (image == null) return;
        g.drawImage(this.image, x, y, size, size, null); //draw fish
    }
}
