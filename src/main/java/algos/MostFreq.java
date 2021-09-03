package algos;

import java.util.HashMap;
import java.util.Map;

public class MostFreq {

    public int mostFreq(int[] numbers) {
        if(numbers.length == 0)  return 0;
        Map<Integer, Integer> found = new HashMap<>();

        int mostOcc = numbers[0];
        int mostOccCount = 1;
        found.put(mostOcc, mostOccCount);

        for(int i = 1; i < numbers.length; i ++) {
            int num = numbers[i];
            int foundCount = found.compute(num, (k, v) -> v == null ? 1 : v + 1);
            if(foundCount > mostOccCount) {
                mostOccCount = foundCount;
                mostOcc = num;
            }
        }
        return mostOcc;
    }
}