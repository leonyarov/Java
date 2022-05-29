package w3.FishController.Memento;

import java.awt.*;

public class Originator {
    public int x,y,size;
    public Color color;

    public Memento makeMemento(){
        return new Memento(x,y,size,color);
    }

    public void getStateFromMemento(Memento Memento){
        this.x = Memento.x;
        this.y = Memento.y;
        this.size = Memento.size;
        this.color = Memento.color;
    }
}
