package inf.lesson2;

import ads.lesson2.BubbleSort;

public class Main {
    public static void main(String[] args) {
        Integer[] data = {5, 7, 2, 16, -7, 3};
        BubbleSort.sort(data);
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }
}
