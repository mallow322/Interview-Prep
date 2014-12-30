/**
 * Problem #172
 * https://oj.leetcode.com/problems/factorial-trailing-zeroes/
 * Given an integer n, return the number of trailing zeroes in n!.
 */
class Solution {
public:
    /**
     * Note that all trailing zeroes from factors 5 * 2.  However, sometimes one number may have several 5 factors.  For example, 25 has two 5 factors;
     * 125 has three 5 factors.  In the n! operation, factors of 2 are plentiful.  So, we can just count how many factors of 5 are in the number from 1 to n.
     */
    int trailingZeroes(int n) {
       return n == 0 ? 0 : n/5 + trailingZeroes(n/5);
    }
};
