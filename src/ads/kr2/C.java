package ads.kr2;

import java.util.Scanner;

public class C {

    private static int[] in = {1,2,3,4,5};
    private static int[][] order = new int[120][5];
    private static int cursor = 0;

    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int[][] a = new int[5][5];
        for (int i = 0; i < a.length; i++) for (int j = 0; j < a[i].length; j++) a[i][j] = src.nextInt();
        permutations(0);
        int happy = 0;
        for (int[] ints : order) {
            int t = 0;
            for (int j = 0; j < ints.length - 1; j++) {
                for (int k = j; k < ints.length - 1; k += 2) {
                    t += a[ints[k] - 1][ints[k + 1] - 1];
                    t += a[ints[k + 1] - 1][ints[k] - 1];
                }
            }
            if (t > happy) happy = t;
        }
        System.out.println(happy);
    }

    private static void permutations(int k) {
        if (k == in.length) {
            System.arraycopy(in, 0, order[cursor], 0, in.length);
            cursor++;
        } else {
            for (int j = k; j < in.length; j++) {
                int t = in[k];
                in[k] = in[j];
                in[j] = t;
                permutations(k + 1);
                t = in[k];
                in[k] = in[j];
                in[j] = t;
            }
        }
    }
}
