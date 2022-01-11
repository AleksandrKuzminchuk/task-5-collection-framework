package main.java;

import java.util.*;

public class CharacterCounter {

    private static LinkedHashMap<String, Integer> cache = new LinkedHashMap<>();

    public LinkedHashMap<String, Integer> countTheNumberOfCharactersInTheString(String str) {

        requiredNonNull(str);

        String[] splitString = str.split("");

        LinkedHashSet<String> listSymbols = new LinkedHashSet<>(Arrays.asList(splitString));

        LinkedHashMap<String, Integer> count = new LinkedHashMap<>();

        for (String s1 : listSymbols) {
//            if(listSymbols.equals(cache)){
//                return cache;
//            }
            int num = 0;
            for (int i = 0; i < splitString.length; i++) {
                if (s1.equals(splitString[i])) {
                    num++;
                }
            }
            count.put(s1, num);
        }

//        cache.putAll(count);
        System.out.println(str);
        return count;
    }

    public void makeView(LinkedHashMap<String, Integer> map) {
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println("\"" + entry.getKey() + "\"" + " - " + entry.getValue());
        }

    }

    private void requiredNonNull(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Non null input string required!");
        }
    }
}


