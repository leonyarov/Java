package q3;

public class MultiColorFish extends Fish {

    public MultiColorFish() {
        super();
    }

    public MultiColorFish(int fishSize, int xFront, int yFront, int horizontalSpeed, int verticalSpeed, int fishColor) {
        super(fishSize, xFront, yFront, horizontalSpeed, verticalSpeed, fishColor);
    }

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
