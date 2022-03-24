package start;
import q1.MyDate;
import q2.Location;
import q3.Swimmable;

import java.util.*;
import java.util.Collection;
import java.util.Map;


public class Utility {

    public static MyDate threeDates(MyDate[] dateArray) {
        var arrayList = Arrays.asList(Arrays.stream(dateArray).map(MyDate::toString).toArray(String[]::new));
        for (MyDate thisDate : dateArray) {
            if (arrayList.contains(thisDate.nextDate().toString()) && arrayList.contains(thisDate.nextDate().nextDate().toString()))
                return thisDate;
        }
        return new MyDate();
    }

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

    public static void printAquarium(Swimmable[] swimmables) {
        System.out.println("Aquarium [type/color/actual size/eat count]: ");
        Arrays.stream(swimmables).forEach(fish -> System.out.println(fish.toString()));
    }

    public static void feedAquaticAnimal(Swimmable[] swimmables, int amount) {
        while (amount > 0) {
            Random random = new Random();
            int index = random.nextInt(swimmables.length);
            swimmables[index].eatInc();
            amount--;
        }
    }

    public static long countAquaticAnimal(Swimmable[] swimmables) {
        return Arrays.stream(swimmables).filter(smol -> swimmables[0].getSize() > smol.getSize()).count();
    }

    public static void sortAquaticAnimal(Swimmable[] swimmables) {
        Arrays.sort(swimmables, Comparator.comparingInt(Swimmable::getSize));
        Collections.reverse(Arrays.asList(swimmables));
    }
}


