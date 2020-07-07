package inf.lesson16;

import java.io.*;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Downloader {
    public static void main(String[] args) {
        first();
        //second();
    }

    private static void first() {
        Scanner src = new Scanner(System.in);
        System.out.println("Enter URL");
        String url = src.nextLine();
        try (InputStream in = new BufferedInputStream(new URL(url).openStream());
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            byte[] buf = new byte[1024];
            int n = in.read(buf);
            while (n != -1) {
                out.write(buf, 0, n);
                n = in.read(buf);
            }
            String type = new URL(url).openConnection().getContentType();
            String name = "";
            if (type.contains("image")) {
                name = "first.jpg";
            } else if (type.contains("text")) {
                name = "first.txt";
            } else
                System.out.println("Unsupported content type");
            FileOutputStream fos = new FileOutputStream(name);
            fos.write(out.toByteArray());
            fos.close();
            System.out.println(name + " created successfully");
        } catch (FileNotFoundException e) {
            System.out.print("Bad URL");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void second() {
        Scanner src = new Scanner(System.in);
        System.out.println("Enter URL");
        String url = src.nextLine();
        System.out.println("Which of : img or div ?");
        String mode = src.nextLine();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new URL(url).openStream()))) {
            int count = 0;
            String regexp;
            if (mode.trim().equals("div")) {
                regexp = "</div>";
            } else if (mode.trim().equals("img")) {
                regexp = "<img ";
            } else {
                System.out.println("invalid mod");
                return;
            }
            String line = in.readLine();
            while (line != null) {
                Matcher matcher = Pattern.compile(regexp).matcher(line);
                while (matcher.find()) {
                    count++;
                }
                line = in.readLine();
            }
            System.out.println("Quantity of " + mode + " is " + count);
        } catch (FileNotFoundException e) {
            System.out.print("Bad URL");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//todo сделать для audio