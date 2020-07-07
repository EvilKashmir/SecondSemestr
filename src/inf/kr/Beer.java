package inf.kr;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Beer {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        String id = src.nextLine();
        URLConnection url = openURI(id.trim());

        try (InputStreamReader reader = new InputStreamReader(new BufferedInputStream(url.getInputStream()));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("ingredients.ini")))) {

            JSONParser jsonParser = new JSONParser();
            JSONArray jsonArray = (JSONArray) jsonParser.parse(reader);
            JSONObject jsonObject = (JSONObject) jsonArray.get(0);

            downloadImages(new URI((String) jsonObject.get("image_url")));
            downloadDescription((String) jsonObject.get("description"));
            downloadIngredients((JSONObject) jsonObject.get("ingredients"));
        } catch (IOException | ParseException | URISyntaxException e) {
            System.out.println("Can't find this beer...");
        }

    }

    private static void downloadIngredients(JSONObject ingredients) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("ingredients.ini")))){
            JSONArray malts = (JSONArray) ingredients.get("malt");
            writer.write("[MALTS] (\n");
            for (int i = 0; i < malts.size(); i++) {
                JSONObject malt = (JSONObject) malts.get(i);
                writer.write("[section" + (i+1) + "] \n");
                writer.write("name=" + malt.get("name")+"\n");
                writer.write("[AMOUNT] (\n");
                JSONObject amount = (JSONObject) malt.get("amount");
                writer.write("value=" + amount.get("value")+"\n");
                writer.write("unit=" + amount.get("unit")+"\n");
                writer.write(")\n");
            }
            writer.write(")\n[HOPS] (\n");
            JSONArray hops = (JSONArray) ingredients.get("hops");
            for (int i = 0;i < hops.size(); i++) {
                JSONObject hop = (JSONObject) hops.get(i);
                writer.write("[section" + (i+1) + "] \n");
                writer.write("name=" + hop.get("name")+"\n");
                writer.write("[AMOUNT] (\n");
                JSONObject amount = (JSONObject) hop.get("amount");
                writer.write("value=" + amount.get("value") +"\n");
                writer.write("unit=" + amount.get("unit")+"\n");
                writer.write(")\n");
                writer.write("add=" + hop.get("add")+"\n");
                writer.write("attribute=" + hop.get("attribute")+"\n");
            }
            writer.write(")\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void downloadDescription(String description) {
        try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("description.txt")))) {
            writer.write(description);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void downloadImages(URI uri) {
        URI path = null;
        URLConnection connection = null;
        try {
            connection = new URL(uri.toString()).openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            connection.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (InputStream in = new BufferedInputStream(connection.getInputStream());
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            byte[] buf = new byte[1024];
            int n = in.read(buf);

            while (n != -1) {
                out.write(buf, 0, n);
                n = in.read(buf);
            }

            byte[] response = out.toByteArray();
            FileOutputStream fos = new FileOutputStream("beer.png");

            fos.write(response);
            fos.close();
        } catch (FileNotFoundException e) {
            System.out.print("Bad URL");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static URLConnection openURI(String name) {
        URI path = null;
        URLConnection connection = null;
        try {
            connection = new URL("https://api.punkapi.com/v2/beers/" + name).openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            connection.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
