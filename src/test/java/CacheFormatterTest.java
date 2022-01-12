package test.java;

import main.java.CacheFormatter;
import main.java.CharacterCounter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CacheFormatterTest {

    CacheFormatter formatter;

    CharacterCounter characterCounter;

    @BeforeEach
    void initCacheFormatter() {
        formatter = new CacheFormatter();
    }

    @BeforeEach
    void initCharacterCounter() {
        characterCounter = new CharacterCounter();
    }


    @Test
    void testFormatShouldMakeFormat() {
        String expected = "hello world!" + "\n"
                + "\"h\" - 1" + "\n"
                + "\"e\" - 1" + "\n"
                + "\"l\" - 3" + "\n"
                + "\"o\" - 2" + "\n"
                + "\" \" - 1" + "\n"
                + "\"w\" - 1" + "\n"
                + "\"r\" - 1" + "\n"
                + "\"d\" - 1" + "\n"
                + "\"!\" - 1" + "\n";

        String actual = "hello world!";

        assertEquals(expected, formatter.format(actual, characterCounter.count(actual)));
    }

    @Test
    void testFormatShouldReturnStringWithSameLength() {
        String expected = "hello world!" + "\n"
                + "\"h\" - 1" + "\n"
                + "\"e\" - 1" + "\n"
                + "\"l\" - 3" + "\n"
                + "\"o\" - 2" + "\n"
                + "\" \" - 1" + "\n"
                + "\"w\" - 1" + "\n"
                + "\"r\" - 1" + "\n"
                + "\"d\" - 1" + "\n"
                + "\"!\" - 1" + "\n";

        String actual = "hello world!";

        assertEquals(expected.length(), formatter.format(actual, characterCounter.count(actual)).length());
    }

    @Test
    void testFormatShouldThrowExceptionOnZero() {
        assertThrows(IllegalArgumentException.class,
                () -> formatter.format(null, null));

    }
}
