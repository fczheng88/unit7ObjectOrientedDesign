import javax.swing.JFrame;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.JFrame;
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
        add(controls);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new DrawingEditor();
    }

}