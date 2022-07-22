import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IMDBContentExtractor implements ContentExtractor {
    public List<Content> extractContent(String json) {
        // Extrair os dados que interessam
        JsonParser jsonParser = new JsonParser();
        List<Map<String, String>> attributesList = jsonParser.parse(json);

        List<Content> contents = new ArrayList<>();

        // Popular a lista de conteúdos
        for (Map<String, String> attributes: attributesList) {
            String title = attributes.get("title");
            String imageUrl = attributes.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");
            var content = new Content(title, imageUrl);

            contents.add(content);
        }

        return contents;
    }
}
