import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcDif extends BaseTest {
    private Calculator calc = new Calculator("CalcDif");

    @Test (dependsOnMethods = "testDif2")
    public void testDif1() {
        Assert.assertEquals(calc.dif(5, 3), 2);
    }

    @Test ()
    public void testDif2() {
        Assert.assertEquals(calc.dif(7, 0), 7);
    }

    @Test (description = "testDif1")
    public void testDif3() {
        Assert.assertEquals(calc.dif(7, 4), 3);
    }


}
