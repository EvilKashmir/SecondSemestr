package ads.lesson6;

import java.util.Arrays;

public class MergeSortRec {
    public static void main(String[] args) {
        int[] a = new int[]{9, 1, 8, 2, 7, 3, 6, 4, 5};
        System.out.println(Arrays.toString(a));
        int[] s = mergeSort(a);
        System.out.println("\n"+Arrays.toString(s));
    }

    private static int[] mergeSort(int[] arr) {
        int len = arr.length;
        if (len < 2) {
            return arr;
        }
        int middle = len / 2;
        return merge(mergeSort(Arrays.copyOfRange(arr, 0, middle)),
                mergeSort(Arrays.copyOfRange(arr, middle, len)));
    }

    private static int[] merge(int[] a1, int[] a2) {
        int len1 = a1.length;
        int len2 = a2.length;
        int k1 = 0;
        int k2 = 0;
        int len = len1 + len2;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            if (k1 < len1 && k2 < len2) {
                if (a1[k1] > a2[k2]) res[i] = a2[k2++];
                else  res[i] = a1[k1++];
            } else if (k2 < len2) res[i] = a2[k2++];
            else res[i] = a1[k1++];
        }
        return res;
    }
}
