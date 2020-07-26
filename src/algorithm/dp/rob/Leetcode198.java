package algorithm.dp.rob;

/**
 * @Author: liyang27
 * @Date: 2020/7/23 12:06
 * @Description:打家劫舍1
 */
public class Leetcode198 {
    public static void main(String[] args) {
        int[] nums={2,7,9,3,1};
        Leetcode198 A =new Leetcode198();
        System.out.println(A.rob(nums));
    }
    public int rob(int[] nums) {

        //dp[i]=Math.max(dp[i-2]+nums[i],dp[i-3]+nums[i])
        if(nums==null||nums.length<1){
            return 0;
        }else if(nums.length==1){
            return nums[0];
        }else if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }else{
            int dp_2=nums[0],dp_1=Math.max(dp_2,nums[1]),dp_0=0;
            for(int i=2;i<nums.length;i++){
                dp_0=Math.max(dp_2+nums[i],dp_1);
                dp_2=dp_1;
                dp_1=dp_0;
            }
            return dp_0;
        }
    }
}
