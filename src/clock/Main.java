package clock;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;

public class Main {

    static private int width = 1980, height = 1080;
    static private Point O = new Point(width / 2, height / 2);

    public static void main(String[] args) {
        System.out.println("\nHello Alexander Ferenets! let's show you my clock...\n");
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Clock clock1 = new Clock(), clock2 = new Clock();
        Graphics gr = bi.createGraphics();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                bi.setRGB(x, y, Color.GRAY.getRGB());
            }
        }
        int radiusClock = Math.min(O.x, O.y) - 90;
        int radiusHour = radiusClock - 50;
        double angle;

        for (int i = 1; i < 13; i++) {
            angle = Math.PI / 2 - i * Math.PI / 6;
            Point point = getEndPoint(angle, radiusClock);
            drawString(gr, point, i);
        }

        drawHourLine(gr, clock1, radiusHour, new Color(26, 26, 255));
        drawHourLine(gr, clock2, radiusHour, new Color(255, 0, 0));

        try {
            ImageIO.write(bi, "jpg", new File("NewImage.jpg"));
        } catch (IOException e) {
            System.out.println("Wrong output");
        }
    }

    /**
     * Draw each hour's line
     *
     * @param gr
     * @param clock1
     * @param radiusHour
     * @param color
     */
    private static void drawHourLine(Graphics gr, Clock clock1, int radiusHour, Color color) {
        double angle = Math.PI / 2 - (clock1.getHours() + clock1.getMinutes() / 60.0) * Math.PI / 6;
        Point point = getEndPoint(angle, radiusHour);
        gr.setColor(color);
        gr.drawLine(O.x, O.y, point.x, point.y);
    }

    /**
     * Get point where we creat clock's number or draw hour's line
     *
     * @param angle
     * @param radiusClock
     * @return
     */
    private static Point getEndPoint(double angle, int radiusClock) {
        int x = (int) (O.x + radiusClock * Math.cos(angle));
        int y = (int) (O.y - radiusClock * Math.sin(angle));
        return new Point(x, y);
    }

    /**
     * Draw clock's numbers
     *
     * @param gr
     * @param point
     * @param i
     */
    private static void drawString(Graphics gr, Point point, int i) {
        gr.setColor(Color.WHITE);
        Font font = new Font("TimesRoman", Font.BOLD, 25);
        gr.setFont(font);
        gr.drawString(i + "", point.x - 15, point.y - 15);
    }

    /**
     * New class which help to input time
     *
     */
    private static class Clock {

        private int hours;
        private int minutes;

        public Clock() {
            Scanner src = new Scanner(System.in);
            System.out.println("Input hours and minutes");
            hours = src.nextInt();
            minutes = src.nextInt();
        }

        public int getMinutes() {
            return minutes;
        }

        public int getHours() {
            return hours;
        }
    }
}
