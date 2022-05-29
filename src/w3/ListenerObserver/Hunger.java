package w3.ListenerObserver;

import java.time.LocalTime;

public class Hunger  {
    public LocalTime birth;
    public int hungerTime;
    public boolean isNotified = false;

    public Hunger(int hungerTime) {
        birth  = LocalTime.now();
        this.hungerTime = hungerTime;
    }
    public boolean isHungry() {
        return LocalTime.now().isAfter(birth.plusSeconds(hungerTime));
    }

    public void feed(){
        isNotified = false;
        birth = LocalTime.now();
    }
}
