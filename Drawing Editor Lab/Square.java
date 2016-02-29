import javax.swing.JFrame;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.awt.geom.*;

public class Square extends Shape
{
    public Square(Point2D.Double center, double radius, Color color){
        this.center = center;
        this.radius = radius;
        this.color = color;
    }

    Point2D.Double getCenter()
    { return center;}

    double getRadius()
    {return radius;}

    void move(double x, double y)
    {center = new Point2D.Double(x,y);}

    void setRadius(double r)
    {radius = r;}

    boolean isInside(Point2D.Double point)
    {return true;//mehfu}

    }
}