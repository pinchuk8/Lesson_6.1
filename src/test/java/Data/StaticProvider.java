package Data;

import org.testng.annotations.DataProvider;

public class StaticProvider {
    @DataProvider(name = "dataForSome")
    public static Object[][] dataForSomeFunction() {
        return new Object[][]{
                        {-2, -3, -5},
                        {0, 0, 0},
                        {2, 3, 5}

        };
    }
}
