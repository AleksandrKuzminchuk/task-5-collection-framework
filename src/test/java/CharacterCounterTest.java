package test.java;

import main.java.CharacterCounter;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CharacterCounterTest {

    CharacterCounter characterCounter = new CharacterCounter();

    @Test
    @Order(1)
    void shouldIncreaseCacheOncePerUniqueCompute() {
        Map<String, LinkedHashMap<Character, Integer>> cacheCopyStart =
                characterCounter.getCacheCopy();
        assertTrue(cacheCopyStart != null && cacheCopyStart.isEmpty());

        characterCounter.count("actual");
        Map<String, LinkedHashMap<Character, Integer>> cacheCopyAfterFirstResult =
                characterCounter.getCacheCopy();
        assertTrue(cacheCopyAfterFirstResult != null && cacheCopyAfterFirstResult.size() == 1);

        characterCounter.count(new String("actual"));
        Map<String, LinkedHashMap<Character, Integer>> cacheCopyAfterSecondResult =
                characterCounter.getCacheCopy();
        assertTrue(cacheCopyAfterSecondResult != null && cacheCopyAfterSecondResult.size() == 1);

    }

    @Test
    @Order(2)
    void shouldCountFasterThanFirstTime() {
        String string = "hello world!hello world!hello world!hello world!hello world!hello world!hello world!" +
                "hello world!hello world!hello world!hello world!hello world!hello world!hello world!hello " +
                "world!hello world!hello world!hello world!hello world!hello world!hello world!hello world!hello world!" +
                "hello world!hello world!hello world!hello world!hello world!hello world!hello world!hello world!hello world!" +
                "hello world!hello world!hello world!hello world!hello world!hello world!hello world!hello world!hello world!" +
                "hello world!hello world!";

        long start = System.nanoTime();
        LinkedHashMap<Character, Integer> firstResult = characterCounter.count(string);
        long finish = System.nanoTime();
        long firstResultTime = finish - start;
        assertTrue(firstResult != null && !firstResult.isEmpty());

        start = System.nanoTime();
        LinkedHashMap<Character, Integer> secondResult = characterCounter.count(string);
        finish = System.nanoTime();
        long secondResultTime = finish - start;

        assertTrue(secondResult != null && !secondResult.isEmpty());
        assertEquals(firstResult, secondResult);
        assertTrue(firstResultTime / 10 > secondResultTime);
    }


    @Test
    @Order(3)
    void testCountShouldCountRepeatingCharacters() {
        LinkedHashMap<Character, Integer> expected = getExpected();

        String actual = "hello world!";

        assertEquals(expected, characterCounter.count(actual));
    }

    @Test
    @Order(4)
    void testCountShouldCountSize() {
        LinkedHashMap<Character, Integer> expected = getExpected();

        String actual = "hello world!";

        assertEquals(expected.size(), characterCounter.count(actual).size());
    }

    @Test
    @Order(5)
    void testCountShouldThrowExceptionOnZero() {
        assertThrows(IllegalArgumentException.class,
                () -> characterCounter.count(null));

    }

    private LinkedHashMap<Character, Integer> getExpected() {
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
        return expected;
    }

}
