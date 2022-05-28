package w3.FishController;

import java.awt.*;

public interface SeaCreature {
    void drawCreature(Graphics g);
    void setSize(int size);
    void set_Xfront(int xfront);
    void set_Yfront(int yfront);
    void setHorSpeed(int horSpeed);
    void setVerSpeed(int verSpeed);
    void setColor(Color color);
    int getEatCount();
    String getAnimalName();
    void setFeed(int feed_i);
}
