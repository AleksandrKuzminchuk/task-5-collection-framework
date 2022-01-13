package test.java;

import main.java.CacheFormatter;
import main.java.CharacterCounter;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CacheFormatterTest {

    CacheFormatter formatter = new CacheFormatter();

    CharacterCounter characterCounter = new CharacterCounter();

    @Test
    @Order(1)
    void testFormatShouldMakeFormat() {
        String expected = getExpected();

        String actual = "hello world!";

        assertEquals(expected, formatter.format(actual, characterCounter.count(actual)));
    }

    @Test
    @Order(2)
    void testFormatShouldReturnStringWithSameLength() {
        String expected = getExpected();

        String actual = "hello world!";

        assertEquals(expected.length(), formatter.format(actual, characterCounter.count(actual)).length());
    }

    @Test
    @Order(3)
    void testFormatShouldThrowExceptionOnZero() {
        assertThrows(IllegalArgumentException.class,
                () -> formatter.format(null, null));

    }

    private String getExpected() {
        return "hello world!" + "\n"
                + "\"h\" - 1" + "\n"
                + "\"e\" - 1" + "\n"
                + "\"l\" - 3" + "\n"
                + "\"o\" - 2" + "\n"
                + "\" \" - 1" + "\n"
                + "\"w\" - 1" + "\n"
                + "\"r\" - 1" + "\n"
                + "\"d\" - 1" + "\n"
                + "\"!\" - 1" + "\n";
    }

}
