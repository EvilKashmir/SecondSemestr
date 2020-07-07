package inf.lesson10;

import inf.lesson9.Student;
import java.io.*;

public class Test {
    public static void main(String[] args) {
        final String PATH =
                "D:/IdeaProjects/Projects/src/Inf/Lesson10/test.txt";
        Student student = new Student("A", 901, 20, false);
        try (OutputObjStudent out = new OutputObjStudent(new FileOutputStream(PATH));
             InputObjStudent in = new InputObjStudent(new FileInputStream(PATH))) {
            out.writeStudent(student);
            System.out.println(in.readStudent().toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
        try (OutputDataStudent out = new OutputDataStudent(new FileOutputStream(PATH));
             InputDataStudent in = new InputDataStudent(new FileInputStream(PATH))) {
            out.writeStudent(student);
            System.out.println(in.readStudent().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
