import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
public class TriangleComponent extends JComponent
{
    private int numPts;
    private Rectangle2D[] pts;

    public TriangleComponent()
    {        
        numPts=0;
        pts = new Rectangle2D[3];
    }

    public void addPoint(int x, int y)
    {
        if(numPts!=3)
        {
            pts[numPts] = new Rectangle2D.Double(x, y,0,0);
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
            g2.draw(pts[0]);
        }
        if(numPts>=2)
        {
            g2.draw(pts[1]);
            g2.draw(new Line2D.Double(pts[0].getX(),pts[0].getY(),pts[1].getX(),pts[1].getY()));
        }
        if(numPts>=3)
        {
            g2.draw(pts[2]);
            g2.draw(new Line2D.Double(pts[1].getX(),pts[1].getY(),pts[2].getX(),pts[2].getY()));
            g2.draw(new Line2D.Double(pts[0].getX(),pts[0].getY(),pts[2].getX(),pts[2].getY()));
        }
    }
}
