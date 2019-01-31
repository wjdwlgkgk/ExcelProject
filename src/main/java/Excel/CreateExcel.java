package Excel;

import JDBC.connectDB;
import Json.JsonTest;
import com.account.Account;
import com.account.AccountService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CreateExcel {

    static String FileName = "NewExcel.xlsx";
    static String FileDir = "C:/Users/admin/Desktop/";
    static String title[] = {"cve_id", "sumary", "score", "wfn_parts", "wfn_vendor", "wfn_product", "window_10", "window_7", "window_8", "window_8.1", "windows_server_2008", "windows_server_2012", "centos", "ubuntu_linux_18.04", "ubuntu_linux_16.04", "cve_id"};
    final static int RowSize = 1000;
    final static int CellSize = title.length;
    AccountService accountService;
    XSSFRow row[];
    XSSFCell cell[][];
    XSSFCellStyle style[][];
    XSSFWorkbook WB;
    XSSFSheet sheet;

    public void makeExcelFile(){
        //생성
        WB = new XSSFWorkbook();
        sheet= WB.createSheet("firstSheet");
        row = new XSSFRow[RowSize];
        cell = new XSSFCell[RowSize][CellSize];
        style = new XSSFCellStyle[RowSize][CellSize];
        for(int i = 0 ; i< RowSize; i++)
        {
            row[i] = sheet.createRow(i);
            for(int j = 0 ; j< CellSize; j++) {
                cell[i][j] = row[i].createCell(j);
                // 스타일은 셀 생성 이후에 가능한 것입니다.
//                style[i][j] = cell[i][j].getCellStyle();
//                style[i][j].setWrapText(true);
//                cell[i][j].setCellStyle(style[i][j]);
                // 셀 크기 알맞게 수정해야함. 자동으로 맞춰주는 것은 한계가 있음. 높이 넓이를 둘다 맞추는 것이 아님.
                sheet.setColumnWidth(i*15 + j,(sheet.getColumnWidth(i*15+j)+(short)1024 * 5));

            }
        }

        // 내용 채워넣고 그리는 부분.
        DBGrid();
        //bookinfogrid();s
        //Accountgrid();


        //쓴 메소드를 통해 Excel 파일 생성.
        make();
    }

    public void DBGrid(){
        //JDBC를 활용한 localhostDB 데이터 추출 후 Excel 출력.
        connectDB cd = new connectDB();
        cd.init();
        String b[][] = cd.getA();


        for(int j=0; j<CellSize; j++) {
            cell[0][j].setCellValue(title[j]);
        }

        for(int i = 0; i<RowSize; i++)
        {
            for(int j=0; j<CellSize; j++) {
                cell[1+i][j].setCellValue(b[i][j]);
            }
        }

    }

    public void bookinfogrid(){
        JsonTest jt = new JsonTest();
        try {
            jt.dataFromOpenApi();
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObj = (JSONObject) jsonParser.parse(jt.sb.toString());
            JSONArray itemsArray = (JSONArray) jsonObj.get("items");
            for(int i=0; i<itemsArray.size(); i++)
            {
                JSONObject tempObj = (JSONObject) itemsArray.get(i);
                Set<String> s = tempObj.keySet();
                Iterator<String> it = s.iterator();

                int n = 0;
                while(it.hasNext()){
                    cell[i][n].setCellValue(tempObj.get(it.next()).toString());
                    n++;
                }


//                for(int j=0; j<tempObj.size(); j++){
//                    cell[i][j].setCellValue(tempObj.get(it.hasNext()).toString());
//                }

            }
        } catch (ParseException e) {}catch (Exception e){}




    }

    public void Accountgrid() {
        useCommand();
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,4));
        sheet.addMergedRegion(new CellRangeAddress(0,0,5,6));
        sheet.addMergedRegion(new CellRangeAddress(0,0,7,8));
        cell[0][5].setCellValue(accountService.findAccount("A").getId());
        cell[0][7].setCellValue(accountService.findAccount("B").getId());


        // 간단한 메뉴에요.
        String[] menu ={"from","to", "How Many", "Fuc", "Date", "현재 금액", "기능 후 금액", "현재 금액", "기능 후 금액"};
        for(int i =0; i<menu.length; i++)
        {
            cell[1][i].setCellValue(menu[i]);
        }


        int aindex = 0, bindex = 0;
        for(int i =0; i<accountService.logIndex; i++)
        {
            String[] content = accountService.log[i].split(" ");
            for(int j=0; j<5; j++)
            {
                cell[2+i][j].setCellValue(content[j]);
            }

            if(content[1].equals("-"))
            {
                if(content[0].equals("A"))
                {
                    aindex++;
                    cell[2 + i][5].setCellValue(accountService.findAccount("A").logBalance.get(aindex-1));
                    cell[2 + i][6].setCellValue(accountService.findAccount("A").logBalance.get(aindex));
                    cell[2 + i][7].setCellValue(accountService.findAccount("B").logBalance.get(bindex));
                    cell[2 + i][8].setCellValue(accountService.findAccount("B").logBalance.get(bindex));
                }
                else if(content[0].equals("B")) {
                    bindex++;
                    cell[2 + i][5].setCellValue(accountService.findAccount("A").logBalance.get(aindex));
                    cell[2 + i][6].setCellValue(accountService.findAccount("A").logBalance.get(aindex));
                    cell[2 + i][7].setCellValue(accountService.findAccount("B").logBalance.get(bindex-1));
                    cell[2 + i][8].setCellValue(accountService.findAccount("B").logBalance.get(bindex));
                }
            }
            else
            {
                aindex++;
                bindex++;
                cell[2 + i][5].setCellValue(accountService.findAccount("A").logBalance.get(aindex-1));
                cell[2 + i][6].setCellValue(accountService.findAccount("A").logBalance.get(aindex));
                cell[2 + i][7].setCellValue(accountService.findAccount("B").logBalance.get(bindex-1));
                cell[2 + i][8].setCellValue(accountService.findAccount("B").logBalance.get(bindex));
            }
        }
        sheet.addMergedRegion(new CellRangeAddress(2+ accountService.logIndex,2+ accountService.logIndex,0,4));
        cell[2 + accountService.logIndex][0].setCellValue("잔액(현재 : " + "12.27" + ")");
        sheet.addMergedRegion(new CellRangeAddress(2+ accountService.logIndex,2+ accountService.logIndex,5,6));
        cell[2 + accountService.logIndex][5].setCellValue(accountService.findAccount("A").getBalance());
        sheet.addMergedRegion(new CellRangeAddress(2+ accountService.logIndex,2+ accountService.logIndex,7,8));
        cell[2 + accountService.logIndex][7].setCellValue(accountService.findAccount("B").getBalance());
    }

    public void make() {
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

    public void useCommand(){
        accountService = new AccountService();
        Account a = new Account("A",5000);
        Account b = new Account("B",3000);
        accountService.addAccount(a);
        accountService.addAccount(b);

        accountService.transfer(a,b,1500);
        accountService.debit(a,3000);
        accountService.credit(b,10000);
        accountService.transfer(b,a,5000);
        accountService.credit(b,10000);
        accountService.credit(a,5000);
        accountService.transfer(a,b,3000);
    }
}
