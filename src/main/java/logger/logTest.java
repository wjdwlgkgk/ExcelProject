package logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class logTest {

    private static Logger logger = LoggerFactory.getLogger(logTest.class);


    public static void main(String args[]){


//        Scanner sc = new Scanner(System.in);
//        int a;
//
//
//        a = sc.nextInt();



        logger.info("스캐너 이상 무");


        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");






    }
}
