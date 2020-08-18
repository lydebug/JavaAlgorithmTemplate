package algorithm.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liyang27
 * @Date: 2020/8/18 15:33
 * @Description:找到所有数组中消失的数字
 */
public class Leetcode448 {
    public static void main(String[] args) {
        int[] nums={4,3,2,7,8,2,3,1};
        Leetcode448 A = new Leetcode448();
        System.out.println(A.findDisappearedNumbers(nums));
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans =new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int idx=Math.abs(nums[i])-1;
            if(nums[idx]>0){
                nums[idx]=-nums[idx];
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                ans.add(i+1);
            }
        }
        return ans;
    }
}
