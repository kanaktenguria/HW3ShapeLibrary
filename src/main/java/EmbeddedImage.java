import java.awt.*;
import java.util.HashMap;

public class EmbeddedImage implements Shapes{
    private Image image;
    private String filename;
    private Point initCoordinate;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    private int height;
    private int width;

    private static HashMap<String, Image> imageHashMap = new HashMap<String, Image>();

    public EmbeddedImage(String filename, double x, double y, int height, int width) throws Exception {
        initCoordinate = new Point(x, y);
        this.height = height;
        this.width = width;
        this.filename = filename;
        image = imageHashMap.get(filename);

        if (image == null) {
            image = new Image(this.filename);
            imageHashMap.put(filename, image);
        }
    }

    public EmbeddedImage(String string) throws Exception {
        if (string.toLowerCase().contains("embeddedimage:"))
            string = string.split(":")[1];

        String[] strings = string.split(",");
        filename = strings[0];
        double x = Double.valueOf(strings[1]);
        double y = Double.valueOf(strings[2]);
        height = Integer.valueOf(strings[3]);
        width = Integer.valueOf(strings[4]);
        initCoordinate = new Point(x, y);
    }

    @Override
    public void move(double deltaX, double deltaY) throws ShapeException{
        initCoordinate.move(deltaX, deltaY);
    }

    @Override
    public double computeArea(){
        return width*height;
    }

    @Override
    public void scale(Double scaleFactor) throws ShapeException {
        Validator.validatePositiveDouble(scaleFactor, "Invalid scale factor");
        height*=scaleFactor;
        width*=scaleFactor;
    }

    @Override
    public void render(Graphics2D graphics) throws ShapeException {
        image.render(graphics, initCoordinate.getX(), initCoordinate.getY(), height, width);
    }

    public Point getInitCoordinate(){
        return initCoordinate;
    }

    @Override
    public String toString() {
        return "EmbeddedImage:" + filename + "," + initCoordinate.getX() + "," + initCoordinate.getY() + "," + height + "," + width;
    }

}
