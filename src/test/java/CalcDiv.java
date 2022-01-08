import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadTimeoutException;

public class CalcDiv extends BaseTest {
    private Calculator calc = new Calculator("CalcDiv");
    @Test (groups = "negative")
    public void testDiv1() {
        Assert.assertEquals(calc.div(6, 3), 2);
    }

    @Test (expectedExceptions = ArithmeticException.class,groups = "negative")
    public void testDiv2() {
        Assert.assertEquals(calc.div(7, 0), 7);
    }

    @Test (timeOut = 1000,expectedExceptions = ThreadTimeoutException.class)
    public void testDiv3() throws InterruptedException {
        Assert.assertEquals(calc.div(12, 4), 3);
        Thread.sleep(2000);
    }


}
