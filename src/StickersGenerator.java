import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

public class StickersGenerator {
    public void create(InputStream inputStream, String fileName) throws Exception {
        BufferedImage originalImage = ImageIO.read(inputStream);

        // Cria uma imagem com transparência e com um tamanho novo
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        int newHeight = height + 200;
        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        // Copiar a imagem original para uma nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(originalImage, 0, 0, null);

        // Configurar a fonte da frase
        var font = new Font(Font.SANS_SERIF, Font.BOLD, 128);
        graphics.setColor(Color.CYAN);
        graphics.setFont(font);

        // Escrever uma frase na imagem
        graphics.drawString("TOPZERA", 180, newHeight - 80);

        // Cria a nova imagem em um arquivo
        File stickersFolder = new File("stickers/");
        if (!stickersFolder.exists()) stickersFolder.mkdirs();
        ImageIO.write(newImage, "png", new File("stickers/" + fileName + ".png"));
    }
}
