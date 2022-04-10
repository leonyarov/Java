package w2.FishController;

import w2.fishes.Swimmable;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.*;
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
}
