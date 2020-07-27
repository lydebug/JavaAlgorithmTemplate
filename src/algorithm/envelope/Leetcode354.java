package algorithm.envelope;

import java.util.Arrays;

/**
 * @Author: liyang27
 * @Date: 2020/7/27 20:03
 * @Description:信封嵌套
 */
public class Leetcode354 {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes==null||envelopes.length<1){
            return 0;
        }
        Arrays.sort(envelopes,(int[] a,int[] b)-> a[0]-b[0]==0?b[1]-a[1]:a[0]-b[0]);
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp,1);
        int max=0;
        for(int i=1;i<dp.length;i++){
            for(int j=i-1;j>=0;j--){
                if(envelopes[i][1]>envelopes[j][1]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            max=Math.max(dp[i],max);
        }
        return max;
    }
}
