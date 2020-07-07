package ads.kr3;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        String s = sc.next();
        String str = "";
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (i + d < n) {
                str = s.substring(i, i + d);
            } else {
                str = s.substring(i);
            }
            i = i + str.lastIndexOf("1");
            count += 1;
            if (str.lastIndexOf("1") == -1) {
                count = -1;
                break;
            }
        }
        System.out.print("\n" + count);
    }
}
