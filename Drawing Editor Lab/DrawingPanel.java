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
    private Dimension ctrOffset, preferredSize;
    private boolean resizeMode;

    public DrawingPanel()
    {
        preferredSize = new Dimension(600,600);
        shapes = new ArrayList<Shape>();

        oMousePos = new Point2D.Double(0.0,0.0);

        activeShape = 0;
        currentColor = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
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
        return preferredSize;
    }

    public void addCircle()
    {
        shapes.add(new Circle(new Point2D.Double(Math.random()*600,Math.random()*600), 50, currentColor));
        activeShape = shapes.size()-1;
        currentColor = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
    }

    public void addSquare()
    {
        shapes.add(new Square(new Point2D.Double(Math.random()*600,Math.random()*600), 50, currentColor));
        activeShape = shapes.size()-1;
        currentColor = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
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
                shapes.get(i).draw(g2,true);
            }
            else
            {
                shapes.get(i).draw(g2,true);
            }
        }
        //active shape
        if(shapes.size()!=0&&activeShape!=shapes.size())
        {
            g2.setColor(shapes.get(activeShape).color);
            if(shapes.get(activeShape).getClass().equals(Circle.class))
            {
                shapes.get(activeShape).draw(g2,false);
            }
            else
            {
                shapes.get(activeShape).draw(g2,false);
            }
        }
        //after the active shape
        for(int i=activeShape+1;i<shapes.size();i++)
        {
            g2.setColor(shapes.get(i).color);
            if(shapes.get(i).getClass().equals(Circle.class))
            {
                shapes.get(i).draw(g2,true);
            }
            else
            {
                shapes.get(i).draw(g2,true);
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
                if(shapes.get(i).isOnBorder(new Point2D.Double(event.getX(),event.getY())))
                {
                    activeShape = i;
                    resizeMode = true;
                    break;
                }
                else if(shapes.get(i).isInside(new Point2D.Double(event.getX(),event.getY())))
                {
                    if(SwingUtilities.isRightMouseButton(event))
                    {
                        shapes.remove(i);
                        activeShape = shapes.size();
                        break;
                    }
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

        public void mouseReleased(MouseEvent event)
        {resizeMode=false;}

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
                if(resizeMode)
                {
                    System.out.println("resizing");

                    shapes.get(activeShape).setRadius(Math.pow(Math.pow((event.getX()-shapes.get(activeShape).getCenter().getX()),2)+Math.pow((event.getY()-shapes.get(activeShape).getCenter().getY()),2),0.5));

                }
                else
                {
                    shapes.get(activeShape).move(event.getX()+ctrOffset.getWidth(),event.getY()+ctrOffset.getHeight());
                }
            }
            repaint();
        }

        public void mouseMoved(MouseEvent event){}       
    }
}