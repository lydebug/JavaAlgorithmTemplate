package algorithm.math;

import java.util.Arrays;

/**
 * @Author: liyang27
 * @Date: 2020/8/18 15:58
 * @Description:
 */
public class Leetcode645 {
    public static void main(String[] args) {
        Leetcode645 A =new Leetcode645();
        int[] nums={1,2,2,4};
        System.out.println(Arrays.toString(A.findErrorNums(nums)));
    }
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        for(int i=0;i<nums.length;i++){
            int idx=Math.abs(nums[i])-1;
            if(nums[idx]<0){
                ans[0]=idx+1;
            }else{
                nums[idx]=-nums[idx];
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                ans[1]=i+1;
                break;
            }
        }
        return ans;
    }
}
