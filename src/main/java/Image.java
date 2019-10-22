import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Image {
    private BufferedImage bImage;
    private File file;

    public Image(String filename) throws Exception {
        this.file = new File(filename);
        bImage = ImageIO.read(file);
    }

    public void render(Graphics2D graphics, double x, double y, int height, int width){
        graphics.drawImage(bImage, (int)x, (int)y, height, width, null, null);
    }
}
