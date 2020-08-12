package algorithm.twoPointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liyang27
 * @Date: 2020/7/24 10:44
 * @Description:两数之和
 */
public class Leetcode1 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        Leetcode1 A = new Leetcode1();
        int[] ans = A.twoSum(nums, 9);
        System.out.println(Arrays.toString(ans));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


}
