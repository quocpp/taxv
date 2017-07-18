import java.util.List;

/**
 * Created by bean on 18/07/2017.
 */
public class CusInfo {
    private String MSt;
    private String TEN_NNT;
    private String S0;
    private String MA_CQT_QL;
    private String MOTA_DIACHI;
    private String MA_TINH;
    private String MA_HUYEN;
    private String MA_XA;
    private String SO_NHA;
    private String DIACHI_TT;
    private String MA_TINH_TT;
    private String MA_HUYEN_TT;
    private String MA_XA_TT;
    private String SO_NHA_TT;
    private String MOBILE;
    private String EMAIL;
    private String MA_NV;
    private String MA_T;
    private String MA_UNT;
    private String DIA_BAN;
    private String KBNN;
    private String DA_GIAO;
    private String SOTIEN;
    private List <KyThue> kyThue;

    public List<KyThue> getKyThue() {
        return kyThue;
    }

    public void addttno(List<ttno> ittno, int position)
    {
        kyThue.get(position).setThongTNo(ittno);
    }
    public List<ttno> getttno(int position)
    {
        return kyThue.get(position).getThongTNo();
    }

    public void setKyThue(List<KyThue> kyThue) {
        this.kyThue = kyThue;
    }

    public String getMSt() {
        return MSt;
    }

    public void setMSt(String MSt) {
        this.MSt = MSt;
    }

    public String getTEN_NNT() {
        return TEN_NNT;
    }

    public void setTEN_NNT(String TEN_NNT) {
        this.TEN_NNT = TEN_NNT;
    }

    public String getS0() {
        return S0;
    }

    public void setS0(String s0) {
        S0 = s0;
    }

    public String getMA_CQT_QL() {
        return MA_CQT_QL;
    }

    public void setMA_CQT_QL(String MA_CQT_QL) {
        this.MA_CQT_QL = MA_CQT_QL;
    }

    public String getMOTA_DIACHI() {
        return MOTA_DIACHI;
    }

    public void setMOTA_DIACHI(String MOTA_DIACHI) {
        this.MOTA_DIACHI = MOTA_DIACHI;
    }

    public String getMA_TINH() {
        return MA_TINH;
    }

    public void setMA_TINH(String MA_TINH) {
        this.MA_TINH = MA_TINH;
    }

    public String getMA_HUYEN() {
        return MA_HUYEN;
    }

    public void setMA_HUYEN(String MA_HUYEN) {
        this.MA_HUYEN = MA_HUYEN;
    }

    public String getMA_XA() {
        return MA_XA;
    }

    public void setMA_XA(String MA_XA) {
        this.MA_XA = MA_XA;
    }

    public String getSO_NHA() {
        return SO_NHA;
    }

    public void setSO_NHA(String SO_NHA) {
        this.SO_NHA = SO_NHA;
    }

    public String getDIACHI_TT() {
        return DIACHI_TT;
    }

    public void setDIACHI_TT(String DIACHI_TT) {
        this.DIACHI_TT = DIACHI_TT;
    }

    public String getMA_TINH_TT() {
        return MA_TINH_TT;
    }

    public void setMA_TINH_TT(String MA_TINH_TT) {
        this.MA_TINH_TT = MA_TINH_TT;
    }

    public String getMA_HUYEN_TT() {
        return MA_HUYEN_TT;
    }

    public void setMA_HUYEN_TT(String MA_HUYEN_TT) {
        this.MA_HUYEN_TT = MA_HUYEN_TT;
    }

    public String getMA_XA_TT() {
        return MA_XA_TT;
    }

    public void setMA_XA_TT(String MA_XA_TT) {
        this.MA_XA_TT = MA_XA_TT;
    }

    public String getSO_NHA_TT() {
        return SO_NHA_TT;
    }

    public void setSO_NHA_TT(String SO_NHA_TT) {
        this.SO_NHA_TT = SO_NHA_TT;
    }

    public String getMOBILE() {
        return MOBILE;
    }

    public void setMOBILE(String MOBILE) {
        this.MOBILE = MOBILE;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getMA_NV() {
        return MA_NV;
    }

    public void setMA_NV(String MA_NV) {
        this.MA_NV = MA_NV;
    }

    public String getMA_T() {
        return MA_T;
    }

    public void setMA_T(String MA_T) {
        this.MA_T = MA_T;
    }

    public String getMA_UNT() {
        return MA_UNT;
    }

    public void setMA_UNT(String MA_UNT) {
        this.MA_UNT = MA_UNT;
    }

    public String getDIA_BAN() {
        return DIA_BAN;
    }

    public void setDIA_BAN(String DIA_BAN) {
        this.DIA_BAN = DIA_BAN;
    }

    public String getKBNN() {
        return KBNN;
    }

    public void setKBNN(String KBNN) {
        this.KBNN = KBNN;
    }

    public String getDA_GIAO() {
        return DA_GIAO;
    }

    public void setDA_GIAO(String DA_GIAO) {
        this.DA_GIAO = DA_GIAO;
    }

    public String getSOTIEN() {
        return SOTIEN;
    }

    public void setSOTIEN(String SOTIEN) {
        this.SOTIEN = SOTIEN;
    }
}
