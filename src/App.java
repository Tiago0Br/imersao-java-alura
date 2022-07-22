import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual o tema das figurinhas?");
        System.out.println("1) Os filmes mais bem avaliados pelo IMDB");
        System.out.println("2) Imagens da NASA");
        int option = scanner.nextInt();
        option = (option == 1 || option == 2) ? option : 1;
        String URL;
        ContentExtractor extractor;
        if (option == 1) {
            URL = "https://alura-imdb-api.herokuapp.com/movies";
            extractor = new IMDBContentExtractor();
        } else {
            URL = "https://api.mocki.io/v2/549a5d8b/NASA-APOD";
            extractor = new NasaContentExtractor();
        }

        var http = new HttpConnection();
        String json = http.searchData(URL);
        List<Content> contentList = extractor.extractContent(json);

        // Exibição dos dados
        int contentTotal = contentList.size();
        System.out.println("Quantas figurinhas deverão ser geradas? (Máximo: " +contentTotal + ")");
        int numberOfStickers = scanner.nextInt();
        if (numberOfStickers > contentTotal) {
            System.out.println("Será considerado o valor máximo " + contentTotal);
            numberOfStickers = contentTotal;
        }

        int i = 1;
        for (Content content : contentList) {
            if (i > numberOfStickers) return;
            String urlImage = content.getImageURL();
            String title = content.getTitle();
            InputStream inputStream = new URL(urlImage).openStream();

            var stickersGenerator = new StickersGenerator();
            stickersGenerator.create(inputStream, title);
            i++;
        }
    }
}
