package w3.State;

public class Hungry implements HungerState {

    @Override
    public void changeHungerState(Hunger hunger) {
        hunger.setState(this);
        hunger.isNotified = false;
    }

    @Override
    public String toString() {
        return "Hungry";
    }
}
