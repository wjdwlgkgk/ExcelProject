package Excel;

import dto.asObject;
import dto.objectDto;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class executeExcel {
//    static int RowSize = 1000;
//    static int CellSize = 8;
    static String FileName = "NewExcel.xlsx";
    static String FileDir = "C:/Users/admin/Desktop/";
    static String connectionUrl = "jdbc:sqlserver://192.168.152.104:1433;" + "databaseName = SecuMS;";
    static FileOutputStream fileout = null;
    //static String[] title = {"RESULTITEM_SEQ", "jobid", "hw_seq", "map_id", "RESULT_SEQ", "EXCEPTION_YN", "item", "message"};
    static String title[] = {"cve_id", "sumary", "score", "wfn_parts", "wfn_vendor", "wfn_product", "window_10", "window_7", "window_8", "window_8.1", "windows_server_2008", "windows_server_2012", "centos", "ubuntu_linux_18.04", "ubuntu_linux_16.04", "cve_id"};
    static SqlSession session;

    public static  void main(String args[])throws Exception {

        // list를 만들고, row 갯수 , col 갯수 체크하고, 메시지 마다. 열마다. 맵 게체수 확인 후에 들어가는 걸로.

        XSSFWorkbook WB = new XSSFWorkbook();
        XSSFSheet sheet = WB.createSheet("firstSheet");
        ArrayList<XSSFRow> row = new ArrayList<XSSFRow>();
        ArrayList<ArrayList<XSSFCell>> cells = new ArrayList<ArrayList<XSSFCell>>();
        ArrayList<XSSFCell> cell = new ArrayList<XSSFCell>();
        ArrayList<ArrayList<XSSFCellStyle>> style = new ArrayList<ArrayList<XSSFCellStyle>>();
        int rownum = 0;
        int cellnum = 0;

        setDB();

        MyResultHandler myResultHandler = new MyResultHandler();
//        List<HashMap> list = session.select("cve", myResultHandler);
//
//
//        for(int kk=0; kk<myResultHandler.maps.size(); kk++)
//        {
//            row.add(sheet.createRow(kk));
//            for(int i=0; i<title.length; i++)
//                cell.add(i, row.get(rownum).createCell(i));
//            //"RESULTITEM_SEQ", "jobid", "hw_seq", "map_id", "RESULT_SEQ", "EXCEPTION_YN", "item", "message"
//            cell.add(cellnum,row.get(rownum).createCell(cellnum++).setCellValue(hashMap[0].get("").getRESULTITEM_SEQ()));
//            cell.add(cellnum,row.get(rownum).createCell(cellnum++).setCellValue(list.get(rownum).getJobid()));
//            cell.add(cellnum,row.get(rownum).createCell(cellnum++).setCellValue(list.get(rownum).getMap_id()));
//            cell.add(cellnum,row.get(rownum).createCell(cellnum++).setCellValue(list.get(rownum).getRESULT_SEQ()));
//            cell.add(cellnum,row.get(rownum).createCell(cellnum++).setCellValue(list.get(rownum).getEXCEPTION_YN()));
//            cell.add(cellnum,row.get(rownum).createCell(cellnum++).setCellValue(list.get(rownum).getItem()));
//            cell.add(cellnum,row.get(rownum).createCell(cellnum++).setCellValue(list.get(rownum).getMessage()));
//
//
//            cells.add(cell);
//
//
//
//            cell.get(0).setCellValue(hashMap[0].get(""));
//            cell.get(1).setCellValue(list.get(rownum).getJobid());
//            cell.get(2).setCellValue(list.get(rownum).getHw_seq());
//            cell.get(3).setCellValue(list.get(rownum).getMap_id());
//            cell.get(4).setCellValue(list.get(rownum).getRESULT_SEQ());
//            cell.get(5).setCellValue(list.get(rownum).getEXCEPTION_YN());
//            cell.get(6).setCellValue(list.get(rownum).getItem());
//            cell.get(7).setCellValue(list.get(rownum).getMessage());
//            rownum++;
//        }

        try {
            File xlsFile = new File(FileDir + FileName);
            fileout = new FileOutputStream(xlsFile);
            WB.write(fileout); //이 부분 필요스.
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileout.flush();
                fileout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void setDB() throws IOException {
        Reader reader = Resources.getResourceAsReader("sqlconfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        session = sqlSessionFactory.openSession();
    }
}
