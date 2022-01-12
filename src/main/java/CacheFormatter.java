package main.java;

import java.util.LinkedHashMap;
import java.util.Map;

public class CacheFormatter {

    public String format(String str, LinkedHashMap<Character, Integer> values) {
        requiredNonNull(str, values);

        String string = str + "\n" + "";
        for (Map.Entry<Character, Integer> value : values.entrySet()) {
            string = string + "\"" + value.getKey() + "\"" + " - " + value.getValue() + "\n";

        }
        return string;
    }

    private void requiredNonNull(String str, LinkedHashMap<Character, Integer> map) {
        if (str == null && map == null) {
            throw new IllegalArgumentException("Non null input string required!");

        }
    }
}
