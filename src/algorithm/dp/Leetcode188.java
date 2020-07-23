package algorithm.dp;

/**
 * 买卖股票的最佳时机 IV
 *
 * @author Leon
 * @since 2020/07/23
 */
public class Leetcode188 {
    public static void main(String[] args) {
        Leetcode188 A = new Leetcode188();
        int[] nums={3,2,6,5,0,3};
        System.out.println(A.maxProfit(2,nums));
    }
    public int maxProfit(int k,int[] prices) {
        int n=prices.length;
        if(k>=n/2){
            int[][] dp = new int[n+1][2];
            dp[0][0]=0;
            dp[0][1]=Integer.MIN_VALUE;
            for(int i=1;i<=n;i++){
                dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i-1]);
                dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i-1]);
            }
            return dp[n][0];
        }
        //0 表示未持有，1表示持有
        int[][][] dp = new int[n+1][k+1][2];
        for(int i=0;i<=k;i++){
            dp[0][i][0]=0;
            dp[0][i][1]=Integer.MIN_VALUE;
        }
        for(int i=1;i<=n;i++){
            for(int j=0;j<=k;j++){
                dp[i][j][0]=Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i-1]);
                if(j-1>=0){
                    dp[i][j][1]=Math.max(dp[i-1][j][1],dp[i-1][j-1][0]-prices[i-1]);
                }else{
                    dp[i][j][1]=dp[i-1][j][1];
                }
            }
        }
        int ans=0;
        for(int i=0;i<=k;i++){
            ans=Math.max(dp[n][i][0],ans);
        }
        return ans;
    }
}
