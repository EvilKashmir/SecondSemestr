package inf.lesson1;

public class Car {

    private String name;
    private double length;
    private double powerEngine;
    private final double EPS = 0.1e10;

    public Car(String name, double length, double powerEngine) {
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

    public int compareTo(Car newCar) {
        return (Math.abs(this.powerEngine - newCar.powerEngine) < EPS) ? 0 : (Math.abs(this.powerEngine - newCar.powerEngine) > EPS) ? 1 : -1;
    }
}
