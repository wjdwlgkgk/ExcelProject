package logger;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Foo1 {


    public static String a = "난나나나솨~";
    public static String name = "정지하";

    public static void test(){
        log.debug("ID : {} " + name  , a );
        log.info("난 말이죠 . *** 입니다."+ name );

    }



}
