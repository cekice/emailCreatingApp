package xpathparser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XpathParser {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, XPathExpressionException {

        XPathFactory xpathfactory = XPathFactory.newInstance();
        XPath xpath = xpathfactory.newXPath();
        XPathExpression expr = xpath.compile("//book[price>10 and translate(publish_date,'-','')>20050101]/title/text()");
        File doc = new File("catalog.xml");
        InputSource inputSource = new InputSource(new FileInputStream(doc));

        System.out.println("Knjige čija je cena veća od 10, a koje su izdate nakon 2005. godine.");

        Object result = expr.evaluate(inputSource, XPathConstants.NODESET);
        NodeList nodes = (NodeList) result;
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getNodeValue());
        }
    }

}
