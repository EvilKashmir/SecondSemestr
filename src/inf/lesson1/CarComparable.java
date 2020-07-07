package inf.lesson1;

public class CarComparable implements Comparable<CarComparable> {

    private String name;
    private double length;
    private double powerEngine;

    public CarComparable(String name, double length, double powerEngine) {
        this.name = name;
        this.length = length;
        this.powerEngine = powerEngine;
    }

    public String getName() {
        return name;
    }

    public double getLength() {
        return length;
    }

    public double getPowerEngine() {
        return powerEngine;
    }

    @Override
    public int compareTo(CarComparable newCar) {
        return this.name.equals(newCar.name) ? 0 : this.name.length() - newCar.name.length() > 0 ? 1 : -1;
    }
}
