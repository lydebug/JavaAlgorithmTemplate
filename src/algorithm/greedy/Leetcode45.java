package algorithm.greedy;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Arrays;

/**
 * @Author: liyang27
 * @Date: 2020/8/18 14:19
 * @Description:
 */
public class Leetcode45 {
    public static void main(String[] args) {
        Leetcode45 A = new Leetcode45();
        int[] nums = {5,4,0,1,3,6,8,0,9,4,9,1,8,7,4,8};
        System.out.println(A.jump(nums));
    }

    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int max = 0,steps=0,end=0;
        for (int i = 0; i < nums.length-1; i++) {
            max=Math.max(max,i+nums[i]);
            if(i==end){
                steps++;
                end=max;
            }
        }
        return steps;
    }
}
