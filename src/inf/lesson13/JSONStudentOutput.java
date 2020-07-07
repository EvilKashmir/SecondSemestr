package inf.lesson13;

import org.json.simple.JSONObject;

import java.io.*;

public class JSONStudentOutput extends OutputStream {

    private OutputStream out;

    public JSONStudentOutput(OutputStream out) {
        this.out = out;
    }

    @Override
    public void write(int b) {
        throw new UnsupportedOperationException();
    }

    public void writeStudent(Student student) {
        JSONObject json = new JSONObject();
        json.put("name", student.getName());
        json.put("group", student.getGroup());
        json.put("age", student.getAge());
        json.put("gender", student.isGender());
        try (OutputStreamWriter wr = new OutputStreamWriter(out)) {
            wr.write(json.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
