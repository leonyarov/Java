package w3.FishController;

import java.awt.*;
import java.awt.image.BufferedImage;

import static w3.Utils.FishUtils.imageToBufferedImage;

public class MarineAnimalDecorator implements MarineAnimal {
    @Override
    public Image PaintAnimal(Image image, Color color) {
        if (image == null) return null;
        BufferedImage buff = imageToBufferedImage(image);

        for(int y = 0; y < buff.getHeight(); y++){
            for(int x = 0; x < buff.getWidth(); x++){
                int pixel = buff.getRGB(x,y);

                int alpha = (pixel>>24)&0xff;
                int red = (pixel>>16)&0xff;
                int green = (pixel>>8)&0xff;
                int blue = pixel&0xff;

                pixel = (alpha<<24) | (color.getRed()*red/255<<16) | (color.getGreen()*green/255<<8) | (color.getBlue()*blue/255);

                buff.setRGB(x, y, pixel);
            }
        }
        return buff;
    }
}
