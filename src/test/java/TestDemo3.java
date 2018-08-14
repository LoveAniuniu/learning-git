import Util.ExcelUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDemo3 {
    @Test
    public void test1() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Test01");
    }

    @Test
    public void test2() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Test02");
    }

    @Test
    public void test3() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Test03");
    }

    //从excel文件中进行参数化
    @DataProvider(name = "excel")
    public Object[][] getData() throws Exception{
        return ExcelUtil.getTestData2("testData","test.xls","Sheet1");
    }
    @Test(dataProvider = "excel")
    public void testExcel(String a,String b){
        System.out.println(a+";"+b);
    }

}
