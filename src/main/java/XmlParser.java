import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class XmlParser {

    public String parser(String file) {
        try {
            var factory = DocumentBuilderFactory.newInstance();
            var builder = factory.newDocumentBuilder();
            var document = builder.parse(file);
            var nodeList = document.getDocumentElement().getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                var node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    var element = (Element) node;
                    var name = element.getElementsByTagName("name").item(0).getTextContent();
                    var email = element.getElementsByTagName("email").item(0).getTextContent();
                    var userName = element.getElementsByTagName("username").item(0).getTextContent();
                    System.out.println("name: " + name + " email: " + email + " userName: " + userName);
                }
            }
            // I want my error message to be red.
        } catch (SAXException | IOException | ParserConfigurationException e) {
            System.err.println("Error parsing XML: " + e.getMessage());
        }
        return file;
    }
}
