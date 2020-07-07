package inf.lesson3;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        String[] data1 = {"a", "b" , "c" , "d", null, "e", "f", "z" , null};
        String[] data2 = {null, null, null, null};
        String[] data3 = {};
        String[] data4 = {"a", "b","c"};
        StrangeIterator strange = new StrangeIterator(data4);
        SimpleIterator simple = new SimpleIterator(data4);
        InterestingIterator inter = new InterestingIterator(data4);
        EndlessIterator ei = new EndlessIterator();
        EAIterator ea = new EAIterator();
        EAIterable<String> ea1 = new EAIterable<>(data4);
        Iterator iterator = ea1.iterator();
        ea1.add("a");
        ea1.add("b");
        ea1.add("b");
        /*while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
 while (ea.hasNext()) {
            System.out.println(ea.next());
        }
        System.out.println(ea.toString());
        while (ei.hasNext()) {
            System.out.println(ei.next());
        }
        while (inter.hasNext()) {
            System.out.println(inter.next());
        }

        System.out.println();
        while(strange.hasNext()) {
            System.out.println(strange.next());
        }
        System.out.println();
        while(simple.hasNext()) {
            System.out.println(simple.next());
        }
        System.out.println(strange.hasNext());
        System.out.println(strange.next());
        System.out.println(strange.hasNext());
        System.out.println(strange.next());
        System.out.println(strange.hasNext());
        System.out.println(strange.next());

        System.out.println(simple.hasNext());
        System.out.println(simple.next());
        System.out.println(simple.hasNext());
        System.out.println(simple.next());
        System.out.println(simple.hasNext());
        System.out.println(simple.next());
        System.out.println(simple.hasNext());
        System.out.println(simple.next());*/
    }
}
