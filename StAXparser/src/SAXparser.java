import java.io.File;
import javax.xml.parsers.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
//knjige čija je cena veća od 10, a koje su izdate nakon 2005. godine.

public class SAXparser {
   private String currentElement;
   private String currentElement1;
   private String currentElement2;
   private int bookCount = 1;
   
   // Constructor
   public SAXparser() {
      try {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
         sp.parse(new File("catalog.xml"), new MyHandler());
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   public static void main(String args[]) {
      new SAXparser();
   }
   
  
   class MyHandler extends DefaultHandler {
      @Override
      public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
         currentElement = qName;
         
         if (currentElement.equals("book") ) {
            System.out.println("Book " + bookCount);
            bookCount++;
            String id = attributes.getValue("id");
            System.out.println("\tId:\t" + id);
            ;
         }
      }
   
      @Override
      public void endElement(String uri, String localName, String qName)
            throws SAXException {
         currentElement = "";
      }
   
      @Override
      public void characters(char[] chars, int start, int length) throws SAXException {
          
         if (currentElement.equals("author")) {
            System.out.println("\tAuthor:\t" + new String(chars, start, length));
         } else if (currentElement.equals("title")) {
            System.out.println("\tTitle:\t" + new String(chars, start, length));
         } else if (currentElement.equals("genre")) {
            System.out.println("\tGendre:\t" + new String(chars, start, length));
         } else if (currentElement.equals("price")) {
            System.out.println("\tPrice:\t" + new String(chars, start, length));
         } else if (currentElement.equals("publish_date")) {
            System.out.println("\tPublish date:\t" + new String(chars, start, length));
         } else if (currentElement.equals("description")) {
            System.out.println("\tDescription:\t" + new String(chars, start, length));
         }
      }
   }
}