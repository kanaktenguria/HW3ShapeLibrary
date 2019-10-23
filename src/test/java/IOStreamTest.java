import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class IOStreamTest {
    @Test
    public void readWriteShape() throws Exception {
        Point point1 = new Point(-1.5, 0);
        Point point2 = new Point(1.5, 0);
        Point point3 = new Point(1.5, -2);
        Point point4 = new Point(-1.5, -2);
        Point point5 = new Point(40, 60);

        Rectangle rectangle= new Rectangle(point1, point2, point3, point4);
        Triangle triangle = new Triangle(point1, point2, point3);
        Line line = new Line(point1, point5);
        Circle circle = new Circle(100, 100, 50);
        String pictureName = "goku.jpg";
        EmbeddedImage embeddedImage = new EmbeddedImage(pictureName, 10, 10, 100, 100);

        CompositeShape compositeShape = new CompositeShape();
        CompositeShape compositeShape2 = new CompositeShape();

        compositeShape.addShape(circle);
        compositeShape.addShape(rectangle);
        compositeShape.addShape(embeddedImage);

        compositeShape2.addShape(triangle);
        compositeShape2.addShape(line);

        compositeShape.addShape(compositeShape2);
        String filename = "shapeStream.txt";
        IOStream file = new IOStream();
        file.writeShape(filename, compositeShape);

        CompositeShape readCompositeShape = file.readShape(filename);
        System.out.println("\nRead Object from file: \n" + readCompositeShape.toString());
        System.out.println("\nExpected Object from file: \n" + compositeShape.toString());
        assertTrue(readCompositeShape.toString().equals(compositeShape.toString()));
    }
}