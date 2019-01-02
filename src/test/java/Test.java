import Excel.CreateExcel;
import Json.JsonTest;
import com.account.Account;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {

    @org.junit.Test
    public void jihaTest(){
        CreateExcel excel = new CreateExcel();
        excel.makeExcelFile();

    }


    @org.junit.Test
    public void specialcharTest(){

        String jsonStr = "{\"members\":["
                + "{\"name\":\"홍길동\","
                + "\"email\":\"gildong@hong.com\","
                + "\"age\":\"25\""
                + "},"
                + "{\"name\":\"홍길서\","
                + "\"email\":\"gilseo@hong.com\","
                + "\"age\":\"23\""
                + "}]}";

        System.out.println(jsonStr);

    }

    @org.junit.Test
    public void jsonTest(){
        JsonTest jt = new JsonTest();
        try {
            jt.dataFromOpenApi();
        }catch (Exception e){ e.printStackTrace();}
    }

}
