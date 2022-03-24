package q2;

import java.util.Arrays;

public class Location {
    private String name;
    private Temperature[] temp;

    public Location(String name) {
        this.name = name;
        this.temp = new Temperature[0];
    }

    //get set
    public String getName() {
        return name;
    }

    public void printLocation(double range) {
        System.out.println("Location: " + name);
        Arrays.stream(temp).filter(t -> t.getScale() <= getAverage() + range && t.getScale() >= getAverage()- range).forEach(Temperature::printTempFull);
    }
    public void printLocation() {
        System.out.println("Location: " + name);
        if (temp.length == 0) {
            System.out.println("No temperature data");
            return;
        }
        Arrays.stream(temp).forEach(Temperature::printTempFull);
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

}
