import java.time.LocalTime;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

/** An analogue Clock! With hands that indicate the current time!
 @author Jeremy Hilliker @ Langara
 @author Tomas Gonzalez Ortega
 @version 2017-05-29 12h20
 @see <a href="https://d2l.langara.bc.ca/d2l/lms/dropbox/user/folder_submit_files.d2l?db=50644&grpid=0&isprv=0&bp=0&ou=88736">a 04: 2D Graphics - Clock</a>
*/
public class Clock {

    public final static double RADIANS = 2*Math.PI;
    public final static int SCALE = 200;
    public final static int CENTRE = SCALE/2;

    private final static int NUM_TICKS = 12;
    private final static int NUM_FAT_TICKS = 4;
    private final static int TICK_LENGTH = SCALE / 10;

    public LocalTime time = LocalTime.now();
    public Hand[] hand = new Hand[4];

    public Clock() {
        this(LocalTime.now());
    }
    public Clock(LocalTime aTime) {
        time = aTime;
    }

    /**
     *Draws the clock
     *@param g the Graphics2D graphics context
    */
    public void draw(Graphics2D g) {

        // Clock frame
        Rectangle frame = new Rectangle(SCALE, SCALE);
        g.setColor(Color.GRAY);
        g.fill(frame);
        g.setColor(Color.BLACK);
        g.draw(frame);

        // Clock circle
        Ellipse2D.Double circle = new Ellipse2D.Double(0, 0, SCALE, SCALE);
        g.setColor(Color.WHITE);
        g.fill(circle);
        g.setColor(Color.BLACK);
        g.draw(circle);

        // Centre the point CENTRE
        g.translate(CENTRE, CENTRE);

        // Clock ticks
        drawTicks(g, NUM_TICKS, 1);
        drawTicks(g, NUM_FAT_TICKS, 3);

        // Call the Hands method
        getHands();
        // Access each instance of the Hand array (Hour, minute, second, milli)
        for(int h = 0; h < 4 ; h++) {
            hand[h].draw(g);
        }
    }

    private void drawTicks(Graphics2D g, int numTicks, int width) {

        // find angle between ticks
        double angle = RADIANS / numTicks;

        // make stroke
        g.setStroke(new BasicStroke(width));

        // for each tick
        for (int i = 0; i < numTicks; i++){

            // draw it
            g.draw(new Line2D.Float(CENTRE, 0, CENTRE - TICK_LENGTH, 0));
            g.rotate(angle);
        }
    }

    /**
     * A no argument constructor for each possible hand for the clock
     *@return a hand once constructed
     */
    public Hand[] getHands() {

        hand[0] = new Hand(Hand.TimeUnit.HOUR, time);
        hand[1] = new Hand(Hand.TimeUnit.MINUTE, time);
        hand[2] = new Hand(Hand.TimeUnit.SECOND, time);
        hand[3] = new Hand(Hand.TimeUnit.MILLS, time);
        return hand;
    }
}
