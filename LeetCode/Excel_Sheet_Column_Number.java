/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * https://oj.leetcode.com/problems/excel-sheet-column-number/
 * LeetCode Problem #171
 */

public class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); ++i) {
            result = result * 26 + (s.charAt(i) - 'A' + 1);
        }
        return result;
    }
}
