package Report;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;

public class CellValCs {
    String val;
    XSSFCellStyle cs;

    CellValCs(String val, XSSFCellStyle cs) {
        this.val = val;
        this.cs = cs;
    }

    public String getVal() {
        return val;
    }


    public XSSFCellStyle getCs() {
        return cs;
    }
}
