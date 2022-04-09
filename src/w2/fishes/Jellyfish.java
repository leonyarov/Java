package w2.fishes;

import java.util.Objects;

//Leon Yarovinski: 206817181
//Alon Yehuda Levi: 209614288



public class Jellyfish extends Swimmable {
    private final int EAT_DISTANCE = 4;
    private int size;
    private int eatCount;
    private int col;
    private int x_front, y_front, x_dir, y_dir;

    /**
     * Default constructor for 'Jellyfish' Class
     */
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

    /**
     * Jellyfish constructor with parameters
     *
     * @param JellyfishSize        size of the Jellyfish
     * @param xFront          x coordinate of the front of the Jellyfish
     * @param yFront          y coordinate of the front of the Jellyfish
     * @param horizontalSpeed horizontal speed of the Jellyfish
     * @param verticalSpeed   vertical speed of the Jellyfish
     * @param fishColor       color of the Jellyfish
     */
    public Jellyfish(int JellyfishSize, int xFront, int yFront, int horizontalSpeed, int verticalSpeed, int fishColor) {
        super(horizontalSpeed, verticalSpeed);
        this.eatCount = 0;
        this.x_dir = 1;
        this.y_dir = 1;
        this.size = JellyfishSize;
        this.col = fishColor;
        this.y_front = yFront;
        this.x_front = xFront;
    }

    /**
     * Copy-constructor for class 'Jellyfish'
     * @param jellyfish class 'Jellyfish' object
     */
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

    /**
     * sets inner-field 'x_front' in 'Jellyfish'
     * @param jellyfish class 'Jellyfish' object
     */
    public void setx_front(Jellyfish jellyfish){
        this.x_front = jellyfish.getx_front();
    }

    /**
     * Retrieve inner-field 'x_front of 'Jellyfish'
     */
    public int getx_front(){
        return this.x_front;
    }

    /**
     * sets inner-field 'y_front' in 'Jellyfish'
     * @param jellyfish class 'Jellyfish' object
     */
    public void sety_front(Jellyfish jellyfish){
        this.y_front = jellyfish.gety_front();
    }

    /**
     * Retrieve inner-field 'y_front of 'Jellyfish'
     */
    public int gety_front(){
        return this.y_front;
    }

    /**
     * sets inner-field 'x_dir' in 'Jellyfish'
     * @param jellyfish class 'Jellyfish' object
     */
    public void setx_dir(Jellyfish jellyfish){
        this.x_dir = jellyfish.getx_dir();
    }

    /**
     * Retrieve inner-field 'x_dir of 'Jellyfish'
     */
    public int getx_dir(){
        return this.x_dir;
    }

    /**
     * sets inner-field 'y_dir' in 'Jellyfish'
     * @param jellyfish class 'Jellyfish' object
     */
    public void sety_dir(Jellyfish jellyfish){
        this.y_dir = jellyfish.gety_dir();
    }
    /**
     * Retrieve inner-field 'y_dir of 'Jellyfish'
     */
    public int gety_dir(){
        return this.y_dir;
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
        //make array of colors from switch below
        String[] colors = {"Black", "Red", "Blue", "Green", "Cyan", "Orange", "Yellow", "Magenta", "Pink"};
        if (this.col >= colors.length) return "Unknown";
        return colors[this.col];
    }

    /**
     * Retrieve inner-field 'color of 'Jellyfish'
     */
    public int getCol() {return col;}

    @Override
    public int eatInc() {
        return 0;
    }

    /**
     * Changes the inner-field 'size' of object 'Jellyfish'
     * @param size integer value representing 'size' for class 'Jellyfish'
     */
    public void changeJellyFish(int size) {
        this.size = size;
    }

    @Override
    public int compareTo(Swimmable swimmable) {
        return Integer.compare(swimmable.getSize(), size);
    }

    /**
     * Equality determination for 2 'Fish' objects
     * @param jellyfish class 'Jellyfish' object
     * @return true or false if all object 'Fish' inner-fields equal and point to the same adress
     */
    public boolean equals(Jellyfish jellyfish){
        return super.equals(jellyfish) && Objects.equals(this.getColor(), jellyfish.getColor()) && this.size == jellyfish.getSize() && this.eatCount == jellyfish.getEatCount() && this.x_front == jellyfish.getx_front() && this.x_dir == jellyfish.getx_dir() && this.y_front == jellyfish.gety_front() && this.y_dir == jellyfish.gety_dir();
    }
    @Override
    public String toString() {
        return super.toString();

    }
}


