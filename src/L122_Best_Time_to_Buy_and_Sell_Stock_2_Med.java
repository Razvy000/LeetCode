
/*
 ay you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. 
 You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). 

 However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class L122_Best_Time_to_Buy_and_Sell_Stock_2_Med {

    // equivalent to finding all ascending sequences
    // 3 4 5 2 8 7 4 5 6
    // 0 1 1 0 6 0 0 1 1
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                profit += prices[i] - prices[i - 1];
        }

        return profit;
    }
}
