package w3.FishController;

import w3.Utils.FishUtils;

import java.awt.*;

public class Immobile implements SeaCreature {
    int x,y, size;
    Image image;
    Color color;
    public Immobile(int x, int y, int size, String imageLocation, Color color){
        this.x = x;
        this.y = y;
        this.image = FishUtils.getRandomImage(imageLocation, color);
        this.color = color;
    }
    public void drawCreature(Graphics g){
        if (image == null) return;
        g.drawImage(this.image, x, y, size, size, null); //draw fish
    }

    @Override
    public void setSize(int size) {

    }

    @Override
    public void set_Xfront(int xfront) {

    }

    @Override
    public void set_Yfront(int yfront) {

    }

    @Override
    public void setHorSpeed(int horSpeed) {

    }

    @Override
    public void setVerSpeed(int verSpeed) {

    }

    @Override
    public void setColor(Color color) {

    }

    @Override
    public int getEatCount() {
        return 0;
    }

    @Override
    public String getAnimalName() {
        return null;
    }

    @Override
    public void setFeed(int feed_i) {

    }
}
