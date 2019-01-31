import Excel.CreateExcel;
import Json.JsonTest;
import Thread.ThreadInterrupt;
import com.account.Account;
import dto.Enum;
import logger.Foo;
import logger.Foo1;
import testbed.openapi;

import java.util.*;

public class Test {

    @org.junit.Test
    public void jihaTest(){
        CreateExcel excel = new CreateExcel();
        excel.makeExcelFile();

    }


    @org.junit.Test
    public void specialcharTest(){

       String[] a = new String[500000];
       for(int i = 0 ; i < a.length; i++)
           a[i] = "a";
        for(int i = 0 ; i < a.length; i++)
            System.out.println(a[i]);

    }

    @org.junit.Test
    public void jsonTest(){
        JsonTest jt = new JsonTest();
        try {
            jt.dataFromOpenApi();
        }catch (Exception e){ e.printStackTrace();}
    }


    @org.junit.Test
    public void Thread5Test(){
        ThreadInterrupt th = new ThreadInterrupt("뉴 스레드");
        th.start();

        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){}
        th.interrupt();
    }


    @org.junit.Test
    public void openapiTest(){
        openapi op = new openapi();
        try {
            op.init();
        }catch (Exception e ) { e.printStackTrace();}


    }


    @org.junit.Test
    public void asldkfn(){
        System.out.println(Enum.jiha + "" + Enum.fight + "" + Enum.people);
        System.out.println("1234");
    }

    @org.junit.Test
    public void alksdnvlaks(){
        HashMap<String, Integer> map = new HashMap();

        map.put("asdf", 1234);
        map.put("a", 12345);
        map.put("b", 12346);
        map.put("c", 12347);
        map.put("d", 12348);

        Set set = map.keySet();
        Iterator iterator = set.iterator();
        ArrayList<String> keys = new ArrayList<String>();
        String[] key1;

        while(iterator.hasNext())
            keys.add((String)iterator.next());

        key1 = (String[])keys.toArray(new String[keys.size()]);
        System.out.println(1234);

    }


    @org.junit.Test
    public void 테스트(){
        Foo1.test();
        Foo.test();
    }


}

