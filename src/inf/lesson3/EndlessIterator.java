package inf.lesson3;

import java.util.Iterator;
import java.util.Random;

public class EndlessIterator<T> implements Iterator<Integer> {

    private int cursor;

    public EndlessIterator() {
        this.cursor = 0;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        Random random = new Random();
        int el = random.nextInt(100);
        cursor++;
        return el;
    }
}
