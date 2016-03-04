import java.awt.*;
import java.awt.geom.*;

public class Circle extends Shape
{
    public Circle(Point2D.Double center, double radius, Color color){
        super(center, radius, color);
    }

    boolean isInside(Point2D.Double point)
    {
        return Math.pow(Math.pow((point.getX()-center.getX()),2)+Math.pow((point.getY()-center.getY()),2),0.5) < radius;
    }
    boolean isOnBorder(Point2D.Double point)
    {
        return Math.abs(Math.pow(Math.pow((point.getX()-center.getX()),2)+Math.pow((point.getY()-center.getY()),2),0.5)-radius)<=5;//allow some margin of error
    }  
    void draw(Graphics2D g2, boolean filled)
    {
        if(filled)
        g2.fill(new Ellipse2D.Double(center.getX()-radius,center.getY()-radius, radius*2, radius*2));
        else
        g2.draw(new Ellipse2D.Double(center.getX()-radius,center.getY()-radius, radius*2, radius*2));
    }   
}