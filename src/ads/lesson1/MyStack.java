package ads.lesson1;

import java.util.EmptyStackException;

public class MyStack<T> {

    private int size;
    private T[] data;

    public MyStack() {
        data = (T[]) new Object[1000];
        size = 0;
    }

    public void add(T t) {
        if (t == null) throw new NullPointerException();
        data[size++] = t;
    }

    public T pop() {
        if (size() == 0) throw new EmptyStackException();
        T old = data[--size];
        T[] temp =(T[]) new Object[size];
        System.arraycopy(this.data, 0, temp, 0, temp.length);
        data = temp;
        return old;
    }

    public int size() {
        return size;
    }
}
