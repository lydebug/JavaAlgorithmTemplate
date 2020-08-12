package datastructure.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: liyang27
 * @Date: 2020/7/25 14:12
 * @Description:下一个更大的元素1
 */
public class Leetcode496 {
    public static void main(String[] args) {
        Leetcode496 A = new Leetcode496();
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        System.out.println(Arrays.toString(A.nextGreaterElement(nums1, nums2)));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length < 1 || nums2.length < 1) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        int n1 = nums1.length - 1, n2 = nums2.length - 1;
        int[] ans = new int[n1 + 1];
        map.put(nums2[n2], -1);
        Stack<Integer> stack = new Stack();
        stack.push(nums2[n2]);
        for (int i = n2 - 1; i >= 0; i--) {
            while (!stack.empty() && nums2[i] > stack.peek()) {
                stack.pop();
            }
            if (stack.empty()) {
                stack.push(nums2[i]);
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], stack.peek());
                stack.push(nums2[i]);
            }
        }
        for (int i = 0; i <= n1; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}
