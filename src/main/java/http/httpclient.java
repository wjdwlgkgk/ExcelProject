package http;

import org.apache.http.client.ClientProtocolException;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class httpclient {




    public static void main(String args[]) throws ClientProtocolException, IOException {


        String ip = "http://localhost:8093/greeting.json";
        URL url = new URL(ip);
        URLConnection conn = url.openConnection();
        HttpURLConnection urlConn = (HttpURLConnection) conn;

        urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        urlConn.setRequestMethod("POST");
        urlConn.setDoOutput(true);
        urlConn.setUseCaches(false);
        urlConn.setDefaultUseCaches(false);

        String param = "name=" + URLEncoder.encode("jiha", "UTF-8");

        OutputStream out = urlConn.getOutputStream();
        out.write(param.getBytes("euc-kr"));
        out.flush();
        out.close();

        int reponseCode = urlConn.getResponseCode();
        int length = urlConn.getContentLength();
        String content = urlConn.getContent().toString();
        String type = urlConn.getContentType();
        urlConn.disconnect();


        //allRequestParams = cron_exp , 0 0 5 ? * THU, FRI
//        httpPost.addHeader("cron_exp", "0 0 */5 * * THU, FRI");
        System.out.println("::GET Response Status::");

        //response의 status 코드 출력
        System.out.println(reponseCode);
        System.out.println(content);


    }



}
