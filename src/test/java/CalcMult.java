import Data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcMult extends BaseTest {
    private Calculator calc = new Calculator("CalcMult");
    private Object b;

    @Test(invocationCount = 6, threadPoolSize = 3)
    public void testMult1() throws InterruptedException {
        Assert.assertEquals(calc.mult(6, 3), 18);

    }

    @Test(dataProvider = "dataForSomeMult", dataProviderClass = StaticProvider.class)
    public void testMult2(int a, int b, int expectedResult) {
        Assert.assertEquals(calc.mult(a, b), expectedResult);
    }

    @Test(retryAnalyzer = RetryMult.class)
    public void testMult3() {
        int expected = 36;
        int a = 12;
        int b = 1;
        if ((a * b) == expected) {
            Assert.assertTrue(true);
        } else {
            System.out.println(b);
            b++;
            throw new NullPointerException();
        }
    }
}