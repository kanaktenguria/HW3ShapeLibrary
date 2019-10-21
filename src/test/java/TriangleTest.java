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
//
//    @Test
//    public void move() throws ShapeException {
//        Point point1 = new Point(8, 20);
//        Point point2 = new Point(39, 2);
//        Point point3 = new Point(47, 16);
//        Point point4 = new Point(16, 34);
//        Rectangle myRectangle = new Rectangle(point1, point2, point3, point4);
//
//        myRectangle.move(2,3);
//
//        assertEquals(10, myRectangle.getPoint1().getX(),0.1);
//        assertEquals(23, myRectangle.getPoint1().getY(),0.1);
//        assertEquals(41, myRectangle.getPoint2().getX(),0.1);
//        assertEquals(5, myRectangle.getPoint2().getY(),0.1);
//        assertEquals(49, myRectangle.getPoint3().getX(),0.1);
//        assertEquals(19, myRectangle.getPoint3().getY(),0.1);
//        assertEquals(18, myRectangle.getPoint4().getX(),0.1);
//        assertEquals(37, myRectangle.getPoint4().getY(),0.1);
//
//    }
//
//    @Test
//    public void scale() throws ShapeException {
//        Point point1 = new Point(8, 20);
//        Point point2 = new Point(39, 2);
//        Point point3 = new Point(47, 16);
//        Point point4 = new Point(16, 34);
//        Rectangle myRectangle = new Rectangle(point1, point2, point3, point4);
//
//        myRectangle.scale(2);
//
//        assertEquals(8, myRectangle.getPoint1().getX(),0.1);
//        assertEquals(20, myRectangle.getPoint1().getY(),0.1);
//        assertEquals(78, myRectangle.getPoint2().getX(),0.1);
//        assertEquals(2, myRectangle.getPoint2().getY(),0.1);
//        assertEquals(94, myRectangle.getPoint3().getX(),0.1);
//        assertEquals(32, myRectangle.getPoint3().getY(),0.1);
//        assertEquals(16, myRectangle.getPoint4().getX(),0.1);
//        assertEquals(68, myRectangle.getPoint4().getY(),0.1);
//    }
//
//    @Test
//    public void computeLength() throws ShapeException {
//        Point point1 = new Point(8, 20);
//        Point point2 = new Point(39, 2);
//        Point point3 = new Point(47, 16);
//        Point point4 = new Point(16, 34);
//        Rectangle myRectangle = new Rectangle(point1, point2, point3, point4);
//        assertEquals(35.8, myRectangle.computeLength(), 0.1);
//    }
//
//    @Test
//    public void computeBreadth() throws ShapeException {
//        Point point1 = new Point(8, 20);
//        Point point2 = new Point(39, 2);
//        Point point3 = new Point(47, 16);
//        Point point4 = new Point(16, 34);
//        Rectangle myRectangle = new Rectangle(point1, point2, point3, point4);
//        assertEquals(16.1, myRectangle.computeBreadth(),0.1);
//    }
//
//    @Test
//    public void computeArea() throws ShapeException {
//        Point point1 = new Point(8, 20);
//        Point point2 = new Point(39, 2);
//        Point point3 = new Point(47, 16);
//        Point point4 = new Point(16, 34);
//        Rectangle myRectangle = new Rectangle(point1, point2, point3, point4);
//        assertEquals(578, myRectangle.computeArea(),0.1);
//    }
//
//    @Test
//    public void render() throws Exception {
//
//        String outputFilename = "Rectangle.png";
//
//        BufferedImage bufferedImage = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
//        Graphics2D graphics = bufferedImage.createGraphics();
//        graphics.setColor(Color.white);
//        Point point1 = new Point(8, 20);
//        Point point2 = new Point(39, 2);
//        Point point3 = new Point(47, 16);
//        Point point4 = new Point(16, 34);
//
//        Rectangle rectangle = new Rectangle(point1, point2, point3, point4);
//        rectangle.render(graphics);
//
//        File file = new File(outputFilename);
//        ImageIO.write(bufferedImage, "png", file);
//        graphics.dispose();
//    }
}