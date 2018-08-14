import org.testng.Assert;
import org.testng.annotations.*;

public class TestWn01 {
    @BeforeSuite
    public void BeforeSuite() {
        System.out.println("BeforeSuite");
    }
    @AfterSuite
    public void AfterSuite() {
        System.out.println("AfterSuite");
    }
    @BeforeClass
    public void BeforeClass() {
        System.out.println("BeforeClass");
    }
    @AfterClass
    public void AfterClass() {
        System.out.println("AfterClass");
    }
    @BeforeTest
    public void BeforeTest() {
        System.out.println("BeforeTest");
    }
    @AfterTest
    public void AfterTest() {
        System.out.println("AfterTest");
    }
    @BeforeMethod
    public void BeforeMethod() {
        System.out.println("BeforeMethod");
    }
    @AfterMethod
    public void AfterMethod() {
        System.out.println("AfterMethod");
    }
    @Test
    public void Test1() {
        System.out.println("Test01");
    }
    @Test
    public void Test2() {
        System.out.println("Test02");
    }
}
