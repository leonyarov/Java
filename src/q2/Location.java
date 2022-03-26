package q2;

import java.util.Arrays;
import java.util.Objects;

public class Location {
    private String name;
    private Temperature[] temp;


    /**
     * Default constructor for class 'Location'
     */
    public Location(){
        this.name = "Unknown";
        this.temp = new Temperature[0];
    }

    /**
     * Default constructor for class 'Location'
     * @param name representation for class 'Location'
     *
     */
    public Location(String name) {
        this.name = name;
        this.temp = new Temperature[0];
    }

    /**
     * Copy-constructor of class 'Location'
     * @param location Object class represented with a String 'name' and Array 'Temperature'
     */
    public Location(Location location){
        setName(location.getName());
        setTemp(location.getTemp());
    }


    /**
     * Returns inner-field of 'name' in class 'Location'
     */
    public String getName() {
        return name;
    }
    /**
     * Sets inner-field of 'name' in class 'Location'
     */
    public void setName(String name) { this.name = name; }
    /**
     * Sets inner-field of 'Temperature' in class 'Location'
     */
    public void setTemp(Temperature[] tmp) {
            temp = tmp;
    }

    /**
     *
     * Returns inner-field 'Temperature' in class 'Location'
     */
    public Temperature[] getTemp() { return temp;}

    /**
     * Prints location name and temperature logs
     * @param range representation of the range in double from each temp log location.
     */
    public void printLocation(double range) {
        System.out.println("Location: " + name);
        Arrays.stream(temp).filter(t -> t.getScale() <= getAverage() + range && t.getScale() >= getAverage()- range).forEach(Temperature::printTempFull);
    }

    /**
     * Default print for location name when no logs exist
     */
    public void printLocation() {
        System.out.println(this);
    }

    /**
     * Returns the average temperature of the class 'Location'
     */
    public double getAverage(){
        return Arrays.stream(temp).mapToDouble(Temperature::getScale).average().orElse(0);
    }

    /**
     * Input temperature log with date and temperature value
     * @param temp inner-field of class 'Location'
     * @param day integer for 'day' representation used in class 'Location'
     * @param month integer for 'month' representation used in class 'Location'
     * @param year integer for 'year' representation used in class 'Location'
     */
    public void addTemp(double temp, int day, int month, int year) {
        ExtendWith(new Temperature(temp, day, month, year));
    }

    /**
     *
     * Input temperature log with date and temperature value
     * @param temp inner-field of class 'Location'
     */
    public void addTemp(double temp){
        ExtendWith(new Temperature(temp));
    }

    /**
     * Extending the current array inner-field 'Temperature' in class 'Location'
     * @param temp inner-field of class 'Location'
     */
    private void ExtendWith(Temperature temp) {
        Temperature[] newTemp = new Temperature[this.temp.length + 1];
        System.arraycopy(this.temp, 0, newTemp, 0, this.temp.length);
        newTemp[this.temp.length] = temp;
        this.temp = newTemp;
    }

    /**
     * Returns the Maximum value from inner-field 'Temperature' in class 'Location'
     */
    public Temperature getMax(){
        return Arrays.stream(temp).reduce(Temperature::compareTemp).orElse(null);
    }

    /**
     * String representation of class 'Location' inner-field parameters
     * @return string format of class 'Location'
     */
    public String toString(){
        var output = ("Location: " + name + '\n');
        if (temp.length == 0) {
            return output + "No temperature data";
        }
        for (var t: temp){
            output += t.toString() + '\n';
        }
        return output;
    }


    /**
     * Compares pointer references of two date objects
     * @param location Object class represented with a String 'name' and Array 'Temperature'
     * @return returns true and false based on object equality
     */
    public boolean equals(Location location){
        return Objects.equals(this.name, location.getName()) && this.temp == location.getTemp();
    }
}


