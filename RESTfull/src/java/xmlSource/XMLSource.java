package xmlSource;

import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.w3c.dom.Document;


public class XMLSource{
   private Document readData() throws Exception {  

    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    return builder.parse("translation.xml");
    
   } 
   

    public String getTranslation(String original, String originalLanguage, String outputLanguage) throws Exception {

        Document doc = readData();
        XPathFactory xpf = XPathFactory.newInstance();
        XPath xp = xpf.newXPath();
        XPathExpression xpe = xp.compile("/translation/word/" + outputLanguage + "[../" + originalLanguage 
                + "/text()='" + original + "'] ");
        String translated = (String) xpe.evaluate(doc, XPathConstants.STRING);
        return translated;

    }
    
}
