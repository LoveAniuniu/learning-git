import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClient {
    public static void main(String[] args) throws IOException {
        /*1、创建httpClient对象
          2、并制定请求URL，httpGet或者httpPost
          3、发送请求参数，可调用httpGet，httpPost共同的setParams(hetpParams params)方法来添加请求参数，对于post对象而言，也可以调用setEntity(HttpEntity entity)方法来设置请求参数
          4、调用HttpClient对象的execute发送请求，该方法返回一个httpResponse
          5、调用HttpResponse的getAllHeaders()，getHeaders(String name)等方法可获取服务器的响应头；调用httpResponse的getEntity()方法可获取httpEntity对象，包装了服务器的相应内容
          6、释放连接*/

        //创建一个httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
       //创建一个get请求
        HttpGet get = new HttpGet("http://test87.company.home.ke.com/api/user/login?type=user_code&auth=20261056&password=123456&emergency=1");
        //发送请求
        CloseableHttpResponse response = httpClient.execute(get);
        //获取response的状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        //获取response的结果
        HttpEntity entity = response.getEntity();
        String string = EntityUtils.toString(entity,"utf-8");
        System.out.println(string);
        //释放连接
        response.close();
        httpClient.close();


    }
}
