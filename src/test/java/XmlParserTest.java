import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class XmlParserTest {

    private final Parser parser = new Parser();
    private final Printer printer = new Printer();

    @Test
    void should_should_return_users_from_users_xml() throws ParserConfigurationException, IOException, SAXException {
        // given
        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource("users.xml").getFile());
        var factory = DocumentBuilderFactory.newInstance();
        var builder = factory.newDocumentBuilder();
        var document = builder.parse(file);
        var nodeList = document.getDocumentElement().getChildNodes();


        // when
        //   var result = parser.parser(nodeList);

        // then
        //    assertEquals(result, "name: Kalle Anka email: donald@email.dt userName: donaldd\n" +
        //           "name: Joakim von Anka email: scrooge@email.dt userName: onkelscrooge\n" +
        //           "name: Arne Anka email: arne@email.com userName: arneanka");
    }

    @Test
    public void check_if_file_exist() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource("users.xml").getFile());
        assertTrue(file.exists());
    }
}