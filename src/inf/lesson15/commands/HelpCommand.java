package inf.lesson15.commands;

import java.nio.file.Path;

public class HelpCommand extends Command {
    @Override
    public void run(Path root, String... parameter) {
        if (parameter.length == 1) {
            System.out.println("Available commands : " +
                    "[cat, " +
                    "cd, " +
                    "copy, " +
                    "delete, " +
                    "dir, " +
                    "exit, " +
                    "help]\n");
        } else if (parameter.length == 2) {
            Command command = getCommand(parameter[1]);
            if (command != null)
                System.out.println(command + "\n");
        } else
            System.out.println("Wrong number of parameters\n");
    }

    @Override
    public String toString() {
        return "help <command name>[optional] - return available commands or description of command";
    }
}
