import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcSum extends BaseTest {
    private Calculator calc = new Calculator("CalcSum");

    @Test (description = "Test of Sum in my Calculator", priority = 3, groups = "negative")
    public void testSum1() {
        Assert.assertEquals(calc.sum(5, 3), 8);
    }

    @Test (priority = 2,groups = "positive")
    public void testSum2() {
        Assert.assertEquals(calc.sum(5, 4), 9);

    }

    @Test (priority = 1,groups = "positive")
    public void testSum3() {
        Assert.assertEquals(calc.sum(7, 4), 11);
    }


}
