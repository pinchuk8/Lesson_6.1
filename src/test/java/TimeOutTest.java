import org.testng.annotations.Test;

public class TimeOutTest {
    @Test (timeOut = 1000)
    public void timeOutTest () throws InterruptedException {
        Thread.sleep(1001);
    }
}