package fall_2014_hw.clock;
import javax.swing.JApplet;
import java.awt.*;

public class Animator extends JApplet {

    private int lag = 23;

    public void setLag(int newLag) {
        lag = newLag;
    }

    public int getLag() {
        return lag;
    }

    public boolean tick() {
        return true;
    }

    public void snapshot(Graphics g) {

    }

    public void delay(int lag) {
        if (lag > 0) {
            delay(lag - 1);
            delay(lag - 1);
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        snapshot(g);
        if (tick()) {
            delay(lag);
            repaint();
        }
    }
}