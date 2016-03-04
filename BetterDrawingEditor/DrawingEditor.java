import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
/**
 * DrawingEditor extends JFrame and contains main method to create a Drawing Editor. 
 * 
 * @author Felix Zheng 
 * @version Release
 */
public class DrawingEditor extends JFrame
{
    private DrawingPanel canvas;
    private ControlPanel controls;
    public DrawingEditor(){
        canvas = new DrawingPanel();
        controls = new ControlPanel(canvas);

        //sets the size based on the preferred dimension and adds 75 for buttons
        setSize((int)canvas.getPreferredSize().getWidth(),(int)canvas.getPreferredSize().getHeight()+75);
        setTitle("Drawing Editor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(new BorderLayout());
        
        add(canvas,BorderLayout.NORTH);
        add(controls, BorderLayout.SOUTH);
        
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new DrawingEditor();
    }

}