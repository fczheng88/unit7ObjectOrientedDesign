import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.util.*;
import java.awt.*;
import java.awt.geom.*;
/**
 * Write a description of class adsf here.
 * 
 * @author Felix Zheng
 * @version Release
 */
public class DrawingPanel extends JComponent
{
    private ArrayList<Shape> shapes;//creates the array for storing shapes
    private int activeShape; //stores the shape currently being edited/moved
    private Color currentColor;//stores the current color. Automatically randomized unless JColorChooser is called.
    private JColorChooser colorChooser;//Allows the user to choose a color using a GUI
    private MyMouseListener listener;//Listens for mouse events
    private MyMouseMotionListener motionListener;//Listens for mouse events
    private Point2D.Double oMousePos;//Original Mouse Position - used here and there for shape moves/resizes
    private Dimension ctrOffset, preferredSize;//Stores various goodies
    private boolean resizeMode;//Determines whether the DrawingEditor is in "resize mode" and enables shapes to be resized

    /**
     * DrawingPanel Constructor initializes instance variables
     *
     */
    public DrawingPanel()
    {
        preferredSize = new Dimension(400,400);//sets the size of the canvas
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

    /**
     * Method getColor returns the current Color of the shape
     *
     * @return The current Color
     */
    public Color getColor()
    {
        return currentColor;
    }

    /**
     * Method pickColor is called to display the JColorChooser GUI for choosing colors
     *
     */
    public void pickColor()
    {
        currentColor = colorChooser.showDialog(this, "Choose a Color",currentColor);
    }

    /**
     * Method getPreferredSize overrides JCompoent’s getPreferredSize method
     * to return a size large enough to encapsulate a reasonable drawing canvas.
     *
     * @return The dimensions of the drawing canvas
     */
    public Dimension getPreferredSize()
    {
        return preferredSize;
    }

    /**
     * Method addCircle adds a new circle to the list of shapes
     * at a random location on the canvas with a random radius from 25-75 px
     *
     */
    public void addCircle()
    {
        shapes.add(new Circle(new Point2D.Double(Math.random()*preferredSize.getWidth(),Math.random()*preferredSize.getHeight()), Math.random()*50+25, currentColor));
        activeShape = shapes.size()-1;
        currentColor = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
    }

    /**
     * Method addSquare adds a new square to the list of shapes
     * at a random location on the canvas with a random radius from 25-75 px, 
     * where the radius determines the size of an inscribed circle
     *
     */
    public void addSquare()
    {
        shapes.add(new Square(new Point2D.Double(Math.random()*preferredSize.getWidth(),Math.random()*preferredSize.getHeight()), Math.random()*50+25, currentColor));
        activeShape = shapes.size()-1;
        currentColor = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
    }

    /**
     * Method paintComponent is called by repaint and determines which objects should be painted in what ways
     *
     * @param g the graphics object
     */
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
    /**
     * MyMouseListener implements MouseListener and defines several methods to run based on the type of mouse event
     * 
     * @author Felix Zheng 
     * @version Release
     */
    class MyMouseListener implements MouseListener
    {
        /**
         * Method mousePressed decides what to do based on when and where the mouse is pressed
         *
         * @param event The mouse event
         */
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
            }
            repaint();
        }

        /**
         * Method mouseReleased ensures shapes are deselected when the mouse is released
         *
         * @param event a mouse event
         */
        public void mouseReleased(MouseEvent event)
        {
            resizeMode=false;
            activeShape = shapes.size();
            repaint();
        }

        /**
         * Method mouseClicked is called when the mouse is clicked
         *
         * @param event a mouse event
         */
        public void mouseClicked(MouseEvent event){}

        /**
         * Method mouseEntered is called when the mouse is clicked
         *
         * @param event a mouse event
         */
        public void mouseEntered(MouseEvent event){}

        /**
         * Method mouseExited is called when the mouse is clicked
         *
         * @param event a mouse event
         */
        public void mouseExited(MouseEvent event){}        
    }
    /**
     * MyMouseMotionListener implements MouseMotionListener and defines several methods to run based on the type of mouse event
     * 
     * @author Felix Zheng 
     * @version Release
     */
    class MyMouseMotionListener implements MouseMotionListener
    {
        public void mouseDragged(MouseEvent event)
        {
            if(shapes.size()!=0&&activeShape!=shapes.size())
            {
                if(resizeMode)
                {
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