package inf.lesson12;

import java.util.Scanner;
import java.util.regex.*;

public class Regexp {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);

        Pattern pattern = Pattern.compile("([a-zA-Z0-9]([a-zA-Z0-9\\-]{0,54}[a-zA-Z0-9])?\\.)+[a-zA-Z]{2,7}");
        System.out.println(pattern.matcher(src.nextLine()).matches());

        show(pattern.matcher(src.nextLine()));

        Pattern pattern1 = Pattern.compile("(((?<=@)[a-zA-Z\\d]([a-zA-Z\\d\\-]{0,54}[a-zA-Z\\d])?(?=\\.))|((?<=\\.)[a-zA-Z]{2,7})$)");
//                Pattern.compile("(((?<=@)[a-zA-Z\\d]([a-zA-Z\\d]*[a-zA-Z\\d])?(?=\\.))|((?<=\\.)[a-zA-Z]{2,7})$)");
//

        show(pattern1.matcher(src.nextLine()));
    }

    private static void show(Matcher matcher) {
        if (matcher.find()) {
            StringBuilder res = new StringBuilder();
            do {
                res.append(matcher.group()).append("\n");
            } while (matcher.find());
            System.out.print(res.toString());
        } else
            System.out.println("not found");
    }
}
