import java.awt.*;
import javax.swing.JComponent;
import javax.swing.Timer;
import java.time.LocalTime;

/** This component clears, translates, scales and draws a clock
 @author Jeremy Hilliker @ Langara
 @author Tomas Gonzalez Ortega
 @version 2017-05-29 12h20
 @see <a href="https://d2l.langara.bc.ca/d2l/lms/dropbox/user/folder_submit_files.d2l?db=50644&grpid=0&isprv=0&bp=0&ou=88736">a 04: 2D Graphics - Clock</a>
*/
public class ClockComponent extends JComponent
{

	public ClockComponent() {
	}

    /**
     *This component draws a clock
     *@ param Graphics environment
     */
	public void paint(Graphics g) {
		// the frame's dimensions
		final int w = getWidth();  // width
		final int h = getHeight(); // height

		// clear the specified rectangle by filling it with the background colour
		// useful when resizing because we want to erase what there was before
		g.clearRect(0, 0, w, h);

        // set up our transform to be relative to a 200x200 box
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(
			RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// move to centre
		g2.translate(w/2.0, h/2.0);
		// scale
    	int min = Math.min(w, h);
    	double scaleFactor = min/(double)Clock.SCALE;
    	g2.scale(scaleFactor, scaleFactor);
    	// move to top left of bound
    	g2.translate(-Clock.CENTRE, -Clock.CENTRE);

		// draw the 200x200 box
		Clock c = new Clock();
		c.draw(g2);

		g2.dispose();
	}
}
