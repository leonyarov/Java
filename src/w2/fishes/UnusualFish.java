package w2.fishes;

//Leon Yarovinski: 206817181
//Alon Yehuda Levi: 209614288


public class UnusualFish extends Fish {
    private int factor;

    /**
     * Default constructor for 'Unusual fish' Class
     */
    public UnusualFish(){
        super();
        this.factor = 0;
    }

    /**
     * UnusualFish constructor with parameters
     *
     * @param fishSize        size of the 'Unusual fish'
     * @param xFront          x coordinate of the front of the 'Unusual fish'
     * @param yFront          y coordinate of the front of the 'Unusual fish'
     * @param horizontalSpeed horizontal speed of the 'Unusual fish'
     * @param verticalSpeed   vertical speed of the 'Unusual fish'
     * @param fishColor       color of the 'Unusual fish'
     */
    public UnusualFish(int fishSize, int xFront, int yFront, int horizontalSpeed, int verticalSpeed, int fishColor, int factor){
        super(fishSize,xFront,yFront,horizontalSpeed,verticalSpeed,fishColor);
        this.factor = factor;
    }

    /**
     * Copy-constructor for class 'UnusualFish'
     * @param unusualFish class 'Fish' object
     */
    public UnusualFish(UnusualFish unusualFish){
        super(unusualFish);
        setFactor(unusualFish.getFactor());
    }

    /**
     * Retrieve inner-field 'Factor 'UnusualFish'
     */
    public int getFactor() { return factor; }

    /**
     * Sets the inner-field value of 'factor' in class 'UnusualFish'
     * @param fact - primitive integer
     */
    public boolean setFactor(int fact) { return (factor = fact) == fact; }

    @Override
    public int getSize() {
        return super.getSize()*factor;
    }

    @Override
    public String getAnimalName(){
        return this.getClass().getSimpleName();
    }

    /**
     * Equality determination for 2 'Fish
     * @param unusualFish class 'UnusualFish' object
     * @return true or false if all object 'UnusualFish' inner-fields equal and point to the same address
     */
    public boolean equals(UnusualFish unusualFish){
        return super.equals(unusualFish) && this.factor == unusualFish.getFactor();
    }
    @Override
    public String toString() {
        return super.toString();

    }
}
