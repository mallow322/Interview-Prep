/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * Excel Sheet Column Title 
 * Problem #168 LeetCode
 */
class Solution {
public:
    string convertToTitle(int n) {
        return n == 0 ? "" : convertToTitle((n - 1) / 26) + (char) ((n - 1) % 26 + 'A');
    }
};
