package w1.q1;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.TextStyle;

//Leon Yarovinski: 206817181
//Alon Yehuda Levi: 209614288


public class MyDate {
    private int day;
    private int month;
    private int year;


    /**
     * Default Constructor of MyDate Class
     */
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

    /**
     * Constructor for 'MyDate' with predetermined inputted values
     * @param day integer value of 'day' in 'Date'
     * @param month integer value of 'month' in 'Date'
     * @param year integer value of 'year' in 'Date'
     */
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


    /**
     * copyConstructor of 'MyDate' class
     * @param date class date represented by 3 integers as day/month/year
     */
    public MyDate(MyDate date) {
        setDay(date.getDay());
        setMonth(date.getMonth());
        setYear(date.getYear());
    }

    /**
     * Retrieves the 'day' inner field in 'Date'
     * @return integer value of 'day' in 'Date'
     */
    public int getDay() {
        return day;
    }

    /**
     * Retrieves the 'month' inner field in 'Date'
     * @return integer value of 'month' in 'Date'
     */
    public int getMonth() {
        return month;
    }


    /**
     * Retrieves the 'year' inner field in 'Date'
     * @return integer value of 'year' in 'Date'
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the inner field 'day' of 'date' class
     * @param day - Date class inner field.<br> integer parameter representing the current day number
     * @return true if day is valid, false otherwise
     */
    public boolean setDay(int day) {
        //set february days
        if (month == 2) day = day % 29;

        //set days in month
        else if (month == 4 || month == 6 || month == 9 || month == 11) day = day % 31;
        else day = day % 32;

        //set day if zero or smaller
        if (day <= 0) day = 1;

        //set day
        this.day = day;
        return true;
    }

    /**
     * Sets the inner field 'month' of 'date' class
     * @param month - Date class inner field.<br> integer parameter representing the current month number
     * @return true if month is valid, false otherwise
     */
    public boolean setMonth(int month) {
        //month cannot be more than 12
        month = month % 13;

        //set month if zero or smaller
        if (month <= 0) month = 1;

        //set month
        this.month = month;
        return true;
    }

    /**
     * Sets the inner field 'year' of 'date' class
     * @param year - Date class inner field.<br> integer parameter representing the current year number
     * @return true if year is valid, false otherwise
     */
    public boolean setYear(int year) {
        return (this.year = year) == year;
    }

    /**
     * Creates string of the up-to-date 'date' dd/mm/yy
     * @return String format of  date class
     */
    public String toString() {
        return String.format("%02d/%02d/%04d",day,month,year);
    }

    /**
     * Prints up-to-date date class representation dd/mm/yy
     */
    public void printDate(){
        System.out.println(this);
    }

    /**
     * Prints the up-to-date month name in the class
     */
    public void printMonthName(){
        System.out.printf("%02d %s %02d%n",getDay(),LocalDate.of(getYear(), getMonth(), getDay()).getMonth().getDisplayName(TextStyle.SHORT,java.util.Locale.ENGLISH),getYear());
    }

    /**
     * Creates a date object of the up-to-date 'date' inner fields
     * @return date object of the current updated year, month, day and length of the month
     */
    public int getMonthDay(){
         return LocalDate.of(getYear(), getMonth(), getDay()).lengthOfMonth();
    }

    /**
     * Returns Determines if Date is LeapYear
     * @return True or False if the currentDate is represented as a LeapYear
     * @author Alon
     */
    public boolean isLeapYear(){
        return LocalDate.of(getYear(), getMonth(), getDay()).isLeapYear();
    }

    /**
     * Returns the following day of the currentDate
     * @return New DateObject represented by currentDate plus 1 day
     */
    public MyDate nextDate(){
        LocalDate date = LocalDate.of(getYear(), getMonth(), getDay());
        date = date.plusDays(1);
        return new MyDate(date.getDayOfMonth(), date.getMonth().getValue(), date.getYear());
    }

    /**
     * Prints a date object from a pool of format options
     * @param format string representation for viewing date object
     */
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

    /**
     * Function creates date object for current and other and compares the two for whom is prior and posterior
     * @param date class date represented by 3 integers as day/month/year
     * @return  returns integer as following:<br> -1 if current date is prior inputted date,<br>  1 if current date is posterior of other date,<br>  0 if dates are the same
     *
     */
    public int compareDate(MyDate date){
        LocalDate today = LocalDate.of(getYear(), getMonth(), getDay());
        LocalDate other = LocalDate.of(date.getYear(), date.getMonth(), date.getDay());
        boolean isBefore = today.isBefore(other);
        boolean isAfter = today.isAfter(other);
        if (isBefore) return -1;
        else if (isAfter) return 1;
        else return 0;
    }

    /**
     * Compares pointer references of two date objects
     * @param date class date represented by 3 integers as day/month/year
     * @return returns true and false based on object equality
     */
    public boolean equals(MyDate date){
        return this.day == date.getDay() && this.month == date.getMonth() && this.month == date.getMonthDay();
    }
}
