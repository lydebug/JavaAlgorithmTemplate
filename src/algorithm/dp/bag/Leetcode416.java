package algorithm.dp.bag;

/**
 * @Author: liyang27
 * @Date: 2020/7/26 17:21
 * @Description:分割等和子集
 */
public class Leetcode416 {
    public static void main(String[] args) {
        int[] nums={1,2,5};
        Leetcode416 A = new Leetcode416();
        System.out.println(A.canPartition(nums));
    }
    //dp[i,j]表示挑选前i件物品，重量为j是否可以装满
    //dp[i,j]=dp[i-1,j]||dp[i-1,j-nums[i-1]]
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2==1){
            return false;
        }
        sum=sum/2;
        boolean[][] dp = new boolean[nums.length+1][sum+1];
        for(int i=0;i<sum+1;i++){
            dp[0][i]=false;
        }
        for(int i=0;i<nums.length+1;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<nums.length+1;i++){
            for(int j=1;j<=sum;j++){
                if(j-nums[i-1]>=0){
                    dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i-1]];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[nums.length][sum];
    }
}
