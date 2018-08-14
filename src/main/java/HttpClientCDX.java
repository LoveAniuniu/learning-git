import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class HttpClientCDX {
    public static void main(String[] args) throws Exception {
        LaxRedirectStrategy redirectStrategy = new LaxRedirectStrategy();
        CloseableHttpClient httpClient = HttpClients.custom().setRedirectStrategy(redirectStrategy).build();
        HttpClientContext context = HttpClientContext.create();
        HttpPost httpPost = new HttpPost("http://116.196.88.42/bugfree/site/login");
        List<NameValuePair> kvList = new ArrayList<NameValuePair>();
        kvList.add(new BasicNameValuePair("LoginForm[username]","admin"));
        kvList.add(new BasicNameValuePair("LoginForm[password]","123456"));
        kvList.add(new BasicNameValuePair("LoginForm[language]","zh_cn"));
        kvList.add(new BasicNameValuePair("LoginForm[rememberMe]","0"));
        StringEntity entity = new UrlEncodedFormEntity(kvList,"utf-8");
        httpPost.setEntity(entity);
        CloseableHttpResponse response = httpClient.execute(httpPost,context);
        HttpHost target = context.getTargetHost();
        List<URI> redirectLocations = context.getRedirectLocations();
        System.out.println(redirectLocations);
        URI location = URIUtils.resolve(httpPost.getURI(),target,redirectLocations);
        System.out.println("Final Http location:"+ location.toASCIIString());
    }
}
