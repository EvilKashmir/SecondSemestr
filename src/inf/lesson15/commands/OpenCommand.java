package inf.lesson15.commands;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OpenCommand extends Command {
    @Override
    public void run(Path root, String... parameter) throws IOException {
        if (parameter.length != 2) {
            System.out.println("Wrong number of parameters\n");
            return;
        }
        Path path = getPath(root, parameter[1]);
        if (path != null) {
            Desktop desktop = null;
            if (Desktop.isDesktopSupported()) {
                desktop = Desktop.getDesktop();
            }
            desktop.open(Paths.get(parameter[1]).toFile());
            System.out.print("\n");
        } else
            System.out.println("Not found\n");
    }

    @Override
    public String toString() {
        return "open <path> - open files";
    }
}
