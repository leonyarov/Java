package w3.FishController;

import w3.Utils.FishUtils;

import java.awt.*;

public class Immobile {
    int x,y, size;
    Image image;
    Color color;
    public Immobile(int x, int y, int size, String imageLocation, Color color){
        this.x = x;
        this.y = y;
        this.image = FishUtils.getRandomImage(imageLocation, color);
        this.color = color;
    }
    public void draw(Graphics g){
        if (image == null) return;
        g.drawImage(this.image, x, y, size, size, null); //draw fish
    }
}
