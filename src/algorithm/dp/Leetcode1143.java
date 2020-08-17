package algorithm.dp;

import java.util.Arrays;

/**
 * @Author: liyang27
 * @Date: 2020/8/15 19:13
 * @Description:
 */
public class Leetcode1143 {
    public static void main(String[] args) {
        Leetcode1143 A= new Leetcode1143();
        String text1="abc";
        String text2="def";
        System.out.println(A.longestCommonSubsequence(text1,text2));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1==null||text2==null||text1.length()<1||text2.length()<1){
            return 0;
        }
        int m=text1.length();
        int n=text2.length();
        int[][] dp=new int[m+1][n+1];
        Arrays.fill(dp[0],0);
        for(int i = 0;i<=m;i++){
            dp[i][0]=0;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
