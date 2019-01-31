package examplepoi;

import org.apache.ibatis.session.SqlSession;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.sql.SQLException;

public class ProtoRowHander {

    private SqlSession session;

    String statementName;
    Message msg;
    public ProtoRowHander(SqlSession session, String statementName , Message msg) {
        this.session = session;
        this.statementName = statementName;
        this.msg = msg;
    }

    public void HanderExecute(final XSSFSheet sheet, int rowNum) throws SQLException {
        MyRowHander myRowHan = new MyRowHander(sheet,rowNum);
    }
}
