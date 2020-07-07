package ads.lesson6;//package ads.lesson6;
//
//import java.math.BigInteger;
//import java.util.Arrays;
//
//public class Karatsuba {
//    public static void main(String[] args) {
//        System.out.println(karatsubaSolve(BigInteger.valueOf(1234), BigInteger.valueOf(1000)));
//    }
//
//    public static BigInteger karatsubaSolve(BigInteger num1, BigInteger num2) {
//        boolean[] b1 = toBinArray(num1);
//        boolean[] b2 = toBinArray(num2);
//        int maxLen = Math.max(b1.length, b2.length);
//        if (maxLen < 100)
//            num1.multiply(num2);
//        int divider = (int) Math.pow(2, Math.round(maxLen / 2));
//        boolean[] a = binDiv(b1, (int) Math.pow(2, Math.round(maxLen / 2)));
//        boolean[] b = binMod(b1, (int) Math.pow(2, Math.round(maxLen / 2)));
//        boolean[] c = binDiv(b2, (int) Math.pow(2, Math.round(maxLen / 2)));
//        boolean[] d = binMod(b2, (int) Math.pow(2, Math.round(maxLen / 2)));
//
//        BigInteger first = karatsubaSolve(toNum(a), toNum(c));
//        BigInteger second = karatsubaSolve(toNum(b), toNum(d));
//        BigInteger third = karatsubaSolve(toNum(binSum(a, b)), toNum(binSum(c, d)));
//
//        return first.multiply(BigInteger.valueOf((int) Math.pow(2, Math.round(maxLen))))
//                .add((third.subtract(second).subtract(first))
//                        .multiply(BigInteger.valueOf((int) Math.pow(2, Math.round(maxLen / 2))))).add(second);
//    }
//
//    public static boolean[] toBinArray(BigInteger num) {
//        char[] boolChars = num.toString(2).toCharArray();
//        boolean[] res = new boolean[boolChars.length];
//        for (int i = 0; i < boolChars.length; i++) {
//            if (boolChars[i] == '1')
//                res[i] = true;
//            else
//                res[i] = false;
//        }
//        return res;
//    }
//
//    public static BigInteger toNum(boolean[] b) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < b.length; i++) {
//            if (b[i]) sb.append('1');
//            else sb.append('0');
//        }
//        return new BigInteger(sb.toString(), 2);
//    }
//
//    // целочисленное деление булевого массива (на число кратное 2)
//    public static boolean[] binDiv(boolean[] b, int num) {
//        return Arrays.copyOfRange(b, 0, b.length - Integer.toBinaryString(num).length() + 1);
//    }
//
//    // остаток от деления булевого массива (на число кратное 2)
//    public static boolean[] binMod(boolean[] b, int num) {
//        return Arrays.copyOfRange(b, b.length - Integer.toBinaryString(num).length() + 1, b.length);
//    }
//
//    // сложение двух булевых массивов
//    public static boolean[] binSum(boolean[] b1, boolean[] b2) {
//        return toBinArray(toNum(b1).add(toNum(b2)));
//    }
//}
import java.math.BigInteger;
import java.util.Arrays;

public class Karatsuba {
    public static void main(String[] args) {
        System.out.println(karatsubaSolve(BigInteger.valueOf(9876), BigInteger.valueOf(10001)));
    }

    private static BigInteger karatsubaSolve(BigInteger bi1, BigInteger bi2) {
        boolean[] b1 = toBin(bi1);
        boolean[] b2 = toBin(bi2);
        double maxLen = Math.max(b1.length,b2.length);
        if (maxLen < 100)
            return bi1.multiply(bi2);
        boolean[] a = binDiv(b1, (int) Math.pow(2, Math.round(maxLen/2)));
        boolean[] b =  binMod(b1, (int) Math.pow(2, Math.round(maxLen/2)));
        boolean[] c = binDiv(b2, (int) Math.pow(2, Math.round(maxLen/2)));
        boolean[] d =  binMod(b2, (int) Math.pow(2, Math.round(maxLen/2)));
        BigInteger f = karatsubaSolve(toDec(a), toDec(c));
        BigInteger s = karatsubaSolve(toDec(b), toDec(d));
        BigInteger t = karatsubaSolve(toDec(binSum(a,b)), toDec(binSum(c,d)));
        return  f.add(s).add(t);
    }

    public static boolean[] toBin(BigInteger num) {
        char[] binChars = num.toString(2).toCharArray();
        boolean[] res = new boolean[binChars.length];
        for (int i = 0; i < binChars.length; i++) {
            if (binChars[i] == '1') res[i] = true;
            else res[i] = false;
        }
        return res;
    }

    public static BigInteger toDec(boolean[] b) {
        StringBuilder sb = new StringBuilder();
        for (boolean value : b) {
            if (value) sb.append('1');
            else sb.append('0');
        }
        return new BigInteger(sb.toString(), 2);
    }

    public static boolean[] binDiv(boolean[] b, int num) {
        return Arrays.copyOfRange(b, 0, b.length - Integer.toBinaryString(num).length() + 1);
    }

    public static boolean[] binMod(boolean[] b, int num) {
        return Arrays.copyOfRange(b, b.length - Integer.toBinaryString(num).length() + 1, b.length);
    }

    public static boolean[] binSum(boolean[] b1, boolean[] b2) {
        return toBin(toDec(b1).add(toDec(b2)));
    }
}