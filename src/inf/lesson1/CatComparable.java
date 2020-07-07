package inf.lesson1;

import java.util.Date;

public class CatComparable implements Comparable<CatComparable> {

    private String name;
    private Date birthday;
    private double length;
    private final double EPS = 0.1e10;

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public double getLength() {
        return length;
    }

    public CatComparable(String name, Date birthday, double length) {
        this.name = name;
        this.birthday = birthday;
        this.length = length;
    }

    public int compareTo(CatComparable newCat) {
        return (Math.abs(this.length - newCat.length) < EPS) ? 0 : (this.length > newCat.length) ? 1 : -1;
    }
}
