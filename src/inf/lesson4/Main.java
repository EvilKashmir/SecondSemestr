package inf.lesson4;

public class Main {
    public static void main(String[] args) {
        ModCollection<Integer> mc = new ModCollection<>();
        mc.add(1);
        System.out.println(mc.remove(1));
    }
}
