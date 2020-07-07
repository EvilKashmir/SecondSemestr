package inf.lesson13;

import java.io.*;

public class Main {

    private static final String PATH_JSON = "D:\\JavaProjects\\SecondSem\\src\\inf\\lesson13/test.json";
    private static final String PATH_YAML = "D:\\JavaProjects\\SecondSem\\src\\inf\\lesson13/test.yaml";

    public static void main(String[] args) {
        Student student = new Student("Ural", 902, 18, true);
        try (JSONStudentOutput out = new JSONStudentOutput(new FileOutputStream(PATH_JSON))) {
            out.writeStudent(student);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (JSONStudentInput in = new JSONStudentInput(new FileInputStream(PATH_JSON))) {
            student = in.readStudent();
            System.out.println("JSON: " + student);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (YAMLStudentOutput out = new YAMLStudentOutput(new FileOutputStream(PATH_YAML))) {
            out.writeStudent(student);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (YAMLStudentInput in = new YAMLStudentInput(new FileInputStream(PATH_YAML))) {
            student = in.readStudent(PATH_YAML);
            System.out.println("YAML: " + student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
