import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.util.*;
import java.awt.*;
import java.awt.geom.*;

public class DrawingPanel extends JComponent
{
    private ArrayList<Shape> shapes;
    private int activeShape;
    private Color currentColor;
    private JColorChooser colorChooser;
    private MyMouseListener listener;
    private MyMouseMotionListener motionListener;
    private Point2D.Double oMousePos;
    private Dimension ctrOffset;

    public DrawingPanel()
    {
        shapes = new ArrayList<Shape>();

        oMousePos = new Point2D.Double(0.0,0.0);

        activeShape = 0;
        currentColor = Color.RED;
        colorChooser = new JColorChooser(currentColor);

        listener = new MyMouseListener();
        motionListener = new MyMouseMotionListener();

        addMouseListener(listener);
        addMouseMotionListener(motionListener);
        
        ctrOffset = new Dimension();
        ctrOffset.setSize(0.0,0.0);
    }

    public Color getColor()
    {
        return currentColor;
    }

    public void pickColor()
    {
        currentColor = colorChooser.showDialog(this, "Choose a Color",currentColor);
    }

    public Dimension getPreferredSize()
    {
        return new Dimension(400,400);
    }

    public void addCircle()
    {
        shapes.add(new Circle(new Point2D.Double(Math.random()*400,200), 50, currentColor));
        activeShape = shapes.size()-1;
    }

    public void addSquare()
    {
        shapes.add(new Square(new Point2D.Double(200,Math.random()*400), 50, currentColor));
        activeShape = shapes.size()-1;
    }

    public void paintComponent(Graphics g)    
    {
        Graphics2D g2 = (Graphics2D) g;
        //before the active shape
        for(int i=0;i<activeShape;i++)
        {
            g2.setColor(shapes.get(i).color);
            if(shapes.get(i).getClass().equals(Circle.class))
            {
                g2.fill(new Ellipse2D.Double(shapes.get(i).getCenter().getX()-shapes.get(i).getRadius(),shapes.get(i).getCenter().getY()-shapes.get(i).getRadius(), shapes.get(i).getRadius()*2, shapes.get(i).getRadius()*2));
            }
            else
            {
                g2.fill(new Rectangle2D.Double(shapes.get(i).getCenter().getX()-shapes.get(i).getRadius(),shapes.get(i).getCenter().getY()-shapes.get(i).getRadius(), shapes.get(i).getRadius()*2, shapes.get(i).getRadius()*2));
            }
        }
        //active shape
        if(shapes.size()!=0&&activeShape!=shapes.size())
        {
            g2.setColor(shapes.get(activeShape).color);
            if(shapes.get(activeShape).getClass().equals(Circle.class))
            {
                g2.draw(new Ellipse2D.Double(shapes.get(activeShape).getCenter().getX()-shapes.get(activeShape).getRadius(),shapes.get(activeShape).getCenter().getY()-shapes.get(activeShape).getRadius(), shapes.get(activeShape).getRadius()*2, shapes.get(activeShape).getRadius()*2));
            }
            else
            {
                g2.draw(new Rectangle2D.Double(shapes.get(activeShape).getCenter().getX()-shapes.get(activeShape).getRadius(),shapes.get(activeShape).getCenter().getY()-shapes.get(activeShape).getRadius(), shapes.get(activeShape).getRadius()*2, shapes.get(activeShape).getRadius()*2));
            }
        }
        //after the active shape
        for(int i=activeShape+1;i<shapes.size();i++)
        {
            g2.setColor(shapes.get(i).color);
            if(shapes.get(i).getClass().equals(Circle.class))
            {
                g2.fill(new Ellipse2D.Double(shapes.get(i).getCenter().getX()-shapes.get(i).getRadius(),shapes.get(i).getCenter().getY()-shapes.get(i).getRadius(), shapes.get(i).getRadius()*2, shapes.get(i).getRadius()*2));
            }
            else
            {
                g2.fill(new Rectangle2D.Double(shapes.get(i).getCenter().getX()-shapes.get(i).getRadius(),shapes.get(i).getCenter().getY()-shapes.get(i).getRadius(), shapes.get(i).getRadius()*2, shapes.get(i).getRadius()*2));
            }
        }
    }
    class MyMouseListener implements MouseListener
    {
        public void mousePressed(MouseEvent event)
        {
            oMousePos = new Point2D.Double(event.getX(),event.getY());
            for(int i=shapes.size()-1;i>=0;i--)
            {
                if(shapes.get(i).isInside(new Point2D.Double(event.getX(),event.getY())))
                {
                    activeShape = i;
                    ctrOffset.setSize(shapes.get(activeShape).getCenter().getX()-oMousePos.getX(),shapes.get(activeShape).getCenter().getY()-oMousePos.getY());
                    break;
                }
                else
                {
                    activeShape = shapes.size();
                }
            }
            repaint();
        }

        public void mouseReleased(MouseEvent event){}

        public void mouseClicked(MouseEvent event)
        {}

        public void mouseEntered(MouseEvent event){}

        public void mouseExited(MouseEvent event){}        
    }
    class MyMouseMotionListener implements MouseMotionListener
    {
        public void mouseDragged(MouseEvent event)
        {
            
            
            if(shapes.size()!=0&&activeShape!=shapes.size())
            {
                shapes.get(activeShape).move(event.getX()+ctrOffset.getWidth(),event.getY()+ctrOffset.getHeight());
            }
            repaint();
        }

        public void mouseMoved(MouseEvent event){}       
    }
}