package algorithm.dp;

import java.util.Arrays;

/**
 * @Author: liyang27
 * @Date: 2020/8/15 19:56
 * @Description:
 */
public class Leetcode72 {
    public static void main(String[] args) {
        Leetcode72 A =new Leetcode72();
        String word1="horse";
        String word2="ros";
        System.out.println(A.minDistance(word1,word2));
    }
    public int minDistance(String word1, String word2) {
        if(word1==null&&word2==null){
            return 0;
        }
        if(word1!=null&&word1.length()<1&&word2!=null&&word2.length()<1){
            return 0;
        }
        if(word1==null){
            return word2.length();
        }
        if(word2==null){
            return word1.length();
        }
        int m=word2.length(),n=word1.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=n;i++){
            dp[0][i]=i;
        }
        for(int i=0;i<=m;i++){
            dp[i][0]=i;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(word2.charAt(i-1)==word1.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    dp[i][j]=min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1;
                }
            }
        }
        return dp[m][n];
    }
    public int min(int a,int b,int c){
        return Math.min(Math.min(a,b),c);
    }
}
