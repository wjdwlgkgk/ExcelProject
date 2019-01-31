package testbed;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class openapi {

    StringBuilder sb = new StringBuilder();

    public void init() throws Exception{
        String apiKey = "l7xx0beed2c20cf7417aa895b987aad55a17";
        String apiSecret = "ee15850b32824465ab3ebf434151dd93";
        String fintech_use_num = "123456789012345678901234";
        String tran_dtime = "20160310101921";

        URL url = new URL("https://openapi.open-platform.or.kr/account/balance");
        //url 상세검색 =  book_adv, 그냥 검색 book
        URLConnection urlConn = url.openConnection();

        urlConn.setRequestProperty("fintech_use_num", fintech_use_num);
        urlConn.setRequestProperty("tran_dtime", tran_dtime);

        BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));


        String msg = null;

        while ((msg = br.readLine()) != null)
            sb.append(msg);


        System.out.println(sb.toString());


    }
}
