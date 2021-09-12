package algos;
import java.util.Comparator;
import java.util.PriorityQueue;
public class Top3Product {
    public static int[] findMaxProduct(int[] arr) {
        // Write your code here
        int n = arr.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int[] output = new int[n];

        for(int i = 0; i < n; i ++) {
            int ith = arr[i];
            queue.offer(ith);
            int qCount = queue.size();
            if(qCount < 3) {
                output[i] = -1;
            } else if(qCount == 3) {
                // we have 3 items. Get product and fill ith item in output
                int product = productQueue(queue);
                output[i] = product;
            } else {
                queue.remove();
                int product = productQueue(queue);
                output[i] = product;
            }
        }

        return output;
    }

    private static int productQueue(PriorityQueue<Integer> queue) {
        Integer[] arr = new Integer[3];
        queue.toArray(arr);

        int product = 1;
        for(int num : arr) {
            product *= num;
        }
        return product;
    }
}
