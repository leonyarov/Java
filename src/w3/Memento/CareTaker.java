package w3.Memento;

import java.util.ArrayList;
import java.util.List;

/**
 * Providing saved sessions for SeaCreatures in the Aquarium
 to be retrieved for later applications.
 */

public class CareTaker {

    public List<Memento> mementoList = new ArrayList<>();
    public void add(Memento state, int index){
        if (index < 0 || index >= mementoList.size())  mementoList.add(state);
        else mementoList.set(index, state);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }

}
