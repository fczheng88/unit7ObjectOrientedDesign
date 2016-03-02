import javax.swing.JFrame;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.JFrame;

public class DrawingEditor extends JFrame
{
    private DrawingPanel canvas;
    private ControlPanel controls;
    public DrawingEditor(){
        canvas = new DrawingPanel();
        controls = new ControlPanel(canvas);
        
        add(controls);       
        setSize((int)canvas.getPreferredSize().getWidth(),(int)canvas.getPreferredSize().getHeight()+200);
        setTitle("Drawing Editor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args)
    {
        DrawingEditor editor = new DrawingEditor();
    }
    
}