package inf.lesson10;

import inf.lesson9.Student;
import java.io.*;

public class InputObjStudent extends InputStream {
    private InputStream in;

    public InputObjStudent (InputStream in) { this.in = in; }

    public Object readStudent() throws IOException {
        try(ObjectInputStream oin = new ObjectInputStream(in)){ return (Student) oin.readObject(); }
        catch (IOException | ClassNotFoundException e){ e.printStackTrace(); }
        return null;
    }

    @Override
    public int read() throws IOException {
        throw new UnsupportedOperationException();
    }
}
