package Excel;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import java.util.ArrayList;
import java.util.HashMap;

public class MyResultHandler implements ResultHandler{
        static ArrayList<HashMap> maps = new ArrayList<HashMap>();
        static HashMap map = new HashMap();
            @Override
            public void handleResult(ResultContext resultContext) {
                map = (HashMap) resultContext.getResultObject();
                maps.add(map);
            }
    }
