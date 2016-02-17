import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
public class TriangleComponent extends JComponent
{
    private int numPts;
    private Point2D[] pts;
    private Rectangle2D.Double p1,p2,p3;
    private Line2D.Double l1,l2,l3;
    /**
     * Constructor for objects of class Triangle
     */
    public TriangleComponent()
    {        
        numPts=0;
        pts = new Point2D[3];
        p1=p2=p3=new Rectangle2D.Double(0,0,0,0);
    }

    public void addPoint(int x, int y)
    {
        if(numPts!=3)
        {
            pts[numPts] = new Point2D.Double(x, y);
            numPts++;
            return;
        }
        numPts=0;
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        if(numPts>=1)
        {
            p1 = new Rectangle2D.Double(pts[0].getX(),pts[0].getY(),0,0);
            g2.draw(p1);
        }
        if(numPts>=2)
        {
            p2 = new Rectangle2D.Double(pts[1].getX(),pts[1].getY(),0,0);
            l1 = new Line2D.Double(pts[0].getX(),pts[0].getY(),pts[1].getX(),pts[1].getY());
            g2.draw(p2);
            g2.draw(l1);
        }
        if(numPts>=3)
        {
            p3 = new Rectangle2D.Double(pts[2].getX(),pts[2].getY(),0,0);
            l2 = new Line2D.Double(pts[1].getX(),pts[1].getY(),pts[2].getX(),pts[2].getY());
            l3 = new Line2D.Double(pts[0].getX(),pts[0].getY(),pts[2].getX(),pts[2].getY());
            
            g2.draw(p3);
            g2.draw(l2);
            g2.draw(l3);
        }
        
        
        
        
    }

}
