import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
/**
 * Write a description of interface MouseListener here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface MouseListener
{
    void mousePressedLocation(MouseEvent event);
    void mouseReleased(MouseEvent event);
    void mouseClicked(MouseEvent event);
    void mouseEntered(MouseEvent event);
    void mouseExited(MouseEvent event);
}
