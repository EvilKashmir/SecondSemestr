package inf.lesson13;

import org.ho.yaml.Yaml;
import java.io.*;

public class YAMLStudentInput extends InputStream {

    private InputStream in;

    public YAMLStudentInput(InputStream in) {
        this.in = in;
    }

    @Override
    public int read() {
        throw new UnsupportedOperationException();
    }

    public Student readStudent(String path) {
        Student student = new Student();
        try {
            student = (Student) Yaml.load(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return student;
    }
}
