package w2.FishController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FishUtils {


    /**
     * Get all images from folder
     * @param path path to folder
     * @param extension extension of images (png, jpg, jpeg, gif)
     * @return {@link List} of images
     */
    public static List<String> GetImagesFromPath(String path, String extension) {
        try (Stream<Path> walk = Files.walk(Paths.get(path))) {
            return  walk
                    .filter(p -> !Files.isDirectory(p))   // not a directory
                    .map(p -> p.toString().toLowerCase()) // convert path to string
                    .filter(f -> f.endsWith(extension))       // check end with
                    .collect(Collectors.toList());        // collect all matched to a List
        }
        catch (Exception e) {
            System.out.println("Error reading file: " + e);
            return null;
        }
    }

    /**
     * Flips fish thread on GUI Horizontally
     * @param src source of image
     * @return filtered source image
     */
    public static BufferedImage flipHorizontal(BufferedImage src){

        AffineTransform tx=AffineTransform.getScaleInstance(-1.0,1.0);  //scaling
        tx.translate(-src.getWidth(),0);  //translating
        AffineTransformOp tr=new AffineTransformOp(tx,null);  //transforming
        return tr.filter(src, null);  //filtering
    }

    /**
     * Converting image to BufferedImage
     * @param image Image of file
     * @return bufferedImage from Image file
     */
    public static BufferedImage imageToBufferedImage(Image image) {
        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);
        Graphics bGr = bufferedImage.createGraphics();
        bGr.drawImage(image, 0, 0, null);
        bGr.dispose();
        return bufferedImage;
    }

    /**
     * Random Aquatic Image
     * @param path path to folder
     * @param color The Color class is used to encapsulate colors in the default sRGB
     * @return Random Aquatic Image from path
     */
    public static Image getRandomImage(String path, Color color){
        var imgs = FishUtils.GetImagesFromPath(path, "png");
        var r = new Random().nextInt(imgs.size());
        var img = new ImageIcon(imgs.get(r)).getImage();
        img = applyColorFilter(img, color);
        return img;
    }

    /**
     * applying color filtration to
     * @param image Image of file
     * @param color The Color class is used to encapsulate colors in the default sRGB
     * @return BufferedImage with color filtration
     */
    public static Image applyColorFilter(Image image,Color color)  {
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

    public static final String fishLibrary = "src/w2/Assets/Fish/";
    public static final String jellyfishLibrary = "src/w2/Assets/JellyFish/";
}
