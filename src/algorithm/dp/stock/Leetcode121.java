package algorithm.dp.stock;

/**
 * @Author: liyang27
 * @Date: 2020/7/22 20:56
 * @Description:买卖股票的最佳时机
 */
public class Leetcode121 {
    public static void main(String[] args) {
        int[] nums = {7, 6, 4, 3, 1};
        Leetcode121 A = new Leetcode121();
        System.out.println(A.maxProfit(nums));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        //n:第几天
        // k：表示能完成几笔交易
        // s：你当前的状态是持有(1)还是未持有(0)
        //dp[i][k][0]=Max(dp[i-1][k][0],dp[i-1][k][1]+prices[i])
        //dp[i][k][1]=Max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i])
        //目标：dp[n][k][0]
        //base case:dp[0][k][0]=0;dp[0][k][1]=-Infinity
        //
        int[][][] dp = new int[n + 1][2][2];
        for (int i = 0; i <= 1; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = Integer.MIN_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 1; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i - 1]);
                if (j - 1 >= 0) {
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i - 1]);
                } else {
                    dp[i][j][1] = dp[i - 1][j][1];
                }

            }
        }
        int ans = 0;
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                ans = Math.max(dp[n][i][j], ans);
            }
        }
        return ans;

    }
}
