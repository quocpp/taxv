/**
 * Created by bean on 17/07/2017.
 */
public class LoginInfo {
    private String result;
    private String serial;
    private String infores;
    private String MaNvThu;
    private String MaTinh;
    private String UserName;

    public String getReCorNum() {
        return ReCorNum;
    }

    public void setReCorNum(String reCorNum) {
        ReCorNum = reCorNum;
    }

    private String ReCorNum;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    private String PassWord;
    public LoginInfo() {
    }

    public LoginInfo(String result, String serial) {
        this.result = result;
        this.serial = serial;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getInfores() {
        return infores;
    }

    public void setInfores(String infores) {
        this.infores = infores;
    }

    public String getMaNvThu() {
        return MaNvThu;
    }

    public void setMaNvThu(String maNvThu) {
        MaNvThu = maNvThu;
    }

    public String getMaTinh() {
        return MaTinh;
    }

    public void setMaTinh(String maTinh) {
        MaTinh = maTinh;
    }
}
