import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;


public class CompositeShape implements Shapes {
    private ArrayList<Shapes> composites;

    public CompositeShape() throws Exception {
        composites = new ArrayList<Shapes>();
    }

    public void addShape(Shapes shape) throws Exception {
        composites.add(shape);
    }

    public void removeShape(Shapes shape) throws Exception {
        composites.remove(shape);
    }

    public int getItemCount() throws Exception{
        return composites.size();
    }

    @Override
    public void move(double deltaX, double deltaY) throws ShapeException {
        for (Shapes shape : composites) {
            shape.move(deltaX, deltaY);
        }
    }

    @Override
    public double computeArea() throws ShapeException {
        double compositeArea = 0;
        for (Shapes shape : composites) {
            compositeArea += shape.computeArea();
        }
        return compositeArea;
    }

    @Override
    public void scale(Double scaleFactor) throws ShapeException {
        for (Shapes shape : composites) {
            shape.scale(scaleFactor);
        }
    }

    @Override
    public String toString() {
        String string = "Composite:" + String.valueOf(this.composites.size()) + System.lineSeparator();
        for (Shapes shape : composites) {
            string = string.concat(shape.toString() + System.lineSeparator());
        }
        return string;
    }

    @Override
    public void render(Graphics2D graphics) throws ShapeException {
        for (Shapes shape : composites) {
            shape.render(graphics);
        }
    }

}
