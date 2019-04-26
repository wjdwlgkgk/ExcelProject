//package Report;
//
//
//import kr.co.lsware.csp.Service.SecurityScanHistoryImpl;
//import org.apache.ibatis.session.ResultContext;
//import org.apache.ibatis.session.ResultHandler;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.xssf.streaming.SXSSFWorkbook;
//import org.apache.poi.xssf.usermodel.XSSFCellStyle;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.io.OutputStream;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class reportDetail extends reportStyle{
//    private final Logger logger = LoggerFactory.getLogger(reportDetail.class);
//    SXSSFWorkbook wb;
//    Sheet sheet;
//    int cellH = 0;
//    int cellW = 0;
//
//    reportUtil rUtil = new reportUtil();
//
//
//    SqlSession session;
//
//    Map<String, XSSFCellStyle> cs;
//
//    private static String static_pol_item_id = null;
//    private static int pol_cnt = 0;
//    private static int cve_cnt = 0;
//
//    public void execute(OutputStream os , String map) throws Exception {
//        logger.info("excel make start======================");
//
//        this.wb = new SXSSFWorkbook(1000);
//        this.sheet = wb.createSheet("표지");
//        sheet.setDisplayGridlines(false);
//        cs = createDefaultStyles(wb);
//
//        mainTitle(cs);
//
//        //자산목록
////        excelAssetList(map);
//
//        //체크리스트
//
//
//        //장비별
//        mainContents(map);
//
//        wb.write(os);
//        os.close();
//        wb.dispose();
//
//        logger.info("excel make end======================");
//    }
//
//    public void mainContents(String map) throws Exception {
//        org.json.JSONArray jsonArray = new org.json.JSONArray(map);
//        String nowDt = securityScanHistoryImpl.getNowDt();
//        for (int i = 0; i < jsonArray.length(); i++) {
//            cellH = 0;
//            HashMap hm = new HashMap();
//
//            hm.put("chk_grp_seq", jsonArray.getJSONObject(i).getInt("chk_grp_seq"));
//            hm.put("chk_vm_seq" , jsonArray.getJSONObject(i).getInt("chk_vm_seq"));
//            hm.put("eval_seq" , jsonArray.getJSONObject(i).getInt("eval_seq"));
//            hm.put("work_seq" , jsonArray.getJSONObject(i).getInt("work_seq"));
//
//            logger.info("chk_grp_seq :" + hm.get("chk_grp_seq") + " chk_vm_seq :" + hm.get("chk_vm_seq")  + " eval_seq :" + hm.get("eval_seq") + " work_seq :" + hm.get("work_seq"));
//
//            Map polInfo = securityScanHistoryImpl.getPolInfo(hm);
//            hm.put("pol_mngt_seq" , String.valueOf(polInfo.get("pol_mngt_seq")));
//            hm.put("pol_nm" , String.valueOf(polInfo.get("pol_nm")));
//            Map vmInfo = securityScanHistoryImpl.getVmInfo(hm);
//
//            List list = securityScanHistoryImpl.getSumaryRslt(hm);
//
//            sheet = wb.createSheet(vmInfo.get("chk_vm_nm") + "_"+ nowDt + "_" + i+1);
//            sheet.setDisplayGridlines(false);
//
//            rUtil.insertCell(sheet, 0, 0, vmInfo.get("chk_vm_nm") + " 점검 상세 내역" , cs.get(DEFAULT_TITLE_CS));
//            rUtil.mergeCell(sheet, 0, 0, 0, 8);
//            sheet.getRow(0).setHeight((short)700);
//
//            // 점검 VM 정보
//            excelVmInfo(vmInfo);
//            // 점검 정보
//            excelScanInfo(vmInfo);
//            // 점검 결과 요약 및 상세
//            excelVmSumary(list , hm);
//        }
//    }
//
//    public void mainTitle(Map<String, XSSFCellStyle> cs) throws Exception {
//        try {
//            rUtil.insertCell(sheet, 2, 0, "취약점 진단 상세 보고서", cs.get(DEFAULT_JACKET_TITLE_CS));
//            rUtil.mergeCell(sheet, 2, 2, 0, 8);
//            sheet.getRow(2).setHeight((short) 1200);
//
//            String dt = securityScanHistoryImpl.getNowDt().substring(0, 4) + "년 "
//                    + securityScanHistoryImpl.getNowDt().substring(5, 7) + "월 "
//                    + securityScanHistoryImpl.getNowDt().substring(8, 10) + "일";
//            rUtil.insertCell(sheet, 24, 5, "작성일자 : " + dt, cs.get(DEFAULT_TITLE_CS));
//            rUtil.mergeCell(sheet, 24, 24, 5, 8);
//        }catch (Exception e){
//            throw new Exception(e);
//        }
//    }
//
//    public void excelVmInfo(Map vmInfo) throws Exception {
//        // 점검 VM 정보
//        try {
//            cellH++;
//            cellH++;
//            cellH++;
//            rUtil.insertCellCntRow(sheet, cellH, 0, "■ 점검 VM 정보", 8, cs.get(DEFAULT_TABLE_HEADER_LEFT_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 0, 8);
//
//            cellH++;
//            cellH++;
//
//            rUtil.insertCellCntRow(sheet, cellH, 0, "점검그룹", 1, cs.get(DEFAULT_TABLE_HEADER_LIGHT_BLUE_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 0, 1);
//            rUtil.insertCellCntRow(sheet, cellH, 2, String.valueOf(vmInfo.get("chk_grp_nm")), 2, cs.get(DEFAULT_CENTER_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 2, 4);
//            rUtil.insertCellCntRow(sheet, cellH, 5, "소속", 1, cs.get(DEFAULT_TABLE_HEADER_LIGHT_BLUE_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 5, 6);
//            rUtil.insertCellCntRow(sheet, cellH, 7, String.valueOf(vmInfo.get("comp_nm")), 1, cs.get(DEFAULT_CENTER_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 7, 8);
//
//            cellH++;
//            rUtil.insertCellCntRow(sheet, cellH, 0, "마스터 VM명", 1, cs.get(DEFAULT_TABLE_HEADER_LIGHT_BLUE_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 0, 1);
//            rUtil.insertCellCntRow(sheet, cellH, 2, String.valueOf(vmInfo.get("mastr_vm_nm")), 2, cs.get(DEFAULT_CENTER_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 2, 4);
//            rUtil.insertCellCntRow(sheet, cellH, 5, "마스터 VM IP", 1, cs.get(DEFAULT_TABLE_HEADER_LIGHT_BLUE_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 5, 6);
//            rUtil.insertCellCntRow(sheet, cellH, 7, String.valueOf(vmInfo.get("m_ip")), 1, cs.get(DEFAULT_CENTER_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 7, 8);
//
//            cellH++;
//            rUtil.insertCellCntRow(sheet, cellH, 0, "점검 VM명", 1, cs.get(DEFAULT_TABLE_HEADER_LIGHT_BLUE_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 0, 1);
//            rUtil.insertCellCntRow(sheet, cellH, 2, String.valueOf(vmInfo.get("chk_vm_nm")), 2, cs.get(DEFAULT_CENTER_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 2, 4);
//            rUtil.insertCellCntRow(sheet, cellH, 5, "점검 VM IP", 1, cs.get(DEFAULT_TABLE_HEADER_LIGHT_BLUE_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 5, 6);
//            rUtil.insertCellCntRow(sheet, cellH, 7, String.valueOf(vmInfo.get("v_ip")), 1, cs.get(DEFAULT_CENTER_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 7, 8);
//        }catch (Exception e){
//            throw new Exception(e);
//        }
//    }
//
//    public void excelScanInfo(Map vmInfo) throws Exception {
//        try {
//            cellH++;
//            cellH++;
//            rUtil.insertCellCntRow(sheet, cellH, 0, "■ 점검 정보", 8, cs.get(DEFAULT_TABLE_HEADER_LEFT_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 0, 8);
//
//            cellH++;
//            cellH++;
//            rUtil.insertCellCntRow(sheet, cellH, 0, "점검 시작 시간", 1, cs.get(DEFAULT_TABLE_HEADER_LIGHT_BLUE_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 0, 1);
//            rUtil.insertCellCntRow(sheet, cellH, 2, String.valueOf(vmInfo.get("start_dt")), 3, cs.get(DEFAULT_CENTER_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 2, 4);
//            rUtil.insertCellCntRow(sheet, cellH, 5, "점검 완료 시간", 1, cs.get(DEFAULT_TABLE_HEADER_LIGHT_BLUE_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 5, 6);
//            rUtil.insertCellCntRow(sheet, cellH, 7, String.valueOf(vmInfo.get("end_dt")), 1, cs.get(DEFAULT_CENTER_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 7, 8);
//
//            cellH++;
//            rUtil.insertCellCntRow(sheet, cellH, 0, "점검자ID", 1, cs.get(DEFAULT_TABLE_HEADER_LIGHT_BLUE_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 0, 1);
//            rUtil.insertCellCntRow(sheet, cellH, 2, String.valueOf(vmInfo.get("user_id")), 6, cs.get(DEFAULT_CENTER_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 2, 8);
//        }catch (Exception e){
//            throw new Exception(e);
//        }
//    }
//
//    public void excelVmSumary(List list , Map hm) throws Exception {
//        for(int p=0; p < list.size(); p++){
//            HashMap hmap = new HashMap();
//            hmap = (HashMap) list.get(p);
//            hm.put("asset_category_seq" , hmap.get("seq"));
//
//            cellH++;
//            cellH++;
//            rUtil.insertCellCntRow(sheet, cellH , 0, "■ 점검 결과 요약" , 8 , cs.get(DEFAULT_TABLE_HEADER_LEFT_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 0, 8);
//
//            cellH++;
//            cellH++;
//            rUtil.insertCellCntRow(sheet, cellH , 0, "대상종류" , 1 , cs.get(DEFAULT_TABLE_HEADER_LIGHT_BLUE_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 0, 1);
//            rUtil.insertCellCntRow(sheet, cellH , 2, (String)hmap.get("cate_cd"), 2, cs.get(DEFAULT_CENTER_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 2, 4);
//            rUtil.insertCellCntRow(sheet, cellH , 5, "호스트명" , 1 , cs.get(DEFAULT_TABLE_HEADER_LIGHT_BLUE_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 5, 6);
//            rUtil.insertCellCntRow(sheet, cellH , 7, (String)hmap.get("asset_nm") , 1 , cs.get(DEFAULT_CENTER_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 7, 8);
//
//            cellH++;
//            rUtil.insertCellCntRow(sheet, cellH , 0, "IP" , 1 , cs.get(DEFAULT_TABLE_HEADER_LIGHT_BLUE_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 0, 1);
//            rUtil.insertCellCntRow(sheet, cellH , 2, hmap.get("ip") == null ? ""  : (String)hmap.get("ip"), 2, cs.get(DEFAULT_CENTER_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 2, 4);
//            rUtil.insertCellCntRow(sheet, cellH , 5, "OS" , 1 , cs.get(DEFAULT_TABLE_HEADER_LIGHT_BLUE_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 5, 6);
//            rUtil.insertCellCntRow(sheet, cellH , 7, (String)hmap.get("ver") , 1 , cs.get(DEFAULT_CENTER_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 7, 8);
//
//            cellH++;
//            rUtil.insertCellCntRow(sheet, cellH , 0, "결과 요약" , 1 , cs.get(DEFAULT_TABLE_HEADER_LIGHT_BLUE_CS));
//            rUtil.mergeCell(sheet, cellH, cellH+4, 0, 1);
//            rUtil.insertCellCntRow(sheet, cellH , 2, "항목수", 2, cs.get(DEFAULT_CENTER_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 2, 4);
//            rUtil.insertCellCntRow(sheet, cellH , 5, String.valueOf(hmap.get("total_cnt")) , 3 , cs.get(DEFAULT_CENTER_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 5, 8);
//
//            cellH++;
//            rUtil.insertCellCntRow(sheet, cellH , 2, "점검 가능 항목수" , 2 , cs.get(DEFAULT_CENTER_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 2, 4);
//            rUtil.insertCellCntRow(sheet, cellH , 5, String.valueOf(hmap.get("total_cnt")) , 3, cs.get(DEFAULT_CENTER_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 5, 8);
//
//            cellH++;
//            rUtil.insertCellCntRow(sheet, cellH , 2, "취약 항목수" , 2 , cs.get(DEFAULT_CENTER_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 2, 4);
//            rUtil.insertCellCntRow(sheet, cellH , 5, String.valueOf(hmap.get("bad_cnt")) , 3, cs.get(DEFAULT_CENTER_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 5, 8);
//
//            cellH++;
//            rUtil.insertCellCntRow(sheet, cellH , 2, "인포 항목수" , 2 , cs.get(DEFAULT_CENTER_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 2, 4);
//            rUtil.insertCellCntRow(sheet, cellH , 5, String.valueOf(hmap.get("info_cnt")) , 3, cs.get(DEFAULT_CENTER_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 5, 8);
//
//            cellH++;
//            rUtil.insertCellCntRow(sheet, cellH , 2, "양호 항목수" , 2 , cs.get(DEFAULT_CENTER_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 2, 4);
//            rUtil.insertCellCntRow(sheet, cellH , 5, String.valueOf(hmap.get("ok_cnt")) , 3, cs.get(DEFAULT_CENTER_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 5, 8);
//
//            cellH++;
//            cellH++;
//            rUtil.insertCellCntRow(sheet, cellH , 0, "■ 점검 결과 상세" , 8 , cs.get(DEFAULT_TABLE_HEADER_LEFT_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 0, 8);
//
//            cellH++;
//            cellH++;
//            rUtil.insertCellCntRow(sheet, cellH , 0, "그룹" , 1 , cs.get(DEFAULT_TABLE_HEADER_LIGHT_BLUE_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 0, 1);
//            rUtil.insertCellCntRow(sheet, cellH , 2, "항목" , 5 , cs.get(DEFAULT_TABLE_HEADER_LIGHT_BLUE_CS));
//            rUtil.mergeCell(sheet, cellH, cellH, 2, 7);
//            rUtil.insertCell(sheet, cellH, 8 , "결과" , cs.get(DEFAULT_TABLE_HEADER_LIGHT_BLUE_CS));
//
//            List polList = securityScanHistoryImpl.getTargetRsltList(hm);
//            for(int pl = 0; pl < polList.size(); pl++){
//                HashMap pMap = new HashMap();
//                pMap = (HashMap) polList.get(pl);
//
//                cellH++;
//                rUtil.insertCellCntRow(sheet, cellH , 0, String.valueOf(pMap.get("pol_item_grp_nm")) , 1 , cs.get(DEFAULT_CENTER_CS));
//                rUtil.mergeCell(sheet, cellH, cellH, 0, 1);
//                rUtil.insertCellCntRow(sheet, cellH , 2, String.valueOf(pMap.get("pol_item_nm")) , 5 , cs.get(DEFAULT_CENTER_CS));
//                rUtil.mergeCell(sheet, cellH, cellH, 2, 7);
//
//                if("취약".equals(pMap.get("rslt_type").toString())){
//                    rUtil.insertCell(sheet, cellH, 8 , String.valueOf(pMap.get("rslt_type")) , cs.get(DEFAULT_RED_CS));
//                }else{
//                    rUtil.insertCell(sheet, cellH, 8 , String.valueOf(pMap.get("rslt_type")) , cs.get(DEFAULT_CENTER_CS));
//                }
//            }
//
//            class InnerResultHandler implements ResultHandler {
//                @Override
//                public void handleResult(ResultContext context) {
//                    Map<String, Object> row = (Map<String, Object>) context.getResultObject();
//                    String pol_item_nm = (String) row.get("pol_item_nm");
//
//                //    if(!"양호".equals((String) row.get("rslt_type"))) {
//                        pol_cnt++;
//                //    }
//
//                    if(static_pol_item_id == null ){  // 최초
//                        static_pol_item_id = (String) row.get("pol_item_id");
//
//                        cellH++;
//                        cellH++;
//                        rUtil.insertCellCntRow(sheet, cellH , 0, "■ " + pol_item_nm , 8 , cs.get(DEFAULT_TABLE_HEADER_LEFT_CS));
//                        rUtil.mergeCell(sheet, cellH, cellH, 0, 8);
//
//                        cellH++;
//                        cellH++;
//                        rUtil.insertCellCntRow(sheet, cellH , 0, "결과" , 1 , cs.get(DEFAULT_TABLE_HEADER_LIGHT_BLUE_CS));
//                        rUtil.mergeCell(sheet, cellH, cellH, 0, 1);
//
//                        if("취약".equals(String.valueOf(row.get("rslt_type")))){
//                            rUtil.insertCellCntRow(sheet, cellH , 2, String.valueOf(row.get("rslt_type")) , 6, cs.get(DEFAULT_RED_CS));
//                        }else{
//                            rUtil.insertCellCntRow(sheet, cellH , 2, String.valueOf(row.get("rslt_type")) , 6, cs.get(DEFAULT_CENTER_CS));
//                        }
//                        rUtil.mergeCell(sheet, cellH, cellH, 2, 8);
//
//                        if(!"양호".equals((String) row.get("rslt_type")) && row.get("dtl_msg") != null) {
//                            cellH++;
//                            rUtil.insertCellCntRow(sheet, cellH , 0, "점검 결과" , 8 , cs.get(DEFAULT_TABLE_HEADER_LIGHT_BLUE_CS));
//                            rUtil.mergeCell(sheet, cellH, cellH, 0, 8);
//
//                            cellH++;
//                            rUtil.insertCellCntRow(sheet, cellH , 0, "MESSAGE" , 8 , cs.get(DEFAULT_TABLE_HEADER_LIGHT_BLUE_CS));
//                            rUtil.mergeCell(sheet, cellH, cellH, 0, 8);
//
//                            cellH++;
//                            rUtil.insertCellCntRow(sheet, cellH , 0, (String) row.get("dtl_msg") , 8 , cs.get(DEFAULT_LEFT_CS));
//                            rUtil.mergeCell(sheet, cellH, cellH, 0, 8);
//                        }
//
//                    }else if(static_pol_item_id.equals((String) row.get("pol_item_id"))){  // 중복
//                        if(!"양호".equals((String) row.get("rslt_type")) && row.get("dtl_msg") != null) {
//                            cellH++;
//                            rUtil.insertCellCntRow(sheet, cellH , 0, (String) row.get("dtl_msg") , 8 , cs.get(DEFAULT_LEFT_CS));
//                            rUtil.mergeCell(sheet, cellH, cellH, 0, 8);
//                        }
//                    }else if(!static_pol_item_id.equals((String) row.get("pol_item_id"))){  // 신규
//                        static_pol_item_id = (String) row.get("pol_item_id");
//
//                        cellH++;
//                        cellH++;
//                        rUtil.insertCellCntRow(sheet, cellH , 0, "■ " + pol_item_nm , 8 , cs.get(DEFAULT_TABLE_HEADER_LEFT_CS));
//                        rUtil.mergeCell(sheet, cellH, cellH, 0, 8);
//
//                        cellH++;
//                        cellH++;
//                        rUtil.insertCellCntRow(sheet, cellH , 0, "결과"  , 1 , cs.get(DEFAULT_TABLE_HEADER_LIGHT_BLUE_CS));
//                        rUtil.mergeCell(sheet, cellH, cellH, 0, 1);
//
//                        if("취약".equals(String.valueOf(row.get("rslt_type")))){
//                            rUtil.insertCellCntRow(sheet, cellH , 2, String.valueOf(row.get("rslt_type"))  , 6 , cs.get(DEFAULT_RED_CS));
//                        }else{
//                            rUtil.insertCellCntRow(sheet, cellH , 2, String.valueOf(row.get("rslt_type"))  , 6 , cs.get(DEFAULT_CENTER_CS));
//                        }
//                        rUtil.mergeCell(sheet, cellH, cellH, 2, 8);
//
//                        if(!"양호".equals((String) row.get("rslt_type")) && row.get("dtl_msg") != null) {
//                            cellH++;
//                            rUtil.insertCellCntRow(sheet, cellH , 0, "점검 결과" , 8 , cs.get(DEFAULT_TABLE_HEADER_LIGHT_BLUE_CS));
//                            rUtil.mergeCell(sheet, cellH, cellH, 0, 8);
//
//                            cellH++;
//                            rUtil.insertCellCntRow(sheet, cellH , 0, "MESSAGE" , 8 , cs.get(DEFAULT_TABLE_HEADER_LIGHT_BLUE_CS));
//                            rUtil.mergeCell(sheet, cellH, cellH, 0, 8);
//
//                            cellH++;
//                            rUtil.insertCellCntRow(sheet, cellH , 0 ,(String) row.get("dtl_msg") , 8 , cs.get(DEFAULT_LEFT_CS));
//                            rUtil.mergeCell(sheet, cellH, cellH, 0, 8);
//                        }
//                    }
//                    // 조치법
//                    if(pol_cnt == Integer.parseInt(String.valueOf(row.get("pol_cnt")))){
//                        pol_cnt = 0;
//
//                        if(String.valueOf(row.get("pol_item_cont")).length() > 0 ){
//                            cellH++;
//                            cellH++;
//                            rUtil.insertCellCntRow(sheet, cellH , 0, "■ 점검 결과 상세" , 8 , cs.get(DEFAULT_TABLE_HEADER_LEFT_CS));
//                            rUtil.mergeCell(sheet, cellH, cellH, 0, 8);
//
//                            cellH++;
//                            cellH++;
//                            rUtil.insertCellCntRow(sheet, cellH , 0, "내용" , 8 , cs.get(DEFAULT_TABLE_HEADER_LIGHT_BLUE_CS));
//                            rUtil.mergeCell(sheet, cellH, cellH, 0, 8);
//
//                            cellH++;
//                            rUtil.insertCellCntRow(sheet, cellH , 0, row.get("pol_item_cont") == null ? "" : String.valueOf(row.get("pol_item_cont")) , 8 , cs.get(DEFAULT_LEFT_CS));
//                            rUtil.mergeCell(sheet, cellH, cellH, 0, 8);
//                            sheet.getRow(cellH).setHeight((short) 1200);
//
//                            cellH++;
//                            rUtil.insertCellCntRow(sheet, cellH , 0, "확인 방법" , 8 , cs.get(DEFAULT_TABLE_HEADER_LIGHT_BLUE_CS));
//                            rUtil.mergeCell(sheet, cellH, cellH, 0, 8);
//
//                            cellH++;
//                            rUtil.insertCellCntRow(sheet, cellH , 0, row.get("pol_item_confm_meth") == null ? "" : String.valueOf(row.get("pol_item_confm_meth")) , 8 , cs.get(DEFAULT_LEFT_CS));
//                            rUtil.mergeCell(sheet, cellH, cellH, 0, 8);
//                            sheet.getRow(cellH).setHeight((short) 1200);
//
//                            cellH++;
//                            rUtil.insertCellCntRow(sheet, cellH , 0, "기준" , 8 , cs.get(DEFAULT_TABLE_HEADER_LIGHT_BLUE_CS));
//                            rUtil.mergeCell(sheet, cellH, cellH, 0, 8);
//
//                            cellH++;
//                            rUtil.insertCellCntRow(sheet, cellH , 0, row.get("pol_item_judge_stnd") == null ? "" : String.valueOf(row.get("pol_item_judge_stnd")) , 8 , cs.get(DEFAULT_LEFT_CS));
//                            rUtil.mergeCell(sheet, cellH, cellH, 0, 8);
//                            sheet.getRow(cellH).setHeight((short) 1200);
//
//                            cellH++;
//                            rUtil.insertCellCntRow(sheet, cellH , 0, "조치법" , 8 , cs.get(DEFAULT_TABLE_HEADER_LIGHT_BLUE_CS));
//                            rUtil.mergeCell(sheet, cellH, cellH, 0, 8);
//
//                            cellH++;
//                            rUtil.insertCellCntRow(sheet, cellH , 0, row.get("pol_item_remed") == null ? "" : String.valueOf(row.get("pol_item_remed")) , 8 , cs.get(DEFAULT_LEFT_CS));
//                            rUtil.mergeCell(sheet, cellH, cellH, 0, 8);
//                            sheet.getRow(cellH).setHeight((short) 1200);
//                        }
//                    }
//                }
//            }
//            try {
//                session.select("getDetailRsltList", hm, new InnerResultHandler());
//            }catch(Exception e){
//                throw new Exception(e);
//            }
//            cve_cnt = 0;
//            class InnerCveResultHandler implements ResultHandler {
//                @Override
//                public void handleResult(ResultContext context) {
//                    Map<String, Object> row = (Map<String, Object>) context.getResultObject();
//                    int row_cnt = context.getResultCount();
//
//                    if (cve_cnt == 0) {
//                        cellH++;
//                        cellH++;
//                        rUtil.insertCellCntRow(sheet, cellH, 0, "■ CVE 결과 상세", 8, cs.get(DEFAULT_TABLE_HEADER_LEFT_CS));
//                        rUtil.mergeCell(sheet, cellH, cellH, 0, 8);
//
//                        cellH++;
//                        cellH++;
//                        rUtil.insertCellCntRow(sheet, cellH, 0, "CVE-ID", 1, cs.get(DEFAULT_TABLE_HEADER_LIGHT_BLUE_CS));
//                        rUtil.mergeCell(sheet, cellH, cellH, 0, 1);
//                        rUtil.insertCell(sheet, cellH, 2, "Score", cs.get(DEFAULT_TABLE_HEADER_LIGHT_BLUE_CS));
//                        rUtil.insertCellCntRow(sheet, cellH, 3, "Title", 4, cs.get(DEFAULT_TABLE_HEADER_LIGHT_BLUE_CS));
//                        rUtil.mergeCell(sheet, cellH, cellH, 3, 7);
//                        rUtil.insertCell(sheet, cellH, 8, "결과", cs.get(DEFAULT_TABLE_HEADER_LIGHT_BLUE_CS));
//
//                    } if(row_cnt >= 1){
//                        cellH++;
//                        rUtil.insertCellCntRow(sheet, cellH, 0, String.valueOf(row.get("cve_id")), 1, cs.get(DEFAULT_CENTER_CS));
//                        rUtil.mergeCell(sheet, cellH, cellH, 0, 1);
//                        rUtil.insertCell(sheet, cellH, 2, String.valueOf(row.get("score")), cs.get(DEFAULT_CENTER_CS));
//                        rUtil.insertCellCntRow(sheet, cellH, 3, String.valueOf(row.get("title")), 4, cs.get(DEFAULT_CENTER_CS));
//                        rUtil.mergeCell(sheet, cellH, cellH, 3, 7);
//                        sheet.getRow(cellH).setHeight((short) 1000);
//                        if ("취약".equals(String.valueOf(row.get("rslt_type")))) {
//                            rUtil.insertCell(sheet, cellH, 8, String.valueOf(row.get("rslt_type")), cs.get(DEFAULT_RED_CS));
//                        } else {
//                            rUtil.insertCell(sheet, cellH, 8, String.valueOf(row.get("rslt_type")), cs.get(DEFAULT_CENTER_CS));
//                        }
//                    }
//                    cve_cnt++;
//                }
//            }
//            try{
//                session.select("getDetailCveRsltList" , hm , new InnerCveResultHandler());
//            }catch (Exception e){
//                throw new Exception(e);
//            }
//
//        }
//    }
//
//    public void excelAssetList(String map) throws Exception {
//        org.json.JSONArray jsonArray = new org.json.JSONArray(map);
//        String nowDt = securityScanHistoryImpl.getNowDt();
//
//        for (int i = 0; i < jsonArray.length(); i++) {
//            cellH = 0;
//            HashMap param = new HashMap();
//
//            param.put("chk_grp_seq", jsonArray.getJSONObject(i).getInt("chk_grp_seq"));
//            param.put("chk_vm_seq" , jsonArray.getJSONObject(i).getInt("chk_vm_seq"));
//            param.put("eval_seq" , jsonArray.getJSONObject(i).getInt("eval_seq"));
//            param.put("work_seq" , jsonArray.getJSONObject(i).getInt("work_seq"));
//            Map vmInfo = securityScanHistoryImpl.getVmInfo(param);
//            List list = securityScanHistoryImpl.getSumaryRslt(param);
//
//            sheet = wb.createSheet("자산목록");
//            sheet.setDisplayGridlines(false);
//
//            rUtil.insertCell(sheet, 0, 0, " 점검 상세 내역" , cs.get(DEFAULT_TITLE_CS));
//            rUtil.mergeCell(sheet, 0, 0, 0, 8);
//            sheet.getRow(0).setHeight((short)700);
//        }
//
//
//    }
//
//
//
//}
