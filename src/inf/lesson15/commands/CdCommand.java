package inf.lesson15.commands;

import inf.lesson15.FileManager;

import java.nio.file.Files;
import java.nio.file.Path;

public class CdCommand extends Command {

    @Override
    public void run(Path root, String... parameter) {
        if (parameter.length == 2) {
            Path path = getPath(root, parameter[1]);
            if (path == null || !Files.isDirectory(path)) {
                System.out.println("Wrong parameters\n");
                return;
            }
            FileManager.setRoot(path.normalize());
            System.out.println("\n");
        } else if (parameter.length > 2)
            System.out.println("Wrong number of parameters\n");
    }
}
