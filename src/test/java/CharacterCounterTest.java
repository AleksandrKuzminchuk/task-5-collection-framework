package test.java;

import main.java.CharacterCounter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;

public class CharacterCounterTest {

    CharacterCounter characterCounter;

    @BeforeEach
    @Test
    void init() {

        characterCounter = new CharacterCounter();
    }

    @Test
    void testCountShouldCountRepeatingCharacters() {
        LinkedHashMap<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('h', 1);
        expected.put('e', 1);
        expected.put('l', 3);
        expected.put('o', 2);
        expected.put(' ', 1);
        expected.put('w', 1);
        expected.put('r', 1);
        expected.put('d', 1);
        expected.put('!', 1);

        String actual = "hello world!";

        assertEquals(expected, characterCounter.count(actual));
    }

    @Test
    void testCountShouldCountSize() {
        LinkedHashMap<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('h', 1);
        expected.put('e', 1);
        expected.put('l', 3);
        expected.put('o', 2);
        expected.put(' ', 1);
        expected.put('w', 1);
        expected.put('r', 1);
        expected.put('d', 1);
        expected.put('!', 1);

        String actual = "hello world!";

        assertEquals(expected.size(), characterCounter.count(actual).size());
    }

    @Test
    void testCountShouldThrowExceptionOnZero() {
        assertThrows(IllegalArgumentException.class,
                () -> characterCounter.count(null));

    }

}
