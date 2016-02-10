import javax.swing.*;
import java.awt.event.*;

public class ButtonViewer
{
    private static final int FRAME_WIDTH = 100;
    private static final int FRAME_HEIGHT = 60;
    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    private JButton button, button2;
    private ClickListener listener;
    public ButtonViewer()
    {
        frame = new JFrame();
        label = new JLabel();
        panel = new JPanel();

        button = new JButton("Click Me!");
        button2 = new JButton("Click Me 2!");
        panel.add(button2);
        panel.add(button);
        label = new JLabel();
        panel.add(this.label);
        frame.add(panel);


        listener = new ClickListener();

        button.addActionListener(listener);
        button2.addActionListener(listener);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public class ClickListener implements ActionListener
    {
        public ClickListener(){}
        public void actionPerformed(ActionEvent event)
        {
            label.setText("Button "+event.getActionCommand()+" was clicked!");
        }
    }
}