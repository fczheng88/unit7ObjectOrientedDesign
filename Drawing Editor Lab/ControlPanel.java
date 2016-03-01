import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
/**
 * Write a description of class CotnrolPanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ControlPanel extends JPanel
{
    private JButton pickColor, addCircle, addSquare;
    private JPanel panel;

    /**
     * Constructor for objects of class CotnrolPanel
     */
    public ControlPanel(DrawingPanel canvas)
    {

        addCircle = new JButton("Add Circle");
        addSquare = new JButton("Add Square");   
        pickColor = new JButton("Pick Color");
        panel = new JPanel();

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
        panel.add(addCircle);

        panel.add(addSquare);

        panel.add(pickColor);
        add(canvas, BorderLayout.PAGE_START);
        add(panel,BorderLayout.PAGE_END);
        
    }

}
