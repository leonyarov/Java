package w3.Creatures;

import w3.GUI.AquaBackground;
import w3.GUI.AquaFrame;
import w3.ListenerObserver.HungerObserver;
import w3.ListenerObserver.HungrySubject;
import w3.Memento.CareTaker;

import java.util.HashSet;
import java.util.concurrent.CyclicBarrier;

/**
 * This class represents a fish tank.
 * It contains a set of swimmable objects.
 */
public class FishTank implements HungerObserver {

    public HashSet<SeaCreature> seaCreatures;
    public Food food = Food.getInstance();
    private static FishTank instance;
    public CyclicBarrier foodBarrier;
    public int totalEatCount = 0;
    public CareTaker careTaker;

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
    }

    /**
     * Wake all instances of Swimmable threads
     */
    public void wakeAll() {
        seaCreatures.stream().filter(fish -> fish instanceof Swimmable).forEach(fish -> ((Swimmable) fish).setResume());
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
        if(seaCreatures.size() == 0) return;        //If no fishes present don't place food
        food.placeFood(400, 300);         //Place in the center of the aquarium
        foodBarrier = new CyclicBarrier(seaCreatures.size()); //init new barrier
        for(var fish : seaCreatures) ((Swimmable)fish).setBarrier(foodBarrier); //set the barrier to the fishes
    }

    public void addCreature(SeaCreature creature){
        if (creature instanceof Swimmable && seaCreatures.stream().filter(x -> x instanceof Swimmable).count() >= 5) return;
        if (creature instanceof Immobile && seaCreatures.stream().filter(x -> x instanceof Immobile).count() >= 5) return;
        if (creature instanceof  Swimmable) ((Swimmable)creature).attach(this);
        seaCreatures.add(creature);
    }


    @Override
    public void update(HungrySubject subject) {
        AquaBackground.setShouldNotifyHunger(subject.isHungry());
    }
}
