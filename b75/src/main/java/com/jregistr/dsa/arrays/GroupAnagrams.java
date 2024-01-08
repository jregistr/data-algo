package com.jregistr.dsa.arrays;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*
        for each str in array
        we sort the characters of that string. Then
        Check if it is in array. If not, add the sort as the key. And the str in a new list.
        If we did find it in the array, then append to list
        */
        final Map<String, List<String>> anagrams = new HashMap<>();
        for (String str : strs) {
            char[] asChars = str.toCharArray();
            Arrays.sort(asChars);
            String sortedStr = new String(asChars);

            List<String> likes;
            if (anagrams.containsKey(sortedStr)) {
                likes = anagrams.get(sortedStr);
            } else {
                likes = new ArrayList<>();
                anagrams.put(sortedStr, likes);
            }

            likes.add(str);
        }

        return new ArrayList<>(anagrams.values());
    }
}
