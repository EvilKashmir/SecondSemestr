//package ads.codewars2;

import java.math.BigInteger;
import java.util.Scanner;

public class H {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt();
        if (a + b * 3 < n) {
            System.out.println(0);
            return;
        }
        BigInteger res = BigInteger.ZERO;
        while (b >= 0) {
            for (int i = 0; i <= a; i++) {
                if (i + b * 3 == n) {
                    BigInteger b1 = fact(BigInteger.valueOf(b));
                    BigInteger a1 = fact(BigInteger.valueOf(i));
                    BigInteger mult = b1.multiply(a1);
                    res = res.add(fact(BigInteger.valueOf(i + b)).divide(mult)).mod(BigInteger.valueOf(1000000009));
                    break;
                }
                if (i + b * 3 > n) break;
            }
            b--;
        }
        System.out.println(res);
    }

    private static BigInteger fact(BigInteger bigInt) {
        BigInteger res = BigInteger.valueOf(1);
        for (int i = 1; i <= bigInt.intValue(); i++) {
            res = res.multiply(BigInteger.valueOf(i));
        }
        return res;
    }
}
