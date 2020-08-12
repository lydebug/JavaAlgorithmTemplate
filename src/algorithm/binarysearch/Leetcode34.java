package algorithm.binarysearch;

import java.util.Arrays;

/**
 * @Author: liyang27
 * @Date: 2020/7/20 21:54
 * @Description:
 */
public class Leetcode34 {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        Leetcode34 A = new Leetcode34();
        int[] ans = A.searchRange(nums, 1);
        System.out.println(Arrays.toString(ans));
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return new int[]{-1, -1};
        }
        int left = leftBound(nums, target);
        int right = rightBound(nums, target);
        if (left >= 0 && right >= 0) {
            return new int[]{left, right};
        } else {
            return new int[]{-1, -1};
        }
    }

    public int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[left] == target ? left : -1;
    }

    public int rightBound(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        int ans = -1;
        while (left <= right && left < nums.length) {
            if (nums[left] == target) {
                ans = left;
            }
            left++;

        }
        return ans;
    }
}
