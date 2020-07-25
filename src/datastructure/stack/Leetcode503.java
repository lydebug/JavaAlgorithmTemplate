package datastructure.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: liyang27
 * @Date: 2020/7/25 14:12
 * @Description: 下一个更大的元素2
 */
public class Leetcode503 {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,3};
        Leetcode503 A = new Leetcode503();
        System.out.println(Arrays.toString(A.nextGreaterElements(nums)));
    }
    public int[] nextGreaterElements(int[] nums) {
        if(nums==null||nums.length<1){
            return new int[0];
        }
        int[] ans = new int[nums.length];
        int max=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[max]){
                max=i;
            }
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[max]);
        ans[max]=-1;
        for(int i=(max-1+nums.length)%nums.length;i!=max;i=(i-1+nums.length)%nums.length){
            while(!stack.empty()&&nums[i]>=stack.peek()){
                stack.pop();
            }
            if(stack.empty()){
                ans[i]=-1;
            }else{
                ans[i]=stack.peek();
            }
            stack.push(nums[i]);
        }
        return ans;
    }
}
