import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
/**
     * ControlPanel extends JPanel and creates the buttons for the DrawingEditor
     * 
     * @author Felix Zheng 
     * @version Release
     */
public class ControlPanel extends JPanel
{
    private JButton pickColor, addCircle, addSquare;//the buttons
    /**
     * Constructor for objects of class ControlPanel
     */
    public ControlPanel(DrawingPanel canvas)
    {
        //Creates the buttons
        addCircle = new JButton("Add Circle");
        addSquare = new JButton("Add Square");   
        pickColor = new JButton("Pick Color");
        
        //actionListeners are added with their own ActionListeners
        pickColor.addActionListener(new ActionListener()
            {   
                public void actionPerformed(ActionEvent event)
                {
                    {canvas.pickColor();}
                }
            });
        addCircle.addActionListener(new ActionListener()
            {   
                public void actionPerformed(ActionEvent event)
                {
                    {canvas.addCircle();
                        canvas.repaint();}
                }
            });
        addSquare.addActionListener(new ActionListener()
            {   
                public void actionPerformed(ActionEvent event)
                {
                    {canvas.addSquare();
                        canvas.repaint();}
                }
            });
        
        //Everthing is added to the Panel
        setLayout(new BorderLayout());
        add(addCircle,BorderLayout.WEST);
        add(addSquare,BorderLayout.EAST);
        add(pickColor,BorderLayout.CENTER);
        add(canvas,BorderLayout.NORTH);
        
    }

}
