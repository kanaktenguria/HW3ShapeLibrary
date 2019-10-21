import java.awt.*;

/**
 *
 *  Line
 *
 *  This class represents line objects that can be moved.  Users of a line can also get its length and slope.
 *
 */
@SuppressWarnings("WeakerAccess")
public class Line {
    private Point point1;
    private Point point2;

    /**
     * Constructor based on x-y Locations
     * @param x1                The x-location of first point -- must be a valid double.
     * @param y1                The y-location of first point -- must be a valid double.
     * @param x2                The x-location of second point -- must be a valid double.
     * @param y2                The y-location of second point -- must be a valid double.
     * @throws ShapeException   Exception throw if any parameter is invalid
     */
    public Line(double x1, double y1, double x2, double y2) throws ShapeException {
        point1 = new Point(x1, y1);
        point2 = new Point(x2, y2);
    }

    /**
     *
     * @param point1            The first point -- must not be null
     * @param point2            The second point -- must not b e null
     * @throws ShapeException   Exception throw if any parameter is invalid
     */
    public Line(Point point1, Point point2) throws ShapeException {
        if (point1==null || point2==null)
            throw new ShapeException("Invalid Point");

        this.point1 = point1.copy();
        this.point2 = point2.copy();
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
     * Move a line
     *
     * @param deltaX            The delta x-location by which the line should be moved -- must be a valid double
     * @param deltaY            The delta y-location by which the line should be moved -- must be a valid double
     * @throws ShapeException   Exception throw if any parameter is invalid
     */
    public void move(double deltaX, double deltaY) throws ShapeException {
        point1.move(deltaX, deltaY);
        point2.move(deltaX, deltaY);
    }

    /**
     * @return  The length of the line
     */
    public double computeLength() {
        return Math.sqrt(Math.pow(point2.getX() - point1.getX(), 2) +
                Math.pow(point2.getY() - point1.getY(), 2));
    }

    /**
     * @return  The slope of the line
     */
    public double computeSlope() {
        return (point2.getX() - point1.getX())/(point2.getY() - point1.getY());
    }

    /**
     * @return  zero as area of line.
     */
    public double computeArea(){return 0;}

    /**
     * Scale the line
     *
     * @param scaleFactor       a non-negative double that represents the percentage to scale the line.
     *                          0>= and <1 to shrink.
     *                          >1 to grow.
     * @throws ShapeException   Exception thrown if the scale factor is not valid
     */
    public void scale(double scaleFactor) throws ShapeException {
        Validator.validatePositiveDouble(scaleFactor, "Invalid scale factor");
        double x1 = point1.getX();
        double x2 = point2.getX();
        double y1 = point1.getY();
        double y2 = point2.getY();
        x1 = (x1*scaleFactor)-x1;
        x2 = (x2*scaleFactor)-x2;
        y1 = (y1*scaleFactor)-y1;
        y2 = (y2*scaleFactor)-y2;
        point1.moveX(x1);
        point1.moveY(y1);
        point2.moveX(x2);
        point2.moveY(y2);
    }

    /**
     * Renders the line to a file.
     */
    public void render(Graphics2D graphics) {
        int x1 = (int) (this.point1.getX());
        int y1 = (int) (this.point1.getY());
        int x2 = (int) (this.point2.getX());
        int y2 = (int) (this.point2.getY());
        graphics.drawLine(x1, y1, x2, y2);
    }
}
