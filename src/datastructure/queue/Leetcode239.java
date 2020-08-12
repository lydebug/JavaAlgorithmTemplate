package datastructure.queue;

import algorithm.twoPointers.Leetcode1;

import java.util.*;

/**
 * @Author: liyang27
 * @Date: 2020/7/25 15:11
 * @Description:滑动窗口最大值
 */
public class Leetcode239 {
    public static void main(String[] args) {
        int[] nums = {-7, -8, 7, 5, 7, 1, 6, 0};
        int k = 4;
        Leetcode239 A = new Leetcode239();
        System.out.println(Arrays.toString(A.maxSlidingWindow(nums, k)));
    }

    //有序队列，队列的大小不超过k
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return new int[0];
        }
        if (nums.length <= k) {
            //求出最大值
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                max = Math.max(max, nums[i]);
            }
            return new int[]{max};
        }
        int[] ans = new int[nums.length - k + 1];
        int idx = 0;
        DecreaseQue queue = new DecreaseQue();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                queue.offer(nums[i]);
            } else {
                queue.offer(nums[i]);
                ans[idx++] = queue.peek();
                queue.poll(nums[i - k + 1]);
            }
        }
        return ans;
    }
}

class DecreaseQue {
    private Deque<Integer> deque;

    public DecreaseQue() {
        deque = new LinkedList<>();
    }

    public void offer(int n) {
        while (!deque.isEmpty() && deque.getLast() < n) {
            deque.removeLast();
        }
        deque.offerLast(n);
    }

    public Integer peek() {
        return deque.getFirst();
    }

    public void poll(Integer n) {
        if (!deque.isEmpty() && deque.getFirst().equals(n)) {
            deque.removeFirst();
        }
    }
}
