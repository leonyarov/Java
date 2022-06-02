package w3.Memento;

import java.awt.*;
import java.time.LocalTime;


/**
 * Memento DP implementation to secure saved state of existing SeaCreature.
 */
public class Memento {

    public int x,y,size;
    public Color color;
    public LocalTime time;

    public Memento(int x, int y, int size, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
        time = LocalTime.now();
    }

}
