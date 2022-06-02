package w3.Memento;


/**
 * Interface implementation for Memento DP.
   Save & Load State Methods.
 */
public interface Originator {
    public Memento saveState();
    public void loadState(Memento state);

    }
