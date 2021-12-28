package main.resources;

import java.util.*;


public class CharacterCounter {

    private List chars = new ArrayList();

    public void countTheNumberOfCharactersInYheString(String str) {

        requiredNonNull(str);

        System.out.println(str);


        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (isProcessedChar(ch))
                continue;

            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                if (ch == str.charAt(j)) {
                    count++;
                }
            }
            System.out.println("\"" + ch + "\"" + " - " + count);
        }
        chars.clear();

    }

    // checking whether the given char is already processed or not
    private boolean isProcessedChar(char ch) {

        if (chars.contains(Character.toString(ch))) {
            return true;
        } else {
            chars.add(Character.toString(ch));
        }
        return false;
    }

    private void requiredNonNull(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Non null input string required!");
        }
    }
}
