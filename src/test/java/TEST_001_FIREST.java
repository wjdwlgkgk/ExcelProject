import com.sun.org.glassfish.gmbal.Description;
import examplepoi.Message;
import examplepoi.MyPoi;
import examplepoi.ProtoRowHander;
import examplepoi.ReportDao;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class TEST_001_FIREST {


    private static SqlSession session;


    @Before
    public static void setup() throws IOException {
        ReportDao dao = new ReportDao();
        session = dao.getSession();
    }

//    @Test
//    @Description("T_001 jdbc 연결 설정 확인")
//    public void T_001_Hello(){
//        Assertions.assertNotNull(session);
//    }
//
//    @Test
//    @Description("T_002 기본 select 조회 확인")
//    public void T_002_list(){
//        List list = session.selectList("select");
//        Assertions.assertNotEquals(0,list.size());
//    }

    @Test
    public void T003_sample_파일명_경로입력(){
        String fileName = "T003_sample_파일명_경로입력.xlsx";
        String rootPath = System.getProperty("user.dir");
        String filePath = rootPath+"\\result";
        MyPoi sm = new MyPoi();
        sm.execute(fileName,filePath,getContents());
    }

    @Test
    public void T006_대용량() throws SQLException, IOException {

        String fileName = "T005_sample_대용량.xlsx";
        String filePath = "D:\\ws\\templ\\poi\\result";

        MyPoi sm = new MyPoi();
        Message em = new Message();
        ProtoRowHander prh = new ProtoRowHander(session,"Employee.result", em);
        sm.execute(fileName,filePath, prh);


    }

    public Object[][] getContents() {
        Object[][] contents = {
                {"ㅁㅁㅁㅁㅁ", "Type", "Size(in bytes)"},
                {"int", "Primitive", 2},
                {"float", "Primitive", 4},
                {"double", "Primitive", 8},
                {"char", "Primitive", 1},
                {"String", "Non-Primitive", "No fixed size"}
        };
        return contents;
    }

}
