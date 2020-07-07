package inf.lesson15.commands;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CatCommand extends Command {

    @Override
    public void run(Path root, String... parameter) throws IOException {
        Path path = getPath(root, parameter[1]);
        List<String> list = new ArrayList<>();
        if (path == null) {
            System.out.println("File not exist\n");
            return;
        }
        if (parameter.length == 2) {
            list = read(path, "UTF-8");
        } else if (parameter.length == 3)
            list = read(path, parameter[2]);
        if (list.size() == 0) {
            System.out.println("Empty file\n");
            return;
        }
        for (String line : list)
            System.out.println(line);
        System.out.println("\n");
    }

    public ArrayList<String> read(Path root, String encoding) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(root.toFile()), encoding));
            String str;
            while ((str = reader.readLine()) != null) {
                list.add(str);
            }
        } catch (UnsupportedEncodingException e) {
            System.out.println("Bad encoding\n");
        }
        return list;
    }


    @Override
    public String toString() {
        return "cat <file path> <encoding>[optional] - read file";
    }
}
