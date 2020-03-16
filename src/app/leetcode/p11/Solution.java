package app.leetcode.p11;

/**
 * MaxArea
 * for more, please refer to https://leetcode.com/problems/container-with-most-water/
 */
public class Solution {

    public int maxArea(int[] height) {
        int area = 0;
        int length = height.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                area = Math.max(area, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return area;
    }

    public int maxArea2(int[] height) {
        int area = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            area = Math.max(area, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return area;
    }

    public int maxArea3(int[] height) {
        int area = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int minHeight = height[left] < height[right] ? height[left++] : height[right--];
            area = Math.max(area, (right - left + 1) * minHeight);
        }

        return area;
    }

    public static void main(String[] args) {
        int[] values = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        int area = new Solution().maxArea2(values);

        System.out.println(area);
    }
}