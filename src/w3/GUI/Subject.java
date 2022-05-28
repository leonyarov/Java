package w3.GUI;
import java.util.ArrayList;
import java.util.List;
import w3.GUI.Observer;


public interface Subject {
    List<Observer> observers = new ArrayList<Observer>();

    public boolean getStatus();
    public void setState(boolean state);
    public void attach(Observer observer);
    public void notifyAllObservers();
}
