package w3.FishController;

import w3.Utils.FishUtils;

import java.awt.Color;

public class Laminaria extends Immobile {
    public Laminaria(int x, int y, int size, Color color) {
        super(x, y, size, FishUtils.laminariaLibrary, color);
    }
}

