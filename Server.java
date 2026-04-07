import com.sun.net.httpserver.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.nio.file.*;
import java.util.ArrayList;

public class Server {

    public static void serveFile(HttpExchange res, String filePath, String contentType) throws IOException {
        byte[] bytes = Files.readAllBytes(Path.of(filePath));
        res.getResponseHeaders().set("Content-Type", contentType);
        res.sendResponseHeaders(200, bytes.length);
        res.getResponseBody().write(bytes);
        res.getResponseBody().close();
    }

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        System.out.println("Running at http://localhost:8080");

        DataAnalyzer analyzer = new DataAnalyzer();
        ArrayList<Country> countries = analyzer.getCountryPopulation();
        System.out.printf("Countries loaded: %d%n",   countries.size());
        System.out.printf("Smallest: %s (%,d)%n",     analyzer.findMinCountry(countries), analyzer.findMin(countries));
        System.out.printf("Largest:  %s (%,d)%n",     analyzer.findMaxCountry(countries), analyzer.findMax(countries));
        System.out.printf("Average:  %,.0f%n",         analyzer.findAve(countries));

        server.createContext("/",         res -> serveFile(res, "index.html", "text/html"));
        server.createContext("/style.css", res -> serveFile(res, "style.css", "text/css"));
        server.createContext("/code.js",   res -> serveFile(res, "code.js",   "application/javascript"));

        server.createContext("/data", exchange -> {
            exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
            exchange.getResponseHeaders().set("Content-Type", "application/json");

            ArrayList<Country> list = new DataAnalyzer().getCountryPopulation();
            ArrayList<String> jsonItems = new ArrayList<>();
            for (Country c : list) jsonItems.add(c.toString());
            String json = "[" + String.join(",", jsonItems) + "]";

            byte[] response = json.getBytes();
            exchange.sendResponseHeaders(200, response.length);
            exchange.getResponseBody().write(response);
            exchange.getResponseBody().close();
        });

        server.createContext("/stats", exchange -> {
            exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
            exchange.getResponseHeaders().set("Content-Type", "application/json");

            DataAnalyzer a = new DataAnalyzer();
            String json = a.statsToJson(a.getCountryPopulation());

            byte[] response = json.getBytes();
            exchange.sendResponseHeaders(200, response.length);
            exchange.getResponseBody().write(response);
            exchange.getResponseBody().close();
        });

        server.start();
    }
}