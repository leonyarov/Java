package w2.FishController;


import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class AquaFood extends Drawable {

    private Image image;
    final static int FOOD_WIDTH = 20;
    private int eatRadius = 30;
    public AquaFood(int x, int y){
        image = FishUtils.getRandomImage("src/w2/Assets/Food/", Color.WHITE);
        xFront = x;
        yFront = y;
    }

    @Override
    public void drawAnimal(Graphics g) {
        g.drawImage(image, xFront, yFront, FOOD_WIDTH, FOOD_WIDTH, null);
    }

    void move(){
        yFront += 1;
    }

    /*
    * @returns true if the fish ate food
     */
    public boolean isEaten(){
        var f = nearFish();
        if (f != null){
            f.eatInc();
            return true;
        }
        return  false;
    }


    public AquaAnimal nearFish() {
        for (var f : FishTank.fishes) {
            var x1 = f.getXFront() + f.pixelSize / 2;
            var y1 = f.getYFront() + f.pixelSize / 2;
            var x2 = xFront + FOOD_WIDTH / 2;
            var y2 = yFront + FOOD_WIDTH / 2;
            var d = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
            if (d < eatRadius) return f;
        }
        return null;
    }

}
