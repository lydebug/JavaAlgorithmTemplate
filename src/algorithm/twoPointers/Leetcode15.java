package algorithm.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: liyang27
 * @Date: 2020/7/24 10:45
 * @Description:三数之和
 */
public class Leetcode15 {
    public static void main(String[] args) {
        Leetcode15 A = new Leetcode15();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(A.threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            List<List<Integer>> res = twoSum(nums, i + 1, -nums[i]);
            for (int j = 0; j < res.size(); j++) {
                res.get(j).add(nums[i]);
                ans.add(res.get(j));
            }
        }
        return ans;
    }

    public List<List<Integer>> twoSum(int[] nums, int left, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[left]);
                list.add(nums[right]);
                ans.add(list);
                left++;
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
            } else if (sum < target) {
                left++;
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
            } else {
                right--;
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            }
        }
        return ans;
    }
}
