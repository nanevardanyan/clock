package fall_2014_hw.clock;

import java.awt.*;

public class Arm {

    private int value;
    private int length;
    private int period;

    public Arm(int newLength, int newCycle) {
        value = 0;
        length = newLength;
        period = newCycle;
    }

    public boolean tick() {
        value = (value + 1) % period;
        return value == 0;
    }

    public void draw(Graphics g, Point start) {
        g.drawLine(start.x, start.y,
                (int)(start.x + length * Math.sin(value * 2 * Math.PI / period)),
                (int)(start.y - length * Math.cos(value * 2 * Math.PI / period)));
    }
}
