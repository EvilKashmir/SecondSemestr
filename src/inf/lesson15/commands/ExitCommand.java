package inf.lesson15.commands;

import inf.lesson15.FileManager;

import java.nio.file.Path;

public class ExitCommand extends Command {
    @Override
    public void run(Path root, String... parameter) {
        if (parameter.length == 1) {
            FileManager.setStatus(false);
        } else
            System.out.println("Wrong number of parameters\n");
    }

    @Override
    public String toString() {
        return "exit - stop program";
    }
}
