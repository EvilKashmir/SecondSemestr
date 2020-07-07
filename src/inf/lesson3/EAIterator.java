package inf.lesson3;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class EAIterator<T> implements Iterator<T> {

    private T[] data;
    private int size;
    private int cursor;

    public EAIterator() {
        this.cursor = 0;
        this.size = 0;
        this.data = (T[]) new Object[10];
    }

    public EAIterator(int capacity) {
        this.cursor = 0;
        this.size = 0;
        this.data = (T[]) new Object[capacity];
    }

    public EAIterator(int capacity, T obj) {
        this.cursor = 0;
        this.size = 0;
        this.data = (T[]) new  Object[capacity];
        for (int i = 0; i < data.length; i++) {
            this.data[i] = obj;
            this.size++;
        }
    }

    public EAIterator(T[] data) {
        this.cursor = 0;
        this.data = data;
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                size++;
            }
        }
    }

    public void add(T obj) {
        if (size == data.length) {
            T[] temp =(T[]) new Object[(int) (data.length * 1.5f)];
            System.arraycopy(data,0,temp,0, data.length);
            data = temp;
        }
        data[size] = obj;
        size++;

    }
    public T get(int index) {
        if (index > size) {
            System.out.println("Wrong index.");
            System.exit(1);
        }
        return data[index];
    }

    public int getCapacity() {
        return data.length;
    }

    public int getSize() {
        return size;
    }

    public void remove(int index) {
        for (int i = 0; i < data.length - 1; i++) {
            if (i == index) {
                for (int j = index; j < data.length - 1; j++) {
                    data[j] = data[j+1];
                }
            }
        }
        size--;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EAIterator that = (EAIterator) o;
        return size == that.size &&
                Arrays.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }

    @Override
    public String toString() {
        return "size : " + size;

    }

    @Override
    public boolean hasNext() {
        return cursor < size;
    }

    @Override
    public T next() {
        try {
            T el = data[cursor];
            cursor++;
            return el;
        }
        catch (IndexOutOfBoundsException ex) {
            throw new java.util.NoSuchElementException();
        }
    }
}
