package algorithm.dp.bag;

/**
 * @Author: liyang27
 * @Date: 2020/7/26 19:59
 * @Description:零钱兑换2(完全背包问题)
 */
public class Leetcode518 {
    public static void main(String[] args) {
        Leetcode518 A = new Leetcode518();
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println(A.change1(amount, coins));
    }

    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i < coins.length + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < amount + 1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[coins.length][amount];
    }

    public int change1(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j - coins[i] >= 0) {
                    dp[j] = dp[j] + dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }
}

