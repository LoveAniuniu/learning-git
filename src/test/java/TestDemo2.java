import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class TestDemo2 {
    @Test
    @Parameters({ "xx", "yy" })
    public void test01(String dbconfig, String poolsize){
        System.out.println("param1="+dbconfig+",param2="+poolsize);
    }
    //数据驱动测试1
    @Test
    @Parameters({"ss","yy"})
    public void test02(String a,String b){
        System.out.println("param1="+a+",param2="+b);
    }
    //DataProvider使用较频繁
    @Test(dataProvider = "provideNumbers")
    public void test03(int number, int expected) {
        Assert.assertEquals(number + 10, expected);
        System.out.println(number+":"+expected);
    }
    //数据驱动测试2
    @DataProvider(name = "provideNumbers")
    public Object[][] provideData() {
        return new Object[][] { { 10, 20 }, { 100, 110 }, { 200, 210 } };
    }


    @Test(dataProvider = "dataProvider")
    public void test04(int a,int b){
        System.out.println("param1="+a+",param2="+b);
    }

    @Test(dataProvider = "dataProvider")
    public void test05(String a,String b){
        System.out.println("param1="+a+",param2="+b);
    }

    @DataProvider(name = "dataProvider")
    public Object[][] provideData(Method method) {
        Object[][] result = null;
        if (method.getName().equals("test04")) {
            result = new Object[][]{
                    {1, 1}, {200, 200}
            };
        } else if (method.getName().equals("test05")) {
            result = new Object[][]{
                    {"test@gmail.com", "test@gmail.com"},
                    {"test@yahoo.com", "test@yahoo.com"}
            };
        }
        return result;
    }
    }
