import javax.swing.JFrame;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.awt.geom.*;
/**
 * Write a description of class CotnrolPanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ControlPanel  JPanel
{
    private JButton pickColor, addCircle, addSquare;
    private JPanel colorDisp;
    private Color currColor;
    private ClickListener colorListener, circleListener, squareListener;
    /**
     * Constructor for objects of class CotnrolPanel
     */
    public ControlPanel()
    {
        pickColor = new JButton("Pick Color");
        addCircle = new JButton("Add Circle");
        addSquare = new JButton("Add Square");        
        
        
        currColor = canvas.getColor();
    }
    
    public class ClickListener implements ActionListener
    {
        public ClickListener(){}
        public void actionPerformed(ActionEvent event)
        {
            
        }
    }
}
