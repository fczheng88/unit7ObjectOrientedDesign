import javax.swing.JFrame;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.awt.geom.*;

public class Square extends Shape
{
    public Square(Point2D.Double center, double radius, Color color)
    {
        super(center, radius, color);
    }

    boolean isInside(Point2D.Double point)
    {
        return Math.abs(point.getX()-center.getX())<radius&&Math.abs(point.getY()-center.getY())<radius;
    }
    boolean isOnBorder(Point2D.Double point)
    {
        return Math.abs(Math.abs(point.getX()-center.getX())-radius)<=3||Math.abs(Math.abs(point.getY()-center.getY())-radius)<=5;//allow some error
    }  
    void draw(Graphics2D g2, boolean filled)
    {
        if(filled)
        g2.fill(new Rectangle2D.Double(center.getX()-radius,center.getY()-radius, radius*2, radius*2));
        else
        g2.draw(new Rectangle2D.Double(center.getX()-radius,center.getY()-radius, radius*2, radius*2));
    } 
}