package main.java;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CharacterCounter {

    private static Map<String, LinkedHashMap<Character, Integer>> cache = new HashMap<>();

    public LinkedHashMap<Character, Integer> count(String str) {
        requiredNonNull(str);
        if (cache.containsKey(str)) {
            return cache.get(str);
        }
        LinkedHashMap<Character, Integer> newCache = createNewCacheCount(str);
        cache.put(str, newCache);
        return newCache;
    }

    private LinkedHashMap<Character, Integer> createNewCacheCount(String str) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        char[] symbols = str.toCharArray();

        for (char c : symbols) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);

            } else {
                map.put(c, 1);
            }
        }
        return map;
    }

    private void requiredNonNull(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Non null input string required!");
        }
    }
}