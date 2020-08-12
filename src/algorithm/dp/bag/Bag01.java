package algorithm.dp.bag;

import java.util.Arrays;

/**
 * @Author: liyang27
 * @Date: 2020/7/26 16:45
 * @Description:0/1背包问题
 */
public class Bag01 {
    public static void main(String[] args) {
        Bag01 A = new Bag01();
        int N = 3, W = 4;
        int[] wt = {2, 1, 3};
        int[] val = {4, 2, 3};
        int ans = A.maxVal(N, W, wt, val);
        System.out.println(ans);
    }

    //dp(i,w)表示在装第i件物品时，还可以装重量为w的背包的最大价值
    //dp(i,w)=Math.max(dp(i-1,w),dp(i-1,w-wt(i-1))+val(i-1))
    public int maxVal(int N, int W, int[] wt, int[] val) {
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 0; i <= W; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                if (j - wt[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt[i - 1]] + val[i - 1]);
                }
            }
        }
        return dp[N][W];
    }
}
