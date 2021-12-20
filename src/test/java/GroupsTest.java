import org.testng.annotations.Test;

public class GroupsTest extends BaseTest{

    @Test (groups = {"smoke","sanity","regression"})
    public void smokeTest(){
        System.out.println("CalcTest -> testSum");
    }

    @Test (groups = {"sanity", "regression"})
    public void sanityTest(){System.out.println("CalcTest -> testSum");}

    @Test (groups = "regression")
    public void regressionTest(){System.out.println("CalcTest -> testSum");}

}