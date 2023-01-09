import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class XmlParser {

    public String parser(String file) {
        try {
            final var factory = DocumentBuilderFactory.newInstance();
            final var builder = factory.newDocumentBuilder();
            final var document = builder.parse(file);
            final var nodeList = document.getDocumentElement().getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                final var node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    final var element = (Element) node;
                    final var name = element.getElementsByTagName("name").item(0).getTextContent();
                    final var email = element.getElementsByTagName("email").item(0).getTextContent();
                    final var userName = element.getElementsByTagName("username").item(0).getTextContent();
                    file = ("name: " + name + " email: " + email + " userName: " + userName);
                    //   System.out.println("name: " + name + " email: " + email + " userName: " + userName);
                }
            }
        } catch (SAXException | IOException | ParserConfigurationException e) {
            System.err.println("Error parsing XML: " + e.getMessage());
        }
        return file;
    }

}
