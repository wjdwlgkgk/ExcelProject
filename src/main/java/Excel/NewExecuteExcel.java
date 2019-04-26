package Excel;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder;
import org.omg.CORBA.WrongTransactionHolder;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetView;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSheetViewType;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class NewExecuteExcel {
    static String FileName = "NewExcel.xlsx";
    static String FileDir = "C:/Users/admin/Desktop/";
    static FileOutputStream fileout = null;
    static String title[] = {"cve_id", "sumary", "score", "wfn_parts", "wfn_vendor", "wfn_product", "window_10", "window_7", "window_8", "window_8.1", "windows_server_2008", "windows_server_2012", "centos", "ubuntu_linux_18.04", "ubuntu_linux_16.04", "ubuntu_linux_14.04", "apache_http_server", "microsoft_sql_server", "mysql_mysql", "oracle_mysql", "apache_tomcat", "redislabs_redis", "cve_id"};

    public static XSSFColor BlueColor = new XSSFColor(new java.awt.Color(1, 122, 203));
    public static XSSFColor YellowColor = new XSSFColor(new java.awt.Color(253, 242, 99));
    public static XSSFColor WhiteColor = new XSSFColor(new java.awt.Color(255,255,255));
    public static XSSFColor BlackColor = new XSSFColor(new java.awt.Color(0,0,0));

    public static  void main(String args[])throws Exception {

        XSSFWorkbook WB = new XSSFWorkbook();
        XSSFSheet sheet = WB.createSheet("firstSheet");
        CTSheetView view = sheet.getCTWorksheet().getSheetViews().getSheetViewArray(0);
        view.setView(STSheetViewType.PAGE_BREAK_PREVIEW);

        Row row = sheet.createRow(2);


        XSSFCellStyle style = WB.createCellStyle();


        style.setFillBackgroundColor(YellowColor);
        style.setFillForegroundColor(BlueColor);
//        style.setFillPattern(XSSFCellStyle.ALT_BARS); //점 패턴

        style.setBorderBottom(XSSFCellStyle.BORDER_THIN); //길 짧 선
        style.setBorderTop(XSSFCellStyle.BORDER_DASHED); // 두꺼운 점선
        style.setBorderRight(XSSFCellStyle.BORDER_HAIR); //가는 점선
        style.setBorderLeft(XSSFCellStyle.BORDER_NONE); // 없음

        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setAlignment(HorizontalAlignment.LEFT);


        style.setBorderColor(XSSFCellBorder.BorderSide.BOTTOM, WhiteColor);
        style.setBorderColor(XSSFCellBorder.BorderSide.TOP, BlueColor);
        style.setBorderColor(XSSFCellBorder.BorderSide.RIGHT, BlueColor);
        style.setBorderColor(XSSFCellBorder.BorderSide.LEFT, WhiteColor);



        XSSFFont font = (XSSFFont)WB.createFont();
        font.setFontName("Courier New");
        font.setBoldweight((short)12);
        font.setItalic(true);
        font.setStrikeout(true);
        font.setColor(BlackColor);



        style.setFont(font);
        style.setWrapText(true);


        Cell cell = row.createCell(2);
//        cell.setCellStyle(style);
        cell.setCellValue("안녕나는-12345687-asdfasdk야호!");


        for(int i=0; i<10; i++)
        {
            row = sheet.createRow(i);
            cell = row.createCell(0);
            cell.setCellValue((int)i);
            cell.setCellStyle(style);
        }
        //"RESULTITEM_SEQ", "jobid", "hw_seq", "map_id", "RESULT_SEQ", "EXCEPTION_YN", "item", "message"


        sheet.setSelected(true);

        sheet = WB.createSheet("firstSheet");



        try {
            File xlsFile = new File(FileDir+FileName);
            FileOutputStream fileout = new FileOutputStream(xlsFile);
            WB.write(fileout); //이 부분 필요스.
            fileout.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
