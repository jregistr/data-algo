package algos;
import java.util.*;
import java.util.stream.*;


public class IsRotationOf {
    public static Boolean isRotationOf(int[] array1, int[] array2) {
        if(array1.length != array2.length) return false;
        if(array1.length == 0 && array2.length == 0) return true;

        int a0 = array1[0];
        int bIndex = Arrays.stream(array2).boxed().collect(Collectors.toList()).indexOf(a0);
        if(bIndex < 0) return false;

        bIndex++;
        for(int i = 1; i < array1.length; i ++, bIndex++) {
            int bWrapped = bIndex % array2.length;
            if(array1[i] != array2[bWrapped]) return false;
        }

        return true;
    }
}
