package inf.lesson8;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try(OutputStream out = new FileOutputStream("D:\\JavaProjects\\SecondSem\\src\\inf\\lesson8\\test.txt");){
            int v = -987654321;
            char c = 'у';
            out.write(v >>> 24 & 0xFF);
            out.write(v >>> 16 & 0xFF);
            out.write(v >>>  8 & 0xFF);
            out.write(v >>>  0 & 0xFF);
            out.write(c >> 8 & 0xFF);
            out.write(c >> 0 & 0xFF);
            out.flush();
        }
        catch (IOException e){
            System.out.println("Not found");
        }
        try(InputStream in = new FileInputStream("D:\\JavaProjects\\SecondSem\\src\\inf\\lesson8\\test.txt")){
            int[] data = new int[2563443];
            int i = 0;
            int b;
            while((b = in.read())!= -1){
                data[i++] = b;
            }
            System.out.println("Integer from file = " + ((data[0] << 24) + (data[1] << 16) + (data[2] << 8) + (data[3])));
            System.out.println("Char from file = " + (char)((data[4]<<8) + data[5]));
        }
        catch (IOException e){
            System.out.println("Not found");
        }
    }
}