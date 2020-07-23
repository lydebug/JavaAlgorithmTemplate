package algorithm.dp;

/**
 * 买卖股票的最佳时机 II
 *k为无限次
 * @author Leon
 * @since 2020/07/23
 */
public class Leetcode122 {
    public static void main(String[] args) {
        Leetcode122 A = new Leetcode122();
        int[] nums={1,2,3,4,5};
        System.out.println(A.maxProfit(nums));
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        //表示未持有，1表示持有
        int[][] dp = new int[n+1][2];
        dp[0][0]=0;
        dp[0][1]=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i-1]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i-1]);
        }
        return dp[n][0];
    }
}
