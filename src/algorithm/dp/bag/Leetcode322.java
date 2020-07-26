package algorithm.dp.bag;

import java.util.Arrays;

/**
 * @Author: liyang27
 * @Date: 2020/7/20 17:43
 * @Description:零钱兑换
 */
public class Leetcode322 {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int coin:coins){
                if(i-coin>=0){
                    dp[i]=Math.min(dp[i],dp[i-coin]+1);
                }

            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }
}
