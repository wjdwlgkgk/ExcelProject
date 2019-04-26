package Excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class praticeExcel {

    public static void main(String[] args) {

        try {

            Workbook wb = new XSSFWorkbook();
            Sheet sheet = wb.createSheet("My Sample Excel");

            //FileInputStream obtains input bytes from the image file
            String current = new java.io.File( "." ).getCanonicalPath();
            InputStream inputStream = new FileInputStream(current + "/src/main/resources/kisa.png");
            //Get the contents of an InputStream as a byte[].
            byte[] bytes = IOUtils.toByteArray(inputStream);
            //Adds a picture to the workbook
            int pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
            //close the input stream
            inputStream.close();

            //Returns an object that handles instantiating concrete classes
            CreationHelper helper = wb.getCreationHelper();

            //Creates the top-level drawing patriarch.

            Drawing drawing = sheet.createDrawingPatriarch();

            //Create an anchor that is attached to the worksheet
            ClientAnchor anchor = helper.createClientAnchor();
            //set top-left corner for the image
            anchor.setCol1(4);
            anchor.setRow1(49);

            //Creates a picture
            Picture pict = drawing.createPicture(anchor, pictureIdx);
            //Reset the image to the original size
            pict.resize();

            //Write the Excel file
            FileOutputStream fileOut = null;
            fileOut = new FileOutputStream("C:/Users/admin/Documents/LSware/myFile.xlsx");
            wb.write(fileOut);
            fileOut.close();

        }
        catch (Exception e) {
            System.out.println(e);
        }


    }

}
