package q3;

public class UnusualFish extends Fish {
    private int factor;

    public UnusualFish(){
        super();
        this.factor = 0;
    }
    public UnusualFish(int fishSize, int xFront, int yFront, int horizontalSpeed, int verticalSpeed, int fishColor, int factor){
        super(fishSize,xFront,yFront,horizontalSpeed,verticalSpeed,fishColor);
        this.factor = factor;
    }

    public UnusualFish(UnusualFish unusualFish){
        super(unusualFish);
        setFactor(unusualFish.getFactor());
    }

    public int getFactor() { return factor; }
    public void setFactor(int fact) { factor = fact; }

    @Override
    public int getSize() {
        return super.getSize()*factor;
    }

    @Override
    public String getAnimalName(){
        return this.getClass().getSimpleName();
    }

    public boolean equals(UnusualFish unusualFish){
        return super.equals(unusualFish) && this.factor == unusualFish.getFactor();
    }
    @Override
    public String toString() {
        return super.toString();

    }
}
