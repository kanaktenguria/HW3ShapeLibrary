import java.awt.*;

/**
 *
 *  Triangle
 *
 *  This class represents triangle objects that can be moved or scaled.  Users of a triangle can also get its area.
 *
 */
public class Triangle {
    private Point point1;
    private Point point2;
    private Point point3;
    private Line line1;
    private Line line2;
    private Line line3;

    /**
     * Constructor based on x-y Locations
     * @param x1                The x-location of first point -- must be a valid double.
     * @param y1                The y-location of first point -- must be a valid double.
     * @param x2                The x-location of second point -- must be a valid double.
     * @param y2                The y-location of second point -- must be a valid double.
     * @param x3                The x-location of third point -- must be a valid double.
     * @param y3                The y-location of third point -- must be a valid double.
     * @throws ShapeException   Exception throw if any parameter is invalid
     */
    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) throws ShapeException {
        point1 = new Point(x1, y1);
        point2 = new Point(x2, y2);
        point3 = new Point(x3, y3);
        checkValidTriangle(point1,point2,point3);
    }

    /**
     *
     * @param point1            The first point -- must not be null
     * @param point2            The second point -- must not be null
     * @param point3            The third point -- must not be null
     * @throws ShapeException   Exception throw if any parameter is invalid
     */
    public Triangle(Point point1, Point point2, Point point3) throws ShapeException {
        if (point1==null || point2==null || point3==null)
            throw new ShapeException("Invalid Point");

        this.point1 = point1.copy();
        this.point2 = point2.copy();
        this.point3 = point3.copy();
        checkValidTriangle(point1,point2,point3);
    }

    /**
     * @return  The first point
     */
    public Point getPoint1() throws ShapeException { return point1.copy(); }

    /**
     * @return  The second point
     */
    public Point getPoint2() throws ShapeException { return point2.copy(); }

    /**
     * @return  The third point
     */
    public Point getPoint3() throws ShapeException { return point3.copy(); }

    /**
     * Move a triangle
     *
     * @param deltaX            The delta x-location by which the triangle should be moved -- must be a valid double
     * @param deltaY            The delta y-location by which the triangle should be moved -- must be a valid double
     * @throws ShapeException   Exception throw if any parameter is invalid
     */
    public void move(double deltaX, double deltaY) throws ShapeException {
        point1.move(deltaX, deltaY);
        point2.move(deltaX, deltaY);
        point3.move(deltaX, deltaY);
    }

    /**
     * Scale the triangle
     *
     * @param scaleFactor       a non-negative double that represents the percentage to scale the rectangle.
     *                          0>= and <1 to shrink.
     *                          >1 to grow.
     * @throws ShapeException   Exception thrown if the scale factor is not valid
     */
    public void scale(double scaleFactor) throws ShapeException {
        Validator.validatePositiveDouble(scaleFactor, "Invalid scale factor");
        double x1 = point1.getX();
        double x2 = point2.getX();
        double x3 = point3.getX();
        double y1 = point1.getY();
        double y2 = point2.getY();
        double y3 = point3.getY();
        x1 = (x1*scaleFactor)-x1;
        x2 = (x2*scaleFactor)-x2;
        x3 = (x3*scaleFactor)-x3;
        y1 = (y1*scaleFactor)-y1;
        y2 = (y2*scaleFactor)-y2;
        y3 = (y3*scaleFactor)-y3;
        point1.moveX(x1);
        point1.moveY(y1);
        point2.moveX(x2);
        point2.moveY(y2);
        point3.moveX(x3);
        point3.moveY(y3);
    }

    /**
     * @return  The area of the triangle.
     */
    public double computeArea() {
        return ((point1.getX() * (point2.getY() - point3.getY()) + point2.getX() * (point3.getY() - point1.getY()) + point3.getX() * (point1.getY() - point2.getY())) / 2.0);
    }

    /**
     * Check whether sum of two sides is greater than third.
     */
    public void checkValidTriangle(Point point1, Point point2, Point point3) throws ShapeException {
        line1 = new Line(point1, point2);
        line2 = new Line(point2, point3);
        line3 = new Line(point3, point1);
        double length1 = line1.computeLength();
        double length2 = line2.computeLength();
        double length3 = line3.computeLength();
        assert length1 + length2 > length3;
    }

    /**
     * Renders the shape to a file.
     */
    public void render(Graphics2D graphics) throws ShapeException {
        int[] xCoordinate = new int[4];
        int[] yCoordinate = new int[4];

        xCoordinate[0] = (int) this.getPoint1().getX();
        xCoordinate[1] = (int) this.getPoint2().getX();
        xCoordinate[2] = (int) this.getPoint3().getX();
        xCoordinate[3] = xCoordinate[0];

        yCoordinate[0] = (int) this.getPoint1().getY();
        yCoordinate[1] = (int) this.getPoint2().getY();
        yCoordinate[2] = (int) this.getPoint3().getY();
        yCoordinate[3] = yCoordinate[0];

        graphics.drawPolyline(xCoordinate, yCoordinate, 4);
    }
}
