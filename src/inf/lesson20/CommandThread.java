package inf.lesson20;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class CommandThread extends Thread {

    private DownloadThread dt;
    private boolean status = true;

    private static String COMMANDS = "Available commands: [ download<url> , help, show, stopDownload, stopProgram ]";

    public void start() {
        System.out.println("Enter command\n" + COMMANDS);
        Scanner scanner = new Scanner(System.in);
        while (status) {
            switch (scanner.nextLine().trim().toLowerCase()) {
                case "exit":
                    stopProgram();
                    break;
                case "d":
                    System.out.println("Enter URL");
                    download(scanner.nextLine());
                    break;
                case "show":
                    showProgress();
                    break;
                case "s":
                    stopDownload();
                    break;
                case "help":
                    help();
                    break;
                default:
                    System.out.println("Unknown command.");
            }
        }
    }

    private void download(String str) {
        try {
            dt = new DownloadThread(new URL(str));
            dt.start();
        } catch (MalformedURLException e) {
            System.out.println("Wrong URL");
        }
    }

    private void showProgress() {
        try {
            if (dt.isAlive()) {
                int a = dt.getUrl().openConnection().getContentLength();
                int b = (int) Files.size(dt.getRoot());
                System.out.println(b * 100 / a + "%");
            } else System.out.println("There is nothing to show");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("There is nothing to show");
        }
    }

    private void stopDownload() {
        try {
            if (dt.isAlive()) ;
            dt.interrupt();
        } catch (NullPointerException e) {
            System.out.println("There is nothing to stop");
        }
    }

    private void stopProgram() {
        status = false;
    }

    private void help() {
        System.out.println(COMMANDS);
    }
}
