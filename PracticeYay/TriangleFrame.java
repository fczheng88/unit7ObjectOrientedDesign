import javax.swing.JFrame;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.awt.geom.*;
public class TriangleFrame extends JFrame{
    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 400;
    private TriangleComponent tri;
    public TriangleFrame()
    {
        tri = new TriangleComponent();
        add(tri);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);

        MouseListener listener = new MyMouseListener();
        tri.addMouseListener(listener);
    }
    class MyMouseListener implements MouseListener
    {
        public void mousePressed(MouseEvent event)
        {
            tri.addPoint(event.getX(), event.getY());
            repaint();
        }

        public void mouseReleased(MouseEvent event){}

        public void mouseClicked(MouseEvent event){}

        public void mouseEntered(MouseEvent event){}

        public void mouseExited(MouseEvent event){}        
    }
}
