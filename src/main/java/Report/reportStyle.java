package Report;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder;

import java.util.HashMap;
import java.util.Map;

public class reportStyle {
    protected final String FONT_NAME = "맑은 고딕";
    protected String DEFAULT_CS = "DEFAULT_CS";
    protected String DEFAULT_CENTER_CS = "DEFAULT_CENTER_CS";
    protected String DEFAULT_LEFT_CS = "DEFAULT_LEFT_CS";
    protected String DEFAULT_RED_CS = "DEFAULT_RED_CS";
    protected String DEFAULT_TABLE_HEADER_CS = "DEFAULT_TABLE_HEADER_CS";
    protected String DEFAULT_TABLE_HEADER_LEFT_CS = "DEFAULT_TABLE_HEADER_LEFT_CS";
    protected String DEFAULT_TITLE_CS = "DEFAULT_TITLE_CS";
    protected String DEFAULT_JACKET_TITLE_CS = "DEFAULT_JACKET_TITLE_CS";
    protected String DEFAULT_TABLE_HEADER_LIGHT_BLUE_CS = "DEFAULT_TABLE_HEADER_LIGHT_BLUE_CS";

    protected Map<String, XSSFCellStyle> createDefaultStyles(SXSSFWorkbook wb) {


        Map<String, XSSFCellStyle> styles = new HashMap<String, XSSFCellStyle>();

        XSSFFont title_font = (XSSFFont) createTitleFont(wb);
        XSSFFont default_font = (XSSFFont) createDefaultFont(wb);

        //기본 스타일
        XSSFCellStyle defaultCS = createDefaultStyle(wb);
        styles.put(DEFAULT_CS, defaultCS);

        //기본 좌우-(센터정렬)
        XSSFCellStyle defaultCenterCS = createDefaultCenterStyle(wb);
        styles.put(DEFAULT_CENTER_CS, defaultCenterCS);

        //기본 좌우-(좌측정렬)
        XSSFCellStyle defaultLeftCS = createDefaultLeftStyle(wb);
        styles.put(DEFAULT_LEFT_CS, defaultLeftCS);

        //기본 좌우-(센터정렬, 붉은 폰트)
        XSSFCellStyle defaultRedCS = createDefaultRedStyle(wb);
        styles.put(DEFAULT_RED_CS, defaultRedCS);

        //표 기본 헤더
        XSSFCellStyle tableHeaderCS = createTableHeaderStyle(wb);
        styles.put(DEFAULT_TABLE_HEADER_CS, tableHeaderCS);

        //표 기본 헤더 왼쪽 정렬
        XSSFCellStyle tableHeaderLeftCs = createTableHeaderLeftStyle(wb);
        styles.put(DEFAULT_TABLE_HEADER_LEFT_CS, tableHeaderLeftCs);

        //제목
        XSSFCellStyle titleCS = createTitleStyle(wb);
        styles.put(DEFAULT_TITLE_CS, titleCS);

        XSSFCellStyle jacketTitleCS = createJackTitleStyle(wb);
        styles.put(DEFAULT_JACKET_TITLE_CS, jacketTitleCS);

        XSSFCellStyle headerTitlLightBlugCS = createTableHeaderLightBlueStyle(wb);
        styles.put(DEFAULT_TABLE_HEADER_LIGHT_BLUE_CS, headerTitlLightBlugCS);

        return styles;
    }

    protected Map<String, XSSFCellStyle> createStyles(SXSSFWorkbook wb) {


        Map<String, XSSFCellStyle> styles = new HashMap<String, XSSFCellStyle>();


        XSSFFont title_font = (XSSFFont) createTitleFont(wb);
        XSSFFont default_font = (XSSFFont) createDefaultFont(wb);

//기본 스타일
        XSSFCellStyle decs = createDefaultStyle(wb);

        decs.setVerticalAlignment(VerticalAlignment.CENTER);
        decs.setAlignment(HorizontalAlignment.LEFT);
        decs.setFont(default_font);
        decs.setWrapText(true);

        styles.put("decs", decs);

//기본 좌우-(센터정렬)
        XSSFCellStyle decsC = (XSSFCellStyle) wb.createCellStyle();
        decsC.setFillForegroundColor(new XSSFColor(new java.awt.Color(255, 255, 255)));
        decsC.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);


        decsC.setBorderBottom(BorderStyle.THIN);
        decsC.setBorderTop(BorderStyle.THIN);
        decsC.setBorderRight(BorderStyle.THIN);
        decsC.setBorderLeft(BorderStyle.THIN);

        decsC.setVerticalAlignment(VerticalAlignment.CENTER);
        decsC.setAlignment(HorizontalAlignment.CENTER);
        decsC.setFont(default_font);
        decsC.setWrapText(true);

        styles.put("decsC", decsC);

//표 기본 헤더
        XSSFCellStyle deHcs = (XSSFCellStyle) wb.createCellStyle();
        deHcs.setFillForegroundColor(new XSSFColor(new java.awt.Color(192, 192, 192)));
        deHcs.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);


        deHcs.setBorderBottom(BorderStyle.THIN);
        deHcs.setBorderTop(BorderStyle.THIN);
        deHcs.setBorderRight(BorderStyle.THIN);
        deHcs.setBorderLeft(BorderStyle.THIN);

        deHcs.setVerticalAlignment(VerticalAlignment.CENTER);
        deHcs.setAlignment(HorizontalAlignment.CENTER);
        deHcs.setFont(default_font);
        deHcs.setWrapText(true);


        styles.put("deHcs", deHcs);


//표 기본 헤더 F 등급
        XSSFCellStyle fHcs = (XSSFCellStyle) wb.createCellStyle();
        fHcs.setFillForegroundColor(new XSSFColor(new java.awt.Color(204, 153, 255))); //보라색
        fHcs.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);


        fHcs.setBorderBottom(BorderStyle.THIN);
        fHcs.setBorderTop(BorderStyle.THIN);
        fHcs.setBorderRight(BorderStyle.THIN);
        fHcs.setBorderLeft(BorderStyle.THIN);

        fHcs.setVerticalAlignment(VerticalAlignment.CENTER);
        fHcs.setAlignment(HorizontalAlignment.CENTER);
        fHcs.setFont(default_font);
        fHcs.setWrapText(true);

        styles.put("fHcs", fHcs);

//기본 인포성
        XSSFCellStyle eics = (XSSFCellStyle) wb.createCellStyle();
        eics.setFillForegroundColor(new XSSFColor(new java.awt.Color(197, 249, 7)));  //연두색
        eics.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);

        eics.setBorderBottom(BorderStyle.THIN);
        eics.setBorderTop(BorderStyle.THIN);
        eics.setBorderRight(BorderStyle.THIN);
        eics.setBorderLeft(BorderStyle.THIN);

        eics.setVerticalAlignment(VerticalAlignment.CENTER);
        eics.setAlignment(HorizontalAlignment.CENTER);
        eics.setFont(default_font);
        eics.setWrapText(true);


        styles.put("eics", eics);

//제목
        XSSFCellStyle titleCs = (XSSFCellStyle) wb.createCellStyle();
        titleCs.setFillForegroundColor(new XSSFColor(new java.awt.Color(255, 255, 255)));
        titleCs.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);


        titleCs.setBorderBottom(BorderStyle.THIN);
        titleCs.setBorderTop(BorderStyle.THIN);
        titleCs.setBorderRight(BorderStyle.THIN);
        titleCs.setBorderLeft(BorderStyle.THIN);

        titleCs.setVerticalAlignment(VerticalAlignment.CENTER);
        titleCs.setAlignment(HorizontalAlignment.CENTER);
        titleCs.setFont(title_font);
        titleCs.setWrapText(true);

        styles.put("titleCs", titleCs);
///////////////////style ///////////////////////
        return styles;
    }

    protected Font createTitleFont(SXSSFWorkbook wb) {
        XSSFFont font = (XSSFFont) wb.createFont();
        font.setFontName(FONT_NAME);
        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(new XSSFColor(new java.awt.Color(0, 0, 0)));
        font.setFontHeightInPoints((short) 15);
        font.setBold(true);
        return font;
    }

    protected Font createDefaultFont(SXSSFWorkbook wb) {
        XSSFFont font = (XSSFFont) wb.createFont();
        font.setFontName(FONT_NAME);
        font.setBoldweight(XSSFFont.BOLDWEIGHT_NORMAL);
        font.setColor(new XSSFColor(new java.awt.Color(0, 0, 0)));
        font.setFontHeightInPoints((short) 10);
        font.setBold(true);
        return font;
    }

    protected Font createDefaultRedFont(SXSSFWorkbook wb) {
        XSSFFont font = (XSSFFont) wb.createFont();
        font.setFontName(FONT_NAME);
        font.setBoldweight(XSSFFont.BOLDWEIGHT_NORMAL);
        font.setColor(new XSSFColor(new java.awt.Color(255, 0, 0)));
        font.setFontHeightInPoints((short) 10);
        font.setBold(true);
        return font;
    }

    protected Font createSize8Font(SXSSFWorkbook wb) {
        XSSFFont font = (XSSFFont) wb.createFont();
        font.setFontName(FONT_NAME);
        font.setBoldweight(XSSFFont.BOLDWEIGHT_NORMAL);
        font.setColor(new XSSFColor(new java.awt.Color(255, 255, 255)));
        font.setFontHeightInPoints((short) 8);
        return font;
    }

    protected Font createWhiteFont(SXSSFWorkbook wb) {
        XSSFFont font = (XSSFFont) wb.createFont();
        font.setFontName(FONT_NAME);
        font.setBoldweight(XSSFFont.BOLDWEIGHT_NORMAL);
        font.setColor(new XSSFColor(new java.awt.Color(255, 255, 255)));
        font.setFontHeightInPoints((short) 10);
        font.setBold(true);
        return font;
    }

    protected Font createDefaultBoldFont(SXSSFWorkbook wb) {
        XSSFFont font = (XSSFFont) wb.createFont();
        font.setFontName(FONT_NAME);
        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(new XSSFColor(new java.awt.Color(0, 0, 0)));
        font.setFontHeightInPoints((short) 10);
        font.setBold(true);
        return font;
    }

    protected Font createDefaultWhiteBoldFont(SXSSFWorkbook wb) {
        XSSFFont font = (XSSFFont) wb.createFont();
        font.setFontName(FONT_NAME);
        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(new XSSFColor(new java.awt.Color(0, 0, 0)));
        font.setFontHeightInPoints((short) 10);
        return font;
    }

    protected Font createJacket16BoldFont(SXSSFWorkbook wb) {
        XSSFFont font = (XSSFFont) wb.createFont();
        font.setFontName(FONT_NAME);
        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(new XSSFColor(new java.awt.Color(255, 255, 255)));
        font.setFontHeightInPoints((short) 16);
        return font;
    }

    protected Font createJacket26BoldFont(SXSSFWorkbook wb) {
        XSSFFont font = (XSSFFont) wb.createFont();
        font.setFontName(FONT_NAME);
        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(new XSSFColor(new java.awt.Color(255, 255, 255)));
        font.setFontHeightInPoints((short) 26);
        return font;
    }

    protected Font create20BoldFont(SXSSFWorkbook wb) {
        XSSFFont font = (XSSFFont) wb.createFont();
        font.setFontName(FONT_NAME);
        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(new XSSFColor(new java.awt.Color(255, 255, 255)));
        font.setFontHeightInPoints((short) 20);
        return font;
    }

    protected void setAllBoarderColorGrey(XSSFCellStyle cs) {

        cs.setBottomBorderColor(new XSSFColor(new java.awt.Color(84, 84, 84)));
        cs.setTopBorderColor(new XSSFColor(new java.awt.Color(84, 84, 84)));
        cs.setRightBorderColor(new XSSFColor(new java.awt.Color(84, 84, 84)));
        cs.setLeftBorderColor(new XSSFColor(new java.awt.Color(84, 84, 84)));

    }

    protected XSSFCellStyle createDisposalStyle(SXSSFWorkbook wb) {
        XSSFCellStyle cs = (XSSFCellStyle) wb.createCellStyle();
        cs.setFillForegroundColor(new XSSFColor(new java.awt.Color(255, 255, 255)));
        cs.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        cs.setBorderBottom(BorderStyle.THIN);
        cs.setBorderTop(BorderStyle.THIN);
        cs.setBorderRight(BorderStyle.THIN);
        cs.setBorderLeft(BorderStyle.THIN);

        cs.setBorderColor(XSSFCellBorder.BorderSide.BOTTOM, new XSSFColor(new java.awt.Color(51, 51, 51)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.TOP, new XSSFColor(new java.awt.Color(51, 51, 51)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.RIGHT, new XSSFColor(new java.awt.Color(51, 51, 51)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.LEFT, new XSSFColor(new java.awt.Color(51, 51, 51)));

        cs.setVerticalAlignment(VerticalAlignment.TOP);
        cs.setAlignment(HorizontalAlignment.LEFT);
        cs.setFont(createDefaultFont(wb));
        cs.setWrapText(true);
        return cs;
    }

    protected XSSFCellStyle createDefaultStyle(SXSSFWorkbook wb) {
        XSSFCellStyle cs = (XSSFCellStyle) wb.createCellStyle();
        cs.setFillForegroundColor(new XSSFColor(new java.awt.Color(255, 255, 255)));
        cs.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        cs.setBorderBottom(BorderStyle.THIN);
        cs.setBorderTop(BorderStyle.THIN);
        cs.setBorderRight(BorderStyle.THIN);
        cs.setBorderLeft(BorderStyle.THIN);

        cs.setBorderColor(XSSFCellBorder.BorderSide.BOTTOM, new XSSFColor(new java.awt.Color(51, 51, 51)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.TOP, new XSSFColor(new java.awt.Color(51, 51, 51)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.RIGHT, new XSSFColor(new java.awt.Color(51, 51, 51)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.LEFT, new XSSFColor(new java.awt.Color(51, 51, 51)));

        cs.setVerticalAlignment(VerticalAlignment.CENTER);
        cs.setAlignment(HorizontalAlignment.LEFT);
        cs.setFont(createDefaultFont(wb));
        cs.setWrapText(true);
        return cs;
    }

    protected XSSFCellStyle createDefaultSize8FontStyle(SXSSFWorkbook wb) {
        XSSFCellStyle cs = (XSSFCellStyle) wb.createCellStyle();
        cs.setFillForegroundColor(new XSSFColor(new java.awt.Color(255, 255, 255)));
        cs.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        cs.setBorderBottom(BorderStyle.THIN);
        cs.setBorderTop(BorderStyle.THIN);
        cs.setBorderRight(BorderStyle.THIN);
        cs.setBorderLeft(BorderStyle.THIN);

        cs.setBorderColor(XSSFCellBorder.BorderSide.BOTTOM, new XSSFColor(new java.awt.Color(51, 51, 51)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.TOP, new XSSFColor(new java.awt.Color(51, 51, 51)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.RIGHT, new XSSFColor(new java.awt.Color(51, 51, 51)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.LEFT, new XSSFColor(new java.awt.Color(51, 51, 51)));

        cs.setVerticalAlignment(VerticalAlignment.CENTER);
        cs.setAlignment(HorizontalAlignment.LEFT);
        cs.setFont(createSize8Font(wb));
        cs.setWrapText(true);
        return cs;
    }


    protected XSSFCellStyle createDefaultRedStyle(SXSSFWorkbook wb) {
        XSSFCellStyle cs = (XSSFCellStyle) wb.createCellStyle();
        cs.setFillForegroundColor(new XSSFColor(new java.awt.Color(255, 255, 255)));
        cs.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        cs.setBorderBottom(BorderStyle.THIN);
        cs.setBorderTop(BorderStyle.THIN);
        cs.setBorderRight(BorderStyle.THIN);
        cs.setBorderLeft(BorderStyle.THIN);

        cs.setBorderColor(XSSFCellBorder.BorderSide.BOTTOM, new XSSFColor(new java.awt.Color(0, 0, 0)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.TOP, new XSSFColor(new java.awt.Color(0, 0, 0)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.RIGHT, new XSSFColor(new java.awt.Color(0, 0, 0)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.LEFT, new XSSFColor(new java.awt.Color(0, 0, 0)));

        cs.setVerticalAlignment(VerticalAlignment.CENTER);
        cs.setAlignment(HorizontalAlignment.CENTER);
        cs.setFont(createDefaultRedFont(wb));
        cs.setWrapText(true);
        return cs;
    }

    protected XSSFCellStyle createDefaultCenterStyle(SXSSFWorkbook wb) {
        XSSFCellStyle cs = (XSSFCellStyle) wb.createCellStyle();
        cs.setFillForegroundColor(new XSSFColor(new java.awt.Color(255, 255, 255)));
        cs.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        cs.setBorderBottom(BorderStyle.THIN);
        cs.setBorderTop(BorderStyle.THIN);
        cs.setBorderRight(BorderStyle.THIN);
        cs.setBorderLeft(BorderStyle.THIN);

      /*  cs.setBorderColor(XSSFCellBorder.BorderSide.BOTTOM, new XSSFColor(new java.awt.Color(51, 51, 51)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.TOP, new XSSFColor(new java.awt.Color(51, 51, 51)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.RIGHT, new XSSFColor(new java.awt.Color(51, 51, 51)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.LEFT, new XSSFColor(new java.awt.Color(51, 51, 51)));*/

        cs.setVerticalAlignment(VerticalAlignment.CENTER);
        cs.setAlignment(HorizontalAlignment.CENTER);
        cs.setFont(createDefaultFont(wb));
        cs.setWrapText(true);
        return cs;
    }

    protected XSSFCellStyle createDefaultLeftStyle(SXSSFWorkbook wb) {
        XSSFCellStyle cs = (XSSFCellStyle) wb.createCellStyle();
        cs.setFillForegroundColor(new XSSFColor(new java.awt.Color(255, 255, 255)));
        cs.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        cs.setBorderBottom(BorderStyle.THIN);
        cs.setBorderTop(BorderStyle.THIN);
        cs.setBorderRight(BorderStyle.THIN);
        cs.setBorderLeft(BorderStyle.THIN);

        cs.setBorderColor(XSSFCellBorder.BorderSide.BOTTOM, new XSSFColor(new java.awt.Color(0, 0, 0)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.TOP, new XSSFColor(new java.awt.Color(0, 0, 0)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.RIGHT, new XSSFColor(new java.awt.Color(0, 0, 0)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.LEFT, new XSSFColor(new java.awt.Color(0, 0, 0)));

        cs.setVerticalAlignment(VerticalAlignment.CENTER);
        cs.setAlignment(HorizontalAlignment.LEFT);
        cs.setFont(createDefaultFont(wb));
        cs.setWrapText(true);
        return cs;
    }

    protected XSSFCellStyle createTableHeaderStyle(SXSSFWorkbook wb) {
        XSSFCellStyle cs = (XSSFCellStyle) wb.createCellStyle();
        cs.setFillForegroundColor(new XSSFColor(new java.awt.Color(162, 212, 248)));    // blue
        cs.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        cs.setBorderBottom(BorderStyle.THIN);
        cs.setBorderTop(BorderStyle.THIN);
        cs.setBorderRight(BorderStyle.THIN);
        cs.setBorderLeft(BorderStyle.THIN);

        cs.setBorderColor(XSSFCellBorder.BorderSide.BOTTOM, new XSSFColor(new java.awt.Color(51, 51, 51)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.TOP, new XSSFColor(new java.awt.Color(51, 51, 51)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.RIGHT, new XSSFColor(new java.awt.Color(51, 51, 51)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.LEFT, new XSSFColor(new java.awt.Color(51, 51, 51)));

        cs.setVerticalAlignment(VerticalAlignment.CENTER);
        cs.setAlignment(HorizontalAlignment.CENTER);
        cs.setFont(createDefaultBoldFont(wb));
        cs.setWrapText(true);
        return cs;
    }

    protected XSSFCellStyle createTableHeaderBlueBoldStyle(SXSSFWorkbook wb) {
        XSSFCellStyle cs = (XSSFCellStyle) wb.createCellStyle();
        cs.setFillForegroundColor(new XSSFColor(new java.awt.Color(1, 122, 203)));    // blue
        cs.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        cs.setBorderBottom(BorderStyle.THIN);
        cs.setBorderTop(BorderStyle.THIN);
        cs.setBorderRight(BorderStyle.THIN);
        cs.setBorderLeft(BorderStyle.THIN);

        cs.setBorderColor(XSSFCellBorder.BorderSide.BOTTOM, new XSSFColor(new java.awt.Color(51, 51, 51)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.TOP, new XSSFColor(new java.awt.Color(51, 51, 51)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.RIGHT, new XSSFColor(new java.awt.Color(51, 51, 51)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.LEFT, new XSSFColor(new java.awt.Color(51, 51, 51)));

        cs.setVerticalAlignment(VerticalAlignment.CENTER);
        cs.setAlignment(HorizontalAlignment.LEFT);
        cs.setFont(createDefaultWhiteBoldFont(wb));
        cs.setWrapText(true);
        return cs;
    }

    protected XSSFCellStyle createTableHeaderFont20Style(SXSSFWorkbook wb) {
        XSSFCellStyle cs = (XSSFCellStyle) wb.createCellStyle();
        cs.setFillForegroundColor(new XSSFColor(new java.awt.Color(255, 255, 255)));    // black
        cs.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        cs.setBorderBottom(BorderStyle.NONE);
        cs.setBorderTop(BorderStyle.NONE);
        cs.setBorderRight(BorderStyle.NONE);
        cs.setBorderLeft(BorderStyle.NONE);

        cs.setVerticalAlignment(VerticalAlignment.CENTER);
        cs.setAlignment(HorizontalAlignment.CENTER);
        cs.setFont(create20BoldFont(wb));
        cs.setWrapText(true);
        return cs;
    }

    protected XSSFCellStyle createTableHeaderLightBlueStyle(SXSSFWorkbook wb) {
        XSSFCellStyle cs = (XSSFCellStyle) wb.createCellStyle();
        cs.setFillForegroundColor(new XSSFColor(new java.awt.Color(162, 212, 248)));    // light blue
        cs.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        cs.setBorderBottom(BorderStyle.THIN);
        cs.setBorderTop(BorderStyle.THIN);
        cs.setBorderRight(BorderStyle.THIN);
        cs.setBorderLeft(BorderStyle.THIN);

        cs.setBorderColor(XSSFCellBorder.BorderSide.BOTTOM, new XSSFColor(new java.awt.Color(0, 0, 0)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.TOP, new XSSFColor(new java.awt.Color(0, 0, 0)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.RIGHT, new XSSFColor(new java.awt.Color(0, 0, 0)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.LEFT, new XSSFColor(new java.awt.Color(0, 0, 0)));

        cs.setVerticalAlignment(VerticalAlignment.CENTER);
        cs.setAlignment(HorizontalAlignment.CENTER);
        cs.setFont(createDefaultBoldFont(wb));
        cs.setWrapText(true);
        return cs;
    }

    protected XSSFCellStyle createTableHeaderLeftStyle(SXSSFWorkbook wb) {
        XSSFCellStyle cs = (XSSFCellStyle) wb.createCellStyle();
        cs.setFillForegroundColor(new XSSFColor(new java.awt.Color(66, 105, 151)));    // #426997
        cs.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        cs.setBorderBottom(BorderStyle.THIN);
        cs.setBorderTop(BorderStyle.THIN);
        cs.setBorderRight(BorderStyle.THIN);
        cs.setBorderLeft(BorderStyle.THIN);

        cs.setBorderColor(XSSFCellBorder.BorderSide.BOTTOM, new XSSFColor(new java.awt.Color(0, 0, 0)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.TOP, new XSSFColor(new java.awt.Color(0, 0, 0)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.RIGHT, new XSSFColor(new java.awt.Color(0, 0, 0)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.LEFT, new XSSFColor(new java.awt.Color(0, 0, 0)));

        cs.setVerticalAlignment(VerticalAlignment.CENTER);
        cs.setAlignment(HorizontalAlignment.LEFT);
        cs.setFont(createWhiteFont(wb));
        cs.setWrapText(true);
        return cs;
    }

    protected XSSFCellStyle createTableHeaderBoldLeftStyle(SXSSFWorkbook wb) {
        XSSFCellStyle cs = (XSSFCellStyle) wb.createCellStyle();
        cs.setFillForegroundColor(new XSSFColor(new java.awt.Color(89, 89, 89))); // grey
        cs.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        cs.setBorderBottom(BorderStyle.THIN);
        cs.setBorderTop(BorderStyle.THIN);
        cs.setBorderRight(BorderStyle.THIN);
        cs.setBorderLeft(BorderStyle.THIN);

        cs.setBorderColor(XSSFCellBorder.BorderSide.BOTTOM, new XSSFColor(new java.awt.Color(51, 51, 51)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.TOP, new XSSFColor(new java.awt.Color(51, 51, 51)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.RIGHT, new XSSFColor(new java.awt.Color(51, 51, 51)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.LEFT, new XSSFColor(new java.awt.Color(51, 51, 51)));

        cs.setVerticalAlignment(VerticalAlignment.CENTER);
        cs.setAlignment(HorizontalAlignment.LEFT);
        cs.setFont(createDefaultWhiteBoldFont(wb));
        cs.setWrapText(true);
        return cs;
    }

    protected XSSFCellStyle createTableGreadeFStyle(SXSSFWorkbook wb) {
        XSSFCellStyle cs = (XSSFCellStyle) wb.createCellStyle();
        cs.setFillForegroundColor(new XSSFColor(new java.awt.Color(252, 170, 170))); //살구색
        cs.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        cs.setBorderBottom(BorderStyle.THIN);
        cs.setBorderTop(BorderStyle.THIN);
        cs.setBorderRight(BorderStyle.THIN);
        cs.setBorderLeft(BorderStyle.THIN);

        cs.setBorderColor(XSSFCellBorder.BorderSide.BOTTOM, new XSSFColor(new java.awt.Color(51, 51, 51)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.TOP, new XSSFColor(new java.awt.Color(51, 51, 51)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.RIGHT, new XSSFColor(new java.awt.Color(51, 51, 51)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.LEFT, new XSSFColor(new java.awt.Color(51, 51, 51)));

        cs.setVerticalAlignment(VerticalAlignment.CENTER);
        cs.setAlignment(HorizontalAlignment.CENTER);
        cs.setFont(createDefaultFont(wb));
        cs.setWrapText(true);
        return cs;
    }

    protected XSSFCellStyle createTableGreadeNAStyle(SXSSFWorkbook wb) {
        XSSFCellStyle cs = (XSSFCellStyle) wb.createCellStyle();
        cs.setFillForegroundColor(new XSSFColor(new java.awt.Color(204, 255, 204))); //살구색
        cs.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        cs.setBorderBottom(BorderStyle.THIN);
        cs.setBorderTop(BorderStyle.THIN);
        cs.setBorderRight(BorderStyle.THIN);
        cs.setBorderLeft(BorderStyle.THIN);

        cs.setBorderColor(XSSFCellBorder.BorderSide.BOTTOM, new XSSFColor(new java.awt.Color(51, 51, 51)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.TOP, new XSSFColor(new java.awt.Color(51, 51, 51)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.RIGHT, new XSSFColor(new java.awt.Color(51, 51, 51)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.LEFT, new XSSFColor(new java.awt.Color(51, 51, 51)));

        cs.setVerticalAlignment(VerticalAlignment.CENTER);
        cs.setAlignment(HorizontalAlignment.CENTER);
        cs.setFont(createDefaultFont(wb));
        cs.setWrapText(true);
        return cs;
    }

    protected XSSFCellStyle createTableINFOStyle(SXSSFWorkbook wb) {
        XSSFCellStyle cs = (XSSFCellStyle) wb.createCellStyle();
        cs.setFillForegroundColor(new XSSFColor(new java.awt.Color(253, 242, 99)));  //노락색
        cs.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        cs.setBorderBottom(BorderStyle.THIN);
        cs.setBorderTop(BorderStyle.THIN);
        cs.setBorderRight(BorderStyle.THIN);
        cs.setBorderLeft(BorderStyle.THIN);

        cs.setBorderColor(XSSFCellBorder.BorderSide.BOTTOM, new XSSFColor(new java.awt.Color(51, 51, 51)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.TOP, new XSSFColor(new java.awt.Color(51, 51, 51)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.RIGHT, new XSSFColor(new java.awt.Color(51, 51, 51)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.LEFT, new XSSFColor(new java.awt.Color(51, 51, 51)));

        cs.setVerticalAlignment(VerticalAlignment.CENTER);
        cs.setAlignment(HorizontalAlignment.CENTER);
        cs.setFont(createDefaultFont(wb));
        return cs;
    }

    protected XSSFCellStyle createTitleStyle(SXSSFWorkbook wb) {
        XSSFCellStyle cs = (XSSFCellStyle) wb.createCellStyle();
        cs.setFillForegroundColor(new XSSFColor(new java.awt.Color(255, 255, 255)));
        cs.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        cs.setBorderBottom(BorderStyle.NONE);
        cs.setBorderTop(BorderStyle.NONE);
        cs.setBorderRight(BorderStyle.NONE);
        cs.setBorderLeft(BorderStyle.NONE);

    /*    cs.setBorderColor(XSSFCellBorder.BorderSide.BOTTOM, new XSSFColor(new java.awt.Color(51, 51, 51)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.TOP, new XSSFColor(new java.awt.Color(51, 51, 51)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.RIGHT, new XSSFColor(new java.awt.Color(51, 51, 51)));
        cs.setBorderColor(XSSFCellBorder.BorderSide.LEFT, new XSSFColor(new java.awt.Color(51, 51, 51)));*/

        cs.setVerticalAlignment(VerticalAlignment.CENTER);
        cs.setAlignment(HorizontalAlignment.CENTER);
        cs.setFont(createTitleFont(wb));
        cs.setWrapText(true);
        return cs;
    }

    protected XSSFCellStyle createBorderNoneStyle(SXSSFWorkbook wb) {
        XSSFCellStyle cs = (XSSFCellStyle) wb.createCellStyle();
        cs.setFillForegroundColor(new XSSFColor(new java.awt.Color(255, 255, 255)));
        cs.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        cs.setBorderBottom(BorderStyle.NONE);
        cs.setBorderTop(BorderStyle.NONE);
        cs.setBorderRight(BorderStyle.NONE);
        cs.setBorderLeft(BorderStyle.NONE);
        cs.setVerticalAlignment(VerticalAlignment.CENTER);
        cs.setAlignment(HorizontalAlignment.RIGHT);
        cs.setFont(createJacket16BoldFont(wb));
        cs.setWrapText(true);
        return cs;
    }

    protected XSSFCellStyle createJackTitleStyle(SXSSFWorkbook wb) {
        XSSFCellStyle cs = (XSSFCellStyle) wb.createCellStyle();
        cs.setFillForegroundColor(new XSSFColor(new java.awt.Color(20, 120, 205)));
        cs.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        cs.setBorderBottom(BorderStyle.NONE);
        cs.setBorderTop(BorderStyle.NONE);
        cs.setBorderRight(BorderStyle.NONE);
        cs.setBorderLeft(BorderStyle.NONE);
        cs.setVerticalAlignment(VerticalAlignment.CENTER);
        cs.setAlignment(HorizontalAlignment.CENTER);
        cs.setFont(createJacket26BoldFont(wb));
        cs.setWrapText(true);
        return cs;
    }

}
