package inf.lesson3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class InterestingIterator<T> implements Iterator<T> {

    private T[] data;
    private int cursor;

    public InterestingIterator(T[] data) {
        this.cursor = 0;
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return cursor < data.length;
    }

    @Override
    public T next() {
        try{
            int i = 0;
            T el = data[cursor];
            if (i % 2 == 0) {
                cursor += data.length - i - 1;
            } else {
                cursor -= data.length + i + 1;
            }
            i++;
            return el;
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException();
        }
    }
}
