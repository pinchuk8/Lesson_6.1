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
    @DataProvider(name = "dataForSomeMult")
    public static Object[][] dataForSomeFunction_1() {
        return new Object[][]{
                {-2, -3, 6},
                {0, 0, 0},
                {2, 3, 6}

        };
    }
}
