import java.awt.*;
import java.awt.geom.*;
public abstract class Shape
{
    // instance variables to store the good stuff
    protected Point2D.Double center;
    protected double radius;
    protected Color color;
    protected final double BORDER_ERROR=3;
    /**
     * Shape Constructor
     *
     * @param center The centre of the shape
     * @param radius The radius of the shape. This meaning could change with each shape
     * @param color The color of the shape
     */
    Shape(Point2D.Double center, double radius, Color color){
        this.center = center;
        this.radius = radius;
        this.color = color;
    }

    /**
     * Method getCenter returns the centre of the shape as a Point2D.Double
     *
     * @return The centre of the shape as a Point2D.Double
     */
    Point2D.Double getCenter()
    { return center;}

    /**
     * Method getColor returns the color of the shape as a Color
     *
     * @return The color of the shape as a Point2D.Double
     */
    Color getColor()
    { return color;}

    /**
     * Method getRadius returns the radius of the shape as a double
     *
     * @return The radius of the shape as a double
     */
    double getRadius()
    {return radius;}

    /**
     * Method move sets a new location for the center of the shape
     *
     * @param x The x coordinate of the new centre
     * @param y They y coordinate of the new centre
     */
    void move(double x, double y)
    {
        center.setLocation(center.getX()+x,center.getY()+y);
    }

    /**
     * Method setRadius sets the shape's radius
     *
     * @param r The new radius of the shape
     */
    void setRadius(double r)
    {radius = r;}

    /**
     * Method isInside tests if a given point "isInside" the shape
     *
     * @param point The point to test
     * @return Whether the point "isInside" the shape
     */
    abstract boolean isInside(Point2D.Double point);

    /**
     * Method isOnBorder determines if a point is on the border of a shape within BORDER_ERROR of error
     *
     * @param point The point tested
     * @return Is the point on the border?
     */
    abstract boolean isOnBorder(Point2D.Double point);

    /**
     * Method draw draws the shape
     *
     * @param g2 A parameter
     * @param filled Is the shape filled? Determines if an outline or solid shape is drawn
     */
    abstract void draw(Graphics2D g2, boolean filled);  
}
