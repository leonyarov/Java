package w3.ListenerObserver;


public interface HungrySubject {

    public boolean getHungerStatus();
    public boolean isHungry();
    public void setFed();
    public void attach(HungerObserver observer);
    public void notifyAllObservers();
}
