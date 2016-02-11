import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
public class TriangleComponent extends JComponent
{
    private Point2D.Double p1, p2, p3;
    private Line2D.Double line1, line2, line3;

    /**
     * Constructor for objects of class Triangle
     */
    public TriangleComponent()
    {        
        p1=new Point2D.Double(0.0,0.0);
        p2=new Point2D.Double(0.0,0.0);
        p3=new Point2D.Double(0.0,0.0);
        line1 = new Line2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        line2 = new Line2D.Double(p2.getX(), p2.getY(), p3.getX(), p3.getY());
        line3 = new Line2D.Double(p1.getX(), p1.getY(), p3.getX(), p3.getY());
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(new Line2D.Double(p1.getX(),p1.getY(),p1.getX(),p1.getY()));
        g2.draw(new Line2D.Double(p2.getX(),p2.getY(),p2.getX(),p2.getY()));
        g2.draw(new Line2D.Double(p3.getX(),p3.getY(),p3.getX(),p3.getY()));
        g2.draw(line1);
        g2.draw(line2);
        g2.draw(line3);
    }

    public void changeStuff(Point2D.Double p1, Point2D.Double p2, Point2D.Double p3, boolean is4th)
    {
        if(is4th)
        {
            this.p1=new Point2D.Double(0.0,0.0);
            this.p2=new Point2D.Double(0.0,0.0);
            this.p3=new Point2D.Double(0.0,0.0);
            line1 = new Line2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY());
            line2 = new Line2D.Double(p2.getX(), p2.getY(), p3.getX(), p3.getY());
            line3 = new Line2D.Double(p1.getX(), p1.getY(), p3.getX(), p3.getY()); 
            return;
        }
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        line1 = new Line2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        line2 = new Line2D.Double(p2.getX(), p2.getY(), p3.getX(), p3.getY());
        line3 = new Line2D.Double(p1.getX(), p1.getY(), p3.getX(), p3.getY());
        repaint();
    }

}
