public class XmlPrinter {

    XmlParser xmlParser = new XmlParser();

    public void print(String parsedMessage) {
        System.out.println(xmlParser.parser(parsedMessage));
    }
}
