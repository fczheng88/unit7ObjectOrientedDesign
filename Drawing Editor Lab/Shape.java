
import javax.swing.JFrame;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.awt.geom.*;
public abstract class Shape
{
    // instance variables - replace the example below with your own
    Point2D.Double center;
    double radius;
    Color color;
    public Shape(Point2D.Double center, double radius, Color color){
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

    abstract boolean isInside(Point2D.Double point);
    abstract boolean isOnBorder(Point2D.Double point);
    abstract void draw(Graphics2D g2, boolean filled);  
}
