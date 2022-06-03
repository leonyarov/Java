package w3.State;

public class Satiated implements HungerState {

    @Override
    public void changeHungerState(Hunger hunger) {
            hunger.setState(this);
            hunger.feed();
    }

    @Override
    public String toString() {
        return "Satiated";
    }
}
