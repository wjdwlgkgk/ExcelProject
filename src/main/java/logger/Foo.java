package logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Foo {

        static final Logger logger = LoggerFactory.getLogger(Foo.class);


        public static void test(){
            logger.debug("ID : {}" , "foo");
        }



}
