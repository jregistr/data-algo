package algos;

public class CountSubArrays {

    public static int[] countSubarrays(int[] arr) {
        // Write your code here
        int[] output = new int[arr.length];
        for(int i = 0; i < arr.length; i ++) {
            int contiguous = 1;
            int ithNum = arr[i];

            int offset = i + 1;
            // look forward
            while(offset < arr.length) {
                int atOff = arr[offset];
                if(atOff < ithNum) {
                    contiguous += 1;
                    offset += 1;
                } else {
                    break;
                }
            }

            offset = i - 1;
            while(offset >= 0) {
                int atOff = arr[offset];
                if(atOff < ithNum) {
                    contiguous ++;
                    offset --;
                } else {
                    break;
                }
            }
            output[i] = contiguous;
        }
        return output;
    }

}
