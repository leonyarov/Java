package q3;

public class Jellyfish extends Swimmable {
    private final int EAT_DISTANCE = 4;
    private int size;
    private int eatCount;
    private int col;
    private int x_front, y_front, x_dir, y_dir;

    public Jellyfish(int fishSize, int xFront, int yFront, int horizontalSpeed, int verticalSpeed, int fishColor) {
        super(horizontalSpeed, verticalSpeed);
        this.eatCount = 0;
        this.x_dir = 1;
        this.y_dir = 1;
        this.size = fishSize;
        this.col = fishColor;
        this.y_front = yFront;
        this.x_front = xFront;
    }

    @Override
    public String getAnimalName() {
        return "Jellyfish";
    }

    @Override
    public int getEatCount() {
        return eatCount;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String getColor() {
        String color = "None";
        switch (col) {
            case 1:
                return "Black";
            case 2:
                return "Red";
            case 3:
                return "Blue";
            case 4:
                return "Green";
            case 5:
                return "Cyan";
            case 6:
                return "Orange";
            case 7:
                return "Yellow";
            case 8:
                return "Magenta";
            case 9:
                return "Pink";
            default:
                return color;
        }
    }

    @Override
    public int eatInc() {
        return 0;
    }

    public void changeJellyFish(int sz) {
        size = sz;
    }

    @Override
    public int compareTo(Swimmable swimmable) {
        return Integer.compare(swimmable.getSize(), size);
    }
}


