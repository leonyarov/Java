package start;
import q1.MyDate;
import q2.Location;
import q3.Swimmable;

import java.util.*;
import java.util.Collection;
import java.util.Map;


public class Utility {

    /**
     * Searches for and returns the date for which in the array there are two additional dates that make up a series of three consecutive dates.
     * @param dateArray array of class 'date' represented by 3 integers as day/month/year
     * @return If there is no such date the function returns the current date.
     */
    public static MyDate threeDates(MyDate[] dateArray) {
        var arrayList = Arrays.asList(Arrays.stream(dateArray).map(MyDate::toString).toArray(String[]::new));
        for (MyDate thisDate : dateArray) {
            if (arrayList.contains(thisDate.nextDate().toString()) && arrayList.contains(thisDate.nextDate().nextDate().toString()))
                return thisDate;
        }
        return new MyDate();
    }

    /**
     * Searches for maximum temperature from given array of locations
     * @param locationArray Object class represented with a String 'name' and Array 'Temperature'
     * @return maximum temperature from given array of temperature locations
     */
    public static int getMaxTemp(Location[] locationArray) {
        var max  = locationArray[0].getAverage();
        var index = 0;
        for (int i = 0; i < locationArray.length; i++) {
            var avg = locationArray[i].getAverage();
            if (avg > max) {
                max = avg;
                index = i;
            }
        }
        return index;
    }

    /**
     * prints aquatic animals description extracted from an array of class 'swimmable'
     * @param swimmables object of class 'Swimmable' representation for aquatic animals
     */
    public static void printAquarium(Swimmable[] swimmables) {
        System.out.println("Aquarium [type/color/actual size/eat count]: ");
        Arrays.stream(swimmables).forEach(fish -> System.out.println(fish.toString()));
    }

    /**
     * Feeds aquatic animal by increasing he's eatCounter from a 'food' pool
     * @param swimmables object of class 'Swimmable' representation for aquatic animals
     * @param amount primitive variable integer representing amount
     */
    public static void feedAquaticAnimal(Swimmable[] swimmables, int amount) {
        while (amount > 0) {
            Random random = new Random();
            int index = random.nextInt(swimmables.length);
            swimmables[index].eatInc();
            amount--;
        }
    }

    /**
     * The amount of small sea creatures the size of the first sea creature in the array.
     * @param swimmables object of class 'Swimmable' representation for aquatic animals
     * @return array of aquatic animals sorted by size
     */
    public static long countAquaticAnimal(Swimmable[] swimmables) {
        return Arrays.stream(swimmables).filter(smol -> swimmables[0].getSize() > smol.getSize()).count();
    }

    /**
     * Sorts the array of swimmables by size of aquatic animals in descending order
     * @param swimmables object of class 'Swimmable' representation for aquatic animals
     */
    public static void sortAquaticAnimal(Swimmable[] swimmables) {
        Arrays.sort(swimmables, Comparator.comparingInt(Swimmable::getSize));
        Collections.reverse(Arrays.asList(swimmables));
    }
}


