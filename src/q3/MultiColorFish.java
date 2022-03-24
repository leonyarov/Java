package q3;

public class MultiColorFish extends Fish {

    public MultiColorFish(int fishSize, int xFront, int yFront, int horizontalSpeed, int verticalSpeed, int fishColor){
        super(fishSize,xFront,yFront,horizontalSpeed,verticalSpeed,fishColor);
    }

    @Override
    public void changeFish(int size){
        super.changeFish(size);
        super.changeColor();
    }

    @Override
    public String getAnimalName(){
        return this.getClass().getSimpleName();
    }

}
