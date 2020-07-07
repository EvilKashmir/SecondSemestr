package inf.lesson2;

import inf.lesson1.Car;
import java.util.Comparator;

public class CarComparator implements Comparator<Car> {
    public int compare(Car car1, Car car2) {
        return car1.compareTo(car2);
    }
}
