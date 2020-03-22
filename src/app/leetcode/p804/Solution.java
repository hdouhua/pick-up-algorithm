package app.leetcode.p804;

import java.util.TreeSet;

/**
 * Solution
 * 
 * please refer to https://leetcode.com/problems/unique-morse-code-words/
 */
class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseCodes = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
                "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };

        TreeSet<String> set = new TreeSet<>();
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                sb.append(morseCodes[word.charAt(i) - 'a']);
            }
            set.add(sb.toString());
            sb.setLength(0);
        }

        return set.size();
    }
}