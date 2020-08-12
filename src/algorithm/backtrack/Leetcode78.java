package algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liyang27
 * @Date: 2020/7/26 21:11
 * @Description:子集
 */
public class Leetcode78 {

    public static void main(String[] args) {
        Leetcode78 A = new Leetcode78();
        int[] nums = {1, 2, 3};
        System.out.println(A.subsets(nums));
    }

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length < 1) {
            return ans;
        }
        for (int i = 0; i <= nums.length; i++) {
            subList(nums, i, 0, new ArrayList<>());
        }
        return ans;
    }

    public void subList(int[] nums, int k, int s, List<Integer> list) {
        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
        } else if (nums.length - s + list.size() < k) {
            return;
        } else if (s < nums.length) {
            for (int i = s; i < nums.length; i++) {
                list.add(nums[i]);
                subList(nums, k, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
