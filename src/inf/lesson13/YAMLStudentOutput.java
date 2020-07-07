package inf.lesson13;

import org.ho.yaml.YamlEncoder;
import java.io.*;

public class YAMLStudentOutput extends OutputStream {

    private OutputStream out;

    public YAMLStudentOutput(OutputStream out) {
        this.out = out;
    }

    @Override
    public void write(int b) {
        throw new UnsupportedOperationException();
    }

    public void writeStudent(Student student) {
        YamlEncoder enc = new YamlEncoder(out);
        enc.writeObject(student);
        enc.close();
    }
}
