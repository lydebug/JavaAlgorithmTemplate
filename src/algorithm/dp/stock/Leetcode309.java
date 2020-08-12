package algorithm.dp.stock;

/**
 * @Author: liyang27
 * @Date: 2020/7/23 08:55
 * @Description:最佳买卖股票时机含冷冻期
 */
public class Leetcode309 {
    public static void main(String[] args) {
        Leetcode309 A = new Leetcode309();
        int[] nums = {1, 2, 3, 0, 2};
        System.out.println(A.maxProfit(nums));
    }

    //dp[n][0]=Math.max(dp[n-1][0],dp[n-1][1]+prices[n])
    //dp[n][1]=Math.max(dp[n-1][1],dp[n-2][0]-prices[n])
    //base case:dp[0][0]=0,dp[0][1]=-prices[0]
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        int dp_pre_0 = 0;
        for (int i = 0; i < n; i++) {
            int tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
            dp_pre_0 = tmp;
        }
        return dp_i_0;
    }
}
