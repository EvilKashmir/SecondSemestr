package ads.kr1;

import java.util.Arrays;
import java.util.Scanner;

public class A {

    private static int[] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = new int[sc.nextInt()];
        for (int i = 0; i < a.length; i++)
            a[i] = sc.nextInt();
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        int m = sc.nextInt();
        for (int i = 0; i < m; i++)
            System.out.println(solve(sc.nextInt()) + " ");
    }

    private static int solve(int j) {
        int start = 0;
        int end = a.length - 1;
        if (a[end] <= j) return end + 1;
        if(a[start] > j) return 0;
        while (start <= end) {
            if (a[end] <= j) return ++end;
            if (a[start] > j) return start;
            int mid = (start + end) / 2;
            if (a[mid] <= j) start = ++mid;
            else end = --mid;
        }
        return 0;/*
        9
        3 6 8 10 11 15 22 27 29
        5
        5 7 9 2 3*/
    }
}
