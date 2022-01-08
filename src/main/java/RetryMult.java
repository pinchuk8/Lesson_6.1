import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.internal.TestResult;

public class RetryMult implements IRetryAnalyzer {
    public int a=12;
    private int b=1;
    private int expected=36;
    private int b_max=3;


    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if ((a*b)!=expected) {
                this.b++;
                iTestResult.setStatus(TestResult.FAILURE);
                System.out.println("Retrying one more time");
                return true;

            } else {
                iTestResult.setStatus(TestResult.FAILURE);
            }
        }else {
            iTestResult.setStatus(TestResult.SUCCESS);
        }
        return false;
    }
}

