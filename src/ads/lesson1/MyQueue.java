package ads.lesson1;

import java.util.Arrays;

public class MyQueue<T> {

    private T head;
    private T[] data;
    private int size;

    public MyQueue(int length) {
        data =(T[]) new Object[length];
        size = 0;
    }

    public boolean offer(T t) {
        if (data.length == size) return false;
        if (size == 0) head = t;
        data[size++] = t;
        return true;
    }

    public T peek() {
        if (size == 0) return null;
        return head;
    }

    public T poll() {
        if (size == 0) return null;
        T old = data[0];
        T[] temp =(T[]) new Object[(int)(data.length - 1)];
        System.arraycopy(data,1,temp,0, data.length - 1);
        data = temp;
        head = data[0];
        return old;
    }

    public int size() {
        return size;
    }

    public String toString() {
        return Arrays.toString(data);
    }
}
