package app.leetcode.p509;

/**
 * Fibonacci
 * 
 * for more, please refer to https://leetcode.com/problems/fibonacci-number/
 */
public class Solution {

    // n < 2 ? 1 : (Fib(n-1) + Fib(n-2));
    public int fib(int N) {
        int fn = 1, fnn = 1, fnnn = 0;
        if (N == 0)
            return fnnn;
        if (N == 1)
            return fnn;
        for (int i = 2; i <= N; i++) {
            fn = fnn + fnnn;
            fnnn = fnn;
            fnn = fn;
        }
        return fn;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fib(10));
        System.out.println(new Solution().fib(20));
        System.out.println(new Solution().fib(30));
    }
}