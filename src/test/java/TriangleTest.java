import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void testValidConstruction() throws ShapeException {

        Triangle myTriangle = new Triangle(-4,-1,1,-6,7,5);
        assertEquals(-4, myTriangle.getPoint1().getX(),0);
        assertEquals(-1, myTriangle.getPoint1().getY(),0);
        assertEquals(1, myTriangle.getPoint2().getX(),0);
        assertEquals(-6, myTriangle.getPoint2().getY(),0);
        assertEquals(7, myTriangle.getPoint3().getX(),0);
        assertEquals(5, myTriangle.getPoint3().getY(),0);

        Point point1 = new Point(-2, 1);
        Point point2 = new Point(4, 2);
        Point point3 = new Point(1, 3);
        myTriangle = new Triangle(point1, point2, point3);

        assertEquals(-2, myTriangle.getPoint1().getX(),0);
        assertEquals(1, myTriangle.getPoint1().getY(),0);
        assertEquals(4, myTriangle.getPoint2().getX(),0);
        assertEquals(2, myTriangle.getPoint2().getY(),0);
        assertEquals(1, myTriangle.getPoint3().getX(),0);
        assertEquals(3, myTriangle.getPoint3().getY(),0);

    }

    @Test(expected = ShapeException.class)
    public void testInvalidConstruction() throws ShapeException {
        Point point1 = new Point(-2, 1);
        Point point2 = new Point(4, 2);
        Point point3 = new Point(1, 3);
        new Triangle(null, null, null);
        new Triangle(point1, point2, null);
        new Triangle(point1, null, point3);
    }

    @Test
    public void move() throws ShapeException {
        Point point1 = new Point(-4, -1);
        Point point2 = new Point(1, -6);
        Point point3 = new Point(7, 5);
        Triangle myTriangle = new Triangle(point1, point2, point3);

        myTriangle.move(2,3);

        assertEquals(-2, myTriangle.getPoint1().getX(),0.1);
        assertEquals(2, myTriangle.getPoint1().getY(),0.1);
        assertEquals(3, myTriangle.getPoint2().getX(),0.1);
        assertEquals(-3, myTriangle.getPoint2().getY(),0.1);
        assertEquals(9, myTriangle.getPoint3().getX(),0.1);
        assertEquals(8, myTriangle.getPoint3().getY(),0.1);

    }

    @Test
    public void scale() throws ShapeException {
        Point point1 = new Point(-2, 1);
        Point point2 = new Point(4, 2);
        Point point3 = new Point(1, 3);
        Triangle myTriangle = new Triangle(point1, point2, point3);

        myTriangle.scale(2);

        assertEquals(-4, myTriangle.getPoint1().getX(),0.1);
        assertEquals(2, myTriangle.getPoint1().getY(),0.1);
        assertEquals(8, myTriangle.getPoint2().getX(),0.1);
        assertEquals(4, myTriangle.getPoint2().getY(),0.1);
        assertEquals(2, myTriangle.getPoint3().getX(),0.1);
        assertEquals(6, myTriangle.getPoint3().getY(),0.1);

    }


    @Test
    public void computeArea() throws ShapeException {
        Point point1 = new Point(-2, 1);
        Point point2 = new Point(4, 2);
        Point point3 = new Point(1, 3);
        Triangle myTriangle = new Triangle(point1, point2, point3);
        assertEquals(4.5, myTriangle.computeArea(),0.1);
    }

    @Test
    public void render() throws Exception {

        BufferedImage bImage = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = bImage.createGraphics();
        graphics.setColor(Color.white);
        Point point1 = new Point(1, 10);
        Point point2 = new Point(40, 20);
        Point point3 = new Point(10, 30);
        Triangle myTriangle = new Triangle(point1, point2, point3);
        myTriangle.render(graphics);

        assertTrue(ImageIO.write(bImage, "png", new File("output/triangle.png")));
    }
}