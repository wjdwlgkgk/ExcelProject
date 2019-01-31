package examplepoi;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class MyRowHander implements ResultHandler {
    Sheet sheet;
    int rowNum;
    public MyRowHander(Sheet sheet, int rowNum) {
        this.sheet = sheet;
        this.rowNum = rowNum;

    }

    public void handleRow(Object o) {
        Message vo = (Message) o;
        Row row = sheet.createRow(rowNum);
        Cell cell = row.createCell(0);
        if (vo.message instanceof String) {
            cell.setCellValue((String) vo.message);
        }
        Cell cell1 = row.createCell(1);
        cell.setCellValue((String) vo.jobid);

/*

        for (Object field : datatype) {
            Cell cell = row.createCell(colNum++);
            if (field instanceof String) {
                cell.setCellValue((String) field);
            } else if (field instanceof Integer) {
                cell.setCellValue((Integer) field);
            }
        }
*/

        rowNum  = rowNum +1;
    }


    public void handleResult(ResultContext resultContext) {

    }
}
