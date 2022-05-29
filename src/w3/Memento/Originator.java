package w3.Memento;

public interface Originator {
    public Memento saveState();
    public void loadState(Memento state);

    }
