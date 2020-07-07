package ads.kr2;

import java.util.Scanner;

public class G {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int k = sc.nextInt(), min = 0;
        for (int i = 0; i < k; i++) {
            a[i] = sc.nextInt();
            min += a[i];
        }
        int sum = min, mini = 0, index = 0;
        for (int i = k; i < a.length; i++) {
            a[i] =sc.nextInt();
            sum = sum - a[index++] + a[i];
            if (sum < min) {
                min = sum;
                mini = index;
            }
        }
        System.out.println(++mini);
    }
}