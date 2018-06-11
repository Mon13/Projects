import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



public class SaxParser4XMLdataStore extends DefaultHandler {
    Product p = new Product();
    List<Product> p_list;
    String productXmlFileName;
    String elementValueRead;
	HttpSession session;

    
    public SaxParser4XMLdataStore(String productXmlFileName,HttpSession session) {
        this.productXmlFileName = productXmlFileName;
        p_list = new ArrayList<Product>();
        parseDocument();
        session.setAttribute("productlist",p_list);
    }

    private void parseDocument() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(productXmlFileName, this);
        } catch (ParserConfigurationException e) {
            System.out.println("ParserConfig error");
        } catch (SAXException e) {
            System.out.println("SAXException : xml not well formed");
        } catch (IOException e) {
            System.out.println("IO error");
			e.printStackTrace();
        }
    }


    @Override
    public void startElement(String str1, String str2, String elementName, Attributes attributes) throws SAXException {

        if (elementName.equalsIgnoreCase("product")) {
            p = new Product();
            p.setId(attributes.getValue("id"));
            p.setRetailer(attributes.getValue("retailer"));
        }

    }

    @Override
    public void endElement(String str1, String str2, String element) throws SAXException {
 
        if (element.equals("product")) {
            p_list.add(p);
	    return;
        }
        if (element.equalsIgnoreCase("image")) {
            p.setImage(elementValueRead);
	    return;
        }
        if (element.equalsIgnoreCase("type")) {
            p.setType(elementValueRead);
	    return;
        }
        if (element.equalsIgnoreCase("name")) {
            p.setName(elementValueRead);
	    return;
        }
        
        if(element.equalsIgnoreCase("price")){
            p.setPrice(Integer.parseInt(elementValueRead));
	    return;
        }

    }

    @Override
    public void characters(char[] content, int begin, int end) throws SAXException {
        elementValueRead = new String(content, begin, end);
    }


    

}
