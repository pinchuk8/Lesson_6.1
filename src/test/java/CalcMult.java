import Data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcMult extends BaseTest {
    private Calculator calc = new Calculator("CalcMult");

    @Test(invocationCount = 6, threadPoolSize = 3)
    public void testMult1() throws InterruptedException {
        Assert.assertEquals(calc.mult(6, 3), 18);

    }

    @Test(dataProvider = "dataForSomeMult", dataProviderClass = StaticProvider.class)
    public void testMult2(int a, int b, int expectedResult) {
        Assert.assertEquals(calc.mult(a, b), expectedResult);
    }

    int a = 12;
    int b = 1;
    int attempt=1;
    @Test(retryAnalyzer = Retry.class)
    public void testMult3() {
        if (calc.mult(a,b)==36) {
            Assert.assertTrue(true);
        } else {
            System.out.println("attempt_"+attempt);
            attempt++;
            b++;
            throw new NullPointerException();
        }
    }
}