package algos;
import java.util.*;

//f
public class MedianStream {

    // n * ((n / 2) * nlog(n) + n + n(log(n)) - WRONG. PQ ops are log(n)
    // n^2log(n) WRONG. PQ ops are log(n)



    // n + n => O(n) space
    // n * (2log(n) + n)
    //2nlog(n) + n^2
    // O(n^2) or is it? nlog(n)
    int[] findMedian(int[] arr) {
        int n = arr.length;
        int[] output = new int[n];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < n; i ++) {
            int ith = arr[i];
            queue.offer(ith);
            int pollCount = (queue.size() - 1) / 2;
            boolean isEven = (queue.size() & 1) == 0;
            List<Integer> hold = new ArrayList<>();

            for(int j = 0; j < pollCount; j++) {
                hold.add(queue.poll());
            }

            // odd
            if(!isEven) {
                int peeked = queue.peek();
                output[i] = peeked;
            } else {
                int a1 = queue.poll();
                int a2 = queue.peek();
                int avg = (a1 + a2) / 2;
                output[i] = avg;
                queue.offer(a1);
            }

            for(int num : hold) {
                queue.offer(num);
            }
        }
        return output;
    }
}
