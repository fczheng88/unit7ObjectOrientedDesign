import javax.swing.JFrame;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.JFrame;

public class DrawingEditor
{
    DrawingPanel canvas = new DrawingPanel();
        ControlPanel controls = new ControlPanel(canvas);
    public static void main(String[] args){
        frame.setTitle("Drawing Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}