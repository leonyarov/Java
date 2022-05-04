package w2.FishController;


import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class AquaFood  {

    private Image image;
    final static int FOOD_WIDTH = 20;
    private int eatRadius = 30;
    public boolean isEaten = true;
    public int xFront, yFront;

    public AquaFood(){
        image = FishUtils.getRandomImage("src/w2/Assets/Food/", Color.WHITE);
    }

    public void placeFood(int x, int y){
        isEaten = false;
        xFront = x;
        yFront = y;
    }

    public void draw(Graphics g) {
        g.drawImage(image, xFront, yFront, FOOD_WIDTH, FOOD_WIDTH, null);
    }

    public boolean isNear(AquaAnimal animal) {
        var x1 = animal.getXFront() + animal.pixelSize / 2;
        var y1 = animal.getYFront() + animal.pixelSize / 2;
        var x2 = xFront + FOOD_WIDTH / 2;
        var y2 = yFront + FOOD_WIDTH / 2;
        var d = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
        return d < eatRadius;
    }

}
