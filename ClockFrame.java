import javax.swing.JFrame;

/** A frame to draw a clock
 @author Jeremy Hilliker @ Langara
 @author Tomas Gonzalez Ortega
 @version 2017-05-29 12h20
 @see <a href="https://d2l.langara.bc.ca/d2l/lms/dropbox/user/folder_submit_files.d2l?db=50644&grpid=0&isprv=0&bp=0&ou=88736">a 04: 2D Graphics - Clock</a>
*/
public class ClockFrame {

  private final static int WIDTH = 500;
  private final static int HEIGHT = 500;

  /**
  * Creates a frame window, that works as a canvas to draw the clock
  * @param args line arguments -- ignored in this assignment
  */
  public static void main(String[] args) {
    JFrame frame = new JFrame();

    frame.setSize(WIDTH, HEIGHT);
    frame.setTitle("A Clock");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.add(new ClockComponent());

    frame.setVisible(true);
  }
}
