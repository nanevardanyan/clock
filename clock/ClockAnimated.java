package fall_2014_hw.clock;

import fall_2014_hw.Animator;

import java.awt.*;

public class ClockAnimated extends Animator {

    private Point center;
    private Arm h;
    private Arm m;

    public void init() {
        center = new Point(100, 100);
        h = new Arm(center.x - 20, 12);
        m = new Arm(center.x, 60);
        setSize(2 * center.x + 1, 2 * center.y + 1);
    }

    public boolean tick() {
        if (m.tick())
            h.tick();
        return true;
    }

    public void snapshot(Graphics g) {
        g.drawOval(0, 0, 2 * center.x, 2 * center.y);
        h.draw(g, center);
        m.draw(g, center);

        // TODO BAD practice. Hard codding must be eliminated  ( 8, 15, 2, 10, 7, 4, .....)
        g.drawString("12", (int)center.getX() - 8, 15);
        g.drawString("3", (int)center.getX() * 2 - 10, (int)center.getY() + 7);
        g.drawString("6", (int)center.getX() - 4, (int)center.getY() * 2 - 10);
        g.drawString("9", 10, (int)center.getY() + 7);
        g.fillOval((int)center.getX() - 20, (int)center.getY() + 20, 40, 40);

    }
}
