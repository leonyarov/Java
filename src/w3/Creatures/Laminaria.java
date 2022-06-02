package w3.Creatures;

import w3.Utils.FishUtils;

import java.awt.Color;


/**
 * Belongs to the Abstract Factory DP.
   SeaPlant Laminaria.
 */
public class Laminaria extends Immobile {
    public Laminaria(int x, int y, int size, Color color) {
        super(x, y, size, FishUtils.laminariaLibrary, color);
    }

    public Laminaria(){
        this(0, 0, 30, Color.WHITE);
    }
}

