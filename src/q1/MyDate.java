package q1;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;

//TODO: Javadoc this functions
public class MyDate {
    private int day;
    private int month;
    private int year;

    public MyDate() {
        // Create a date object with the current date
        LocalDate date = LocalDate.now();

        //set day
        this.day = date.getDayOfMonth();

        //set month
        this.month = date.getMonth().getValue();

        //set year
        this.year = date.getYear();
    }
    public MyDate(int day, int month, int year) {

        try{
             SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
             sdf.setLenient(false);
             sdf.format(sdf.parse(String.format("%02d/%02d/%d",day,month,year)));
        } catch (Exception ignored){
            LocalDate date = LocalDate.now();

            //set day
            this.day = date.getDayOfMonth();

            //set month
            this.month = date.getMonth().getValue();

            //set year
            this.year = date.getYear();
            return;
        }
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    public MyDate(MyDate date) {
        setDay(date.getDay());
        setMonth(date.getMonth());
        setYear(date.getYear());
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        //set february days
        if (month == 2) day = day % 29;

        //set days in month
        else if (month == 4 || month == 6 || month == 9 || month == 11) day = day % 31;
        else day = day % 32;

        //set day if zero or smaller
        if (day <= 0) day = 1;

        //set day
        this.day = day;
    }

    public void setMonth(int month) {
        //month cannot be more than 12
        month = month % 13;

        //set month if zero or smaller
        if (month <= 0) month = 1;

        //set month
        this.month = month;
    }

    public void setYear(int year) {
        //set year

        //TODO: year cannot be less than 0
        this.year = year;
    }

    public String toString() {
        return String.format("%02d/%02d/%04d",day,month,year);
    }

    public void printDate(){
        System.out.println(this);
    }

    public void printMonthName(){
        System.out.printf("%02d %s %02d%n",getDay(),LocalDate.of(getYear(), getMonth(), getDay()).getMonth().getDisplayName(TextStyle.SHORT,java.util.Locale.ENGLISH),getYear());
    }


    public int getMonthDay(){
         return LocalDate.of(getYear(), getMonth(), getDay()).lengthOfMonth();
    }

    public boolean isLeapYear(){
        return LocalDate.of(getYear(), getMonth(), getDay()).isLeapYear();
    }

    public MyDate nextDate(){
        LocalDate date = LocalDate.of(getYear(), getMonth(), getDay());
        date = date.plusDays(1);
        return new MyDate(date.getDayOfMonth(), date.getMonth().getValue(), date.getYear());
    }

    public void printFormatDate(String format){
        switch (format) {
            case "ddmmyyyy":
                System.out.println(this);
                break;
            case "ddmmyy":
                System.out.printf("%02d/%02d/%02d%n", day, month, year % 100);
                break;
            case "mmddyyyy":
                System.out.printf("%02d/%02d/%02d%n", month, day, year);
                break;
            case "yyyymmdd":
                System.out.printf("%02d/%02d/%02d%n", year, month, day);
                break;
            case "ddMMyyyy":
                System.out.printf("%02d %s %02d%n", day, LocalDate.of(getYear(), getMonth(), getDay()).getMonth().getDisplayName(TextStyle.SHORT, java.util.Locale.ENGLISH), year);
                break;
        }
    }

    public int compareDate(MyDate date){
        LocalDate today = LocalDate.of(getYear(), getMonth(), getDay());
        LocalDate other = LocalDate.of(date.getYear(), date.getMonth(), date.getDay());
        boolean isBefore = today.isBefore(other);
        boolean isAfter = today.isAfter(other);
        if (isBefore) return -1;
        else if (isAfter) return 1;
        else return 0;
    }

    public boolean equals(MyDate date){
        return this.day == date.getDay() && this.month == date.getMonth() && this.month == date.getMonthDay();
    }
}
