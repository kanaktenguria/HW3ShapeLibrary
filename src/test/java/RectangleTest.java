import org.junit.Test;

import static org.junit.Assert.*;

public class RectangleTest {

    @Test
    public void testValidConstruction() throws ShapeException {

        Rectangle myRectangle = new Rectangle(0,0,4,0,4,-4,0,-4);
        assertEquals(0, myRectangle.getPoint1().getX(),0);
        assertEquals(0, myRectangle.getPoint1().getY(),0);
        assertEquals(4, myRectangle.getPoint2().getX(),0);
        assertEquals(0, myRectangle.getPoint2().getY(),0);
        assertEquals(4, myRectangle.getPoint3().getX(),0);
        assertEquals(-4, myRectangle.getPoint3().getY(),0);
        assertEquals(0, myRectangle.getPoint4().getX(),0);
        assertEquals(-4, myRectangle.getPoint4().getY(),0);


        Point point1 = new Point(-1.5, 0);
        Point point2 = new Point(1.5, 0);
        Point point3 = new Point(1.5, -2);
        Point point4 = new Point(-1.5, -2);
        myRectangle = new Rectangle(point1, point2, point3, point4);

        assertEquals(-1.5, myRectangle.getPoint1().getX(),0);
        assertEquals(0, myRectangle.getPoint1().getY(),0);
        assertEquals(1.5, myRectangle.getPoint2().getX(),0);
        assertEquals(0, myRectangle.getPoint2().getY(),0);
        assertEquals(1.5, myRectangle.getPoint3().getX(),0);
        assertEquals(-2, myRectangle.getPoint3().getY(),0);
        assertEquals(-1.5, myRectangle.getPoint4().getX(),0);
        assertEquals(-2, myRectangle.getPoint4().getY(),0);

        point1 = new Point(0, 0);
        point2 = new Point(2, 0);
        point3 = new Point(2, 2);
        point4 = new Point(0, 2);
        myRectangle = new Rectangle(point1, point2, point3, point4);

        assertEquals(0, myRectangle.getPoint1().getX(),0);
        assertEquals(0, myRectangle.getPoint1().getY(),0);
        assertEquals(2, myRectangle.getPoint2().getX(),0);
        assertEquals(0, myRectangle.getPoint2().getY(),0);
        assertEquals(2, myRectangle.getPoint3().getX(),0);
        assertEquals(2, myRectangle.getPoint3().getY(),0);
        assertEquals(0, myRectangle.getPoint4().getX(),0);
        assertEquals(2, myRectangle.getPoint4().getY(),0);
        }

    @Test(expected = ShapeException.class)
    public void testInvalidConstruction() throws ShapeException {
        Point point1 = new Point(-1.5, 0);
        Point point2 = new Point(1.5, 0);
        Point point3 = new Point(1.5, -2);
        Point point4 = new Point(-1.5, -2);
        new Rectangle(null, null, null, null);
        new Rectangle(point1, point2, null, point4);
        new Rectangle(point1, null, point3, point4);
    }

    @Test
    public void move() throws ShapeException {
        Point point1 = new Point(8, 20);
        Point point2 = new Point(39, 2);
        Point point3 = new Point(47, 16);
        Point point4 = new Point(16, 34);
        Rectangle myRectangle = new Rectangle(point1, point2, point3, point4);

        myRectangle.move(2,3);

        assertEquals(10, myRectangle.getPoint1().getX(),0.1);
        assertEquals(23, myRectangle.getPoint1().getY(),0.1);
        assertEquals(41, myRectangle.getPoint2().getX(),0.1);
        assertEquals(5, myRectangle.getPoint2().getY(),0.1);
        assertEquals(49, myRectangle.getPoint3().getX(),0.1);
        assertEquals(19, myRectangle.getPoint3().getY(),0.1);
        assertEquals(18, myRectangle.getPoint4().getX(),0.1);
        assertEquals(37, myRectangle.getPoint4().getY(),0.1);

    }

    @Test
    public void scale() throws ShapeException {
        Point point1 = new Point(8, 20);
        Point point2 = new Point(39, 2);
        Point point3 = new Point(47, 16);
        Point point4 = new Point(16, 34);
        Rectangle myRectangle = new Rectangle(point1, point2, point3, point4);

        myRectangle.scale(2);

        assertEquals(8, myRectangle.getPoint1().getX(),0.1);
        assertEquals(20, myRectangle.getPoint1().getY(),0.1);
        assertEquals(78, myRectangle.getPoint2().getX(),0.1);
        assertEquals(2, myRectangle.getPoint2().getY(),0.1);
        assertEquals(94, myRectangle.getPoint3().getX(),0.1);
        assertEquals(32, myRectangle.getPoint3().getY(),0.1);
        assertEquals(16, myRectangle.getPoint4().getX(),0.1);
        assertEquals(68, myRectangle.getPoint4().getY(),0.1);
    }

    @Test
    public void computeLength() throws ShapeException {
        Point point1 = new Point(8, 20);
        Point point2 = new Point(39, 2);
        Point point3 = new Point(47, 16);
        Point point4 = new Point(16, 34);
        Rectangle myRectangle = new Rectangle(point1, point2, point3, point4);
        assertEquals(35.8, myRectangle.computeLength(), 0.1);
    }

    @Test
    public void computeBreadth() throws ShapeException {
        Point point1 = new Point(8, 20);
        Point point2 = new Point(39, 2);
        Point point3 = new Point(47, 16);
        Point point4 = new Point(16, 34);
        Rectangle myRectangle = new Rectangle(point1, point2, point3, point4);
        assertEquals(16.1, myRectangle.computeBreadth(),0.1);
    }

    @Test
    public void computeArea() throws ShapeException {
        Point point1 = new Point(8, 20);
        Point point2 = new Point(39, 2);
        Point point3 = new Point(47, 16);
        Point point4 = new Point(16, 34);
        Rectangle myRectangle = new Rectangle(point1, point2, point3, point4);
        assertEquals(578, myRectangle.computeArea(),0.1);
    }

}