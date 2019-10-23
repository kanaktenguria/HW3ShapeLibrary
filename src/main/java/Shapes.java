import java.awt.*;

public interface Shapes {
    public void move(double deltaX, double deltaY) throws ShapeException;

    public double computeArea() throws ShapeException;

    public void scale(Double scaleFactor) throws ShapeException;

    public String toString();

    public void render(Graphics2D graphics) throws ShapeException;
}
