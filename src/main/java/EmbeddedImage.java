import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EmbeddedImage {
    private Point initCoordinate;
    private int height;
    private int width;
    private File file;
    private BufferedImage bufferedImage;
//    private UserImage userImage;
    private String filename;
//    private static HashMap<String, UserImage> stringImageHashMap = new HashMap<String, UserImage>();

    public EmbeddedImage(String filename, double x, double y, int height, int width) throws Exception {
        initCoordinate = new Point(x, y);
        this.height = height;
        this.width = width;
        this.filename = filename;
//        this.userImage = stringImageHashMap.get(filename);
//
//        if (this.userImage == null) {
//            this.userImage = new UserImage(this.filename);
//            stringImageHashMap.put(filename, this.userImage);
//            System.out.println("New object instantiated");
//        }
    }

    public double computeArea(){
        return this.width*this.height;
    }

    public void move(double deltaX, double deltaY) throws ShapeException{
        initCoordinate.move(deltaX, deltaY);
    }

    public void scale
    public void render(Graphics2D graphics) throws IOException {
        file = new File(filename);
        bufferedImage = ImageIO.read(file);
        graphics.drawImage(bufferedImage, (int) this.initCoordinate.getX(), (int) this.initCoordinate.getY(), this.height, this.width, null, null);
    }

    public Point getInitCoordinate(){
        return initCoordinate;
    }

//    @Override
//    public String toString() {
//        return "EmbeddedImage:" +
//                this.filename + "," +
//                this.initCoordinate.getX() + "," +
//                this.initCoordinate.getY() + "," +
//                this.height + "," +
//                this.width;
//    }

//    public EmbeddedImage(String string) throws ShapeException {
//        // Expecting only parameters
//        if (string.toLowerCase().contains("embeddedimage:"))
//            string = string.split(":")[1];
//
//        String[] strings = string.split(",");
//        this.filename = strings[0];
//        double x = Double.valueOf(strings[1]);
//        double y = Double.valueOf(strings[2]);
//        this.height = Integer.valueOf(strings[3]);
//        this.width = Integer.valueOf(strings[4]);
//        this.initCoordinate = new Point(x, y);
//    }
}
