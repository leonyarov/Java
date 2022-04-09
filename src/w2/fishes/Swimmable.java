package w2.fishes;

//Leon Yarovinski: 206817181
//Alon Yehuda Levi: 209614288


public abstract class Swimmable extends Thread implements Comparable<Swimmable> {
    protected int horSpeed;
    protected int verSpeed;


    /**
     * Default constructor of class {@link Swimmable}
     */
    public Swimmable() {
        this.horSpeed = 0;
        this.verSpeed = 0;
    }

    /**
     * Constructor with inputted parameters
     * @param hS Horizontal Speed for class 'Swimmable'
     * @param vS Vertical Speed for class 'Swimmable'
     */
    public Swimmable(int hS , int vS) {
        this.horSpeed = hS;
        this.verSpeed = vS;
    }

    /**
     * Copyconstructor for class 'Swimmable'
     * @param swimmable object of class 'Swimmable' representation for aquatic animals
     */
    public Swimmable(Swimmable swimmable){
        setHorSpeed(swimmable.getHorSpeed());
        setVerSpeed(swimmable.getVerSpeed());
    }

    /**
     * Returns inner-field 'horSpeed' of class 'Location'
     */
    public int getHorSpeed(){ return horSpeed; }

    /**
     * set inner-field 'horSpeed' of class 'Swimmable'
     * @param hS Horizontal Speed for class 'Swimmable'
     */
    public void setHorSpeed(int hS) {  horSpeed = hS; }

    /**
     * set inner-field 'verSpeed' of class 'Swimmable'
     * @param vS Vertical Speed for class 'Swimmable'
     */
    public void setVerSpeed(int vS) { verSpeed = vS; }
    /**
     * Returns inner-field 'verSpeed' of class 'Location'
     */
    public int getVerSpeed(){ return verSpeed; }

    /**
     * Animal name for 'Swimmable' class
     * @return String representation for animal name in of class 'Swimmable'
     */
    public abstract String getAnimalName();

    /**
     * <b>Returns</b> eatCount of 'Swimmable' object
     */
    public abstract int getEatCount();

    /**
     * <b>Returns</b> Size of 'Swimmable' object
     */
    public abstract int getSize();

    /**
     * <b>Abstract function:</b>
     * @return eye color of 'Swimmable' object
     */
    public abstract String getColor();

    /**
     * Increases the eatCount of 'Swimmable' object
     */
    public abstract int eatInc();

    /**
     * 'Swimmable' object in String representation form
     */
    public String toString() {
        return String.format("%-13s\t%-13s\t%d\t%d",getAnimalName(),getColor(), getSize() ,getEatCount());
    }

    /**
     * Equality determination for 2 'Swimmable' objects horizontal and vertical speeds
     * @param swimmable object of class 'Swimmable' representation for aquatic animals
     * @return true or false vertical and horizontal speeds of objects match
     */
    public boolean equals(Swimmable swimmable){
        return this.horSpeed == swimmable.getHorSpeed() && this.verSpeed == swimmable.getVerSpeed() ;
    }

}
