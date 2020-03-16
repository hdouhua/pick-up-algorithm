package app.leetcode.p283;

/**
 * MoveZeros for more, plesae refer to
 * https://leetcode.com/problems/move-zeroes/
 */
public class Solution {

    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        int length = nums.length;
        int nonZeroIndex = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex] = nums[i];
                nonZeroIndex++;
            }
        }

        for (; nonZeroIndex < length; nonZeroIndex++) {
            nums[nonZeroIndex] = 0;
        }
    }

    public void moveZeroes3(int[] nums) {
        int length = nums.length;
        int nonZeroIndex = 0;
        int temp;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                temp = nums[nonZeroIndex];
                nums[nonZeroIndex] = nums[i];
                nums[i] = temp;
                nonZeroIndex++;
            }
        }
    }

    public static void main(String[] args) {

        int[] nums = new int[] { 0, 1, 0, 3, 12 };
        new Solution().moveZeroes3(nums);

        for (int x : nums) {
            System.out.print(x);
        }

    }
}