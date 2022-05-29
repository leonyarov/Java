package w3.Creatures;

import w3.Memento.Memento;
import w3.Memento.Originator;
import w3.Utils.FishUtils;

import java.awt.*;

public abstract class Immobile implements SeaCreature, Originator {
    int x,y, size;
    Image image;
    Color color;
    public Immobile(int x, int y, int size, String imageLocation, Color color){
        this.x = x;
        this.y = y;
        this.size = size;
        this.image = FishUtils.getRandomImage(imageLocation);
        this.color = color;
    }
    public void drawCreature(Graphics g){
        if (image == null) return;
        g.drawImage(this.image, x, y, size, size, null); //draw fish
    }

    public Memento saveState() {
        return new Memento(x,y,size,Color.GREEN);
    }

    public void loadState(Memento state) {
        x = state.x;
        y = state.y;
        size = state.size;
        color = Color.GREEN;
    }

    @Override
    public String toString() {
        return "Immoble creature: Plant" + " Size: " + size;
    }
}
