package app.leetcode;

/**
 * ClimbStairs
 * for more, please refer to https://leetcode.com/problems/climbing-stairs/
 */
public class ClimbStairs {

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
        System.out.println(new ClimbStairs().climbStairs(2));
        System.out.println(new ClimbStairs().climbStairs(3));
        System.out.println(new ClimbStairs().climbStairs(4));
        System.out.println(new ClimbStairs().climbStairs(5));
    }

}