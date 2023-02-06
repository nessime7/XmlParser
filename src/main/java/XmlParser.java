import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class XmlParser {

    public String parser(String fileName) {
        final var resultBuilder = new StringBuilder();
        try {
            final var factory = DocumentBuilderFactory.newInstance();
            final var builder = factory.newDocumentBuilder();
            final var document = builder.parse(fileName);
            final var nodeList = document.getDocumentElement().getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                final var node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    final var element = (Element) node;
                    final var name = element.getElementsByTagName("name").item(0).getTextContent();
                    final var email = element.getElementsByTagName("email").item(0).getTextContent();
                    final var userName = element.getElementsByTagName("username").item(0).getTextContent();
                    resultBuilder.append("name: ").append(name).append("\n").append(" email: ").append(email).append("\n").append(" userName: ").append(userName).append("\n");
                }
            }

        } catch (SAXException | IOException | ParserConfigurationException e) {
            System.err.println("Error parsing XML: " + e.getMessage());
        }
        return resultBuilder.toString();
    }
}
