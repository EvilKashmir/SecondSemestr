package ads.lesson2;

import java.util.Arrays;

import static java.lang.System.arraycopy;

public class MySet<T> implements ISet<T>{

    private T[] data;
    private int size;

    public MySet() {
        data = (T[]) new Object[1000];
        size = 0;
    }

    public boolean add(T t) {
        if (t == null) throw new NullPointerException();
        if (!contains(t)) {
            data[size++] = t;
            return true;
        }
        return false;
    }

    public boolean contains(T t) {
        if (t == null) throw new NullPointerException();
        for (int i = 0; i < size(); i++)
            if (data[i].equals(t)) return true;
        return false;
    }

    public int size() {
        return size;
    }

    public boolean remove(T t) {
        if (t == null) throw new NullPointerException();
        int index = 0;
        boolean check = false;
        for (int i = 0; i < size() && !check; i++) {
            if (data[i].equals(t)) {
                index = i;
                check = true;
            }
        }
        for (int i = index; i < size() - 1 && check; i++)
            data[i] = data[i + 1];
        if (check) data[--size] = null;
        return check;
    }

    public MySet merge(MySet set) {
        MySet res = new MySet();
        res.data = (T[]) new Object[this.size() + set.size()];
        arraycopy(this.data, 0, res.data, 0, this.size());
        arraycopy(set.data,0, res.data, this.size(), set.size());
        res.size = this.size() + set.size();
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; i < res.size(); j++) {
                    if (res.data[i].equals(res.data[j])) res.data[j] = null;
            }
        }
        return res;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
