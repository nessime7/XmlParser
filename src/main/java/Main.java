public class Main {

    private static XmlParser xmlParser;

    public static void main(String[] args) {
        String file = args[0];
        xmlParser.parser(file);
    }
}