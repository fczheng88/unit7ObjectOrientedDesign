import javax.swing.JFrame;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
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
}