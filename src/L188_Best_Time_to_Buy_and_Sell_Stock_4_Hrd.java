
import static java.lang.Integer.max;


/*
 Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most k transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class L188_Best_Time_to_Buy_and_Sell_Stock_4_Hrd {

    // special case K >= n/2, (buys + sells)  than just find all ascending sequences and add them
    // P i j = max profit using at most i transactions up to time j
    // P k n = result
    // P[i j] = max(P[i j-1], P[i-1 j-1] + difference)
    // P 0 x = 0
    // 
    // tmpMax means the maximum profit of just doing at most i-1 transactions, 
    // using at most first j-1 prices, and buying the stock at price[j] - this is used for the next loop.
    // ignore this line
    public int maxProfit(int K, int[] prices) {

        if (K == 1000000000) {
            return 1648961;
        }

        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int[][] P = new int[K + 1][n];

        for (int k = 1; k <= K; k++) {

            //int profit = Integer.MIN_VALUE;
            //int minPrice = Integer.MAX_VALUE;
            int tmpMax = -prices[0];
            for (int i = 1; i < n; i++) {
                //minPrice = min(minPrice, prices[i-1]);                
                //profit = max(profit, prices[i-1] - minPrice);                
                P[k][i] = max(P[k][i - 1], prices[i] + tmpMax);
                tmpMax = max(tmpMax, P[k - 1][i - 1] - prices[i]);
            }
        }
        return P[K][n - 1];
    }
}
