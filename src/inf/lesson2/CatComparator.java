package inf.lesson2;

import inf.lesson1.Cat;
import java.util.Comparator;

public class CatComparator implements Comparator<Cat> {
    public int compare(Cat cat1, Cat cat2) {
        return cat1.getBirthday().compareTo(cat2.getBirthday());
    }
}
