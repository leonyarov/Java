package w3.State;

import java.time.LocalTime;


/**
 * Hunger state class representation for SeaCreatures.
 */
public class Hunger  {
    public LocalTime birth;
    public int hungerTime;
    public boolean isNotified = false;
    public HungerState hungerState;


    public Hunger(int hungerTime) {
        birth  = LocalTime.now();
        this.hungerTime = hungerTime;
        hungerState = new Satiated();

    }
    public boolean isHungry() {
        return LocalTime.now().isAfter(birth.plusSeconds(hungerTime));
    }

    public void feed(){
        isNotified = false;
        birth = LocalTime.now();
    }

    public int gethungerTime(){
        return this.hungerTime;
    }
    public void setState(HungerState state){
        hungerState = state;
    }

}
