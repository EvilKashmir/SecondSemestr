//package Ads.Codewars;

import java.util.*;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Double, Integer> map = new HashMap<>();
        int m = sc.nextInt();
        int x, y, k, temp = 0;
        for (int i = 0; i < n; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            k = sc.nextInt();
            temp += k;
            double r = Math.sqrt(x*x + y*y);
            map.put(r, k + (map.get(r) == null ? 0 : map.get(r)));
        }
        if (1000000 > m + temp) {
            System.out.println(-1);
            return;
        }
        ArrayList<Double> keys = new ArrayList<>();
        map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.naturalOrder())).forEach((s) -> keys.add(s.getKey()));
        for (Double el : keys) {
            m += map.get(el);
            if (m >= 1000000) {
                System.out.println(el);
                return;
            }
        }
    }
}
