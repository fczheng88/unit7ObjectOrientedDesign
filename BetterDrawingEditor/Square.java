import javax.swing.JFrame;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.awt.geom.*;

public class Square extends Shape
{
    public enum WhereInShape{
        TOPBOTTOM, LEFTRIGHT, CORNER, INSIDE, NOWHERE
    }
    public Square(Point2D.Double center, double radius, Color color)
    {
        super(center, radius, color);
    }

    boolean isInside(Point2D.Double point)
    {
        return getWhereInShape(point)==WhereInShape.INSIDE;
    }

    boolean isOnBorder(Point2D.Double point)
    {
        WhereInShape wis = getWhereInShape(point);
        
        return wis!=WhereInShape.NOWHERE && wis!=WhereInShape.INSIDE;
    }  

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

    void draw(Graphics2D g2, boolean filled)
    {
        if(filled)
            g2.fill(new Rectangle2D.Double(center.getX()-radius,center.getY()-radius, radius*2, radius*2));
        else
            g2.draw(new Rectangle2D.Double(center.getX()-radius,center.getY()-radius, radius*2, radius*2));
    } 
}