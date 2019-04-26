package Report;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.SheetUtil;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

import java.util.HashMap;
import java.util.List;

public class reportUtil {
    public void removeCol(final Sheet st, final int firstRowNum,
                          final int lastRowNum, final int stdColNum) {
        for (int rowNum = firstRowNum; rowNum <= lastRowNum; rowNum++){
            removeCell(st,rowNum,stdColNum);
        }
    }


    public void removeCell(final Sheet st, final int rowNum, final int colNum) {
        Row row = st.getRow(rowNum);
        row.removeCell(row.getCell(colNum));
    }


    public void mergeCell(Sheet st, int firstRowNum, int lastRowNum,
                          int firstColNUm, int lastCol) {
        st.addMergedRegion(new CellRangeAddress(firstRowNum, // 시작 로우
                lastRowNum, // 마지막 로우
                firstColNUm, // 시작 컬럼
                lastCol // 마지막 컬럼
        ));
    }


    public void insertCell(Sheet st, int rowNum, int colNum, String cellV,
                           XSSFCellStyle cs) {
        Cell c = makeCell(st,rowNum,colNum);
        c.setCellValue(cellV);
        c.setCellStyle(cs);
    }


    public void insertCell(Sheet st, int rowNum, int colNum, CellValCs valCs) {
        Cell c = makeCell(st,rowNum,colNum);
        c.setCellValue(valCs.getVal());
        c.setCellStyle(valCs.cs);
    }


    public void insertCellRowCol(Sheet st, int rowNum, int colNum,
                                 List<HashMap> list, String[] keys, XSSFCellStyle cs) {

        int rowTemp = rowNum;
        int colTemp = colNum;

        String str = null;

        for (HashMap map : list){
            for (String key : keys){
                str = String.valueOf(map.get(key));
                insertCell(st,rowTemp,colTemp,str,cs);
                colTemp++;
            }
            rowTemp++;
            colTemp = colNum;
        }
    }


    public void insertCellRow(Sheet st, int rowNum, int colNum, String[] str,
                              XSSFCellStyle cs) {
        for (String val : str){
            insertCell(st,rowNum,colNum,val,cs);
            colNum++;
        }
    }


    public void insertCellCntRow(Sheet st , int rowNum , int colNum , String str , int cnt , XSSFCellStyle cs){
        for(int i=0; i < (cnt+1); i++){
            insertCell(st, rowNum , colNum , str , cs);
            colNum++;
        }
    }


    public void insertCellRow(Sheet st, int rowNum, int colNum, String str,
                              XSSFCellStyle cs) {
        insertCell(st,rowNum,colNum,str,cs);
        colNum++;
    }


    public void insertCellRow(Sheet st, int rowNum, int colNum, CellValCs[] valCs) {
        for (CellValCs val : valCs){
            insertCell(st,rowNum,colNum,val.getVal(),val.getCs());
            colNum++;
        }
    }


    public Cell makeCell(Sheet st, int rowNum, int colNum) {
        Row row = null;
        Cell cell = null;

        if (st.getRow(rowNum) == null){
            row = st.createRow(rowNum);
        }else{
            row = st.getRow(rowNum);
        }

        cell = row.createCell(colNum);
        return cell;
    }


    public void autoMaxSizeColumn(Sheet sheet , int column){
        double contentCellWidth = SheetUtil.getColumnWidth(sheet, column, true);
        contentCellWidth *=256;
        int maxColumnWidth = 255*256; // The maximum column width
        double retWidth = 100;
        if(contentCellWidth < maxColumnWidth){
            retWidth = contentCellWidth;
        }else{
            retWidth = maxColumnWidth;
        }
        sheet.setColumnWidth(column,(int)retWidth);
    }
}
