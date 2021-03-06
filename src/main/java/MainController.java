/**
 * Created by bean on 17/07/2017.
 */
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainController {
    private ConstantS myConstatnS;
    SendRequest mySendReq;
    JsonParserC myJsonParser;
    public MainController() {

        myConstatnS = new ConstantS();
        mySendReq = new SendRequest();
        myJsonParser = new JsonParserC();
    }

    public LoginInfo vLogin(String user, String password) throws NoSuchAlgorithmException, IOException, ParserConfigurationException, SAXException {

        MessageDigest m = MessageDigest.getInstance("MD5");
        m.reset();
        m.update(password.getBytes());
        byte[] digest = m.digest();
        BigInteger bigInt = new BigInteger(1,digest);
        String hashpass = bigInt.toString(16);
        String req = String.format(myConstatnS.loginreq, user,hashpass,user);
        String loginres = mySendReq.SendPostRequest(req,"value");
        String pattern = "<ns:return>(.*)<\\/ns:return>";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);
        Matcher imatch = r.matcher(loginres);
        LoginInfo myLoginInfo = new LoginInfo();
        if(imatch.find()) {
            String nsLogins = imatch.group(1);
            System.out.print("nsLogin: "+nsLogins);
            String [] nsLogin = nsLogins.split("\\|");
            myLoginInfo = new LoginInfo(nsLogin[0],nsLogin[1]);
            myLoginInfo.setUserName(user);
            myLoginInfo.setPassWord(hashpass);
        }

        return myLoginInfo;
    }

    public LoginInfo GetUserInfo(LoginInfo iLoginInfo ) throws IOException {

        String req = String.format(myConstatnS.loginInfo,
                                   iLoginInfo.getUserName(),
                                   iLoginInfo.getPassWord(),
                iLoginInfo.getSerial(),
                iLoginInfo.getUserName());

        String loginres = mySendReq.SendPostRequest(req,"value");
        String pattern = "<ns:return>(.*)<\\/ns:return>";
        Pattern r = Pattern.compile(pattern);
        Matcher imatch = r.matcher(loginres);
        LoginInfo myLoginInfo = new LoginInfo();
        String nsLogins = "";
        if(imatch.find()) {
            nsLogins = imatch.group(1);
            System.out.print("nsLogin: "+nsLogins);
        }

        String [] nsLogin = nsLogins.split("\\|");
        LoginInfo rLoginInfo = iLoginInfo;
        rLoginInfo.setMaNvThu(nsLogin[2]);
        rLoginInfo.setInfores(nsLogin[0]);
        rLoginInfo.setMaTinh(nsLogin[1]);
        return rLoginInfo;
    }

    List<CusInfo> GetBill(LoginInfo iLoginInfo, int mode) throws IOException {
        String numrec = "2";

         String req = String.format(myConstatnS.GetBill,
                 iLoginInfo.getMaNvThu(),
                 iLoginInfo.getMaTinh(),
                 mode,
                 iLoginInfo.getReCorNum(),
                 1,
                 iLoginInfo.getUserName(),
                iLoginInfo.getPassWord(),
                iLoginInfo.getSerial(),
                iLoginInfo.getUserName());

        String loginres = mySendReq.SendPostRequest(req,"ref");

        String pattern = "<ns:return>(.*)<\\/ns:return>";
        Pattern r = Pattern.compile(pattern);
        Matcher imatch = r.matcher(loginres);
        LoginInfo myLoginInfo = new LoginInfo();
        String nsLogins = "";
        if(imatch.find()) {
            nsLogins = imatch.group(1);
            System.out.print("nsLogin: "+nsLogins);
        }

        if(mode == 2) {
            String RecNum = myJsonParser.GetOneValue("RECORD",nsLogins,0);
            System.out.println("RecNum: "+RecNum);
            iLoginInfo.setReCorNum(RecNum);
        }
        else
        {
            List<CusInfo> myCusInFo = myJsonParser.GetListValue("RECORD",nsLogins,1);
            return myCusInFo;
        }

        return new ArrayList<CusInfo>();
    }

    List<KyThue> GetKyThue(CusInfo iCusInfo, LoginInfo iLoginInfo) throws IOException {
        String req = String.format(myConstatnS.GetKyThue,
                iCusInfo.getMSt(),
                iCusInfo.getMA_TINH(),
                iLoginInfo.getUserName(),
                iLoginInfo.getPassWord(),
                iLoginInfo.getSerial(),
                iLoginInfo.getUserName()
                );
        String loginres = mySendReq.SendPostRequest(req,"ref");
        String pattern = "<ns:return>(.*)<\\/ns:return>";
        Pattern r = Pattern.compile(pattern);
        Matcher imatch = r.matcher(loginres);
        LoginInfo myLoginInfo = new LoginInfo();
        String nsLogins = "";
        if(imatch.find()) {
            nsLogins = imatch.group(1);
            System.out.print("nsLogin: "+nsLogins);
        }

        List<KyThue> myKyThueList = myJsonParser.GetListValue("RECORD",nsLogins,2);
        return  myKyThueList;
    }

    List<ttno> GetTTNo(CusInfo iCusInfo,LoginInfo iLoginInfo,String kythue) throws IOException {
         String req = String.format(myConstatnS.GetTTNo,
                iCusInfo.getMSt(),
                iCusInfo.getMA_TINH(),
                kythue,
                iLoginInfo.getUserName(),
                iLoginInfo.getPassWord(),
                iLoginInfo.getSerial(),
                iLoginInfo.getUserName()
                );
        String loginres = mySendReq.SendPostRequest(req,"ref");
        String pattern = "<ns:return>(.*)<\\/ns:return>";
        Pattern r = Pattern.compile(pattern);
        Matcher imatch = r.matcher(loginres);
        LoginInfo myLoginInfo = new LoginInfo();
        String nsLogins = "";
        if(imatch.find()) {
            nsLogins = imatch.group(1);
            System.out.print("nsLogin: "+nsLogins);
        }

        List<ttno> myttno = myJsonParser.GetListValue("RECORD",nsLogins,3);
        return  myttno;
    }
}
