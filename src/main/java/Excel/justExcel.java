package Excel;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class justExcel {
    static String FileName = "CCE1.xlsx";
    static String FileDir = "C:/Users/admin/Desktop/";
    static FileOutputStream fileout = null;
    //static String title[] = {"cve_id", "sumary", "score", "wfn_parts", "wfn_vendor", "wfn_product", "window_10", "window_7", "window_8", "window_8.1", "windows_server_2008", "windows_server_2012", "centos", "ubuntu_linux_18.04", "ubuntu_linux_16.04", "ubuntu_linux_14.04", "apache_http_server", "microsoft_sql_server", "mysql_mysql", "oracle_mysql", "apache_tomcat", "redislabs_redis", "cve_id"};
//    static String title[] = {"oval_id"};
//    static String title[] = {"work_seq", "chk_grp_seq", "stat", "start_dt", "end_dt", "chk_meth", "chker_ip"};
//    static String title[] = {"rslt_seq", "eval_asset_seq","work_seq","asset_seq","pol_cate_seq", "pol_item_seq","rslt_type"};
//    static String title[] = {"cve_id", "score"};
//    static String title[] = {"cve_id"};
    static SqlSession session;
    static XSSFWorkbook WB;
    static XSSFSheet sheet;
    public static XSSFColor tableHeaderBlueColor = new XSSFColor(new java.awt.Color(1, 122, 203));

    public static  void main(String args[])throws Exception {

        String title[] = {"rslt_oval_seq", "work_seq", "oval_id", "oval_id_version", "cve_id", "rslt_type", "asset_seq"};
        WB = new XSSFWorkbook();
        sheet = WB.createSheet("firstSheet");



        setDB();


        // ------------------------------------------------------------------ 작업처리-----------------------------------

//        Row row = sheet.createRow(0);
//        Cell cell = row.createCell(3,10);
//        CellStyle style = WB.createCellStyle();
//        style.setFillBackgroundColor(tableHeaderBlueColor);
//        cell.setCellStyle(style);


        MyResultHandler myResultHandler = new MyResultHandler();
        session.select("rslt", myResultHandler);




        for(int kk=0; kk<myResultHandler.maps.size(); kk++)
        {
            Row row = sheet.createRow(kk);

            //"cve_id", "sumary", "score", "wfn_parts", "wfn_vendor", "wfn_product", "window_10", "window_7", "window_8", "window_8.1", "windows_server_2008", "windows_server_2012", "centos", "ubuntu_linux_18.04", "ubuntu_linux_16.04", "ubuntu_linux_14.04", "apache_http_server", "microsoft_sql_server", "mysql_mysql", "oracle_mysql", "apache_tomcat", "redislabs_redis", "cve_id"
            for(int i=0; i<title.length; i++) {
                Cell cell = row.createCell(i);

                if(myResultHandler.maps.get(kk).get(title[i]) == null)
                {
                    cell.setCellValue("NULL");
                }
                else if(myResultHandler.maps.get(kk).get(title[i]).toString().length()>=32767) {
                    cell.setCellValue(myResultHandler.maps.get(kk).get(title[i]).toString().substring(0,32766));
                }
                else
                    cell.setCellValue(myResultHandler.maps.get(kk).get(title[i]).toString());
            }
        }

        // ------------------------------------------------------------------ 작업처리-----------------------------------

        make();
    }

    private static void make() throws IOException {
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

    private static void setDB() throws IOException {
        Reader reader = Resources.getResourceAsReader("sqlconfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        session = sqlSessionFactory.openSession();
    }
}
