package w3.FishController;

import java.awt.*;

public class AquaPlant {
    int x,y, size;
    Image image;
    Color color;
    public AquaPlant(int x, int y, int size, String imageLocation, Color color){
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
