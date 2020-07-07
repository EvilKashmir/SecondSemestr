package inf.lesson20;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DownloadThread extends Thread {

    private URL url;
    private Path root = Paths.get("D:\\JavaProjects\\SecondSem");

    private static int count = 1;

    public DownloadThread(URL name) {
        this.url = name;
    }

    public void run() {
        try (InputStream in = url.openConnection().getInputStream();
             OutputStream out = new FileOutputStream(count++ + "." + url.openConnection().getContentType().split("[/;]")[1])) {
            ByteBuffer buf = ByteBuffer.allocate(1024);
            while (in.available() > 0) {
                if (!(isInterrupted())) {
                    for (int i = 0; i < 1024; i++) {
                        buf.put((byte) in.read());
                    }
                    buf.rewind();
                    out.write(buf.array());
                    buf.rewind();
                    Thread.sleep(128);
                } else {
                    throw new InterruptedException();
                }
            }
            root = Paths.get(root.toString(), (count-1 + "." + url.openConnection().getContentType().split("[/;]")[1]));
            System.out.println((count-1 + "." + url.openConnection().getContentType().split("[/;]")[1]) + " was downloaded");
        } catch (IOException e) {
            System.out.println("Wrong URL.");
        } catch (InterruptedException e) {
            System.out.println("Thread stopped.");
        }
    }

    public URL getUrl() {
        return url;
    }

    public Path getRoot() {
        return root;
    }
}
