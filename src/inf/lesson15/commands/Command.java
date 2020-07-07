package inf.lesson15.commands;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class Command {

    public abstract void run(Path root, String... parameter) throws IOException;

    public static Command getCommand(String commandName) {
        switch (commandName.toLowerCase().trim()) {
            case "cd":
                return new CdCommand();
            case "copy":
                return new CopyCommand();
            case "delete":
                return new DeleteCommand();
            case "dir":
                return new DirCommand();
            case "exit":
                return new ExitCommand();
            case "help":
                return new HelpCommand();
            case "open":
                return new OpenCommand();
            case "cat":
                return new CatCommand();
            default:
                System.out.println("Unknown command\n");
                break;
        }
        return null;
    }

    protected static Path getPath(Path path, String argument) {
        Path temp = path.resolve(Paths.get(argument));
        if (temp.toFile().exists()) {
            return temp;
        } else if (Paths.get(argument).toFile().exists()) {
            return Paths.get(argument);
        }
        return null;
    }
}
