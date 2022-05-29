package w3.ListenerObserver;
import java.util.ArrayList;
import java.util.List;
import w3.ListenerObserver.Observer;


public interface Subject {
    List<Observer> observers = new ArrayList<Observer>();

    public boolean getStatus();
    public void setState(boolean state);
    public void attach(Observer observer);
    public void notifyAllObservers();
}
