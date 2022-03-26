package q2;

import java.util.Arrays;
import java.util.Objects;

public class Location {
    private String name;
    private Temperature[] temp;

    public Location(){
        this.name = "Unknown";
        this.temp = new Temperature[0];
    }

    public Location(String name) {
        this.name = name;
        this.temp = new Temperature[0];
    }

    public Location(Location location){
        setName(location.getName());
        setTemp(location.getTemp());
    }

    //get set
    public String getName() {
        return name;
    }
    public void setName(String name) { this.name = name; }
    public void setTemp(Temperature[] tmp) {
            temp = tmp;
    }
    public Temperature[] getTemp() { return temp;}


    public void printLocation(double range) {
        System.out.println("Location: " + name);
        Arrays.stream(temp).filter(t -> t.getScale() <= getAverage() + range && t.getScale() >= getAverage()- range).forEach(Temperature::printTempFull);
    }
    public void printLocation() {
        System.out.println(this);
    }

    public double getAverage(){
        return Arrays.stream(temp).mapToDouble(Temperature::getScale).average().orElse(0);
    }

    public void addTemp(double temp, int day, int month, int year) {
        ExtendWith(new Temperature(temp, day, month, year));
    }

    public void addTemp(double temp){
        ExtendWith(new Temperature(temp));
    }

    private void ExtendWith(Temperature temp) {
        Temperature[] newTemp = new Temperature[this.temp.length + 1];
        System.arraycopy(this.temp, 0, newTemp, 0, this.temp.length);
        newTemp[this.temp.length] = temp;
        this.temp = newTemp;
    }

    public Temperature getMax(){
        return Arrays.stream(temp).reduce(Temperature::compareTemp).orElse(null);
    }

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

    public boolean equals(Location location){
        return Objects.equals(this.name, location.getName()) && this.temp == location.getTemp();
    }
}


