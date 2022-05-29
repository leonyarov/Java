package w3.Creatures;
import w3.Utils.FishUtils;

import java.awt.*;


/**
 * This class represents Food for AquaticAnimals
 */

public class Food {
    private Image image;
    final static int FOOD_WIDTH = 20;
    private int eatRadius = 30;
    public boolean isEaten = true;
    public int xFront, yFront;
    private static Food food = null;


    private Food(){
        image = FishUtils.getRandomImage("src/w3/Assets/Food/");
    }

    public static Food getInstance(){
        if (food == null){
            food = new Food();
        }
        return food;
    }

    public void setInstance(Food instance){
        this.food = instance;
    }
    /**
     * Food addressable point on a FishTank display screen
     * @param x horizontal addressing pixel location
     * @param y vertical addressing pixel location
     */
    public void placeFood(int x, int y){
        isEaten = false;
        xFront = x;
        yFront = y;
    }

    /**
     * Draw Food on Graphics object
     * @param g Graphics object
     */
    public void draw(Graphics g) {
        g.drawImage(image, xFront, yFront, FOOD_WIDTH, FOOD_WIDTH, null);
    }

    /**
     * Determine if food and AquaticAnimal in proximity
     * @param animal AquaticAnimal Instance in FishTank
     * @return True if AquaticAnimal within acceptable proximity to consume food
     */
    public boolean isNear(Swimmable animal) {
        var x1 = animal.getCenterPointX();
        var y1 = animal.getCenterPointY();
        var x2 = xFront + FOOD_WIDTH / 2;
        var y2 = yFront + FOOD_WIDTH / 2;
        var d = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
        return d < eatRadius;
    }

}

