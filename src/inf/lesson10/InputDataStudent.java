package inf.lesson10;

import inf.lesson9.Student;
import java.io.*;

public class InputDataStudent extends InputStream {

    private InputStream in;

    public InputDataStudent(InputStream in) { this.in = in; }

    public Student readStudent() {
        try (DataInputStream st = new DataInputStream(in)){
            String name = st.readUTF();
            String gender = st.readUTF();
            int age = st.readInt();
            int group = st.readInt();
            return new Student(name, group, age, gender.equals("male"));
        } catch (IOException e) { e.printStackTrace(); }
        return null;
    }

    @Override
    public int read() throws IOException { throw new UnsupportedOperationException(); }
}