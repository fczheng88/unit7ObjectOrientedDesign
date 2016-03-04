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
    private JPanel colorIndicator;//indicates the color
    private JCheckBox randColor;//use a random color?
    DrawingPanel dPanel;//drawing panel reference
    /**
     * Constructor for objects of class ControlPanel
     */
    public ControlPanel(DrawingPanel canvas)
    {
        dPanel = canvas;
        //Creates the buttons
        addCircle = new JButton("Add Circle");
        addSquare = new JButton("Add Square");   
        pickColor = new JButton("Pick Color");
        colorIndicator = new JPanel();

        randColor = new JCheckBox("Random Color?", false);

        colorIndicator.setOpaque(true);
        colorIndicator.setForeground(null);
        colorIndicator.setBackground(dPanel.getColor());

        ActionListener aListener = new MyActionListener();
        //actionListeners are added with their own ActionListeners
        pickColor.addActionListener(aListener);
        addCircle.addActionListener(aListener);
        addSquare.addActionListener(aListener);
        randColor.addItemListener(new ItemListener() //Listens to the checkBox
            {
                public void itemStateChanged(ItemEvent e) {
                    dPanel.useRandomColor(randColor.isSelected());
                    dPanel.requestFocusInWindow();
                }
            });

        //Everthing is added to the Panel
        add(addCircle);
        add(addSquare);
        add(pickColor);
        add(colorIndicator);
        add(randColor);

    }
    /** MyActionListener is an ActionListener with my events 
    * 
    * @author Felix Zheng 
    * @version Release
    */
    public class MyActionListener implements ActionListener
    {   
        /**
         * Method actionPerformed changes the DrawingPanel based on actions
         *
         * @param e The event
         */
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==pickColor)
            {
                dPanel.pickColor();
                colorIndicator.setBackground(dPanel.getColor());
                dPanel.requestFocusInWindow();
            }
            else if(e.getSource()==addCircle)
            {
                dPanel.addCircle();
                dPanel.repaint();
                colorIndicator.setBackground(dPanel.getColor());
                dPanel.requestFocusInWindow();
            }
            else if(e.getSource()==addSquare)
            {
                dPanel.addSquare();
                dPanel.repaint();
                colorIndicator.setBackground(dPanel.getColor());
                dPanel.requestFocusInWindow();
            }
        }
    }

}
