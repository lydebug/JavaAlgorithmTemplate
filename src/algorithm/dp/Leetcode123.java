package algorithm.dp;

/**
 * 买卖股票的最佳时机 III
 * k为2次
 *
 * @author Leon
 * @since 2020/07/23
 */
public class Leetcode123 {
    public static void main(String[] args) {
        Leetcode123 A = new Leetcode123();
        int[] nums={7,6,4,3,1};
        System.out.println(A.maxProfit(nums));
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        //0 表示未持有，1表示持有
        int[][][] dp = new int[n+1][3][2];
        for(int i=0;i<=2;i++){
            dp[0][i][0]=0;
            dp[0][i][1]=Integer.MIN_VALUE;
        }
        for(int i=1;i<=n;i++){
            for(int j=0;j<=2;j++){
                dp[i][j][0]=Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i-1]);
                if(j-1>=0){
                    dp[i][j][1]=Math.max(dp[i-1][j][1],dp[i-1][j-1][0]-prices[i-1]);
                }else{
                    dp[i][j][1]=dp[i-1][j][1];
                }
            }
        }
        int ans=0;
        for(int i=0;i<=2;i++){
            ans=Math.max(dp[n][i][0],ans);
        }
        return ans;
    }
}
