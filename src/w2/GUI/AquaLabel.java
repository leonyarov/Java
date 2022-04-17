package w2.GUI;

import w2.FishController.FishUtils;

import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class AquaLabel extends JLabel {

    public String imagePath;
    public AquaLabel(Icon image, int size) {
        super(image);
        if (image == null) {
            var imgs = FishUtils.GetImagesFromPath("src/w2/Assets/Fish/", "png");
            var r = new Random().nextInt(imgs.size());
            imagePath = imgs.get(r);
            image = new ImageIcon(imagePath);
        }
        setIcon(image);
        setSize(size, size);
        matchSize();
    }

    public AquaLabel(Icon image, int x, int y, int size) {
        this(image,size);
        setLocation(x, y);
    }

    public void moveLabel(int hs, int vs){
        int x = getX();
        int y = getY();
        setLocation(x + hs, y + vs);
    }

    public boolean isOnXBorder(){
        int x = getX();
        int pw = getParent().getWidth();
        int w = getWidth();
        return x + w > pw || x <= 0;
    }

    public boolean isOnYBorder(){
        int y = getY();
        int ph = getParent().getHeight();
        int h = getHeight();
        return y + h > ph || y <= 0;
    }

    public void matchSize(){
        var i = ((ImageIcon)getIcon()).getImage();
        Image imgScale = i.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        setIcon(new ImageIcon(imgScale));
    }


    public void flipImage(){
        var i = FishUtils.imageIconToBufferedImage((ImageIcon) getIcon());
        var b = FishUtils.flipVertical(i);
        setIcon(null);
        setIcon(new ImageIcon(b));
        repaint();
    }

    //mirror image horizontally




}
