package inf.lesson1;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class EndlessArray {
    private int[] data;
    private int size;

    public EndlessArray() {
        this.data = new int[10];
        this.size = 0;
    }

    public EndlessArray(int capacity) {
        this.data = new int[capacity];
        Random random = new Random(100);
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt();
        }
        this.size = capacity;
    }

    public EndlessArray(int capacity, int num) {
        this.data = new int[capacity];
        for (int i = 0; i < data.length; i++) {
            data[i] = num;
        }
        this.size = capacity;
    }

    public void add(int num) {
        if (this.size == this.data.length) {
            int[] newArray = new int[(int) (data.length * 1.5f)];
            System.arraycopy(data, 0, newArray, 0, data.length);
            data = newArray;
        }
        data[this.size] = num;
        this.size++;

    }

    public int get(int index) {
        if (index > size) {
            System.out.println("Wrong index.");
            System.exit(1);
        }
        return data[index];
    }

    public int getCapacity() {
        return data.length;
    }

    public void remove(int index) {
        for (int i = 0; i < data.length - 1; i++) {
            if (i == index) {
                for (int j = index; j < data.length - 1; j++) {
                    data[j] = data[j + 1];
                }
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EndlessArray that = (EndlessArray) o;
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
        return "EndlessArray{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }
}