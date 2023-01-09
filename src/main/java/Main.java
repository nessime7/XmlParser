public class Main {
    public static void main(String[] args) {

        final var filePath = args[0];
        final var parsedMessage = new XmlParser().parser(filePath);
        new XmlPrinter().print(parsedMessage);
    }
}