import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bean on 18/07/2017.
 */
public class JsonParserC {
    private String skey;
    private String SearchRes;
    private String CurrentKey;
    private CusInfo myCusInfo;
    private List<CusInfo> CustList;
    private KyThue myKyThue;
    private List<KyThue> KyThueList;
    private ttno myttno;
    private List<ttno> mylistttno;
    int ifmode = 0;
    String GetOneValue(String ikey,String ijson,int fmode) throws IOException {
        skey = ikey;
        ifmode = fmode;
        System.out.println(ijson);
        //String json = "[{\"RECORD\":\"1045\"}]";
        JsonReader jsonReader = new JsonReader(new StringReader(ijson));

        try {
            while (jsonReader.hasNext()) {
                JsonToken nextToken = jsonReader.peek();
                System.out.println(nextToken);
                if (nextToken.equals(JsonToken.END_ARRAY)) {
                    jsonReader.endArray();
                    break;
                } else if (nextToken.equals(JsonToken.BEGIN_OBJECT)) {
                    handleObject(jsonReader);
                } else if (nextToken.equals(JsonToken.END_OBJECT)) {
                    jsonReader.endObject();
                }
                else if (JsonToken.END_DOCUMENT.equals(nextToken))
                {
                    break;
                }
                else if (JsonToken.BEGIN_ARRAY.equals(nextToken))
                {
                    handleArray(jsonReader);
                }
                else
                {

                    handleNonArrayToken(jsonReader, nextToken);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SearchRes;
    }

    <T> T GetListValue(String ikey,String ijson,int fmode) throws IOException {
        skey = ikey;
        ifmode = fmode;
        System.out.println(ijson);
        //String json = "[{\"RECORD\":\"1045\"}]";
        JsonReader jsonReader = new JsonReader(new StringReader(ijson));
        if(fmode == 1) {
            CustList = new ArrayList<CusInfo>();
        }
        else if (fmode == 2)
        {
            KyThueList = new ArrayList<KyThue>();
        }
        else if (fmode == 3)
        {
            mylistttno = new ArrayList<ttno>();
        }
        try {
            while (jsonReader.hasNext()) {
                JsonToken nextToken = jsonReader.peek();
                System.out.println(nextToken);
                if (nextToken.equals(JsonToken.END_ARRAY)) {
                    jsonReader.endArray();
                    break;
                } else if (nextToken.equals(JsonToken.BEGIN_OBJECT)) {
                    handleObject(jsonReader);
                } else if (nextToken.equals(JsonToken.END_OBJECT)) {
                    jsonReader.endObject();
                }
                else if (JsonToken.END_DOCUMENT.equals(nextToken))
                {
                    break;
                }
                else if (JsonToken.BEGIN_ARRAY.equals(nextToken))
                {
                    handleArray(jsonReader);
                }
                else
                {
                    handleNonArrayToken(jsonReader, nextToken);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(fmode == 1) {
            return (T) CustList;
        }
        else if (fmode == 2)
        {
            return (T) KyThueList;
        }
        else if (fmode == 3)
        {
            return (T) mylistttno;
        }
        return (T) null;
    }

    public void handleArray(JsonReader reader) throws IOException
    {
        reader.beginArray();

        while (true) {
            JsonToken token = reader.peek();
            System.out.println(token);
            if (token.equals(JsonToken.END_ARRAY)) {
                reader.endArray();
                break;
            } else if (token.equals(JsonToken.BEGIN_OBJECT)) {
                reader.beginObject();
                if(ifmode == 1)
                {
                    myCusInfo = new CusInfo();
                }
                else if (ifmode == 2)
                {
                    myKyThue = new KyThue();
                }
                else if (ifmode == 3)
                {
                    myttno = new ttno();
                }
            } else if (token.equals(JsonToken.END_OBJECT)) {
                reader.endObject();
                if(ifmode == 1)
                {
                    CustList.add(myCusInfo);
                }
                else if(ifmode == 2)
                {
                    KyThueList.add(myKyThue);
                }
                else if (ifmode == 3)
                {
                    mylistttno.add(myttno);
                }
            } else
                handleNonArrayToken(reader, token);
        }
    }

    public void handleNonArrayToken(JsonReader reader, JsonToken token) throws IOException
    {
        if (token.equals(JsonToken.NAME)) {
            CurrentKey = reader.nextName();
            System.out.println("NAME: "+ CurrentKey);

        }
        else if (token.equals(JsonToken.STRING)) {
            if(CurrentKey.equals(skey))
            {
                SearchRes = reader.nextString();
                System.out.println("STRING: " + SearchRes);
            }
            else if(ifmode == 1)
            {
                handleCusInfo(reader.nextString());
            }
            else if(ifmode == 2)
            {
                handleKyThue(reader.nextString());
            }
            else if(ifmode == 3)
            {
                handleTTNO(reader.nextString());
            }
            else
                System.out.println("STRING: " + reader.nextString());
        }
        else if (token.equals(JsonToken.NUMBER)) {
            System.out.println("NUMBER: " + reader.nextDouble());
        }
        else {
            reader.skipValue();
        }
    }
    private void handleObject(JsonReader reader) throws IOException
    {
        reader.beginObject();
        while (reader.hasNext()) {
            JsonToken token = reader.peek();
            if (token.equals(JsonToken.BEGIN_ARRAY))
                handleArray(reader);
            else if (token.equals(JsonToken.END_OBJECT)) {
                reader.endObject();
                return;
            } else
                handleNonArrayToken(reader, token);
        }

    }

    private void handleCusInfo(String iContent)
    {
        if(CurrentKey.equals("MST"))
        {
            myCusInfo.setMSt(iContent);
        }
        else if(CurrentKey.equals("TEN_NNT"))
        {
            myCusInfo.setTEN_NNT(iContent);
        }
        else if(CurrentKey.equals("SO"))
        {
            myCusInfo.setS0(iContent);
        }
        else if(CurrentKey.equals("MA_CQT_QL"))
        {
            myCusInfo.setMA_CQT_QL(iContent);
        }
        else if(CurrentKey.equals("MOTA_DIACHI"))
        {
            myCusInfo.setMOTA_DIACHI(iContent);
        }
        else if(CurrentKey.equals("MA_TINH"))
        {
            myCusInfo.setMA_TINH(iContent);
        }
        else if(CurrentKey.equals("MA_HUYEN"))
        {
            myCusInfo.setMA_HUYEN(iContent);
        }
        else if(CurrentKey.equals("MA_XA"))
        {
            myCusInfo.setMA_XA(iContent);
        }
        else if(CurrentKey.equals("SO_NHA"))
        {
            myCusInfo.setSO_NHA(iContent);
        }
        else if(CurrentKey.equals("DIACHI_TT"))
        {
            myCusInfo.setDIACHI_TT(iContent);
        }
        else if(CurrentKey.equals("MA_TINH_TT"))
        {
            myCusInfo.setMA_TINH_TT(iContent);
        }
        else if(CurrentKey.equals("MA_HUYEN_TT"))
        {
            myCusInfo.setMA_HUYEN_TT(iContent);
        }
        else if(CurrentKey.equals("MA_XA_TT"))
        {
            myCusInfo.setMA_XA_TT(iContent);
        }
        else if(CurrentKey.equals("SO_NHA_TT"))
        {
            myCusInfo.setSO_NHA_TT(iContent);
        }
        else if(CurrentKey.equals("MOBILE"))
        {
            myCusInfo.setMOBILE(iContent);
        }
        else if(CurrentKey.equals("EMAIL"))
        {
            myCusInfo.setEMAIL(iContent);
        }
        else if(CurrentKey.equals("MA_NV"))
        {
            myCusInfo.setMA_NV(iContent);
        }
        else if(CurrentKey.equals("MA_T"))
        {
            myCusInfo.setMA_T(iContent);
        }
        else if(CurrentKey.equals("MA_UNT"))
        {
            myCusInfo.setMA_UNT(iContent);
        }
        else if(CurrentKey.equals("DIA_BAN"))
        {
            myCusInfo.setDIA_BAN(iContent);
        }
        else if(CurrentKey.equals("KBNN"))
        {
            myCusInfo.setKBNN(iContent);
        }
        else if(CurrentKey.equals("DA_GIAO"))
        {
            myCusInfo.setDA_GIAO(iContent);
        }
        else if(CurrentKey.equals("SOTIEN"))
        {
            myCusInfo.setSOTIEN(iContent);
        }


    }

    private void handleKyThue(String iContent)
    {
        if(CurrentKey.equals("ID"))
        {
            myKyThue.setID(iContent);
        }
        else if(CurrentKey.equals("NAME"))
        {
            myKyThue.setName(iContent);
        }
    }

    private  void handleTTNO(String iContent)
    {
        if(CurrentKey.equals("NO_CUOI_KY"))
        {
            myttno.setNO_CUOI_KY(iContent);
        }
        else if(CurrentKey.equals("TIEN_TRA"))
        {
            myttno.setTIEN_TRA(iContent);
        }
        else if(CurrentKey.equals("SOTIEN"))
        {
            myttno.setSOTIEN(iContent);
        }
        else if(CurrentKey.equals("MA_CHUONG"))
        {
            myttno.setMA_CHUONG(iContent);
        }
        else if(CurrentKey.equals("MA_CQ_THU"))
        {
            myttno.setMA_CQ_THU(iContent);
        }
        else if(CurrentKey.equals("MA_TMUC"))
        {
            myttno.setMA_TMUC(iContent);
        }
        else if(CurrentKey.equals("SO_TAIKHOAN_CO"))
        {
            myttno.setSO_TAIKHOAN_CO(iContent);
        }
        else if(CurrentKey.equals("SO_QDINH"))
        {
            myttno.setSO_QDINH(iContent);
        }
        else if(CurrentKey.equals("NGAY_QDINH"))
        {
            myttno.setNGAY_QDINH(iContent);
        }
        else if(CurrentKey.equals("LOAI_TIEN"))
        {
            myttno.setLOAI_TIEN(iContent);
        }
        else if(CurrentKey.equals("TI_GIA"))
        {
            myttno.setTI_GIA(iContent);
        }
        else if(CurrentKey.equals("LOAI_THUE"))
        {
            myttno.setLOAI_THUE(iContent);
        }
        else if(CurrentKey.equals("TEN_CHUONG"))
        {
            myttno.setTEN_CHUONG(iContent);
        }
        else if(CurrentKey.equals("TENTIEUMUC"))
        {
            myttno.setTENTIEUMUC(iContent);
        }
        else if(CurrentKey.equals("KYTHUE"))
        {
            myttno.setKYTHUE(iContent);
        }
        else if(CurrentKey.equals("CHUKY"))
        {
            myttno.setCHUKY(iContent);
        }

    }

}
