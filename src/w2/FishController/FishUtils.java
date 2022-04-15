package w2.FishController;

import w2.fishes.Swimmable;

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
import java.util.HashSet;
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
    public static List<BufferedImage> ExtractImagesFromFolder(String path, String extension) {
        var fishImages = new ArrayList<BufferedImage>();
        List<String> result;

        try (Stream<Path> walk = Files.walk(Paths.get(path))) {
            result = walk
                    .filter(p -> !Files.isDirectory(p))   // not a directory
                    .map(p -> p.toString().toLowerCase()) // convert path to string
                    .filter(f -> f.endsWith(extension))       // check end with
                    .collect(Collectors.toList());        // collect all matched to a List
        }
        catch (Exception e) {
            System.out.println("Error reading file: " + e);
            return null;
        }

        result.forEach((f) -> {
            try {
                fishImages.add(ImageIO.read(new File(f)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return fishImages;
    }

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

    public static BufferedImage flipVertical(BufferedImage src){

        AffineTransform tx=AffineTransform.getScaleInstance(-1.0,1.0);  //scaling
        tx.translate(-src.getWidth(),0);  //translating
        AffineTransformOp tr=new AffineTransformOp(tx,null);  //transforming
        return tr.filter(src, null);  //filtering
    }

    public static BufferedImage imageIconToBufferedImage(ImageIcon icon) {
        BufferedImage bufferedImage = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(),
                BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = bufferedImage.createGraphics();
        icon.paintIcon(null, graphics, 0, 0);
        graphics.dispose();//from   w  ww.j a  va  2  s.  co m
        return bufferedImage;
    }
}
