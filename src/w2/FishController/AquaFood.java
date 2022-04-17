package w2.FishController;

import w2.GUI.AquaLabel;

import javax.swing.*;

public class AquaFood extends AquaLabel {

    final static int FOOD_WIDTH = 20;
    private static final Icon img = new ImageIcon("src/w2/Assets/food.png");
    public AquaFood(int x, int y){
        super(img, x, y, FOOD_WIDTH);
    }
}
