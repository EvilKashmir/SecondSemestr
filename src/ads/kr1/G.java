package Ads.Codewars;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class G {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = new String[sc.nextInt()];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = sc.next();
        }
        Set<String> set = new HashSet<>();
        for (int i = strs.length - 1; i >= 0; i--) {
            if (!set.contains(strs[i])) {
                System.out.print(strs[i] + "\n");
                set.add(strs[i]);
            }
        }
    }
}
