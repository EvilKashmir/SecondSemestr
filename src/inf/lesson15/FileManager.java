package inf.lesson15;

import inf.lesson15.commands.Command;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileManager {

    private static boolean status = true;
    private static Path root = Paths.get("D:\\JavaProjects\\SecondSem\\src");

    public void start() throws IOException {
        if (status) {
            System.out.print(root.toAbsolutePath() + ">");
            Scanner sc = new Scanner(System.in);
            String[] commands = sc.nextLine().trim().split(" ");
            Command command = Command.getCommand(commands[0]);
            if (command != null)
                command.run(root, commands);
            start();
        }
    }

    public static void setStatus(boolean newStatus) {
        status = newStatus;
    }

    public static void setRoot(Path newRoot) {
        root = newRoot;
    }
}
