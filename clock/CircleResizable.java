package fall_2014_hw.clock;

import javax.swing.JApplet;
import java.awt.*;

public class CircleResizable extends JApplet {

    private int diameter = 200;

    public void init() {
        setSize(diameter + 1, diameter + 1);
    }

    public void paint(Graphics g) {

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        diameter = Math.min(getWidth(), getHeight()) - 1;
        g.drawOval(0, 0, diameter, diameter);
    }
}