package inf.lesson10;

import inf.lesson9.Student;
import java.io.*;

public class OutputObjStudent extends OutputStream {
    private OutputStream out;

    public OutputObjStudent(OutputStream out) { this.out = out; }

    public void writeStudent (Student student) throws IOException {
        try(ObjectOutputStream oout = new ObjectOutputStream(out)){ oout.writeObject(student); }
        catch (IOException e){ e.printStackTrace(); }
    }

    @Override
    public void write(int b) throws IOException {
        throw new UnsupportedOperationException();
    }
}
