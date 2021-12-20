import org.testng.Assert;
import org.testng.annotations.Test;

public class PriorityTest {
    @Test (priority = 1)
    public void abcTest(){
        System.out.println("DependencyTest->abcTest");
        Assert.fail();
    }
    @Test(priority = 2)
    public void cbaTest(){
        System.out.println("DependencyTest->abcTest");
    }

    @Test (priority = 2)
    public void bacTest(){
        System.out.println("DependencyTest->abcTest");
    }
}
