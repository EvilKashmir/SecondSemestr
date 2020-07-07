package inf.lesson15.commands;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class CopyCommand extends Command {

    @Override
    public void run(Path root, String... parameter) throws IOException {
        if (parameter.length != 3)
            System.out.println("Wrong number of parameters\n");
        else {
            Path source = getPath(root, parameter[1]);
            Path destination = getPath(root, parameter[2]);
            if (source == null || destination == null) {
                System.out.println("Wrong parameter\n");
                return;
            }
            copy(source, destination);
            System.out.print("\n");
        }
    }

    private void copy(Path source, Path destination) throws IOException {
        if (source.toFile().isFile())
            Files.copy(source, destination.resolve(source.toFile().getName()), StandardCopyOption.REPLACE_EXISTING);
        else {
            File[] files = source.toFile().listFiles();
            if (files != null) {
                for (File el : files) {
                    if (el.isDirectory()) {
                        Files.createDirectory(destination.resolve(el.getName()));
                        copy(source.resolve(el.getName()), destination.resolve(el.getName()));
                    } else
                        Files.copy(el.toPath(), destination.resolve(el.getName()), StandardCopyOption.REPLACE_EXISTING);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "copy <file/directory path> <directory path> - copy file/directory in directory";
    }
}
