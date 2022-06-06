package w3.Memento;

import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Providing saved sessions for SeaCreatures in the Aquarium
 to be retrieved for later applications.
 */

public class CareTaker {

    public HashMap<Originator, Stack<Memento>> mementos;

    public CareTaker() {
        this.mementos = new HashMap<>();
    }

    public void add(Originator from, Memento state){
        if(!mementos.containsKey(from))mementos.put(from, new Stack<>());
        var stack = mementos.get(from);
        stack.push(state);
    }

    public Memento get(Originator from) {
        if (noMementos(from)) return null;
        return mementos.get(from).pop();
    }

    public String getLastTime(Originator from) {
        if (noMementos(from)) return "No saved states!";
        var time = mementos.get(from).peek().time;
        return time.format(DateTimeFormatter.ofPattern("hh:mm:ss"));
    }

    public boolean noMementos(Originator from) {
        return mementos.get(from) == null || mementos.get(from).isEmpty();
    }

}
