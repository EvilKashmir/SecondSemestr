package ads.lesson2;

public class BubbleSort {
    public static <T extends Comparable> void sort(T[] data) {
        boolean check = false;
        T temp = null;
        while(!check) {
            check = true;
            for (int i = 0; i < data.length - 1; i++) {
                if (data[i].compareTo(data[i + 1]) > 0) {
                    check = false;
                    temp = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = temp;
                }
            }
        }
    }
}


