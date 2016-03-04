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
        pickColor.setBackground(canvas.getColor());
        //actionListeners are added with their own ActionListeners
        pickColor.addActionListener(new ActionListener()
            {   
                public void actionPerformed(ActionEvent event)
                {
                    {canvas.pickColor();pickColor.setBackground(canvas.getColor());}
                }
            });
        addCircle.addActionListener(new ActionListener()
            {   
                public void actionPerformed(ActionEvent event)
                {
                    {canvas.addCircle();canvas.repaint();pickColor.setBackground(canvas.getColor());}
                }
            });
        addSquare.addActionListener(new ActionListener()
            {   
                public void actionPerformed(ActionEvent event)
                {
                    {canvas.addSquare();canvas.repaint();pickColor.setBackground(canvas.getColor());}
                }
            });
        
        //Everthing is added to the Panel
        
        add(addCircle);
        add(addSquare);
        add(pickColor);
        
        
    }

}
