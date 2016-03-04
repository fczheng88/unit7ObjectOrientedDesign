import java.awt.*;
import java.awt.geom.*;

public class Circle extends Shape
{
    public Circle(Point2D.Double center, double radius, Color color){
        super(center, radius, color);
    }

    /**
     * Method isInside determines if a point is within the shape
     *
     * @param point The point tested
     * @return Is the point inside the shape?
     */
    boolean isInside(Point2D.Double point)
    {
        return Math.pow(Math.pow((point.getX()-center.getX()),2)+Math.pow((point.getY()-center.getY()),2),0.5) < radius;
    }

    /**
     * Method isOnBorder determines if a point is on the border of a shape within BORDER_ERROR of error
     *
     * @param point The point tested
     * @return Is the point on the border?
     */
    boolean isOnBorder(Point2D.Double point)
    {
        return Math.abs(Math.pow(Math.pow((point.getX()-center.getX()),2)+Math.pow((point.getY()-center.getY()),2),0.5)-radius)<=BORDER_ERROR;//allow some margin of error
    }

    /**
     * Method draw draws the shape
     *
     * @param g2 A parameter
     * @param filled Is the shape filled? Determines if an outline or solid shape is drawn
     */
    void draw(Graphics2D g2, boolean filled)
    {
        if(filled)
            g2.fill(new Ellipse2D.Double(center.getX()-radius,center.getY()-radius, radius*2, radius*2));
        else
            g2.draw(new Ellipse2D.Double(center.getX()-radius,center.getY()-radius, radius*2, radius*2));
    }   
}