import static org.junit.Assert.*;
import org.junit.Test;

public class ShapeFactoryTest {

    @Test
    public void testCreate() throws Exception {
        Point point1 = new Point(-1.5, 0);
        Point point2 = new Point(1.5, 0);
        Point point3 = new Point(1.5, -2);
        Point point4 = new Point(-1.5, -2);
        Point point5 = new Point(40, 60);

        Rectangle rectangle= new Rectangle(point1, point2, point3, point4);
        Triangle triangle = new Triangle(point1, point2, point3);
        Line line = new Line(point1, point5);
        Circle circle = new Circle(100, 100, 50);
        CompositeShape compositeShape = new CompositeShape();
        CompositeShape compositeShape2 = new CompositeShape();

        compositeShape.addShape(circle);
        compositeShape.addShape(rectangle);
        compositeShape.addShape(point1);

        compositeShape2.addShape(triangle);
        compositeShape2.addShape(line);

        compositeShape.addShape(compositeShape2);

        String compositeString = compositeShape.toString();
        ShapeFactory factory = new ShapeFactory();
        CompositeShape stringToShape = factory.create(compositeString);

        assertEquals(compositeShape.computeArea(), stringToShape.computeArea(), 0.5);
    }
}
