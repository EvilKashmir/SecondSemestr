package inf.lesson3;

import java.util.Iterator;

public class SimpleIterator<T> implements Iterator<T> {

    protected T[] data;
    protected int cursor;

    public SimpleIterator(T[] data) {
        this.cursor = 0;
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return cursor < data.length;
    }

    @Override
    public T next() {
        try {
            return data[cursor++];
        }
        catch (IndexOutOfBoundsException ex) {
            throw new java.util.NoSuchElementException();
        }
    }
}
