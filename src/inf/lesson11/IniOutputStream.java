package inf.lesson11;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class IniOutputStream extends OutputStream {

    private OutputStream out;

    public IniOutputStream(OutputStream out) {
        this.out = out;
    }

    public void iniWrite(HashMap<String, String> data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out))) {
            for (Map.Entry el : data.entrySet()) {
                if (el.getValue() == null)
                    writer.write(el.getKey().toString());
                else
                    writer.write(el.getKey().toString() + "=" + el.getValue().toString());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new IOException("Not found");
        }
    }

    @Override
    public void write(int i) throws IOException {
        throw new UnsupportedOperationException();
    }
}
