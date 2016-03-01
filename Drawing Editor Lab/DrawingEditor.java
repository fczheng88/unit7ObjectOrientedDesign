import javax.swing.JFrame;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.JFrame;

public class DrawingEditor extends JFrame
{
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 600;
    private DrawingPanel canvas;
    private ControlPanel controls;
    public DrawingEditor(){
        canvas = new DrawingPanel();
        controls = new ControlPanel(canvas);
        
        add(controls);
        
        
        
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setTitle("Drawing Editor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
}