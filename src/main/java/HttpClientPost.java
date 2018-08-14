
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

public class HttpClientPost {
    public static void main(String[] args) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost("http://test87.company.home.ke.com/api/user/login");
//        ?type=user_code&auth=20261056&password=123456&emergency=1;
        List<NameValuePair> kvList = new ArrayList<NameValuePair>();
        kvList.add(new BasicNameValuePair("type","user_code"));
        kvList.add(new BasicNameValuePair("auth","20261056"));
        kvList.add(new BasicNameValuePair("password","123456"));
        kvList.add(new BasicNameValuePair("emergency","1"));
        post.setEntity(new UrlEncodedFormEntity(kvList,"utf-8"));
        CloseableHttpResponse response = httpClient.execute(post);
        String string = EntityUtils.toString(response.getEntity());
        System.out.println(string);
        response.close();
        httpClient.close();
    }


}
