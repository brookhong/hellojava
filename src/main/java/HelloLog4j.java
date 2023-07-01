import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import com.google.inject.Guice;
import com.google.inject.Injector;

import component.Document;
import component.H1Template;
import lombok.extern.slf4j.Slf4j;
import module.BillingModule;

@Slf4j
public class HelloLog4j {
    private static final String NAMESPACE = "http://schemas.xmlsoap.org/soap/encoding/";

    public static void main(String[] args) {
        H1Template h1 = new H1Template("zh_CN", "B004IJO7K8", new H1Template.Tags("/{desc}/{pageId}/"));
        log.error("This is debug message.");
        log.error(h1.toString());

        Injector injector = Guice.createInjector(new BillingModule());

        Document document = new Document();
        document.setName("jenkins");
        log.error(document.toString());

        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        Date date = new Calendar.Builder().setDate(cal.get(Calendar.YEAR) - 2, cal.get(Calendar.MONTH), 1).build().getTime();
        System.out.println(date);
        try {
            (new HelloLog4j()).testXml();
            throw new RuntimeException("test it");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("exiting");
    }

    public void testXml() throws SOAPException, IOException {
        MessageFactory factory = MessageFactory.newInstance();
        SOAPMessage message = factory.createMessage();

        message.getSOAPHeader().detachNode();
        SOAPBody body = message.getSOAPBody();

        SOAPBodyElement bodyElement = body.addBodyElement(new QName(NAMESPACE, "nciicCheck"));

        SOAPElement inLicenseElem = bodyElement.addChildElement("inLicense");
        inLicenseElem.addTextNode("dde1iio1880ac");

        SOAPElement inConditionsElem = bodyElement.addChildElement("inConditions");
        inConditionsElem.addTextNode("abc: good");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        message.writeTo(out);
        String strMsg = new String(out.toByteArray(), "utf-8");
        System.out.println(strMsg);
    }
}
