package algorithm.dp;

/**
 * @Author: liyang27
 * @Date: 2020/7/23 14:48
 * @Description:打家劫舍2
 */
public class Leetcode213 {
    public static void main(String[] args) {
        Leetcode213 A= new Leetcode213();
        int[] nums={1,2,3,1};
        System.out.println(A.rob(nums));
    }
    public int rob(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        return Math.max(rob(nums,0,nums.length-2),rob(nums,1,nums.length-1));
    }
    public int rob(int[] nums,int s,int e){
        if(e-s==1){
            return Math.max(nums[s],nums[e]);
        }
        //dp_0=max(dp_1,dp_2+nums[i]
        int dp2=0,dp1=nums[s],dp0=0;
        for(int i=s+1;i<=e;i++){
            dp0=Math.max(dp2+nums[i],dp1);
            dp2=dp1;
            dp1=dp0;
        }
        return dp0;
    }
}
