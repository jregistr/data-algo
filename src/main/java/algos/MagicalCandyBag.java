package algos;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MagicalCandyBag {
    int maxCandies(int[] arr, int k) {
        if(arr.length == 0) return 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int gobbled = 0;
        fillQueue(arr, queue);
        for(int i = 0; i < k; i ++) {
            int biggest = queue.poll();
            gobbled += biggest;
            int respawned = biggest / 2;
            queue.offer(respawned);
        }
        return gobbled;
    }

    void fillQueue(int[] arr, PriorityQueue<Integer> queue) {
        for(int num : arr) {
            queue.offer(num);
        }
    }
}
