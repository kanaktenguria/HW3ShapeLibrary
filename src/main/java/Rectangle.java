import java.awt.*;

/**
 *
 *  Rectangle
 *
 *  This class represents rectangle objects that can be moved or scaled.  Users of a rectangle can also get its area, length and breadth.
 *
 */
@SuppressWarnings("WeakerAccess")
public class Rectangle implements Shapes{
    private Point point1;
    private Point point2;
    private Point point3;
    private Point point4;
    private Line line1;
    private Line line2;
    private Line line3;
    private Line line4;

    /**
     * Constructor based on x-y Locations
     * @param x1                The x-location of first point -- must be a valid double.
     * @param y1                The y-location of first point -- must be a valid double.
     * @param x2                The x-location of second point -- must be a valid double.
     * @param y2                The y-location of second point -- must be a valid double.
     * @param x3                The x-location of third point -- must be a valid double.
     * @param y3                The y-location of third point -- must be a valid double.
     * @param x4                The x-location of fourth point -- must be a valid double.
     * @param y4                The y-location of fourth point -- must be a valid double.
     * @throws ShapeException   Exception throw if any parameter is invalid
     */
    public Rectangle(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) throws ShapeException {
        point1 = new Point(x1, y1);
        point2 = new Point(x2, y2);
        point3 = new Point(x3, y3);
        point4 = new Point(x4, y4);
        checkValidRectangle(point1,point2,point3,point4);
    }

    /**
     *
     * @param point1            The first point -- must not be null
     * @param point2            The second point -- must not be null
     * @param point3            The third point -- must not be null
     * @param point4            The fourth point -- must not be null
     * @throws ShapeException   Exception throw if any parameter is invalid
     */
    public Rectangle(Point point1, Point point2, Point point3, Point point4) throws ShapeException {
        if (point1==null || point2==null || point3==null || point4==null)
            throw new ShapeException("Invalid Point");

        this.point1 = point1.copy();
        this.point2 = point2.copy();
        this.point3 = point3.copy();
        this.point4 = point4.copy();
        checkValidRectangle(point1,point2,point3,point4);
    }

    /**
     * Constructor
     * @param string    A string which will be used as input stream -- must be a valid String.
     */
    public Rectangle(String string) throws ShapeException {
        if (string.toLowerCase().contains("rectangle:"))
            string = string.split(":")[1];

        String[] strings = string.split(",");
        point1 = new Point(Double.valueOf(strings[0]), Double.valueOf(strings[1]));
        point2 = new Point(Double.valueOf(strings[2]), Double.valueOf(strings[3]));
        point3 = new Point(Double.valueOf(strings[4]), Double.valueOf(strings[5]));
        point4 = new Point(Double.valueOf(strings[6]), Double.valueOf(strings[7]));
        checkValidRectangle(point1, point2, point3,point4);
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
     * @return  The fourth point
     */
    public Point getPoint4() throws ShapeException { return point4.copy(); }

    /**
     * Move a rectangle
     *
     * @param deltaX            The delta x-location by which the rectangle should be moved -- must be a valid double
     * @param deltaY            The delta y-location by which the rectangle should be moved -- must be a valid double
     * @throws ShapeException   Exception throw if any parameter is invalid
     */
    @Override
    public void move(double deltaX, double deltaY) throws ShapeException {
        point1.move(deltaX, deltaY);
        point2.move(deltaX, deltaY);
        point3.move(deltaX, deltaY);
        point4.move(deltaX, deltaY);
    }

    /**
     * Scale the rectangle
     *
     * @param scaleFactor       a non-negative double that represents the percentage to scale the rectangle.
     *                          0>= and <1 to shrink.
     *                          >1 to grow.
     * @throws ShapeException   Exception thrown if the scale factor is not valid
     */
    @Override
    public void scale(Double scaleFactor) throws ShapeException {
        Validator.validatePositiveDouble(scaleFactor, "Invalid scale factor");
        double x2 = point2.getX();
        double x3 = point3.getX();
        double y3 = point3.getY();
        double y4 = point4.getY();
        x2 = (x2*scaleFactor)-x2;
        x3 = (x3*scaleFactor)-x3;
        y3 = (y3*scaleFactor)-y3;
        y4 = (y4*scaleFactor)-y4;
        point2.moveX(x2);
        point3.moveX(x3);
        point3.moveY(y3);
        point4.moveY(y4);
    }

    /**
     * @return  The length of the rectangle.
     */
    public double computeLength() throws ShapeException {
        double length = line1.computeLength();
        return length;
    }

    /**
     * @return  The breadth of the rectangle.
     */
    public double computeBreadth() throws ShapeException {
        double breadth = line2.computeLength();
        return breadth;
    }

    /**
     * @return  The area of the rectangle.
     */
    @Override
    public double computeArea() {
        return (line1.computeLength()*line2.computeLength());
    }

    /**
     * Check whether multiplication of slope of the adjacent lines is -1.
     */
    public void checkValidRectangle(Point point1, Point point2, Point point3, Point point4) throws ShapeException {
        line1 = new Line(point1, point2);
        line2 = new Line(point2, point3);
        line3 = new Line(point3, point4);
        line4 = new Line(point4, point1);
        double length = computeLength();
        double breadth = computeBreadth();
        Line diagonalLine = new Line(point1, point3);
        double diagonalLength= diagonalLine.computeLength();
        assert Math.round(Math.sqrt(Math.pow(length, 2) + Math.pow(breadth, 2))) == Math.round(diagonalLength);
    }

    /**
     *
     * @return String of the object as a output stream.
     */
    @Override
    public String toString() {
        String outputStream=null;
        try {
            outputStream = "Rectangle:" +
                    String.valueOf(this.getPoint1().getX()) + "," +
                    String.valueOf(this.getPoint1().getY()) + "," +
                    String.valueOf(this.getPoint2().getX()) + "," +
                    String.valueOf(this.getPoint2().getY()) + "," +
                    String.valueOf(this.getPoint3().getX()) + "," +
                    String.valueOf(this.getPoint3().getY()) + "," +
                    String.valueOf(this.getPoint4().getX()) + "," +
                    String.valueOf(this.getPoint4().getY());
        } catch (ShapeException e) {}
        return outputStream;
    }
    /**
     * Renders the shape to a file.
     */
    @Override
    public void render(Graphics2D graphics) throws ShapeException{
        int[] xCoordinate = new int[5];
        int[] yCoordinate = new int[5];
        xCoordinate[0] = (int) getPoint1().getX();
        xCoordinate[1] = (int) getPoint2().getX();
        xCoordinate[2] = (int) getPoint3().getX();
        xCoordinate[3] = (int) getPoint4().getX();
        xCoordinate[4] = xCoordinate[0];

        yCoordinate[0] = (int) this.getPoint1().getY();
        yCoordinate[1] = (int) this.getPoint2().getY();
        yCoordinate[2] = (int) this.getPoint3().getY();
        yCoordinate[3] = (int) this.getPoint4().getY();
        yCoordinate[4] = yCoordinate[0];

        graphics.drawPolyline(xCoordinate, yCoordinate, 5);
    }
}