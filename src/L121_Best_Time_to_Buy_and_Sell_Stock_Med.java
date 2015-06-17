
/*
 Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
design an algorithm to find the maximum profit.

 */
public class L121_Best_Time_to_Buy_and_Sell_Stock_Med {

    public int maxProfit(int[] prices) {

        int profit = 0;

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return profit;
    }
}
