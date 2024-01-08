package com.jregistr.dsa.arrays;

import java.util.Arrays;

public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        int[] found = new int[26];
        for (char ch : s.toCharArray()) {
            int index = ((int)ch) - 97;
            found[index] += 1;
        }

        for (char ch : t.toCharArray()) {
            int index = ((int)ch) - 97;
            found[index] -= 1;
        }

        System.out.println(Arrays.toString(found));

        for (int count : found) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
