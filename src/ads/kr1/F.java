//package Ads.Codewars;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class F {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s1 = new String[sc.nextInt()];
        String[] s2 = new String[sc.nextInt()];
        for (int i = 0; i < s1.length; i++)
            s1[i] = sc.next();
        for (int i = 0; i < s2.length; i++)
            s2[i] = sc.next();
        Set<String> set1 = new HashSet<>(Arrays.asList(s1));
        Set<String> set2 = new HashSet<>(Arrays.asList(s2));
        int k1 = 0, k2 = 0, len = Math.max(s1.length, s2.length);
        for (int i = 0; i < len; i++) {
            if (i < s1.length) {
                if (!set1.contains(s1[i])) {
                    if (i + 1 < set1.size()) {
                        set1.remove(s2[i + 1]);
                        set2.remove(s2[i + 1]);
                        k1++;
                    }
                } else {
                    set1.remove(s1[i]);
                    set2.remove(s1[i]);
                    k1++;
                }
            }
            if (i < s2.length) {
                if (!set2.contains(s2[i])) {
                    if (i + 1 < set2.size()) {
                        set2.remove(s2[i + 1]);
                        set1.remove(s2[i + 1]);
                        k2++;
                    }
                } else {
                    set2.remove(s2[i]);
                    set1.remove(s2[i]);
                    k2++;
                }
            }
        }
        if (k1 > k2) System.out.print("YES" + "\n");
        else System.out.print("NO" + "\n");
    }
}
