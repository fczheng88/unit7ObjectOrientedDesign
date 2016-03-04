import javax.swing.*;
import java.awt.event.*;
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
    private MyKeyListener keyListener;//Listens for key events
    private Dimension preferredSize;//Stores goodies
    private boolean resizeMode;//is any shape being resized now?
    private Point2D.Double oldMousePos;
    /**
     * DrawingPanel Constructor initializes instance variables
     *
     */
    public DrawingPanel()
    {
        preferredSize = new Dimension(400,400);//sets the size of the canvas
        shapes = new ArrayList<Shape>();
        currentColor = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
        colorChooser = new JColorChooser(currentColor);
        activeShape=-1;//no active shape

        listener = new MyMouseListener();
        addMouseListener(listener);

        motionListener = new MyMouseMotionListener();
        addMouseMotionListener(motionListener);

        resizeMode = false;

        keyListener = new MyKeyListener();
        addKeyListener(keyListener);        
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
    {return preferredSize;}

    /**
     * Method addCircle adds a new circle to the list of shapes
     * at a random location on the canvas with a random radius from 25-75 px
     *
     */
    public void addCircle()
    {
        shapes.add(new Circle(new Point2D.Double(Math.random()*preferredSize.getWidth(),Math.random()*preferredSize.getHeight()), Math.random()*50+25, currentColor));
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
    }

    /**
     * Method paintComponent is called by repaint and determines which objects should be painted in what ways
     *
     * @param g the graphics object
     */
    public void paintComponent(Graphics g)    
    {
        Graphics2D g2 = (Graphics2D) g;

        for(int i=0;i<shapes.size();i++)
        {
            g2.setColor(shapes.get(i).getColor());
            if(i!=activeShape)
                shapes.get(i).draw(g2,true);
        }
        if(activeShape!=-1)
        {
            g2.setColor(shapes.get(activeShape).getColor());
            shapes.get(activeShape).draw(g2,false);
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
        public void mousePressed(MouseEvent e)
        {
            oldMousePos = new Point2D.Double(e.getX(), e.getY());
            for(int i=shapes.size()-1;i>=0;i--)
            {
                if(shapes.get(i).isOnBorder(new Point2D.Double(e.getX(),e.getY())))
                {
                    activeShape = i;
                    resizeMode = true;
                    return;
                }
                if(shapes.get(i).isInside(new Point2D.Double(e.getX(),e.getY())))
                {
                    if(SwingUtilities.isRightMouseButton(e))
                    {
                        shapes.remove(i);
                        repaint();
                        return;
                    }
                    activeShape=i;
                    return;                    
                }
            }
        }

        /**
         * Method mouseReleased ensures shapes are deselected when the mouse is released
         *
         * @param event a mouse event
         */
        public void mouseReleased(MouseEvent e)
        {
            activeShape=-1;
            resizeMode=false;
            repaint();
        }

        /**
         * Method mouseClicked is called when the mouse is clicked
         *
         * @param event a mouse event
         */
        public void mouseClicked(MouseEvent e){}

        /**
         * Method mouseEntered is called when the mouse is clicked
         *
         * @param event a mouse event
         */
        public void mouseEntered(MouseEvent e){}

        /**
         * Method mouseExited is called when the mouse is clicked
         *
         * @param event a mouse event
         */
        public void mouseExited(MouseEvent e){}        
    }
    /**
     * MyMouseMotionListener implements MouseMotionListener and defines several methods to run based on the type of mouse event
     * 
     * @author Felix Zheng 
     * @version Release
     */
    class MyMouseMotionListener implements MouseMotionListener
    {

        /**
         * Method mouseDragged
         *
         * @param e A mouse event
         */
        public void mouseDragged(MouseEvent e)
        {
            if(activeShape == -1)
            {
                return;
            }
            
            Shape s = shapes.get(activeShape);
            Point2D.Double c = s.getCenter();
            if(resizeMode)
            {   
                if(s.getClass() == Circle.class)
                {    
                    s.setRadius(Math.pow(
                            Math.pow((e.getX()-c.getX()),2) + Math.pow((e.getY()-c.getY()),2),
                            0.5));
                }
                else//square
                {
                    Square.WhereInShape wis = ((Square)s).getWhereInShape(new Point2D.Double(e.getX(),e.getY()));
                    if(wis==Square.WhereInShape.CORNER)
                    {
                        double newRadius = Math.pow(
                                (Math.pow(e.getX()-c.getX(),2) + Math.pow(e.getY()-c.getY(),2)) / 2,
                                0.5);
                        s.setRadius(newRadius);
                    }
                    else if(wis==Square.WhereInShape.TOPBOTTOM)
                    {
                        s.setRadius(Math.abs(e.getY()-c.getY()));
                    }
                    else if(wis==Square.WhereInShape.LEFTRIGHT)
                    {
                        s.setRadius(Math.abs(e.getX()-c.getX()));
                    }
                }
            }
            else//move
            {
                s.move(e.getX()-oldMousePos.getX(),e.getY()-oldMousePos.getY());
            }
            oldMousePos = new Point2D.Double(e.getX(), e.getY());
            repaint();
        }

        public void mouseMoved(MouseEvent e){}       
    }
    /**
     * MyKeyListener implements KeyListener and defines several methods to run based on the type of key event
     * @author Felix Zheng 
     * @version Release
     */
    class MyKeyListener implements KeyListener
    {
        public void keyTyped(KeyEvent e)
        {
        }

        public void keyPressed(KeyEvent e)
        {}

        public void keyReleased(KeyEvent e)
        {}
    }

}
