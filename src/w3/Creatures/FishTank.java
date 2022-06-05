package w3.Creatures;

import w3.GUI.AquaBackground;
import w3.ListenerObserver.HungerObserver;
import w3.ListenerObserver.HungrySubject;
import w3.Memento.CareTaker;
import w3.State.Hungry;

import javax.swing.*;
import java.util.HashSet;
import java.util.concurrent.CyclicBarrier;

/**
 * This class represents a fish tank.
 * It contains a set of swimmable objects.
 */
public class FishTank implements HungerObserver {

    public HashSet<SeaCreature> seaCreatures;
    private static FishTank instance;
    public CyclicBarrier foodBarrier;
    public int totalEatCount = 0;
    public CareTaker careTaker;
    public boolean isSleeping = false;

    /**
     * FishTank Instance
     * @return current instance / Null
     */
    public static FishTank getInstance() {
        if (instance == null) {
            throw new IllegalStateException("FishTank is not initialized");
        }
        return instance;
    }

    /**
     * FishTank Constructor
     */
    public FishTank() {
        seaCreatures = new HashSet<>();
        instance = this;
        careTaker = new CareTaker();
    }

    /**
     * Suspend all instances of Swimmable threads
     */
    public  void sleepAll() {
        seaCreatures.stream().filter(fish -> fish instanceof Swimmable).forEach(fish -> ((Swimmable) fish).setSuspend());
        isSleeping = true;
    }

    /**
     * Wake all instances of Swimmable threads
     */
    public void wakeAll() {
        seaCreatures.stream().filter(fish -> fish instanceof Swimmable).forEach(fish -> ((Swimmable) fish).setResume());
        isSleeping = false;
    }

    /**
     * Clear all instances from FishTank
     */
    public void reset(){
        try{foodBarrier.reset();} catch (NullPointerException e){;}    //reset barrier
        seaCreatures.clear();         //clear fishes
    }

    /**
     * Feed AquaticAnimal within proximity of food
     */
    public void feed(){
        var c = (int)seaCreatures.stream().filter(e -> e instanceof Swimmable && ((Swimmable) e).hunger.hungerState instanceof Hungry).count();
        if(c == 0) return;        //If no fishes present don't place food
        Food.getInstance().placeFood(400, 300);         //Place in the center of the aquarium
        foodBarrier = new CyclicBarrier(c); //init new barrier
        for(var fish : seaCreatures) ((Swimmable)fish).setBarrier(foodBarrier); //set the barrier to the fishes
    }

    public void addCreature(SeaCreature creature){
        if (isSwimmableFull() && creature instanceof Swimmable) {
            JOptionPane.showMessageDialog(null, "The fish tank is full.");
            return;
        }
        if (isImmobileFull() && creature instanceof Immobile) {
            JOptionPane.showMessageDialog(null, "The fish tank is full.");
            return;
        }

        if (creature instanceof  Swimmable) ((Swimmable)creature).attach(this);
        if (isSleeping && creature instanceof Swimmable) ((Swimmable)creature).setSuspend();
        seaCreatures.add(creature);
    }

    public boolean isSwimmableFull(){
        return seaCreatures.stream().filter(x -> x instanceof Swimmable).count() >= 5;
    }

    public boolean isImmobileFull(){
        return seaCreatures.stream().filter(x -> x instanceof Immobile).count() >= 5;
    }

    public boolean isFull() {
        return isSwimmableFull() && isImmobileFull();
    }

    @Override
    public void update(HungrySubject subject) {
        AquaBackground.setShouldNotifyHunger(subject.isHungry());
    }
}
