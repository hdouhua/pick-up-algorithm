package app.leetcode.p20;

import java.util.Stack;

/**
 * ValidParentheses
 * or more, please refer to https://leetcode.com/problems/valid-parentheses/
 */
class Solution {
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (c == '}' || c == ']' || c == ')') {
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if (c == '}' && top != '{'){
                    return false;
                }
                if (c == ']' && top != '['){
                    return false;
                }
                if (c == ')' && top != '('){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("[]{}]"));
        System.out.println(new Solution().isValid("[]{}[()]"));
    }
}
