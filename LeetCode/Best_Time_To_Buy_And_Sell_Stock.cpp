/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
design an algorithm to find the maximum profit.

LeetCode: https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */

class Solution {
public:
    int maxProfit(vector<int> &prices) {
        if(prices.size() < 2) return 0;
        int min_so_far = prices[0];
        int max_diff = prices[1] - prices[0];
        
        for (int i = 0; i < prices.size(); ++i) {
            if (prices[i] - min_so_far > max_diff)
                max_diff = prices[i] - min_so_far;
            if (prices[i] < min_so_far) 
                min_so_far = prices[i];
        }
        return max_diff;
    }
};
