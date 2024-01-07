package com.jregistr.dsa.arrays;

import java.util.HashSet;

// https://leetcode.com/problems/contains-duplicate/
public class ContainsDups {
    public boolean containsDuplicate(int[] nums) {
        var set = new HashSet<>();
        for (var num : nums) {
            if (set.contains(num)) {
                return true;
            }

            set.add(num);
        }
        return false;
    }
}
