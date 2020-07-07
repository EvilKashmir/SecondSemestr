package inf.lesson3;

import java.util.NoSuchElementException;

public class StrangeIterator<T> implements java.util.Iterator<T> {

    private T[] data;
    private int cursor;

    public StrangeIterator(T[] data) {
        this.cursor = 0;
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean result = true;
        try {
            for (int i = cursor + 2; data[i] == null; i += 2) {
                if(data[i] != null) {
                    break;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            result = false;
        }

        return result;
    }

    @Override
    public T next() {
        try{
            while(data[cursor] == null) {
                cursor +=2;
            }
            T el = data[cursor];
            cursor += 2;
            return el;
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException();
        }
    }
}
