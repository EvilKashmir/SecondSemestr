package inf.lesson7;

import inf.lesson6.MyMap;

import java.util.*;
import java.util.stream.Stream;

public class MyStream {
    public static void main(String[] args) {
        method4();
        method5();
        method6();
        method7();
        method8();
    }

    public static void method4() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(6, 5, 4, 3, 2, 1));
        list.sort(Integer::compare);
        System.out.println(list);
    }

    public static void method5() {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 3, 10, 100));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(4, 2, 0));
        list1.stream().filter(n -> n > list2.stream().max(Integer::compare).get()).forEach(x -> System.out.print(x + " "));
        System.out.println();
    }

    public static void method6() {
        Set<String> set = new TreeSet<>(Arrays.asList("abc", "qwerty", "EEYdg", "AAAaaa"));
        String alfa = "eyuioa";
        System.out.println(set.stream().filter(str -> Arrays.stream(str.toLowerCase().split("")).filter(alf -> alfa.contains(alf)).count() > 3).count());
    }

    public static void method7() {
        ArrayList<Integer> keys = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<String> values = new ArrayList<>(Arrays.asList("one", "two", "third", "four", "Five"));
        Map<Integer, String> map = new MyMap<>(keys, values);
        Stream<Integer> newStream = map.keySet().stream();
        StringBuilder sb = new StringBuilder();
        newStream.forEach(str -> sb.append(str));
        System.out.println(sb.toString());
    }

    public static void method8() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("abcdeqwerty", "ddseqd"));
        System.out.println(list.stream().filter(n -> n.length() > 5).reduce((str1, str2) -> str1 + str2).get().length());
    }
}
