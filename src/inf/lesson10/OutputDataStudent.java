package inf.lesson10;

import inf.lesson9.Student;
import java.io.*;

public class OutputDataStudent extends OutputStream {
    private OutputStream out;

    public OutputDataStudent(OutputStream out) { this.out = out; }

    public void writeStudent(Student student) throws IOException {
        try(DataOutputStream st = new DataOutputStream(out)){
            st.writeUTF(student.getName());
            st.writeUTF(student.isGender());
            st.writeInt(student.getAge());
            st.writeInt(student.getGroup());
        }
        catch (IOException e){ e.printStackTrace(); }
    }

    @Override
    public void write(int b) throws IOException {
        throw new UnsupportedOperationException();
    }
}