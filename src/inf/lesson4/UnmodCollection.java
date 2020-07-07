package inf.lesson4;

import java.util.*;

public class UnmodCollection<T> extends AbstractCollection<T> {

    private T[] data;
    private int size;

    public UnmodCollection() {
        this.size = 0;
    }

    public UnmodCollection(Collection<? extends T> collection) {
        this.data = (T[]) (new Object[1000]);
        this.size = 0;
        while (collection.iterator().hasNext()) {
            this.data[size] = collection.iterator().next();
            size++;
        }
    }

    public Iterator<T> iterator() {
        return new SimpleIterator<T>(this.data);
    }

    public int size() {
        return size;
    }

    private class SimpleIterator<T> implements Iterator<T> {

        protected T[] temp;
        protected int cursor;

        public SimpleIterator(T[] temp) {
            this.cursor = 0;
            this.temp = temp;
        }

        public boolean hasNext() {
            return temp.length > cursor;
        }

        public T next() {
            try {
                T el = temp[cursor];
                cursor++;
                return el;
            } catch (IndexOutOfBoundsException ex) {
                throw new java.util.NoSuchElementException();
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnmodCollection<?> that = (UnmodCollection<?>) o;
        if (size != that.size)
            return false;
        else
            return Arrays.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }

    @Override
    public String toString() {
        return "Size: " + size + " --> " +
                Arrays.toString(data);
    }
}
