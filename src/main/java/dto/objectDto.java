package dto;

public class objectDto {

    int RESULTITEM_SEQ;
    String jobid;
    String hw_seq;
    String map_id;
    String RESULT_SEQ;
    char EXCEPTION_YN;
    String item;
    String message;


    public int getRESULTITEM_SEQ() {
        return RESULTITEM_SEQ;
    }

    public void setRESULTITEM_SEQ(int RESULTITEM_SEQ) {
        this.RESULTITEM_SEQ = RESULTITEM_SEQ;
    }

    public String getJobid() {
        return jobid;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid;
    }

    public String getHw_seq() {
        return hw_seq;
    }

    public void setHw_seq(String hw_seq) {
        this.hw_seq = hw_seq;
    }

    public String getMap_id() {
        return map_id;
    }

    public void setMap_id(String map_id) {
        this.map_id = map_id;
    }

    public String getRESULT_SEQ() {
        return RESULT_SEQ;
    }

    public void setRESULT_SEQ(String RESULT_SEQ) {
        this.RESULT_SEQ = RESULT_SEQ;
    }

    public char getEXCEPTION_YN() {
        return EXCEPTION_YN;
    }

    public void setEXCEPTION_YN(char EXCEPTION_YN) {
        this.EXCEPTION_YN = EXCEPTION_YN;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
