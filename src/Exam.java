import static java.lang.Math.sqrt;

public class Exam {
    public static void main(String[] args) {
        boolean b = true;
        int p = 2;
        for (int i = 2; i <= sqrt(p) + 1; i++) {
            if (p % i == 0) b = false;
        }
        System.out.println(b);
    }
}
