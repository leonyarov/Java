package q3;

public abstract class Swimmable implements Comparable<Swimmable> {
    protected int horSpeed;
    protected int verSpeed;


    public Swimmable() {
        this.horSpeed = 0;
        this.verSpeed = 0;
    }

    public Swimmable(int hS , int vS) {
        this.horSpeed = hS;
        this.verSpeed = vS;
    }

    public int getHorSpeed(){ return horSpeed; }
    public void setHorSpeed(int hS) {  horSpeed = hS; }
    public void setVerSpeed(int vS) { verSpeed = vS; }
    public int getVerSpeed(){ return verSpeed; }
    public abstract String getAnimalName();
    public abstract int getEatCount();
    public abstract int getSize();
    public abstract String getColor();
    public abstract int eatInc();

    @Override
    public String toString() {
        return String.format("%-13s\t%-13s\t%d\t%d",getAnimalName(),getColor(), getSize() ,getEatCount());
    }
}
