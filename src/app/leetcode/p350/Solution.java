package app.leetcode.p350;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Solution
 * 
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */
public class Solution {
    public int[] intersection2(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int num : nums1) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int num : nums2) {
            if (map.containsKey(num)) {
                list.add(num);
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0) {
                    map.remove(num);
                }
            }
        }

        int[] nums = new int[list.size()];
        int i = 0;
        for (int num : list) {
            nums[i++] = num;
        }

        return nums;
    }
}