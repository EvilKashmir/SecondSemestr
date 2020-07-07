package inf.lesson15.commands;

import java.io.File;
import java.nio.file.Path;

public class DirCommand extends Command {
    @Override
    public void run(Path root, String... parameter) {
        if (parameter.length > 2) {
            System.out.println("Wrong number of parameters\n");
            return;
        }
        if (parameter.length == 1)
            printDir(root);
        else if (parameter.length == 2) {
            Path path = getPath(root, parameter[1]);
            if (path == null)
                System.out.println("Wrong parameters\n");
            else
                printDir(path);
        }
    }

    private void printDir(Path path) {
        if (path.toFile().isFile()) {
            System.out.println("Not directory\n");
        } else {
            File[] files = path.toFile().listFiles();
            if (files != null) {
                for (File el : files) {
                    System.out.println("\t ->" + el.getName());
                }
                System.out.print("\n");
            } else
                System.out.println("Empty directory\n");
        }
    }

    @Override
    public String toString() {
        return "dir <directory name>[optional] - show directories and files in root or directory";
    }
}
