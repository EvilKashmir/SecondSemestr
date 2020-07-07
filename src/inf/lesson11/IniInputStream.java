package inf.lesson11;

import java.io.*;
import java.util.HashMap;

public class IniInputStream extends InputStream {

    private InputStream in;

    public IniInputStream(InputStream in) {
        this.in = in;
    }

    public HashMap<String, String> iniRead() throws IOException {
        HashMap<String, String> data = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            while (reader.ready()) {
                String line = reader.readLine();
                String[] splitLine = line.split("=");
                if (splitLine.length == 1) {
                    data.put(splitLine[0], null);
                } else {
                    data.put(splitLine[0], splitLine[1]);
                }
            }
        } catch (IOException e) {
            throw new IOException("Not found");
        }
        return data;
    }

    @Override
    public int read() throws IOException {
        throw new UnsupportedOperationException();
    }
}
