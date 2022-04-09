package w1.q2;
import w1.q1.MyDate;


//Leon Yarovinski: 206817181
//Alon Yehuda Levi: 209614288


public class Temperature {
    private double scale;
    private MyDate scale_date;

    /**
     * Default constructor for class 'Temperature'
     */
    public Temperature(){
        this.scale = 0;
        this.scale_date = new MyDate();
    }

    /**
     * Constructor for class 'Temperature' with only 1 parameter
     * @param scale the extent of class 'Temperature' in primitive type double
     */
    public Temperature(double scale) {
        this.scale = scale;
        this.scale_date = new MyDate();
    }

    /**
     * Constructor for class 'Temperature' with multiple parameters
     * @param scale the extent of class 'Temperature' in primitive type double
     * @param day integer for representing 'day' value in class 'Date'
     * @param month integer for representing 'month' value in class 'Date'
     * @param year  integer for representing 'year' value in class 'Date'
     */
    public Temperature(double scale, int day, int month, int year) {
        this.scale = scale;
        this.scale_date = new MyDate(day, month, year);
    }


    /**
     * Copy constructor for class 'Temperature'
     * @param temp inner-field of class 'Location'
     */
    public Temperature(Temperature temp) {
        this.scale = temp.scale;
        this.scale_date = temp.scale_date;
    }

    /**
     * Returns value of inner-field 'scale' in class 'Temperature'
     */
    public double getScale() {
        return scale;
    }

    /**
     * Returns value of inner-field 'scale_date' in class 'Temperature'
     */
    public MyDate getScale_date() {
        return scale_date;
    }

    /**
     * Sets the inner-field 'scale' in class 'Temperature'
     */
    public boolean setScale(double scale) {
        return (this.scale = scale) == scale;
    }

    /**
     * Sets the inner-field 'scale_date' in class 'Temperature'
     */
    public boolean setScale_date(MyDate scale_date) {
        return (this.scale_date = scale_date).equals(scale_date);
    }

    /**
     * Get a string representing temperature and date
     * @return a string with this format "+- (temperature) (date)"
     */
    public String toString(){
        return String.format("%s%.2f°C %s",scale >= 0 ? "+" : "", scale, scale_date.toString());
    }

    /**
     * Prints the string representation of the first logged temperature from class 'Temperature'
     */
    public void printTemp(){
        System.out.println(this.toString().split(" ")[1]);
    }

    /**
     * Prints the entire temperature logs from class 'Temperature'
     */
    public void printTempFull(){
        System.out.println(this);
    }

    /**
     * Compares 2 'Temperature' class inner-field 'scale'
     * @param temp inner-field of class 'Location'
     * @return true or false if 'this' 'scale' is valued higher than inputted object
     */
    public Temperature compareTemp(Temperature temp){
        return this.scale > temp.scale ? this : temp;
    }

    /**
     * equality determination of 'scale' in 'Location'
     * @param temp inner-field of class 'Location'
     * @return true or false if 'scale' of both objects point to the same adress
     */
    public boolean equals(Temperature temp){
        return this.scale == temp.getScale() && this.scale_date == temp.getScale_date();
    }
}
