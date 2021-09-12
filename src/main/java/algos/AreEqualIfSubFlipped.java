package algos;

public class AreEqualIfSubFlipped {
    boolean areTheyEqual(int[] array_a, int[] array_b) {
        assert array_a.length == array_b.length : "The arrays were of different sizes, invalid input";
        int n = array_a.length;
        // Write your code here
        int leftBreakPointer = 0;
        while(leftBreakPointer < n) {
            if(array_a[leftBreakPointer] != array_b[leftBreakPointer]) {
                break;
            }
            leftBreakPointer++;
        }

        if(leftBreakPointer >= n) {
            return true;
        }

        // find where things are not equal from the back
        int backBreakPointer = n - 1;
        while(backBreakPointer > leftBreakPointer) {
            if(array_a[backBreakPointer] != array_b[backBreakPointer]) {
                break;
            }
            backBreakPointer--;
        }

        int aSearchPointer = leftBreakPointer;
        int bSearchPointer = backBreakPointer;

        while((aSearchPointer <= backBreakPointer) && bSearchPointer >= leftBreakPointer) {
            if(array_a[aSearchPointer] != array_b[bSearchPointer]) {
                return false;
            }
            aSearchPointer ++;
            bSearchPointer --;
        }

        return true;
    }

    /*
    Test Cases
     int[] array_a_1 = {1, 2, 3, 4};
    int[] array_b_1 = {1, 4, 3, 2};
    boolean expected_1 = true;
    boolean output_1 = areTheyEqual(array_a_1, array_b_1);
    check(expected_1, output_1);

    int[] array_a_2 = {1, 2, 3, 4};
    int[] array_b_2 = {1, 4, 3, 3};
    boolean expected_2 = false;
    boolean output_2 = areTheyEqual(array_a_2, array_b_2);
    check(expected_2, output_2);
    // Add your own test cases here

    int[] array_a_3 = {1, 3, 2, 0, 5};
    int[] array_b_3 = {1, 3, 0, 2, 5};
    boolean expected_3 = true;
    boolean output_3 = areTheyEqual(array_a_3, array_b_3);
    check(expected_3, output_3);

    // are equal without any flipping
    int[] array_a_4 = {1, 2, 3, 4, 5};
    int[] array_b_4 = {1, 2, 3, 4, 5};
    boolean expected_4 = true;
    boolean output_4 = areTheyEqual(array_a_4, array_b_4);
    check(expected_4, output_4);
     */
}
