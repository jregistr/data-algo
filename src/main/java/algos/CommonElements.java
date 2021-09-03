package algos;
import java.util.*;

public class CommonElements {

    public static Integer[] commonElements(int[] array1, int[] array2) {
        if(array1.length == 0 || array2.length == 0) return new Integer[]{};
        List<Integer> result = new ArrayList<>();

        int a1Index, a2Index;
        a1Index = a2Index = 0;
        while(a1Index < array1.length && a2Index < array2.length) {
            int a1V = array1[a1Index];
            int a2V = array2[a2Index];
            if(a1V == a2V) {
                result.add(a1V);
                a1Index++;
                a2Index++;
            } else if(a1V < a2V) {
                a1Index++;
            } else {
                a2Index++;
            }
        }

        Integer[] resArray = new Integer[result.size()];
        result.toArray(resArray);
        return resArray;
    }
}
