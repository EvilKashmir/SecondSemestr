//package ads.codewars2;

import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> mapB = new HashMap<>();
        Map<Integer, Integer> mapS = new HashMap<>();
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int p;
        int q;
        String d;
        for (int i = 0; i < n; i++) {
            d = scanner.next();
            p = scanner.nextInt();
            q = scanner.nextInt();
            if (d.equals("B")) {
                if (mapB.containsKey(p))
                    mapB.put(p, mapB.get(p) + q);
                else
                    mapB.put(p, q);
            } else if (d.equals("S")) {
                if (mapS.containsKey(p))
                    mapS.put(p, mapS.get(p) + q);
                else
                    mapS.put(p, q);
            }
        }
        mapS.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.naturalOrder())).limit(s).sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).forEach(x -> System.out.println("S " + x.getKey() + " " + x.getValue()));
        mapB.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).limit(s).forEach(x -> System.out.println("B " + x.getKey() + " " + x.getValue()));
    }
}
