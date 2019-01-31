package Json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

// 네이버 API 예제 - 회원프로필 조회
public class JsonTest{
    public StringBuffer sb = new StringBuffer();

    public void dataFromOpenApi() throws Exception{
        String clientID = "1jD9knj7DoCLGvKxQYFh";
        String clientSecret = "lWul1byORz";
        String title = "love";
        int displaynum = 100;
        int startnum = 1;
        URL url = new URL("https://openapi.naver.com/v1/search/book_adv.json?d_titl=" + title + "&display=" + displaynum);
        //url 상세검색 =  book_adv, 그냥 검색 book
        URLConnection urlConn = url.openConnection();

        urlConn.setRequestProperty("X-Naver-Client-ID", clientID);
        urlConn.setRequestProperty("X-Naver-Client-Secret", clientSecret);

        BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));


        String msg = null;

        while((msg = br.readLine())!=null)
            sb.append(msg);
//
//        JSONParser jsonParser = new JSONParser();
//        JSONObject jsonObj = (JSONObject) jsonParser.parse(sb.toString());
//        JSONArray itemsArray = (JSONArray) jsonObj.get("items");
//
//        System.out.println("=====items=====");
//        for(int i=0 ; i<itemsArray.size() ; i++){
//            JSONObject tempObj = (JSONObject) itemsArray.get(i);
//            System.out.println(""+(i+1)+"번째 멤버의 제목 : "+tempObj.get("title"));
//            System.out.println(""+(i+1)+"번째 멤버의 링크 : "+tempObj.get("link"));
//            System.out.println(""+(i+1)+"번째 멤버의 저자 : "+tempObj.get("author"));
//            System.out.println("----------------------------");
//        }
    }
}