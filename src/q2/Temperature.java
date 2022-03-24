package q2;

import q1.MyDate;

public class Temperature {
    private double scale;
    private MyDate scale_date;

    public Temperature(double scale) {
        this.scale = scale;
        this.scale_date = new MyDate();
    }

    public Temperature(double scale, int day, int month, int year) {
        this.scale = scale;
        this.scale_date = new MyDate(day, month, year);
    }



    public Temperature(Temperature temp) {
        this.scale = temp.scale;
        this.scale_date = temp.scale_date;
    }

    public double getScale() {
        return scale;
    }

    public MyDate getScale_date() {
        return scale_date;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public void setScale_date(MyDate scale_date) {
        this.scale_date = scale_date;
    }

    /**
     * Get a string representing temperature and date
     * @return a string with this format "+- (temperature) (date)"
     */
    public String toString(){
        return String.format("%s%.2f°C %s",scale >= 0 ? "+" : "-", scale, scale_date.toString());
    }

    public void printTemp(){
        System.out.println(this.toString().split(" ")[1]);
    }

    public void printTempFull(){
        System.out.println(this.toString());
    }

    public Temperature compareTemp(Temperature temp){
        return this.scale > temp.scale ? this : temp;
    }


}
