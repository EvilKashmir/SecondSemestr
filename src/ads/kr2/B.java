//package ads.codewars2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int n = src.nextInt(), max = 0;
        int[] chain = new int[n + 1];
        chain[0] = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("polycarp", 0);
        for (int i = 1; i <= n; i++) {
            map.put(src.next().toLowerCase(), i);
            src.next();
            chain[i] = map.get(src.next().toLowerCase());
        }
        for (int i = 1; i <= n; i++) {
            int cur = i, res = 1;
            while (cur != 0) {
                res++;
                cur = chain[cur];
            }
            max = Math.max(max, res);
        }
        System.out.println(max);
    }
}
