package q3;

public class Fish extends Swimmable {
    private final int EAT_DISTANCE = 4;
    private int size;
    private int eatCount;
    private int col;
    private int x_front, y_front, x_dir, y_dir;


    /**
     * Fish constructor
     * @param fishSize size of the fish
     * @param xFront x coordinate of the front of the fish
     * @param yFront y coordinate of the front of the fish
     * @param horizontalSpeed  horizontal speed of the fish
     * @param verticalSpeed vertical speed of the fish
     * @param fishColor color of the fish
     */
    public Fish(int fishSize, int xFront, int yFront, int horizontalSpeed, int verticalSpeed, int fishColor){
        super(horizontalSpeed,verticalSpeed);
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
        return "Fish";
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
    public int eatInc(){
        return ++eatCount;
    }

    @Override
    public String getColor(){
        String color = "None";
        switch (col) {
            case 1: return "Black";
            case 2: return "Red";
            case 3: return "Blue";
            case 4: return "Green";
            case 5: return "Cyan";
            case 6: return "Orange";
            case 7: return "Yellow";
            case 8: return "Magenta";
            case 9: return "Pink";
            default: return color;
        }
    }

    public void changeFish(int sz){ size = sz;}
    public void changeColor(){ this.col = ((this.col + 1) % 10) + 1;}
    @Override
    public int compareTo(Swimmable swimmable) {
        return Integer.compare(swimmable.getSize(), size);
    }
}
