import java.awt.*;
import java.awt.geom.Line2D;
import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class Hand {

    public final static double RADIANS = Clock.RADIANS;

    public enum TimeUnit {
        MILLS(ChronoField.MILLI_OF_SECOND, 0 , 0),
        SECOND(ChronoField.SECOND_OF_MINUTE, 80, 0.5f, Color.RED),
        MINUTE(ChronoField.MINUTE_OF_HOUR, 90, 1),
        HOUR(ChronoField.HOUR_OF_AMPM, 60, 2);

        public final ChronoField cf;
        public final int length;
        public final BasicStroke stroke;
        public final Color color;
        TimeUnit(ChronoField aCF, int aLength, float aWidth) {
            this(aCF, aLength, aWidth, Color.BLACK);
        }
        TimeUnit(ChronoField aCF, int aLength, float aWidth, Color aColor) {
            cf = aCF;
            length = (Clock.SCALE * aLength) / (100 * 2);
            stroke = new BasicStroke(aWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
            color = aColor;
        }
    }

    private final TimeUnit unit; // ie: hour, minute, second, etc
    public final double angle; // the rotation of the hand in radians from 12 o'clock
    public final LocalTime time; // the actual stored time

    public Hand(TimeUnit aUnit, LocalTime aTime) {
            this(aUnit, aTime, null);
    }
    
    /**
     *Constructs a hand fot the clock
     *@param aUnit is the TimeUnit to pass into the hand
     *@param aTime is the LocalTime used to construct the hand
     *@param prevHand the following Hand
    */
    public Hand(TimeUnit aUnit, LocalTime aTime, Hand prevHand) {
        unit = aUnit;
        time = aTime;
        double timeValue = time.get(unit.cf);
        angle = (RADIANS / 12) * timeValue;
    }

    /**
     *Draws the hands of the clock
     *@param g the Graphics2D graphics context
    */
    public void draw(Graphics2D g) {
        // TODO FIXME draw the hand
        g.rotate(angle);
        g.setStroke(unit.stroke);
        g.setColor(unit.color);
        g.draw(new Line2D.Double(0, 0, unit.length, 0));
    }
}
