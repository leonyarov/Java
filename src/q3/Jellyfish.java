package q3;

import java.util.Objects;

public class Jellyfish extends Swimmable {
    private final int EAT_DISTANCE = 4;
    private int size;
    private int eatCount;
    private int col;
    private int x_front, y_front, x_dir, y_dir;

    public Jellyfish(){
        super();
        this.size = 0;
        this.eatCount = 0;
        this.col = 0;
        this.x_dir = 0;
        this.x_front = 0;
        this.y_dir = 0;
        this.y_front = 0;
    }

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

    public Jellyfish(Jellyfish jellyfish){
        super(jellyfish);
        this.size = jellyfish.getSize();
        this.eatCount = jellyfish.getEatCount();
        this.x_front = jellyfish.getx_front();
        this.y_front = jellyfish.gety_front();
        this.x_dir = jellyfish.getx_dir();
        this.y_dir = jellyfish.gety_dir();
        this.col = jellyfish.getCol();
    }

    public void setx_front(Jellyfish jellyfish){
        this.x_front = jellyfish.getx_front();
    }

    public int getx_front(){
        return this.x_front;
    }

    public void sety_front(Jellyfish jellyfish){
        this.y_front = jellyfish.gety_front();
    }

    public int gety_front(){
        return this.y_front;
    }

    public void setx_dir(Jellyfish jellyfish){
        this.x_dir = jellyfish.getx_dir();
    }

    public int getx_dir(){
        return this.x_dir;
    }

    public void sety_dir(Jellyfish jellyfish){
        this.y_dir = jellyfish.gety_dir();
    }

    public int gety_dir(){
        return this.y_dir;
    }
    /**
     * Gets the animals name
     * @return Jellyfish name
     */
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
        switch (this.col) {
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
                return "Unknown";
        }
    }
    
    public int getCol() {return col;}
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

    public boolean equals(Jellyfish jellyfish){
        return super.equals(jellyfish) && Objects.equals(this.getColor(), jellyfish.getColor()) && this.size == jellyfish.getSize() && this.eatCount == jellyfish.getEatCount() && this.x_front == jellyfish.getx_front() && this.x_dir == jellyfish.getx_dir() && this.y_front == jellyfish.gety_front() && this.y_dir == jellyfish.gety_dir();
    }
    @Override
    public String toString() {
        return super.toString();

    }
}


