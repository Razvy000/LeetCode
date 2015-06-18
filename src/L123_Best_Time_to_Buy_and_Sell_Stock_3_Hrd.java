
/*
 Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most two transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class L123_Best_Time_to_Buy_and_Sell_Stock_3_Hrd {

    // idea: understand brute force
    // idea: two passes
    public int maxProfit2(int[] prices) {

        int n = prices.length;
        int maxs = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int s = Math.max(0, prices[j] - prices[i]);

                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        s += Math.max(0, prices[l] - prices[k]);
                    }
                }

                maxs = Math.max(maxs, s);
            }
        }
        return maxs;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int res = 0;

        if (n == 0 || n == 1)
            return 0;

        // max profit ending at i
        int[] profit = new int[n];
        profit[0] = 0;
        int min = prices[0];

        for (int i = 1; i < n; i++) {
            profit[i] = Math.max(profit[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        // max profit starting at i
        int[] profit2 = new int[n];
        profit2[n - 1] = 0;
        int max = prices[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            profit2[i] = Math.max(profit2[i + 1], max - prices[i]);
            max = Math.max(max, prices[i]);

            // compute result
            res = Math.max(res, profit[i] + profit2[i]);
        }

        return res;
    }
}
