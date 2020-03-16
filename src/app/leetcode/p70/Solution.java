package app.leetcode.p70;

/**
 * ClimbStairs
 * for more, please refer to https://leetcode.com/problems/climbing-stairs/
 */
public class Solution {

    public int climbStairs(int n) {
        // if (n == 1) {
        //     return 1;
        // }
        int fn = 1, fnn = 1,  fnnn = 1;
        for (int i = 2; i <= n; i++) {
            fnnn = fnn;
            fnn = fn;
            fn = fnn + fnnn;
        }
        return fn;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(2));
        System.out.println(new Solution().climbStairs(3));
        System.out.println(new Solution().climbStairs(4));
        System.out.println(new Solution().climbStairs(5));
    }

}