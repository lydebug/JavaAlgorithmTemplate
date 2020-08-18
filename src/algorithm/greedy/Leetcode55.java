package algorithm.greedy;

/**
 * @Author: liyang27
 * @Date: 2020/8/18 14:13
 * @Description:跳跃游戏1
 */
public class Leetcode55 {
    public static void main(String[] args) {
        Leetcode55 A =new Leetcode55();
        int[] nums={3,2,1,0,4};
        System.out.println(A.canJump(nums));
    }
    public boolean canJump(int[] nums) {
        if(nums==null||nums.length<1){
            return true;
        }
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            if(i>max){
                return false;
            }else{
                max=Math.max(max,i+nums[i]);
            }
        }
        return true;
    }
}
