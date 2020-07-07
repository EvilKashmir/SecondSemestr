package inf.lesson13;

import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import java.io.*;

public class JSONStudentInput extends InputStream {

    private InputStream in;

    public JSONStudentInput(InputStream in) {
        this.in = in;
    }

    @Override
    public int read() {
        throw new UnsupportedOperationException();
    }

    public Student readStudent() {
        StringBuilder jsonString = new StringBuilder();
        Student student = new Student();
        try (InputStreamReader reader = new InputStreamReader(in)) {
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            student = new Student((String) jsonObject.get("name"), ((Long) jsonObject.get("group")).intValue(),
                    ((Long) jsonObject.get("age")).intValue(), jsonObject.get("gender").equals("male"));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return student;
    }
}
