package ads.lesson3;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        MyLinkedList<Integer> list1 = new MyLinkedList<>();
        list1.add(1);
        list1.add(2);
        list.add(10);
        list.add(12);
        list.add(11);
        list1.add(3);
        MyLinkedList<Integer> mlist = list.merge(list1);
        System.out.println(mlist.toString());
        System.out.println(mlist.getFirst());
        System.out.println(mlist.getLast());
        mlist.add(1);
        mlist.addAfter(33,2);
        System.out.println(mlist.toString());
        System.out.println(mlist.getFirst());
        System.out.println(mlist.getLast());
        System.out.println(mlist.size());
        System.out.println(mlist.get(8));
    }
}
