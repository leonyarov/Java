package q3;

public class MultiColorFish extends Fish {

    /**
     * Default constructor for MultiColorFish
     */
    public MultiColorFish() {
        super();
    }

    /**
     * MultiColorFish constructor with parameters
     *
     * @param fishSize size of the MulticolorFish
     * @param xFront x coordinate of the front of the MulticolorFish
     * @param yFront y coordinate of the MulticolorFish
     * @param horizontalSpeed horizontal speed  of the MulticolorFish
     * @param verticalSpeed vertical speed of the MulticolorFish
     * @param fishColor color of the MulticolorFish
     */
    public MultiColorFish(int fishSize, int xFront, int yFront, int horizontalSpeed, int verticalSpeed, int fishColor) {
        super(fishSize, xFront, yFront, horizontalSpeed, verticalSpeed, fishColor);
    }

    /**
     * Copy constructor of class 'MultiColorFish'
     * @param multiFish - multiple color fish extended from base class 'Fish'
     */
    public MultiColorFish(MultiColorFish multiFish) {
        super(multiFish);
    }

    @Override
    public void changeFish(int size) {
        super.changeFish(size);
        super.changeColor();
    }

    @Override
    public String getAnimalName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return super.toString();

    }
}
