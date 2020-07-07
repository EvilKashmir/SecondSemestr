//package Ads.Codewars;

import java.util.Scanner;

public class D {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[sc.nextInt()];
        int m = sc.nextInt();
        a[0] = sc.nextInt() * sc.nextInt();
        for (int i = 1; i < a.length; i++)
            a[i] = a[i-1] + sc.nextInt() * sc.nextInt();
        for (int i = 0, j = 0; i < m; i++) {
            int v = sc.nextInt();
            while (a[j] < v) j++;
            System.out.print(j + 1 + "\n");
        }
    }
}
