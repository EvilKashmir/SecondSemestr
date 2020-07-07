//package Ads.Codewars;

import java.util.Arrays;
import java.util.Scanner;

public class C {

    private static int[] a;
    private static int l;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = new int[sc.nextInt()];
        l = sc.nextInt();
        for (int i = 0; i < a.length; i++)
            a[i] = sc.nextInt();
        Arrays.sort(a);
        System.out.println(solve());
    }

    private static double solve() {
        double m = 0;
        if (a[0] != 0) m = a[0];
        if (a[a.length - 1] != l) m = Math.max(m, l - a[a.length - 1]);
        for (int i = 0; i < a.length - 1; i++)
            m = Math.max(m, (a[i + 1] - a[i]) / 2d);
        return m;
    }
}
