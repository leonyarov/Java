package w3.ListenerObserver;
import java.util.ArrayList;
import java.util.List;


public interface ObserverSubject {

    List<Observer> observers = null;

    public boolean getStatus();
    public void setState(boolean state);
    public void attach(Observer observer);
    public void notifyAllObservers();
}
