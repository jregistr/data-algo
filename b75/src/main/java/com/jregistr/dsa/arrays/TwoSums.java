package com.jregistr.dsa.arrays;

import java.util.HashMap;

public class TwoSums {
    public int[] twoSum(int[] nums, int target) {
        var prev = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i ++) {
            int num = nums[i];
            int other = target - num;

            if (prev.containsKey(other)) {
                return new int[]{i, prev.get(other)};
            } else {
                prev.put(num, i);
            }
        }

        return new int[]{};
    }
}
