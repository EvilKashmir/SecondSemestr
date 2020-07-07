package ads.lesson2;

public class Main {
    public static void main(String[] args) {
        MySet<Integer> set = new MySet<>();
        MySet<Integer> set2 = new MySet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set2.add(10);
        set2.add(6);
        set2.add(7);
        set2.add(8);
        set2.add(9);
        set.merge(set2);
        System.out.println(set.toString());
        /*MyMultiSet<Integer> multiSet = new MyMultiSet<>();
        System.out.println(multiSet.add(1));
        System.out.println(multiSet.add(2));
        System.out.println(multiSet.add(3));
        System.out.println(multiSet.add(4));
        System.out.println(multiSet.size());
        System.out.println(multiSet.toString());
        System.out.println(multiSet.add(4));
        System.out.println(multiSet.size());
        System.out.println(multiSet.toString());
        System.out.println(multiSet.contains(1));
        System.out.println(multiSet.contains(2));
        System.out.println(multiSet.contains(10));*/
    }
}
