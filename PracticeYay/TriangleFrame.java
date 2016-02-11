
public class TriangleFrame{
    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 400;
    private TriangleComponent tri;
    public TriangleFrame()
    {
        tri = new TriangleComponent();
        add(tri);
        
        MouseListener listener = new MouseListener();
        tri.addMouseListener(listener);
        
        seSize(FRAME_WIDTH, FRAME_HEIGHT);
    }
    class MouseListenerYay implements MouseListener
    {
        public void mousePressedLocation(MouseEvent event)
        {
            
        }
        public void mouseReleased(MouseEvent event)
        {
            
        }
        public void mouseClicked(MouseEvent event)
        {
        
        }
        public void mouseExited(MouseEvent event)
        {
        
        }
        
    }
}
