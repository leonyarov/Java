package w3.FishController.Memento;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {

    public List<Memento> mementoList = new ArrayList<>();
    public void add(Memento state){
        mementoList.add(state);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }

}
