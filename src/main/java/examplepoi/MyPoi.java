package examplepoi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

public class MyPoi {

    private String FILE_NAME = "Result.xlsx"; // 기본 명령어.
    private String FILE_PATH = "\\";
    private String FILE_FULL_PATH = "";


    public void execute(String fileName, String filePath, ProtoRowHander rowHander) throws SQLException {

        init(fileName, filePath); //폴더 생성.
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Datatypes in Java");
        //처리 작업.
        int rowNum = 0;
        rowHander.HanderExecute(sheet , rowNum);

        //작업 후, 파일 생성.
        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_FULL_PATH);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }

    public void execute(String fileName, String filePath, Object[][] contents) {
        init(fileName, filePath);
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Datatypes in Java");
        write(sheet, contents);
        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_FULL_PATH);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }


    private void init(String fileName, String filePath) {
        this.FILE_NAME = fileName;
        this.FILE_PATH = filePath;
        this.FILE_FULL_PATH = FILE_PATH + "\\" + FILE_NAME;
        makeDir(FILE_PATH);
    }

    public void execute(FileOutputStream outputStream, Object[][] contents){

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Datatypes in Java");
        write(sheet, contents);
        try {
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
        System.out.println("Done");
    }


    private void write(XSSFSheet sheet, Object[][] datatypes) {
        int rowNum = 0;
        for (Object[] datatype : datatypes) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : datatype) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }
    }

    public void makeDir(String dirPath){
        File f = new File(dirPath);
        f.mkdir();
    }
}
