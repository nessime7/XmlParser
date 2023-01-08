import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class XmlParser {
    public static void main(String[] args) {
        String file = args[0];
        parser(file);
    }

    public static String parser(String file) {
        try {
            // tworzymy instancję fabryki
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // przeneanalizuj dokument users.xml
            DocumentBuilder builder = factory.newDocumentBuilder();
//            Document document = builder.parse("users.xml");
            Document document = builder.parse(file);
            // get users
            NodeList nodeList = document.getDocumentElement().getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    String email = element.getElementsByTagName("email").item(0).getTextContent();
                    String userName = element.getElementsByTagName("username").item(0).getTextContent();
                    System.out.println("name: " + name + " email: " + email + " userName: " + userName);
                }
            }
        } catch (SAXException | IOException | ParserConfigurationException e) {
            System.err.println("Error parsing XML: " + e.getMessage());
        }
        return file;
    }
}