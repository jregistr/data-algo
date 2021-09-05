package algos;

import java.util.*;

public class NonRepeating {
    public static Character nonRepeating(String s) {
        if(s.length() == 0) return null;

        char[] asArr = s.toCharArray();
        Map<Character, Integer> freq = makeFrequencyMap(asArr);
        for(char current : asArr) {
            if(freq.get(current) == 1) return current;
        }
        return null;
    }

    private static Map<Character, Integer> makeFrequencyMap(char[] array) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char current : array) {
            freqMap.compute(current, (k,v) -> v == null ? 1 : v + 1);
        }
        return freqMap;
    }
}
