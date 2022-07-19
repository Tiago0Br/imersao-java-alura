import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {

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
        int i = 1;
        System.out.println("Os 20 filmes mais bem avaliados da história: \n");
        for (Map<String, String> movie : movieList) {
            if (i > 20) return;
            System.out.println(i + " - " + movie.get("fullTitle"));
            i++;
        }
    }
}
