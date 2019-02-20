package com.dooonabe.collection.array;

/**
 * 121. Best Time to Buy and Sell Stock
 * Created on 2019/2/20.
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int max = 0;
        int length = prices.length;
        for (int index = 0; index < length; index++) {
            for (int next = index + 1; next < length; next++)
                max = Math.max(max, (prices[next] - prices[index]) > 0 ? prices[next] - prices[index] : 0);
        }
        return max;
    }

    /**
     * Kadane's Algorithm?I do not know...
     *
     * @param prices prices
     * @return max
     */
    public int anotherMaxProfit(int[] prices) {
        int maxToday = 0;
        int max = 0;
        for(int index=1;index<prices.length;index++){
            maxToday = Math.max(0, maxToday+prices[index]-prices[index-1]);
            max = Math.max(max, maxToday);
        }
        return max;
    }
}
