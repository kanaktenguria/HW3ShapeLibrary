import java.awt.*;

/**
 * Circle
 *
 * This class represents circle objects that can be moved and scales.  Users of a circle can also get its area.
 *
 */
@SuppressWarnings("WeakerAccess")
public class Circle implements Shapes {
    private Point center;
    private double radius;

    /**
     * Constructor with x-y Location for center
     *
     * @param x                 The x-location of the center of the circle -- must be a valid double
     * @param y                 The y-location of the center of the circle
     * @param radius            The radius of the circle -- must be greater or equal to zero.
     * @throws ShapeException   The exception thrown if the x, y, or z are not valid
     */
    public Circle(double x, double y, double radius) throws ShapeException {
        Validator.validatePositiveDouble(radius, "Invalid radius");
        center = new Point(x, y);
        this.radius = radius;
    }

    /**
     * Constructor with a Point for center
     *
     * @param center            The x-location of the center of the circle -- must be a valid point
     * @param radius            The radius of the circle -- must be greater or equal to zero.
     * @throws ShapeException   The exception thrown if the x, y, or z are not valid
     */
    public Circle(Point center, double radius) throws ShapeException {
        Validator.validatePositiveDouble(radius, "Invalid radius");
        if (center==null)
            throw new ShapeException("Invalid center point");

        this.center = center.copy();
        this.radius = radius;
    }

    /**
     * Constructor
     * @param string    A string which will be used as input stream -- must be a valid String.
     */
    public Circle(String string) throws ShapeException {
       if (string.toLowerCase().contains("circle:"))
            string = string.split(":")[1];

        String[] strings = string.split(",");
        double x = Double.valueOf(strings[0]);
        double y = Double.valueOf(strings[1]);
        radius = Double.valueOf(strings[2]);
        center = new Point(x,y);
    }
    /**
     * @return  The center of the circle
     */
    public Point getCenter() throws ShapeException { return center.copy(); }

    /**
     * @return  The radius of the circle
     */
    public double getRadius() { return radius; }

    /**
     * Move the circle
     * @param deltaX            a delta change for the x-location of center of the circle
     * @param deltaY            a delta change for the y-location of center of the circle
     * @throws ShapeException   Exception thrown if either the delta x or y are not valid doubles
     */
    @Override
    public void move(double deltaX, double deltaY) throws ShapeException {
        center.move(deltaX, deltaY);
    }

    /**
     * Scale the circle
     *
     * @param scaleFactor       a non-negative double that represents the percentage to scale the circle.
     *                          0>= and <1 to shrink.
     *                          >1 to grow.
     * @throws ShapeException   Exception thrown if the scale factor is not valid
     */
    public void scale(double scaleFactor) throws ShapeException {
        Validator.validatePositiveDouble(scaleFactor, "Invalid scale factor");
        radius *= scaleFactor;
    }

    /**
     * @return  The area of the circle.
     */
    @Override
    public double computeArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    /**
     *
     * @return String of the object as a output stream.
     */
    @Override
    public String toString() {
        return "Circle:" +
                String.valueOf(center.getX()) + "," + String.valueOf(center.getY()) + "," + String.valueOf(radius);
    }

    /**
     * Renders the shape to a file.
     */
    @Override
    public void render(Graphics2D graphics) throws ShapeException{
        int diameter = (int) (radius*2);
        int x = (int) (center.getX() - radius);
        int y = (int) (center.getY() - radius);
        graphics.drawOval(x, y, diameter, diameter);
    }

}
