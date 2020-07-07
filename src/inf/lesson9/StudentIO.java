package inf.lesson9;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.*;

public class StudentIO {

    public static Collection<Student> read(String path) {
        ArrayList<Student> res = new ArrayList<>();
        try (FileInputStream in = new FileInputStream(path)) {
            File file = new File(path);
            int temp = 0;
            while (temp != -1) {
                ByteBuffer bb = ByteBuffer.allocate((int) file.length());
                while (temp != '\n') {
                    bb.put((byte) temp);
                    temp = in.read();
                }
                bb.rewind();
                byte[] b = new byte[bb.remaining()];
                bb.get(b);
                String[] strspl = (new String(b)).split(",");
                for (int i = 0; i < strspl.length; i++)
                    strspl[i] = strspl[i].trim();
                res.add(new Student(
                        strspl[0], Integer.parseInt(strspl[1]), Integer.parseInt(strspl[2]), strspl[3].equals("male")));
                temp = in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static boolean write(Collection<Student> students) {
        try (FileOutputStream out = new FileOutputStream("D:\\JavaProjects\\SecondSem\\src\\inf\\lesson9\\output.txt")) {
            for (Student st : students) {
                ByteBuffer buff = ByteBuffer.wrap(st.getName().getBytes());
                byte[] b = new byte[buff.remaining()];
                buff.get(b);
                out.write(buff.array());
                out.write(',');
                out.write(' ');
                String s = st.getGroup() + "";
                buff = ByteBuffer.wrap(s.getBytes());
                b = new byte[buff.remaining()];
                buff.get(b);
                out.write(buff.array());
                out.write(',');
                out.write(' ');
                s = st.getAge() + "";
                buff = ByteBuffer.wrap(s.getBytes());
                b = new byte[buff.remaining()];
                buff.get(b);
                out.write(buff.array());
                out.write(',');
                out.write(' ');
                s = st.isGender() + "";
                buff = ByteBuffer.wrap(s.getBytes());
                b = new byte[buff.remaining()];
                buff.get(b);
                out.write(buff.array());
                out.write('\n');
            }
        } catch (IOException e) { e.printStackTrace(); }
        return true;
    }
}

