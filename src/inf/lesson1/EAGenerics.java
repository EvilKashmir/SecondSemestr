package inf.lesson1;

import java.util.Arrays;
import java.util.Objects;

public class EAGenerics<T>  {

    private T[] data;
    private int size;

    public EAGenerics() {
        this.size = 0;
        this.data = (T[]) new Objects[10];
    }

    public EAGenerics(int capacity) {
        this.size = 0;
        this.data = (T[]) new Objects[capacity];
    }

    public EAGenerics(int capacity, T obj) {
        this.size = 0;
        this.data = (T[]) new  Objects[capacity];
        for (int i = 0; i < data.length; i++) {
            this.data[i] = obj;
            this.size++;
        }
    }

    public void add(T obj) {
        if (size == data.length) {
            T[] temp =(T[]) new Objects[(int) (data.length * 1.5f)];
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
        EAGenerics that = (EAGenerics) o;
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
        return Arrays.toString(data);/*"EndlessArray size : " + size;*/
    }
}
