package com.study.dynamic;

/**
 * You are being given an array in which the i'th element is the price of the given stock on day 'i'.
 * If you are permitter to complete at most 1 transaction (i.e. buy once and sell once),
 * what is the maximum profit you can gain?
 * It is to be noted, that you cannot sell a stock before you buy one.
 *
 * MaxProfit(i'th day) = Price(i) - MinUptil(i)
 * MinUptil(i) = min_(k = 0..i)(price(k)) = min (MinUptil(i - 1), price(i))
 */
public class Ex4_ShareMarket {

    int maxProfit(int[] prices) {
        final int n = prices.length;

        final int[] minUptil = new int[n];
        final int[] maxProfit = new int[n];

        minUptil[0] = prices[0];
        maxProfit[0] = 0;

        int highestProfit = 0; // at day 0
        for (int i = 1; i < n; i++) {
            minUptil[i] = Math.min(minUptil[i - 1], prices[i]);
            maxProfit[i] = prices[i] - minUptil[i];
            highestProfit = Math.max(highestProfit, maxProfit[i]);
        }

        return highestProfit;
    }

    int maxProfitWithoutArrays(int[] prices) {
        // day 0
        int minUptilValue = prices[0];
        int highestProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            minUptilValue = Math.min(minUptilValue, prices[i]);
            highestProfit = Math.max(highestProfit, prices[i] - minUptilValue);
        }

        return highestProfit;
    }

}
