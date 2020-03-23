package app.leetcode.p349;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Solution
 * 
 * https://leetcode.com/problems/intersection-of-two-arrays/
 */
public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<>();

        for (int num : nums1) {
            set.add(num);
        }

        ArrayList<Integer> intersect = new ArrayList<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                intersect.add(num);
                set.remove(num);
            }
        }

        int i = 0;
        int[] result = new int[intersect.size()];
        for (int num : intersect) {
            result[i++] = num;
        }
        return result;
    }
}