package inf.lesson11;

import java.io.*;
import java.util.HashMap;

public class Test {

    private final static String PATH = "src/Inf/Lesson11/test.ini";

    public static void main(String[] args) throws IOException {

        HashMap<String, String> data = new HashMap<>();
        data.put("test1", "true");
        data.put("some", "code");
        data.put("[JSON]", null);
        data.put("json", "gg");

        try (IniOutputStream out = new IniOutputStream(new FileOutputStream(PATH))) {
            out.iniWrite(data);
        } catch (IOException e) {
            throw new IOException("Not found");
        }

        try (IniInputStream in = new IniInputStream(new FileInputStream(PATH))) {
            System.out.println(in.iniRead());
        } catch (IOException e) {
            throw new IOException("Not found");
        }


    }
}
