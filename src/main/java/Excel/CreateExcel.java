package Excel;

import JDBC.connectDB;
import com.account.Account;
import com.account.AccountService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateExcel {

    static String FileName = "NewExcel.xls";
    static String FileDir = "C:/Users/admin/Desktop/";
    final static int RowSize = 15;
    final static int CellSize = 15;
    AccountService accountService;
    Row row[];
    Cell cell[][];
    CellStyle style[][];
    Workbook xlsWB;
    Sheet sheet;

    public void makeExcelFile(){
        //생성
        xlsWB = new HSSFWorkbook();
        sheet= xlsWB.createSheet("firstSheet");
        row = new Row[RowSize];
        cell = new Cell[RowSize][CellSize];
        style = new CellStyle[RowSize][CellSize];
        for(int i = 0 ; i< RowSize; i++)
        {
            row[i] = sheet.createRow(i);
            for(int j = 0 ; j< CellSize; j++) {
                cell[i][j] = row[i].createCell(j);
                // 스타일은 셀 생성 이후에 가능한 것입니다.
                style[i][j] = cell[i][j].getCellStyle();
                style[i][j].setWrapText(true);
                cell[i][j].setCellStyle(style[i][j]);

            }
        }

        // 내용 채워넣고 그리는 부분.
        grid();

        //쓴 메소드를 통해 Excel 파일 생성.
        make();
    }

    public void grid() {
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


        connectDB cd = new connectDB();
        cd.init();
        String b[] = cd.getA();
        cell[13][13].setCellValue(b[0]);
        cell[13][14].setCellValue(b[1]);

    }

    public void make() {
        try {
            File xlsFile = new File(FileDir+FileName);
            FileOutputStream fileout = new FileOutputStream(xlsFile);
            xlsWB.write(fileout); //이 부분 필요스.

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
