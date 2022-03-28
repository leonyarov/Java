package start;

import q1.MyDate;
import q2.Location;
import q2.Temperature;
import q3.*;

public class Program {

        public static void main(String[] args) {
            RunQ3();
        }

    /**
     * Homework 1<br>Question 1
     */
    public static void RunQ1(){
            MyDate date1=new MyDate(31,03,2022);
            MyDate date2=new MyDate(29,2,2022);
            System.out.println(date1);
            date2.printDate();
            System.out.println();
            date1.printMonthName();System.out.println();
            System.out.println(date1.nextDate());
            System.out.println(date1.nextDate().getMonthDay());
            MyDate date3=new MyDate(31,12,2020);
            System.out.println(date3.isLeapYear());
            System.out.println(date3.nextDate());
            date3.nextDate().printFormatDate("ddmmyy");System.out.println();
            date3.nextDate().printFormatDate("mmddyyyy");System.out.println();
            date3.printFormatDate("yyyymmdd");System.out.println();
            date3.printFormatDate("ddMMyyyy");System.out.println();
            System.out.println(date3.compareDate(date3)+" "+date3.compareDate(date1)+
                    " "+date1.compareDate(date3));
            MyDate[] arr= {new MyDate(1,2,2022),new MyDate(2,3,2022),new MyDate(12,8,2020),
                    new MyDate(4,3,2022),new MyDate(3,3,2022),new MyDate(14,12,2021)};
            System.out.println(Utility.threeDates(arr));
            arr[3]=new MyDate();
            System.out.println(Utility.threeDates(arr));
        }

    /**
     * Homework 1<br>Question 2
     */
        public static void RunQ2(){
            Location[] arr2 = { new Location("Tel-Aviv"), new Location("London"),
                    new Location("Paris"), new Location("Berlin") };
            arr2[0].addTemp(12);
            arr2[0].addTemp(14, 1, 2, 2022);
            arr2[0].addTemp(21, 28, 1, 2022);
            arr2[0].addTemp(30, 12, 3, 2022);
            arr2[1].addTemp(25, 28, 2, 2022);
            arr2[1].addTemp(10);
            arr2[1].addTemp(14, 10, 1, 2022);
            arr2[1].addTemp(17, 9, 2, 2022);
            arr2[1].addTemp(14, 31, 12, 2021);
            arr2[1].addTemp(11, 2, 3, 2022);
            arr2[2].addTemp(27, 4, 2, 2022);
            arr2[2].addTemp(25, 8, 2, 2022);
            for (Location x : arr2)
                x.printLocation();
            System.out.println("max aveare temp of: ");
            arr2[Utility.getMaxTemp(arr2)].printLocation();
            System.out.println("average temperature is: " +
                    (int) arr2[Utility.getMaxTemp(arr2)].getAverage() + (char) 176 + "C");
            System.out.print("max temperature of " + arr2[1].getName() + ": ");
            arr2[1].getMax().printTempFull();
            System.out.println("\ntemperatures close to average: " +
                    (int) arr2[1].getAverage() + (char) 176 + "C");
            arr2[1].printLocation(2);
        }

    /**
     * Homework 1<br>Question 3
     */
        public static void RunQ3(){
            Swimmable[] arr3= {new Fish(20, 0, 0, 0, 0, 6),new Jellyfish(10, 0, 0, 0, 0, 8),
                    new UnusualFish(15, 0, 0, 0, 0, 9,2),new MultiColorFish(20, 0, 0, 0, 0, 2),
                    new Fish(18, 0, 0, 0, 0, 4),new Jellyfish(34, 0, 0, 0, 0, 7)};
            Utility.printAquarium(arr3);
            Utility.feedAquaticAnimal(arr3, 50);
            Utility.printAquarium(arr3);
            System.out.println("\ncount: "+Utility.countAquaticAnimal(arr3));
            Utility.sortAquaticAnimal(arr3);
            Utility.printAquarium(arr3);
        }

}
