import java.time.LocalTime;

public class HandTester {

    private final static double RADIANS = Math.PI*2;
    private final static double EPSILON = 1E-12;

    public static void main(String[] args) {
        test_0();
        test_1();
        test_2();
        test_3();
        test_4();
        test_5();
        System.err.println("PASS");
    }

    // special
    private static void test_0() {
        LocalTime time = LocalTime.MIN;
        Hand hours = new Hand(Hand.TimeUnit.HOUR, time);
        assert 0 == hours.angle;
    }
    
    // special
    private static void test_1() {
        LocalTime time = LocalTime.MIN;
        Hand minutes = new Hand(Hand.TimeUnit.MINUTE, time);
        assert 0 == minutes.angle;
    }
    
    // special
    private static void test_2() {
        LocalTime time = LocalTime.MIN;
        Hand seconds = new Hand(Hand.TimeUnit.SECOND, time);
        assert 0 == seconds.angle;
    }
    
    // special
    private static void test_3() {
        LocalTime time = LocalTime.MIN;
        Hand milliSeconds = new Hand(Hand.TimeUnit.MILLS, time);
        assert 0 == milliSeconds.angle;
    }
    
    // typical
    public static void test_4() {
        LocalTime timeFour = LocalTime.of(4, 0);
        Hand seconds = new Hand(Hand.TimeUnit.SECOND, timeFour);
        assert 0 == seconds.angle;
        Hand minutes = new Hand(Hand.TimeUnit.MINUTE, timeFour);
        assert 0 == minutes.angle;
        Hand hours = new Hand(Hand.TimeUnit.HOUR, timeFour, minutes);
        assert Math.toRadians(180) == hours.angle;
    }
    
    // boundary
    private static void test_5() {
        LocalTime time = LocalTime.MAX;
        Hand milliSeconds = new Hand(Hand.TimeUnit.MILLS, time);
        assert 0 == milliSeconds.angle;
    }

    // ** Do Not Change Below this line ** //

    private static void assertEquals(double exp, double act) {
        assert Math.abs(exp - act) <= EPSILON :
            "\nexp: " + exp + "\nact: " + act + "\ndif: " + (exp-act);
    }

    static {
        boolean assertsEnabled = false;
        assert assertsEnabled = true; // Intentional side effect!!!
        if (!assertsEnabled) {
            throw new RuntimeException("Asserts must be enabled!!! java -ea");
        }
    }
}
