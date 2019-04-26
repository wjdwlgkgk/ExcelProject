package Report;

import lombok.Data;

@Data
public class reportVo {
    int chk_grp_seq;
    int chk_vm_seq;
    int asset_seq;
    int eval_seq;
    int work_seq;
    int pol_mngt_seq;
    int pol_cate_seq;
    int eval_asset_seq;
    int pol_item_seq;
    String pol_nm;
    String pol_cate_nm;
    String pol_item_grp_nm;
    String pol_item_id;
    String pol_item_nm;
    String pol_item_cont;
    String pol_item_confm_meth;
    String pol_item_jugde_stnd;
    String pol_item_severity_cd; // 중요도
    String pol_item_remed;
    String rslt_type;
    String title;
    String dtl_msg;
}
