import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDeno {
    @Test(expectedExceptions = ArithmeticException.class)
    public void divisionWithException() {
        int i = 1 / 0;
        System.out.println("After division the value of i is :" + i);
    }
    @Test(enabled = false)
    public void test3() {
        Assert.assertEquals(true, true);
    }

//    @Test(groups = "selenium-test")
//    public void runSelenium1() {
//        System.out.println("runSelenium");
//    }
}