package ads.lesson2;

import java.util.Arrays;

public class MyMultiSet<T> implements ISet<T>{

    private T[] data;
    private int[] count;
    private int size;

    public MyMultiSet() {
        data = (T[]) new Object[5];
        count = new int[data.length];
        size = 0;
    }

    @Override
    public boolean add(T t) {
        for (int i = 0; i < size(); i++)
            if (data[i].equals(t)) {
                count[i]++;
                return false;
            }
        data[size] = t;
        count[size++]++;
        return true;
    }

    @Override
    public boolean contains(T t) {
        for (int i = 0; i < size(); i++)
            if (data[i].equals(t)) return true;
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean remove(T t) {
        int index = 0;
        boolean check = false;
        for (int i = 0; i < size() && !check; i++) {
            if (data[i].equals(t)) {
                index = i;
                check = true;
            }
        }
        if (count[index] > 1 && check) {
            count[index]--;
            return true;
        }
        for (int i = index; i < size() - 1 && check; i++) {
            data[i] = data[i + 1];
            count[i] = count[i + 1];
        }
        if (check) {
            data[--size] = null;
            count[size] = 0;
        }
        return check;
    }

    @Override
    public String toString() {
        return  "data : " + Arrays.toString(data) + "\n" +
                "count : " + Arrays.toString(count);
    }
}
