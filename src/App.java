import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        var URL = "https://alura-imdb-api.herokuapp.com/movies";
        var client = HttpClient.newHttpClient();
        var uri = URI.create(URL);
        var request = HttpRequest.newBuilder(uri).GET().build();

        HttpResponse<String> response;
        try {
            response = client.send(request, BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        String body = response.body();

        // Extração dos dados
        JsonParser jsonParser = new JsonParser();
        List<Map<String, String>> movieList = jsonParser.parse(body);

        // Exibição dos dados
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quantas figurinhas deverão ser geradas?");
        int numberOfStickers = scanner.nextInt();

        int i = 1;
        for (Map<String, String> movie : movieList) {
            if (i > numberOfStickers) return;
            String urlImage = movie.get("image");
            String title = movie.get("title");
            InputStream inputStream = new URL(urlImage).openStream();

            var stickersGenerator = new StickersGenerator();
            stickersGenerator.create(inputStream, title);
            i++;
        }
    }
}
