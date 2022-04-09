package w2.FishController;

import w2.fishes.Swimmable;

import java.util.HashSet;

/**
 * This class represents a fish tank.
 * It contains a set of swimmable objects.
 */
public class FishTank {
    HashSet<Swimmable> fishes;

    public FishTank() {
        fishes = new HashSet<Swimmable>();
    }
}
