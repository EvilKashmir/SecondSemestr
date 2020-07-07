package inf.lesson15.commands;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DeleteCommand extends Command {
    @Override
    public void run(Path root, String... parameter) throws IOException {
        if (parameter.length != 2) {
            System.out.println("Wrong number of parameters\n");
        } else {
            Path path = getPath(root, parameter[1]);
            if (path == null) {
                System.out.println("Wrong parameter\n");
                return;
            }
            delete(path);
            Files.deleteIfExists(path);
            System.out.print("\n");
        }
    }

    private void delete(Path path) throws IOException {
        if (path.toFile().isFile()) {
            Files.deleteIfExists(path);
        } else {
            File[] files = path.toFile().listFiles();
            if (files != null) {
                for (File el : files) {
                    if (el.isDirectory()) {
                        delete(el.toPath());
                    }
                    Files.deleteIfExists(el.toPath());
                }
            }
        }
    }

    @Override
    public String toString() {
        return "delete <file/directory path> - delete file/directory";
    }
}
