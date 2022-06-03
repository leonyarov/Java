package w3.ListenerObserver;


/**
 * Implementation of Hunger methods to all SeaCreatures listeners.
 */
public interface HungrySubject {

    public void checkHungerStatus();
    public boolean isHungry();
    public void setFed();
    public void attach(HungerObserver observer);
    public void notifyAllObservers();
}
