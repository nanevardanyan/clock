package fall_2014_hw.clock;


import javax.swing.JApplet;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Clock extends JApplet {

    private int clockSize = 100;
    private int h, m;
    Point center = new Point();


    public void init() {
        System.out.println("init");

    }


    public void start() {

        System.out.println("start");
    }

    private int hArm() {
        return clockSize / 2;
    }

    private int mArm() {
        return clockSize / 2;
    }


    public void tick() {
        m = (m + 1) % 60;
        if (m == 0) {
            h = (h + 1) % 12;
        }
    }

    public void delay(int lag) {
        if (lag > 0) {
            delay(lag - 1);
            delay(lag - 1);
        }
    }


    @Override
    public void update(Graphics g) {
        paint(g);
    }

    Image buff = null;

    public void paint(Graphics gr) {

        Font font12 = new Font("12", Font.BOLD, 18);
        int size = font12.getSize();


        int textWidth = font12.getSize();

        buff = createImage(clockSize, clockSize);
        Graphics g = buff.getGraphics();

        g.clearRect(0, 0, clockSize, clockSize);
        g.setColor(Color.WHITE);
        g.fillOval(0, 0, clockSize, clockSize);
        g.setColor(Color.BLACK);
        clockSize = Math.min(getSize().height, getSize().width);


        g.drawOval(0, 0, clockSize, clockSize);
        g.drawLine(clockSize / 2, clockSize / 2, (int) (clockSize / 2
                + mArm() * Math.sin(m * Math.PI / 30)), (int) (clockSize / 2 - mArm() * Math.cos(m * Math.PI / 30)));
        g.drawLine(clockSize / 2, clockSize / 2, clockSize - 25, clockSize / 2);

        g.drawString("12", clockSize / 2 - size / 2, size);
        g.drawString("3", clockSize - size, clockSize / 2);
        g.drawString("6", clockSize / 2 - size / 2, clockSize - size);
        g.drawString("9", size, clockSize / 2);

        g.setColor(Color.black);
        g.fillOval(clockSize / 2, clockSize / 2, size, size);

        tick();
        delay(25);

        g.setColor(Color.WHITE);

        gr.drawImage(buff, 0, 0, this);
        paint(gr);

    }

    public void stop() {
        System.out.println("stop");
        System.exit(0);
    }

    public void destroy() {
        System.out.println("See You");
    }

}
