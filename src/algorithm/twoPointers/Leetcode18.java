package algorithm.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: liyang27
 * @Date: 2020/7/24 10:45
 * @Description:四数之和
 */
public class Leetcode18 {
    public static void main(String[] args) {
        Leetcode18 A = new Leetcode18();
        int[] nums = {};
        int target = 0;
        System.out.println(A.fourSum(nums, target));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSum(nums, 4, 0, target);
    }

    public List<List<Integer>> nSum(int[] nums, int n, int s, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (n == 2) {
            if (s >= nums.length - 1) {
                return ans;
            }
            int lo = s, hi = nums.length - 1;
            while (lo < hi) {
                if (nums[lo] + nums[hi] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[lo]);
                    list.add(nums[hi]);
                    ans.add(list);
                    lo++;
                    while (lo < hi && nums[lo] == nums[lo - 1]) {
                        lo++;
                    }
                } else if (nums[lo] + nums[hi] < target) {
                    lo++;
                    while (lo < hi && nums[lo] == nums[lo - 1]) {
                        lo++;
                    }
                } else {
                    hi--;
                    while (lo < hi && nums[hi] == nums[hi + 1]) {
                        hi--;
                    }
                }
            }
        } else {
            for (int i = s; i < nums.length; i++) {
                if (i - 1 >= s && nums[i] == nums[i - 1]) {
                    continue;
                }
                List<List<Integer>> tmp = nSum(nums, n - 1, i + 1, target - nums[i]);
                for (int j = 0; j < tmp.size(); j++) {
                    tmp.get(j).add(nums[i]);
                    ans.add(tmp.get(j));
                }
            }
        }
        return ans;
    }
}
