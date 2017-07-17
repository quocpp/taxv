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

public class MainController {
    private ConstantS myConstatnS;
    SendRequest mySendReq;
    XmlParser myXmlParser;
    public MainController() {

        myConstatnS = new ConstantS();
        mySendReq = new SendRequest();
        myXmlParser = new XmlParser();
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
        String nsLogins = myXmlParser.GetTagValue(loginres,"ns:return");
        String [] nsLogin = nsLogins.split("\\|");
        LoginInfo myLoginInfo = new LoginInfo(nsLogin[0],nsLogin[1]);
        myLoginInfo.setUserName(user);
        myLoginInfo.setPassWord(hashpass);
        return myLoginInfo;
    }

    public LoginInfo GetUserInfo(LoginInfo iLoginInfo ) throws IOException {

        String req = String.format(myConstatnS.loginInfo,
                                   iLoginInfo.getUserName(),
                                   iLoginInfo.getPassWord(),
                iLoginInfo.getSerial(),
                iLoginInfo.getUserName());

        String loginres = mySendReq.SendPostRequest(req,"value");
        String nsLogins = myXmlParser.GetTagValue(loginres,"ns:return");
        String [] nsLogin = nsLogins.split("\\|");
        LoginInfo rLoginInfo = iLoginInfo;
        rLoginInfo.setMaNvThu(nsLogin[2]);
        rLoginInfo.setInfores(nsLogin[0]);
        rLoginInfo.setMaTinh(nsLogin[1]);
        return rLoginInfo;
    }

    LoginInfo GetBill(LoginInfo iLoginInfo, int mode) throws IOException {
        String numrec = "2";

         String req = String.format(myConstatnS.GetBill,
                 iLoginInfo.getMaNvThu(),
                 iLoginInfo.getMaTinh(),
                 mode,
                 numrec,
                 1,
                 iLoginInfo.getUserName(),
                iLoginInfo.getPassWord(),
                iLoginInfo.getSerial(),
                iLoginInfo.getUserName());

        String loginres = mySendReq.SendPostRequest(req,"ref");
        String nsLogins = myXmlParser.GetTagValue(loginres,"ns:return");
        return new LoginInfo();

    }
}
