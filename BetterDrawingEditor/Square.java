import javax.swing.JFrame;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.awt.geom.*;

/**
 * Class Square extends Shape and describes squares
 * @author Felix Zheng
 * @version Release
 */
public class Square extends Shape
{
    public enum WhereInShape{ //used to describe a point's location
        TOPBOTTOM, LEFTRIGHT, CORNER, INSIDE, NOWHERE
    }
    /**
     * Square Constructor
     *
     * @param center The center of the square
     * @param radius The radius of an inscribed circle
     * @param color The color of the square
     */
    public Square(Point2D.Double center, double radius, Color color)
    {
        super(center, radius, color);
    }

    /**
     * Method isInside determines if a point is within the shape
     *
     * @param point The point used
     * @return Is the point inside the shape?
     */
    boolean isInside(Point2D.Double point)
    {
        return getWhereInShape(point)==WhereInShape.INSIDE;
    }

    /**
     * Method isOnBorder determines if a point is on the border of a shape within BORDER_ERROR of error
     *
     * @param point The point tested
     * @return Is the point on the border?
     */
    boolean isOnBorder(Point2D.Double point)
    {
        WhereInShape wis = getWhereInShape(point);

        return wis!=WhereInShape.NOWHERE && wis!=WhereInShape.INSIDE;
    }  

    /**
     * Method getWhereInShape determines where a point is in the square
     *
     * @param point The point used 
     * @return An enum of where the point is
     */
    public WhereInShape getWhereInShape(Point2D.Double point)
    {
        double dX = Math.abs(point.getX()-center.getX());
        double dY = Math.abs(point.getY()-center.getY());
        boolean TB,LR;

        TB = Math.abs(dY-radius)<BORDER_ERROR && dX<=radius;
        LR = Math.abs(dX-radius)<BORDER_ERROR && dY<=radius;

        if(TB && LR)
        {
            return WhereInShape.CORNER;
        }
        else if(TB)
        {
            return WhereInShape.TOPBOTTOM;
        }
        else if(LR)
        {
            return WhereInShape.LEFTRIGHT;
        }
        else if(dX<radius && dY<radius)
        {
            return WhereInShape.INSIDE;
        }
        else
        {
            return WhereInShape.NOWHERE;
        }
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
            g2.fill(new Rectangle2D.Double(center.getX()-radius,center.getY()-radius, radius*2, radius*2));
        else
            g2.draw(new Rectangle2D.Double(center.getX()-radius,center.getY()-radius, radius*2, radius*2));
    } 
}