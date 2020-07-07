import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class ModCollection<T> extends AbstractCollection<T> {

    private T[] data;
    private int size;

    public ModCollection() {
        this.data = (T[]) (new Object[1000]);
        this.size = 0;
    }

    public ModCollection(Collection<? extends T> collection) {
        data = (T[]) (new Object[1000]);
        size = 0;
        while (collection.iterator().hasNext()) {
            data[size++] = collection.iterator().next();
        }
    }

    public Iterator<T> iterator() {
        return new SimpleIterator<T>(this.data);
    }

    public int size() {
        return size;
    }

    public boolean add(T obj) {
        data[size++] = obj;
        return true;
    }

    public boolean remove(Object obj) {
        for (int i = 0; i < size; i++) {
            if (obj.equals(data[i])) {
                for (int j = i; j < size - 1; j++)
                    data[j] = data[j + 1];
                size--;
                return true;
            }
        }
        return false;
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
    public String toString() {
        return Arrays.toString(data);
    }
}
