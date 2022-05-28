package w3.FishController;

import w3.Utils.FishUtils;

import java.awt.Color;

public class Zostera extends Immobile {
    public Zostera(int x, int y, int size, Color color) {
        super(x, y, size, FishUtils.zosteraLibrary, color);
    }
}
