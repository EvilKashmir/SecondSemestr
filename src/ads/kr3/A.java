package ads.kr3;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = sc.nextInt();
        }
        if (solve(0, 0, a)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static boolean solve(int sum, int i, int[] a) {
        if (i == a.length)
            return (sum % 360 == 0);
        return solve(sum + a[i], i + 1, a) || solve(sum + 360 - a[i], i + 1, a);
    }
}
