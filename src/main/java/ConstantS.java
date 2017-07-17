/**
 * Created by bean on 17/07/2017.
 */
public class ConstantS {
    public String loginreq = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:vms=\"http://vms.neo\">\n" +
            "   <soap:Header/>\n" +
            "   <soap:Body>\n" +
            "      <vms:value>\n" +
            "      <vms:Service>login_service_ws</vms:Service>\n" +
            "      <vms:Provider>default</vms:Provider>\n" +
            "      <vms:ParamSize>4</vms:ParamSize>\n" +
            "      <vms:P1>%s</vms:P1>\n" +
            "      <vms:P2>%s</vms:P2>\n" +
            "      <vms:P3>bidv_4924dd9882a72c371770a8e9babfd825</vms:P3>\n" +
            "      <vms:P4>POS|%s</vms:P4>\n" +
            "      </vms:value>\n" +
            "   </soap:Body>\n" +
            "</soap:Envelope>";
    public String loginInfo = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:vms=\"http://vms.neo\">\n" +
            "   <soap:Header/>\n" +
            "   <soap:Body>\n" +
            "      <vms:value>\n" +
            "         <vms:Service>crud_map_user_agent</vms:Service>\n" +
            "         <vms:Provider>default</vms:Provider>\n" +
            "         <vms:ParamSize>5</vms:ParamSize>\n" +
            "         <vms:P1>%s</vms:P1>\n" +
            "         <vms:P2>%s</vms:P2>\n" +
            "         <vms:P3>bidv_4924dd9882a72c371770a8e9babfd825</vms:P3>\n" +
            "         <vms:P4>%s</vms:P4>\n" +
            "         <vms:P5>POS|%s</vms:P5>\n" +
            "      </vms:value>\n" +
            "   </soap:Body>\n" +
            "</soap:Envelope>";
    public String GetBill = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:vms=\"http://vms.neo\">\n" +
            "   <soap:Header/>\n" +
            "   <soap:Body>\n" +
            "      <vms:ref>\n" +
            "         <vms:Service>crud_ds_giao_phieu</vms:Service>\n" +
            "         <vms:Provider>default</vms:Provider>\n" +
            "         <vms:ParamSize>10</vms:ParamSize>\n" +
            "         <vms:P1>%s</vms:P1>\n" +
            "         <vms:P2>%s</vms:P2>\n" +
            "         <vms:P3>%d</vms:P3>\n" +
            "         <vms:P4>%s</vms:P4>\n" +
            "         <vms:P5>%s</vms:P5>\n" +
            "         <vms:P6>%s</vms:P6>\n" +
            "         <vms:P7>%s</vms:P7>\n" +
            "         <vms:P8>bidv_4924dd9882a72c371770a8e9babfd825</vms:P8>\n" +
            "         <vms:P9>%s</vms:P9>\n" +
            "         <vms:P10>POS|%s</vms:P10>\n" +
            "      </vms:ref>\n" +
            "   </soap:Body>\n" +
            "</soap:Envelope>";
}
