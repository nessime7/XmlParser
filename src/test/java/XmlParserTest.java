import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class XmlParserTest {

    private static XmlParser xmlParser;

    @Test
    void should_should_return_users_from_users_xml() {
        // given
        String file = "users.xml";

        // when
        var result = xmlParser.parser(file);

        // then
        assertEquals(result,"name: Kalle Anka email: donald@email.dt userName: donaldd\n" +
                "name: Joakim von Anka email: scrooge@email.dt userName: onkelscrooge\n" +
                "name: Arne Anka email: arne@email.com userName: arneanka");
    }
}