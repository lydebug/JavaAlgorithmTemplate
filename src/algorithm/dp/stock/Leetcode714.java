package algorithm.dp.stock;

/**
 * @Author: liyang27
 * @Date: 2020/7/23 08:55
 * @Description:买卖股票的最佳时机含手续费
 */
public class Leetcode714 {
    public static void main(String[] args) {
        Leetcode714 A = new Leetcode714();
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(A.maxProfit(prices, fee));
    }

    public int maxProfit(int[] prices, int fee) {
        //dp[i][0]=dp[i-1][0],dp[i-1][1]+prices[i] dp_0=dp_0,dp_1+prices[i],
        //dp[i][1]=dp[i-1][1],dp[i-1][0]-prices[i]-fee dp_1=dp_1,tmp-prices[i]-fee
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int dp_0 = 0, dp_1 = Integer.MIN_VALUE, tmp = 0;
        for (int i = 0; i < prices.length; i++) {
            tmp = dp_0;
            dp_0 = Math.max(dp_0, dp_1 + prices[i]);
            dp_1 = Math.max(dp_1, tmp - prices[i] - fee);
        }
        return dp_0;
    }
}
