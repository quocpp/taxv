import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import sun.misc.IOUtils;
import sun.nio.ch.IOUtil;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Created by bean on 17/07/2017.
 */
public class XmlParser {

    private String TagFind;
    private String ResFind;
    public String GetTagValue(String xmlString,String TagName)
    {
        try {
            TagFind = TagName;
            InputStream in = new ByteArrayInputStream(xmlString.getBytes());
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandler userhandler = new UserHandler();
            saxParser.parse(in, userhandler);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResFind;
    }
    class UserHandler extends DefaultHandler {

        boolean bNsreturn = false;

        @Override
        public void startElement(String uri,
                                 String localName, String qName, Attributes attributes)
                throws SAXException {
                System.out.println("Start: "+ qName);
                if (qName.equalsIgnoreCase(TagFind)) {
                    bNsreturn = true;
                }
        }

        @Override
        public void endElement(String uri,
                               String localName, String qName) throws SAXException {
                System.out.println("End Element :" + qName);
                if (qName.equalsIgnoreCase("ns:return")) {
                    bNsreturn = false;
                }
        }

        @Override
        public void characters(char ch[],
                               int start, int length) throws SAXException {
            if (bNsreturn) {
                ResFind = new String(ch, start, length);
                bNsreturn = false;
            }
        }
    }
}

